import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';
import OrgTree from '../public/OrgTree';
import Alerts from '../public/Alerts';
import { AuthButton } from '../public/Button';
import { orgList, roleList, funcByIds, roleDetails, roleAuth } from '../../utils/api';

export default class List extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            loading: true,
            orgList: [],
            selected: null,

            roleLoading: false,
            roleList: [],
            checkedRole: null,
            checkedRoleName: null,

            funcLoading: false,
            funcList: [],
            checkedFunc: {},

            authLoading: false,
            authResult: null
        };

        this.renderCommand = this.renderCommand.bind(this)
        this.renderTable = this.renderTable.bind(this)
        this.tableLine = this.tableLine.bind(this)
        this.selectOrg = this.selectOrg.bind(this)
        this.checkedRole = this.checkedRole.bind(this)
        this.checkedFunc = this.checkedFunc.bind(this)
        this.handleAuth = this.handleAuth.bind(this)
        this.showAlert = this.showAlert.bind(this)
        this.clearAlert = this.clearAlert.bind(this)
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
        const isDisabled = $.isEmptyObject(this.state.checkedFunc);
        let temp = [];

        if (SCHOOLPAL_CONFIG.auth[this.props.route.path] && SCHOOLPAL_CONFIG.auth[this.props.route.path].command.length) {
            SCHOOLPAL_CONFIG.auth[this.props.route.path].command.map((item, index) => {
                if (item === 'Auth') {
                    temp.push(
                        <AuthButton
                            key={index}
                            action={this.handleAuth}
                            disabled={isDisabled}
                            loading={this.state.authLoading}
                        />
                    )
                };
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

    checkedRole(event) {
        if (event.target.checked === true) {
            this.setState({
                checkedRole: event.target.value,
                checkedRoleName: $(event.target).parent().text(),
                funcLoading: true
            })

            roleDetails(event.target.value)
                .done((roleFunc) => {
                    const fids = roleFunc.rootFuncs.map((item) => { return item.cId });

                    funcByIds(fids.join(','))
                        .done((func) => {
                            let checked = {};

                            func.data.map((item) => {
                                if (roleFunc.functions.findIndex((elem) => { return elem.cId === item.cId }) < 0) {
                                    checked[item.cId] = false;
                                } else {
                                    checked[item.cId] = true;
                                }
                            })

                            this.setState({
                                funcLoading: false,
                                funcList: func.tree,
                                checkedFunc: checked
                            })
                        })
                })
        } else {
            this.setState({
                checkedRole: null,
                checkedRoleName: null
            })
        }
    }

    checkedFunc(event) {
        const temp = $.extend({}, this.state.checkedFunc);

        temp[event.target.value] = !temp[event.target.value];

        if (temp[event.target.value] === false) {
            if ($('[data-parent=' + event.target.value + ']').length) {
                $('[data-parent=' + event.target.value + ']').each((i, elem) => {
                    temp[$(elem).val()] = false;
                })
            };
        }

        this.setState({
            checkedFunc: temp
        })
    }

    handleAuth() {
        this.setState({
            authLoading: true
        })

        let funcIdArr = [];

        for (const key in this.state.checkedFunc) {
            if (this.state.checkedFunc[key] === true) {
                funcIdArr.push(key)
            }
        }

        const param = {
            id: this.state.checkedRole,
            funcIds: funcIdArr.join(',')
        }

        roleAuth(param)
            .done(() => {
                this.setState({
                    authLoading: false,
                    authResult: {
                        type: 'success',
                        title: 'Well done!',
                        text: '授权成功 ！需要用户重新登陆后，才会更新权限信息 ！'
                    }
                })
            })
            .fail((data) => {
                this.setState({
                    authLoading: false,
                    authResult: {
                        type: 'danger',
                        'title': 'Oh snap!',
                        'text': '[' + data.data.code + '] ' + data.data.detail
                    }
                })
            })
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
        const level = data.cId.split('-').length;
        const spacingStyle = { marginLeft: 40 * level + 'px' };
        const childrenClass = data.children ? '' : 'not-child';
        let action = [];

        if (data.action) {
            action = data.action.map((item) => {
                return (
                    <div key={item.cId} className="form-check form-check-inline">
                        <label className="form-check-label">
                            <input
                                onChange={this.checkedFunc}
                                className="form-check-input"
                                type="checkbox"
                                data-parent={item.cParentId}
                                value={item.cId}
                                checked={this.state.checkedFunc[item.cId]}
                            />
                            {item.cNameLong}
                        </label>
                    </div>
                )
            })
        };

        return (
            <tr key={data.cId} data-id={data.cId} data-level={level}>
                <td>
                    <p className={'tree-node ' + childrenClass} style={spacingStyle}>{data.cNameLong}</p>
                </td>
                <td>
                    <div className="form-check">
                        <label className="form-check-label">
                            <input
                                onChange={this.checkedFunc}
                                className="form-check-input"
                                type="checkbox"
                                value={data.cId}
                                checked={this.state.checkedFunc[data.cId]}
                            />
                        </label>
                    </div>
                </td>
                <td>{action}</td>
            </tr>
        );
    }

    showAlert() {
        if (this.state.authResult) {
            return (
                <Alerts
                    type={this.state.authResult.type}
                    title={this.state.authResult.title}
                    text={this.state.authResult.text}
                />
            )
        } else {
            return '';
        }
    }

    clearAlert() {
        this.setState({
            authResult: null
        })
    }

    render() {
        return (
            <div className="auth">
                <h5>
                    <i className='fa fa-shield' aria-hidden="true"></i>&nbsp;权限管理
                    <div className="btn-group float-right" role="group">
                        {this.renderCommand()}
                    </div>
                </h5>

                {this.showAlert()}

                <div onClick={this.clearAlert} className="main-container">
                    <div className="d-flex align-items-stretch flex-nowrap">
                        <div className={this.state.loading === true ? 'hide' : 'w300'}>
                            <OrgTree data={this.state.orgList} selected={this.selectOrg} defaults={this.state.selected ? this.state.selected.id : null} />
                        </div>

                        <div className={this.state.selected === null ? 'hide' : 'w200 pl-3 b-l'}>
                            {
                                this.state.roleList.map((item) => {
                                    return (
                                        <div key={item.cId} className="form-check">
                                            <label className="form-check-label">
                                                <input
                                                    onChange={this.checkedRole}
                                                    className="form-check-input"
                                                    type="checkbox"
                                                    value={item.cId}
                                                    checked={this.state.checkedRole === item.cId ? true : false}
                                                />
                                                {item.cRankName}
                                            </label>
                                        </div>
                                    )
                                })
                            }

                            {this.state.roleLoading === true ? <p>数据加载中 ...</p> : ''}
                        </div>

                        <div className={this.state.checkedRole === null ? 'hide' : 'flex-cell pl-3 b-l'}>
                            <p className="h6 pb-3 b-b">{this.state.checkedRoleName ? this.state.checkedRoleName : ''}</p>
                            <table className={this.state.funcLoading === true ? 'hide' : 'table table-bordered table-sm'}>
                                <thead>
                                    <tr>
                                        <th>系统菜单</th>
                                        <th>选取</th>
                                        <th>功能权限</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {this.renderTable(this.state.funcList)}
                                </tbody>
                            </table>

                            {this.state.funcLoading === true ? <p>数据加载中 ...</p> : ''}
                        </div>
                    </div>

                    {this.state.loading === true ? <p>数据加载中 ...</p> : ''}
                </div>
            </div>
        )
    }
}