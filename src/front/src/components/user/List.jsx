import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';
import OrgTree from '../public/OrgTree';
import { CreateButton, EditorButton, DelButton } from '../public/Button';
import { orgList, userList } from '../../utils/api';

export default class List extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            loading: true,
            orgList: [],
            selected: null,

            userLoading: false,
            userList: [],
        }

        this.selectOrg = this.selectOrg.bind(this);
        this.renderCommand = this.renderCommand.bind(this);
        this.handleCreate = this.handleCreate.bind(this);
        this.handleEditor = this.handleEditor.bind(this);
        this.handleDel = this.handleDel.bind(this);
    }

    componentDidMount() {
        let enable = false;
        let disable = false;

        if (SCHOOLPAL_CONFIG.auth[this.props.route.path] && SCHOOLPAL_CONFIG.auth[this.props.route.path].command.length) {
            SCHOOLPAL_CONFIG.auth[this.props.route.path].command.map((item, index) => {
                if (item === 'Enable') {
                    enable = true;
                }

                if (item === 'Disable') {
                    disable = true;
                }
            })
        }

        this.setState({
            enable: enable,
            disable: disable
        })

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
                    temp.push(<CreateButton key={index} action={this.handleCreate} disabled={this.state.selected === null ? true : false} />)
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
                roleLoading: true,
                userLoading: true
            })

            userList(org.id)
                .done((data) => {
                    this.setState({
                        userLoading: false,
                        userList: data
                    })
                })
        } else {
            this.setState({
                selected: null,
            })
        };
    }

    handleCreate() {
        const editorPath = SCHOOLPAL_CONFIG.ROOTPATH + 'user/' + this.state.selected.id + '/create';

        this.props.router.push(editorPath)
    }

    handleEditor() { }

    handleDel() { }

    render() {
        return (
            <div className="user">
                <h5>
                    <i className="fa fa-user" aria-hidden="true"></i>&nbsp;用户管理
                    <div className="btn-group float-right mr-4" role="group">
                        {this.renderCommand()}
                    </div>
                </h5>

                <div className="main-container">
                    <div className="d-flex align-items-stretch flex-nowrap">
                        <div className={this.state.loading === true ? 'hide' : 'w300'}>
                            <OrgTree data={this.state.orgList} selected={this.selectOrg} defaults={this.state.selected ? this.state.selected.id : null} />
                        </div>

                        <div className={this.state.selected === null ? 'hide' : 'flex-cell pl-3 b-l'}>
                            <table className={this.state.userLoading === true ? 'hide' : 'table table-bordered table-sm'}>
                                <thead>
                                    <tr>
                                        <th>&nbsp;</th>
                                        <th>状态</th>
                                        <th>用户名</th>
                                        <th>姓名</th>
                                        <th>昵称</th>
                                        <th>电话号码</th>
                                        <th>电子邮件</th>
                                        <th>IM(QQ)</th>
                                        <th>用户角色</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {
                                        this.state.userList.map((item) => {
                                            return (
                                                <tr key={item.cId}>
                                                    <td>
                                                        <div className="form-check form-check">
                                                            <label className="form-check-label">
                                                                <input className="form-check-input" type="checkbox" value={item.cId} />
                                                            </label>
                                                        </div>
                                                    </td>
                                                    <td>{item.cAvailable === true ? '启用' : '禁用'}</td>
                                                    <td>{item.cLoginname}</td>
                                                    <td>{item.cRealname}</td>
                                                    <td>{item.cNickname}</td>
                                                    <td>{item.cPhone}</td>
                                                    <td>{item.cEmail}</td>
                                                    <td>{item.cQq}</td>
                                                    <td>{item.roles.map((role) => { return role.cName }).join(',')}</td>
                                                </tr>
                                            )
                                        })
                                    }
                                </tbody>
                            </table>

                            {this.state.userLoading === true ? <p>数据加载中 ...</p> : ''}
                        </div>
                    </div>

                    {this.state.loading === true ? <p>数据加载中 ...</p> : ''}
                </div>
            </div>
        )
    }
}