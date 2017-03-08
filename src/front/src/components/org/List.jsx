import React from 'react';
import ReactDOM from 'react-dom';
import { CreateButton, EditorButton, DelButton } from '../public/Button';
import { orgList, orgDel } from '../../utils/api';

export default class List extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            loading: true,
            delLoading: false,
            list: [],
            selected: null,
            selectedLevel: null,
            rootLevel: null
        };

        this.renderCommand = this.renderCommand.bind(this);
        this.renderTable = this.renderTable.bind(this);
        this.tableLine = this.tableLine.bind(this);
        this.handleSelect = this.handleSelect.bind(this);
        this.handleEditor = this.handleEditor.bind(this);
        this.handleDel = this.handleDel.bind(this);
        this.handleNode = this.handleNode.bind(this);
    }

    renderCommand() {
        let temp = [];
        let isDisabled;

        if (this.state.selectedLevel && this.state.selectedLevel !== this.state.rootLevel) {
            isDisabled = false;
        } else {
            isDisabled = true;
        };

        if (SCHOOLPAL_CONFIG.auth[this.props.route.path] && SCHOOLPAL_CONFIG.auth[this.props.route.path].command.length) {
            SCHOOLPAL_CONFIG.auth[this.props.route.path].command.map((item, index) => {
                if (item === 'Add') {
                    temp.push(<CreateButton key={index} link={SCHOOLPAL_CONFIG.ROOTPATH + 'org/create'} />)
                };

                if (item === 'Mod') {
                    temp.push(<EditorButton key={index} action={this.handleEditor} disabled={isDisabled} />)
                }

                if (item === 'Del') {
                    temp.push(<DelButton key={index} action={this.handleDel} disabled={isDisabled} loading={this.state.delLoading} />)
                }
            })
        }

        return temp;
    }

    renderTable(data) {
        let table = [];

        if (data.length) {
            data.map((item) => {
                table.push(this.tableLine(item));

                if (item.children && item.children.length) {
                    let children = [];

                    children.push(this.renderTable(item.children));
                    table.push(children);
                }
            })
        }

        return table;
    }

    tableLine(data) {
        const selectedClass = 'select' + ((this.state.selected && this.state.selected.toString() === data.cId) ? ' selected' : '');
        const spacingStyle = { marginLeft: 40 * data.level + 'px' };
        const childrenClass = data.children ? '' : 'not-child';
        const area = data.cState + ' ' + data.cCity + ' ' + data.cCounty;
        const addr = area + ' ' + data.cAddress;

        return (
            <tr key={data.cId} data-id={data.cId} data-level={data.level}>
                <th scope="row">
                    <span onClick={this.handleSelect} className={selectedClass}></span>
                </th>
                <td>
                    <p onClick={this.handleNode} className={'tree-node ' + childrenClass} style={spacingStyle}>{data.cName}</p>
                </td>
                <td>{area}</td>
                <td>{addr}</td>
                <td>{data.cOwner}</td>
                <td>{data.cOwnerPhone}</td>
            </tr>
        );
    }

    handleSelect(event) {
        if ($(event.target).hasClass('selected')) {
            this.setState({
                selected: null,
                selectedLevel: null
            })
        } else {
            this.setState({
                selected: $(event.target).parents('tr').data('id'),
                selectedLevel: $(event.target).parents('tr').data('level')
            })
        }
    }

    handleEditor() {
        const editorPath = SCHOOLPAL_CONFIG.ROOTPATH + 'org/' + this.state.selected;

        this.props.router.push(editorPath)
    }

    handleDel() {
        this.setState({
            delLoading: true
        })

        orgDel(this.state.selected)
            .done(() => {
                this.setState({
                    loading: true,
                    delLoading: false,
                    list: [],
                    selected: null,
                    selectedLevel: null,
                    rootLevel: null
                })
                orgList()
                    .done((data) => {
                        this.setState({
                            loading: false,
                            list: data.tree,
                            rootLevel: data.rootLevel
                        })
                    })
            })

    }

    handleNode(event) {
        if ($(event.target).hasClass('not-child')) {
            return;
        };

        const tr = $(event.target).parents('tr');
        const level = tr.data('level');

        tr.nextAll('tr').each((i, item) => {
            if ($(item).data('level') === level) {
                return false;
            };

            if ($(event.target).hasClass('closed')) {
                if ($(item).data('level') === (level + 1)) {
                    $(item).show();
                }
            } else {
                $(item)
                    .hide()
                    .find('.tree-node')
                    .addClass('closed');
            }
        });

        $(event.target).toggleClass('closed');
    }

    componentDidMount() {
        orgList()
            .done((data, rootLevel) => {
                this.setState({
                    loading: false,
                    list: data.tree,
                    rootLevel: data.rootLevel
                })
            })
    }

    render() {
        return (
            <div className="org">
                <h5>
                    <i className="fa fa-sitemap" aria-hidden="true"></i>&nbsp;组织管理
                    <div className="btn-group float-right" role="group">
                        {this.renderCommand()}
                    </div>
                </h5>
                <div className="main-container">
                    <table className="table table-bordered table-sm">
                        <thead>
                            <tr>
                                <th>&nbsp;</th>
                                <th>组织名称</th>
                                <th>所在地区</th>
                                <th>详细地址</th>
                                <th>负责人</th>
                                <th>联系电话</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.renderTable(this.state.list)}
                        </tbody>
                    </table>

                    {this.state.loading === true ? <p>数据加载中 ...</p> : ''}

                </div>
            </div>
        )
    }
}