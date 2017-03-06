import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';
import OrgTree from '../public/OrgTree';
import { CreateButton, EditorButton, DelButton } from '../public/Button';
import { orgList, roleList } from '../../utils/api';

function getFuncStr(data) {
    let funcArr = [];

    data.map((item) => {
        funcArr.push(item.cNameShort);
    })

    return funcArr.join(',');
}

export default class List extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            loading: true,
            orgList: [],
            selected: null,

            roleLoading: false,
            roleList: [],

            selectedRole: null
        };

        this.renderCommand = this.renderCommand.bind(this);
        this.selectOrg = this.selectOrg.bind(this);
        this.handleSelect = this.handleSelect.bind(this);
        this.handleEditor = this.handleEditor.bind(this);
        this.handleDel = this.handleDel.bind(this);
    }

    componentDidMount() {
        orgList()
            .done((data) => {
                this.setState({
                    loading: false,
                    orgList: data.tree
                })
            })
    }

    renderCommand() {
        let temp = [];

        if (SCHOOLPAL_CONFIG.auth[this.props.route.path] && SCHOOLPAL_CONFIG.auth[this.props.route.path].command.length) {
            SCHOOLPAL_CONFIG.auth[this.props.route.path].command.map((item, index) => {
                if (item === 'Add') {
                    temp.push(<CreateButton key={index} link={SCHOOLPAL_CONFIG.ROOTPATH + 'role/create'} />)
                };

                if (item === 'Mod') {
                    temp.push(<EditorButton key={index} action={this.handleEditor} />)
                }

                if (item === 'Del') {
                    temp.push(<DelButton key={index} action={this.handleDel} loading={this.state.delLoading} />)
                }
            })
        }

        return temp;
    }

    selectOrg(org) {
        if (org) {
            this.setState({
                selected: org,
                roleLoading: true
            })

            roleList(org.id)
                .done((data) => {
                    this.setState({
                        roleLoading: false,
                        roleList: data
                    })
                })
        } else {
            this.setState({
                selected: null
            })
        };
    }

    handleSelect(event) {
        if ($(event.target).hasClass('selected')) {
            this.setState({
                selectedRole: null
            })
        } else {
            this.setState({
                selectedRole: $(event.target).parents('tr').data('id')
            })
        }
    }

    handleEditor() {
        const editorPath = SCHOOLPAL_CONFIG.ROOTPATH + 'role/' + this.state.selectedRole;

    }

    handleDel() {

    }

    render() {
        return (
            <div className="role">
                <h5>
                    <i className='fa fa-glass'></i>&nbsp;角色管理
                    <div className="btn-group float-right" role="group">
                        {this.renderCommand()}
                    </div>
                </h5>

                <div className="main-container">
                    <div className="d-flex align-items-stretch flex-nowrap">
                        <div className={this.state.loading === true ? 'hide' : 'w400'}>
                            <OrgTree data={this.state.orgList} selected={this.selectOrg} defaults={this.state.selected ? this.state.selected.id : null} />
                        </div>
                        <div className={this.state.selected === null ? 'hide' : 'flex-cell pl-3 b-l'}>
                            <table className={this.state.roleLoading === true ? 'hide' : 'table table-bordered table-sm'}>
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>角色职能</th>
                                        <th>角色职级</th>
                                        <th>角色名称</th>
                                        <th>角色描述</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {
                                        this.state.roleList.map((item) => {
                                            return (
                                                <tr key={item.cId} data-id={item.cId}>
                                                    <td>
                                                        <span onClick={this.handleSelect} className={this.state.selectedRole ? 'select selected' : 'select'}></span>
                                                    </td>
                                                    <td>{getFuncStr(item.rootFuncs)}</td>
                                                    <td>{item.cRankName}</td>
                                                    <td>{item.cName}</td>
                                                    <td>{item.cDesc}</td>
                                                </tr>
                                            )
                                        })
                                    }
                                </tbody>
                            </table>

                            {this.state.roleLoading === true ? <p>数据加载中 ...</p> : ''}
                        </div>

                        {this.state.loading === true ? <p>数据加载中 ...</p> : ''}
                    </div>
                </div>
            </div>
        )
    }
}