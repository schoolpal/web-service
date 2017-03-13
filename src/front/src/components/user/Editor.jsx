import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';
import { SaveButton } from '../public/Button';
import Alerts from '../public/Alerts';
import subTitle from '../../utils/subTitle';
import { orgDetails, roleList, userAdd, userDetails, userMod } from '../../utils/api';
import mixedMD5 from '../../utils/mixedMD5'

export default class Editor extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            loading: true,
            org: null,
            roleList: [],
            checkedRole: {},

            saveLoading: false,
            saveResult: null
        }

        this.checkedRole = this.checkedRole.bind(this)
        this.editorSubmit = this.editorSubmit.bind(this)
        this.showAlert = this.showAlert.bind(this)
        this.clearAlert = this.clearAlert.bind(this)
    }

    componentDidMount() {
        orgDetails(this.props.params.oid)
            .done((data) => {
                this.setState({
                    org: {
                        id: data.cId,
                        name: data.cName
                    }
                })

                roleList(data.cId)
                    .done((role) => {

                        if (this.props.params.uid === 'create') {
                            this.setState({
                                loading: false,
                                roleList: role
                            })
                        } else {
                            userDetails(this.props.params.uid)
                                .done((user) => {
                                    let checkedRole = {}

                                    user.roles.map((item) => {
                                        checkedRole[item.cId] = true;
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

                                    this.setState({
                                        loading: false,
                                        roleList: role,
                                        checkedRole: checkedRole
                                    })
                                })
                        }

                    })
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
        let param = {};
        let temp = $(this.editorDom).serializeArray();
        let rolesArr = [];

        this.setState({ saveLoading: true })

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

        if (this.props.params.uid === 'create') {
            userAdd(param)
                .done(() => {
                    $(this.editorDom)
                        .find('input')
                        .val('')

                    this.setState({
                        checkedRole: {},
                        saveLoading: false,
                        saveResult: {
                            type: 'success',
                            title: 'Well done!',
                            text: '添加成功 ！'
                        }
                    })
                })
                .fail((data) => {
                    this.setState({
                        saveLoading: false,
                        saveResult: {
                            type: 'danger',
                            'title': 'Oh snap!',
                            'text': '[' + data.data.code + '] ' + data.data.detail
                        }
                    })
                })
        } else {
            userMod(param)
                .done(() => {
                    this.setState({
                        saveLoading: false,
                        saveResult: {
                            type: 'success',
                            title: 'Well done!',
                            text: '添加成功 ！'
                        }
                    })
                })
                .fail((data) => {
                    this.setState({
                        saveLoading: false,
                        saveResult: {
                            type: 'danger',
                            'title': 'Oh snap!',
                            'text': '[' + data.data.code + '] ' + data.data.detail
                        }
                    })
                })
        }
    }

    showAlert() {
        if (this.state.saveResult) {
            return (
                <Alerts type={this.state.saveResult.type} title={this.state.saveResult.title} text={this.state.saveResult.text}>
                    <Link to={SCHOOLPAL_CONFIG.ROOTPATH + 'user'} className="alert-link">返回列表</Link>
                </Alerts>
            )
        } else {
            return '';
        }
    }

    clearAlert() {
        this.setState({
            saveResult: null
        })
    }

    render() {
        return (
            <div className="user" >
                <h5>
                    <i className="fa fa-user" aria-hidden="true"></i>&nbsp;用户管理&nbsp;&nbsp;|&nbsp;&nbsp;<p className="d-inline text-muted">{subTitle(this.props.router.params.uid, '用户')}</p>
                    <div className="btn-group float-right mr-4" role="group">
                        <SaveButton action={this.editorSubmit} text="保存" loading={this.state.saveLoading} />
                    </div>
                </h5>

                {this.showAlert()}

                <div onClick={this.clearAlert} className="main-container">
                    <p className={this.state.loading === true ? 'hide' : 'h6 pb-3 b-b'}>所属组织：{this.state.org ? this.state.org.name : ''}</p>

                    <div className={this.state.loading === true ? 'hide' : 'd-flex align-items-stretch flex-nowrap'}>

                        <form ref={(dom) => { this.editorDom = dom }} className="w500 pr-3">
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

                    {this.state.loading === true ? <p>数据加载中 ...</p> : ''}

                </div>
            </div>
        )
    }
}