import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';
import { SaveButton, BackButton } from '../public/Button';
import subTitle from '../../utils/subTitle';
import { orgDetails, funcDic, rankDic, roleAdd, roleDetails, roleMod } from '../../utils/api';
import DialogTips from '../../utils/DialogTips'

const FUNC_ADMIN_ID = '7';
const RANK_ADMIN_ID = '4';

function formatFuncData(data) {
    let temp = [];

    data.map((item => {
        if (item.cId === item.cRootId) {
            temp.push(item)
        }
    }))

    return temp;
}

export default class Editor extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            org: null,

            rank: [],
            func: [],

            isAdmin: false,
            checkedFunc: {},
            checkedRank: null,
        }

        this.checkedFunc = this.checkedFunc.bind(this);
        this.checkedRank = this.checkedRank.bind(this);
        this.editorSubmit = this.editorSubmit.bind(this);
    }

    componentDidMount() {
        const dialogTips = DialogTips({ type: 'loading' })

        dialogTips.open()

        if (this.props.params.rid === 'create') {
            $.when(
                orgDetails(this.props.params.oid),
                funcDic(),
                rankDic()
            ).done((org, func, rank) => {
                this.setState({
                    org: {
                        id: org.cId,
                        name: org.cName
                    },
                    rank: rank,
                    func: formatFuncData(func)
                })
            }).always(() => {
                dialogTips.close()
            })
        } else {
            $.when(
                orgDetails(this.props.params.oid),
                funcDic(),
                rankDic(),
                roleDetails(this.props.params.rid)
            ).done((org, func, rank, role) => {
                let tempCheckedFunc = {};

                role.rootFuncs.map((item) => {
                    tempCheckedFunc[item.cId] = true;
                })

                this.setState({
                    editorId: role.cId,
                    org: {
                        id: org.cId,
                        name: org.cName
                    },
                    rank: rank,
                    func: formatFuncData(func),

                    checkedFunc: tempCheckedFunc,
                    checkedRank: role.cRankId.toString()
                })

                $(this.editorDom)
                    .find('[name=name]')
                    .val(role.cName)
                    .end()
                    .find('[name=desc]')
                    .val(role.cDesc)
            }).always(() => {
                dialogTips.close()
            })
        }
    }

    checkedFunc(event) {
        const isAdmin = event.target.value === FUNC_ADMIN_ID ? true : false;
        let tempFunc = $.extend({}, this.state.checkedFunc);
        let tempRank = this.state.checkedRank;
        let checkedFuncCount = 0;

        for (const key in this.state.checkedFunc) {
            if (this.state.checkedFunc[key] === true) {
                checkedFuncCount++;
            }
        }

        if (isAdmin && event.target.checked === true) {
            tempFunc = {};
            tempRank = RANK_ADMIN_ID;
        } else {
            delete tempFunc[FUNC_ADMIN_ID];

            if (tempRank === RANK_ADMIN_ID) {
                tempRank = null;
            }
        }

        tempFunc[event.target.value] = event.target.checked;

        this.setState({
            isAdmin: (isAdmin === true && event.target.checked === true) ? true : false,
            checkedFunc: tempFunc,
            checkedRank: tempRank
        })
    }

    checkedRank(event) {
        if (event.target.checked === true) {
            this.setState({
                checkedRank: event.target.value
            })
        } else {
            this.setState({
                checkedRank: null
            })
        }
    }

    editorSubmit() {
        const successPath = SCHOOLPAL_CONFIG.ROOTPATH + 'role';
        const loading = DialogTips({ type: 'loading' })
        const success = DialogTips({ type: 'success' })
        const fail = DialogTips({ type: 'fail', autoClose: true })
        let param = {};
        let funcIds = [];

        param.orgId = this.state.org.id;

        for (const key in this.state.checkedFunc) {
            if (this.state.checkedFunc[key] === true) {
                funcIds.push(key);
            };
        }

        param.strFuncIds = funcIds.join(',');
        param.rankId = this.state.checkedRank;
        param.name = $(this.editorDom).find('[name=name]').val()
        param.desc = $(this.editorDom).find('[name=desc]').val()

        loading.open()

        if (this.state.editorId) {
            param.id = this.state.editorId;
            roleMod(param)
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
            roleAdd(param)
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
            <div className="org">
                <h5>
                    <i className='fa fa-glass'></i>&nbsp;角色管理&nbsp;|&nbsp;<p className="d-inline text-muted">{subTitle(this.props.router.params.id, '角色')}</p>
                    <div className="btn-group float-right" role="group">
                        <BackButton router={this.props.router} />
                        <SaveButton action={this.editorSubmit} text="保存" />
                    </div>
                </h5>

                <div className="main-container">
                    <div className="d-flex align-items-stretch flex-nowrap">
                        <form ref={(dom) => { this.editorDom = dom }} className={this.state.org === null ? 'hide' : 'w500'}>
                            <div className="form-group">
                                <label for="name"><em className="text-danger">*</em>所属组织：</label>
                                <input type="text" className="form-control" value={this.state.org ? this.state.org.name : ''} disabled="disabled" />
                            </div>
                            <div className="form-group">
                                <label for="name"><em className="text-danger">*</em>角色职能</label>
                                <div>
                                    {
                                        this.state.func.map((item) => {
                                            const adminClass = item.cId === FUNC_ADMIN_ID ? 'form-check form-check-inline b-l pl-3' : 'form-check form-check-inline';

                                            return (
                                                <div key={item.cId} className={adminClass}>
                                                    <label className="form-check-label">
                                                        <input
                                                            onChange={this.checkedFunc}
                                                            className="form-check-input"
                                                            type="checkbox"
                                                            value={item.cId}
                                                            checked={this.state.checkedFunc[item.cId] ? this.state.checkedFunc[item.cId] : false}
                                                            name="func"
                                                        />
                                                        <span className="align-middle">{item.cNameShort}</span>
                                                    </label>
                                                </div>
                                            )
                                        })
                                    }
                                </div>
                            </div>
                            <div className="form-group">
                                <label for="name"><em className="text-danger">*</em>角色职级</label>
                                <div>
                                    {
                                        this.state.rank.map((item) => {
                                            const adminClass = item.cId.toString() === RANK_ADMIN_ID ? 'form-check form-check-inline b-l pl-3' : 'form-check form-check-inline';
                                            let isDisabled = false;
                                            let isChecked = false;
                                            let checkedFuncCount = 0;

                                            for (const key in this.state.checkedFunc) {
                                                if (this.state.checkedFunc[key] === true) {
                                                    checkedFuncCount++;
                                                }
                                            }

                                            if (this.state.isAdmin === true) {
                                                isDisabled = item.cId.toString() !== RANK_ADMIN_ID ? true : false;
                                            } else {
                                                if (checkedFuncCount > 1) {
                                                    isDisabled = item.cId === 1 ? false : true;
                                                }

                                                if (checkedFuncCount === 1) {
                                                    isDisabled = item.cId.toString() === RANK_ADMIN_ID ? true : false;
                                                }
                                            }

                                            return (
                                                <div key={item.cId} className={adminClass}>
                                                    <label className="form-check-label">
                                                        <input
                                                            onChange={this.checkedRank}
                                                            className="form-check-input"
                                                            type="radio"
                                                            name="rank"
                                                            disabled={isDisabled}
                                                            checked={item.cId.toString() === this.state.checkedRank ? true : false}
                                                            value={item.cId}
                                                        />
                                                        <span className="align-middle">{item.cName}</span>
                                                    </label>
                                                </div>
                                            )
                                        })
                                    }
                                </div>
                            </div>
                            <div className="form-group">
                                <label for="name">角色名称</label>
                                <input type="text" className="form-control" name="name" />
                            </div>
                            <div className="form-group">
                                <label for="name">角色描述</label>
                                <textarea name="desc" className="form-control" rows="3"></textarea>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        )
    }

}