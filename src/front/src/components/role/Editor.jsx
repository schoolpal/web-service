import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';
import OrgTree from '../public/OrgTree';
import Alerts from '../public/Alerts';
import { SaveButton } from '../public/Button';
import { orgList, funcDic, rankDic, roleAdd } from '../../utils/api';

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
            loading: true,
            orgList: [],
            selected: null,

            rank: [],
            func: [],

            isAdmin: false,
            checkedFunc: {},
            checkedRank: null,

            saveLoading: false,
            saveResult: null
        }

        this.selectOrg = this.selectOrg.bind(this);
        this.showAlert = this.showAlert.bind(this);
        this.clearAlert = this.clearAlert.bind(this);
        this.checkedFunc = this.checkedFunc.bind(this);
        this.checkedRank = this.checkedRank.bind(this);
        this.editorSubmit = this.editorSubmit.bind(this);
    }

    componentDidMount() {
        $.when(orgList(), funcDic(), rankDic())
            .done((org, func, rank) => {
                this.setState({
                    loading: false,
                    orgList: org.tree,
                    rank: rank,
                    func: formatFuncData(func)
                })
            })
    }

    selectOrg(org) {
        if (org) {
            this.setState({
                selected: org
            })
        } else {
            this.setState({
                selected: null
            })
        };
    }

    checkedFunc(event) {
        const isAdmin = event.target.value === FUNC_ADMIN_ID ? true : false;
        let tempFunc = $.extend({}, this.state.checkedFunc);
        let tempRank = this.state.checkedRank;

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
        let param = {};
        let funcIds = [];

        param.orgId = this.state.selected.id;

        for (const key in this.state.checkedFunc) {
            if (this.state.checkedFunc[key] === true) {
                funcIds.push(key);
            };
        }

        param.strFuncIds = funcIds.join(',');
        param.rankId = this.state.checkedRank;
        param.name = $(this.editorDom).find('[name=name]').val()
        param.desc = $(this.editorDom).find('[name=desc]').val()

        this.setState({
            saveLoading: true
        })

        roleAdd(param)
            .done(() => {
                this.setState({
                    saveLoading: false,
                    selected: null,
                    isAdmin: false,
                    checkedFunc: {},
                    checkedRank: null,
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

    showAlert() {
        if (this.state.saveResult) {
            return (
                <Alerts type={this.state.saveResult.type} title={this.state.saveResult.title} text={this.state.saveResult.text}>
                    <Link to={SCHOOLPAL_CONFIG.ROOTPATH + 'role'} className="alert-link">返回列表</Link>
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
            <div className="org">
                <h5>
                    <i className='fa fa-glass'></i>&nbsp;角色管理&nbsp;|&nbsp;<p className="d-inline text-muted">角色组织</p>
                    <div className="btn-group float-right" role="group">
                        <SaveButton action={this.editorSubmit} text="保存" loading={this.state.saveLoading} />
                    </div>
                </h5>

                {this.showAlert()}

                <div onClick={this.clearAlert} className="main-container">
                    <div className="d-flex align-items-stretch flex-nowrap">
                        <div className={this.state.loading === true || this.props.params.id !== 'create' ? 'hide' : 'w300'}>
                            <OrgTree data={this.state.orgList} selected={this.selectOrg} defaults={this.state.selected ? this.state.selected.id : null} />
                        </div>
                        <form ref={(dom) => { this.editorDom = dom }} className={this.state.selected === null ? 'hide' : 'flex-cell pl-3 b-l'}>
                            <p className="h6 pb-3 b-b">所属组织：{this.state.selected ? this.state.selected.name : ''}</p>
                            <div className="w500">
                                <div className="form-group">
                                    <label for="name"><em className="text-danger">*</em>角色职能</label>
                                    <div>
                                        {
                                            this.state.func.map((item) => {
                                                return (
                                                    <div key={item.cId} className="form-check form-check-inline">
                                                        <label className="form-check-label">
                                                            <input
                                                                onChange={this.checkedFunc}
                                                                className="form-check-input"
                                                                type="checkbox"
                                                                value={item.cId}
                                                                checked={this.state.checkedFunc[item.cId] ? this.state.checkedFunc[item.cId] : false}
                                                                name="func"
                                                            />
                                                            {item.cNameShort}
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
                                                let isDisabled = false;
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
                                                    <div key={item.cId} className="form-check form-check-inline">
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
                                                            {item.cName}
                                                        </label>
                                                    </div>
                                                )
                                            })
                                        }
                                    </div>
                                </div>
                                <div className="form-group">
                                    <label for="name">负责人</label>
                                    <input type="text" className="form-control" name="name" />
                                </div>
                                <div className="form-group">
                                    <label for="name">角色描述</label>
                                    <textarea name="desc" className="form-control" rows="3"></textarea>
                                </div>
                            </div>
                        </form>
                    </div>

                    {this.state.loading === true ? <p>数据加载中 ...</p> : ''}
                </div>
            </div>
        )
    }

}