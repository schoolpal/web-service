import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';
import { SaveButton, BackButton } from '../public/Button';
import Alerts from '../public/Alerts';
import subTitle from '../../utils/subTitle';
import { orgDetails, roleList, userAdd, userDetails, userMod } from '../../utils/api';
import mixedMD5 from '../../utils/mixedMD5'
import DialogTips from '../../utils/DialogTips';

export default class Editor extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            org: null,
            roleList: [],
            checkedRole: {},
        }

        this.checkedRole = this.checkedRole.bind(this)
        this.editorSubmit = this.editorSubmit.bind(this)
    }

    componentDidMount() {
        const dialogTips = DialogTips({ type: 'loading' })

        dialogTips.open()


        $.when(
            orgDetails(this.props.params.oid),
            roleList(this.props.params.oid)
        ).done((org, role) => {
            this.setState({
                org: {
                    id: org.cId,
                    name: org.cName,
                },
                roleList: role
            })

            if (this.props.params.uid === 'create') {
                dialogTips.close()
            } else {
                userDetails(this.props.params.uid)
                    .done((user) => {
                        let checkedRole = {}

                        user.roles.map((item) => {
                            checkedRole[item.cId] = true;
                        })

                        this.setState({
                            checkedRole: checkedRole
                        })

                        $(this.editorDom)
                            .find('[name=loginName]')
                            .val(user.cLoginname)
                            .end()
                            .find('[name=realName]')
                            .val(user.cRealname)
                            .end()
                            .find('[name=nickName]')
                            .val(user.cNickname)
                            .end()
                            .find('[name=phone]')
                            .val(user.cPhone)
                            .end()
                            .find('[name=email]')
                            .val(user.cEmail)
                            .end()
                            .find('[name=im]')
                            .val(user.cQq)
                    })
                    .always(() => {
                        dialogTips.close()
                    })
            }
        }).fail(() => {
            dialogTips.close()
        })
    }

    checkedRole(event) {
        let tempRole = $.extend({}, this.state.checkedRole);

        tempRole[event.target.value] = event.target.checked;

        this.setState({
            checkedRole: tempRole
        })
    }

    editorSubmit() {
        const successPath = SCHOOLPAL_CONFIG.ROOTPATH + 'user';
        const loading = DialogTips({ type: 'loading' })
        const success = DialogTips({ type: 'success' })
        const fail = DialogTips({ type: 'fail', autoClose: true })

        let param = {};
        let temp = $(this.editorDom).serializeArray();
        let rolesArr = [];

        loading.open()

        for (const key in this.state.checkedRole) {
            if (this.state.checkedRole[key] === true) {
                rolesArr.push(key)
            }
        }

        if (this.props.params.uid !== 'create') {
            param.userId = this.props.params.uid;
        }

        param.orgId = this.state.org.id
        param.roles = rolesArr.join(',')

        temp.map((item) => {
            if (item.name === 'loginPass') {
                param[item.name] = mixedMD5(mixedMD5(item.value))
            } else {
                param[item.name] = item.value;
            }
        })

        delete temp['org']

        if (this.props.params.uid === 'create') {
            userAdd(param)
                .done(() => {
                    loading.close()
                    success.open()
                    setTimeout(() => {
                        success.close()
                        this.props.router.push(successPath)
                    }, 2000)
                })
                .fail((data) => {
                    loading.close()
                    fail.open()
                })
        } else {
            userMod(param)
                .done(() => {
                    loading.close()
                    success.open()
                    setTimeout(() => {
                        success.close()
                        this.props.router.push(successPath)
                    }, 2000)
                })
                .fail((data) => {
                    loading.close()
                    fail.open()
                })
        }
    }

    render() {
        return (
            <div className="user" >
                <h5>
                    <i className="fa fa-user" aria-hidden="true"></i>&nbsp;用户管理&nbsp;&nbsp;|&nbsp;&nbsp;<p className="d-inline text-muted">{subTitle(this.props.router.params.uid, '用户')}</p>
                    <div className="btn-group float-right mr-4" role="group">
                        <BackButton router={this.props.router} />
                        <SaveButton action={this.editorSubmit} text="保存" />
                    </div>
                </h5>

                <div className="main-container">

                    <div className={this.state.roleList.length ? 'd-flex align-items-stretch flex-nowrap' : 'hide'}>

                        <form ref={(dom) => { this.editorDom = dom }} className="w500 pr-3">
                            <div className="form-group">
                                <label for="name">所属组织</label>
                                <input type="text" className="form-control" name="org" value={this.state.org ? this.state.org.name : ''} disabled="disabled" />
                            </div>

                            <div className="form-group">
                                <label for="name">用户名</label>
                                <input type="text" className="form-control" name="loginName" />
                            </div>

                            <div className="form-group">
                                <label for="name">登陆密码</label>
                                <input type="password" className="form-control" name="loginPass" />
                            </div>

                            <div className="form-group">
                                <label for="name">姓名</label>
                                <input type="text" className="form-control" name="realName" />
                            </div>

                            <div className="form-group">
                                <label for="name">昵称</label>
                                <input type="text" className="form-control" name="nickName" />
                            </div>

                            <div className="form-group">
                                <label for="name">电话号码</label>
                                <input type="text" className="form-control" name="phone" />
                            </div>

                            <div className="form-group">
                                <label for="name">电子邮箱</label>
                                <input type="text" className="form-control" name="email" />
                            </div>

                            <div className="form-group">
                                <label for="name">IM(QQ...)</label>
                                <input type="text" className="form-control" name="im" />
                            </div>
                        </form>

                        <div className="flex-cell pl-3 b-l">
                            <p className="ht pb-3 b-b">用户角色</p>
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
                                                    checked={this.state.checkedRole[item.cId] ? this.state.checkedRole[item.cId] : false}
                                                />
                                                {item.cName}
                                            </label>
                                        </div>
                                    )
                                })
                            }
                        </div>

                    </div>
                </div>
            </div>
        )
    }
}