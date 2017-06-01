import React from 'react';
import subTitle from '../../../utils/subTitle';
import OrgTree from '../../public/OrgTree';
import { EditorButton, DelButton, BackButton } from '../../public/Button';
import { orgList } from '../../../utils/api';
import DialogTips from '../../../utils/DialogTips';

export default class Editor extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            orgList: [],
            selected: null
        }
        this.renderCommand = this.renderCommand.bind(this)
        this.selectOrg = this.selectOrg.bind(this)
        this.handleEditor = this.handleEditor.bind(this)
        this.confirmDel = this.confirmDel.bind(this)
    }

    componentDidMount() {
        const dialogTips = DialogTips({ type: 'loading' })

        dialogTips.open()

        orgList()
            .done((data) => {
                this.setState({
                    orgList: data.tree,
                    selected: {
                        id: data.original[0].cId,
                        name: data.original[0].cName
                    }
                })
            })
            .always(() => {
                dialogTips.close()
            })
    }

    selectOrg(org) {
        if (org) {
            this.setState({
                selected: org
            })
        }
    }

    renderCommand() {
        const path = this.props.location.pathname.replace(SCHOOLPAL_CONFIG.ROOTPATH, '');
        const auth = SCHOOLPAL_CONFIG.commandRules.find((item) => { return item.PATH_RULE.test(path) === true });
        let temp = [];

        if (auth) {
            auth.command.map((item, index) => {
                if (item === 'Mod') {
                    temp.push(<EditorButton key={index} action={this.handleEditor} />)
                }

                if (item === 'Del') {
                    temp.push(<DelButton key={index} action={this.confirmDel} />)
                }
            })
        }

        return temp;
    }

    handleEditor() {
        const editorPath = SCHOOLPAL_CONFIG.ROOTPATH + 'crm/market/sales/edit/' + this.props.params.id

        this.props.router.push(editorPath)
    }

    confirmDel() { }

    render() {
        return (
            <div className="market">
                <form ref={(dom) => { this.editorDom = dom }}>

                    <h5>
                        <i className="fa fa-pie-chart" aria-hidden="true"></i>&nbsp;销售线索&nbsp;&nbsp;|&nbsp;&nbsp;<p className="d-inline text-muted">{subTitle(this.props.router.params.id, '销售线索')}</p>
                        <div className="btn-group float-right mr-4" role="group">
                            <button type="button" className="btn btn-secondary">上一条</button>
                            <button type="button" className="btn btn-secondary">下一条</button>
                        </div>
                        <div className="btn-group float-right mr-4" role="group">
                            <BackButton router={this.props.router} />
                        </div>
                        <div className="btn-group float-right mr-4" role="group">
                            {this.renderCommand()}
                            <button type="button" className="btn btn-primary" data-toggle="modal" data-target="#myModal">创建合同</button>
                            <button type="button" className="btn btn-primary" data-toggle="modal" data-target="#myModal">分配给</button>
                        </div>
                    </h5>

                    <div className="main-container">
                        <p className="ht pb-3 b-b">线索信息</p>
                        <div className="row">
                            <div className="col">
                                <ul>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100"><em className="text-danger">*</em>学员姓名</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">学员姓别</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100"><em className="text-danger">*</em>学员年龄</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">在读年级</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">所在学校</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div className="col">
                                <ul>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100"><em className="text-danger">*</em>家长姓名</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100"><em className="text-danger">*</em>与孩子关系</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100"><em className="text-danger">*</em>联系电话</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">微信号</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">家庭住址</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div className="col">
                                <ul>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">课程类别</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">课程产品</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div className="col">
                                <ul>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">备注</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>

                        <p className="ht pt-3 pb-3 b-t b-b">线索信息</p>
                        <div className="row">
                            <div className="col">
                                <ul>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">信息来源</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">市场活动</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div className="col">
                                <ul>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">类型</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">阶段</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">状态</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div className="col">
                                <ul>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">所属组织</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">所属用户</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div className="col">
                                <ul>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">创建人</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">创建时间</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>

                        <p className="ht pt-3 pb-3 b-t b-b">沟通记录</p>
                        <table className="table table-bordered table-sm">
                            <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>沟通方式</th>
                                    <th>咨询时间</th>
                                    <th>所属组织</th>
                                    <th>所属用户</th>
                                    <th>沟通记录</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Call in</td>
                                    <td>2016-05-05  10:58:35</td>
                                    <td>北京分公司/门头沟龙湖校区</td>
                                    <td>苗地</td>
                                    <td>孩子父亲咨询了校区情况，课程情况，服务价格，比较关心教学效果。已详细解答并推荐关注微信，权先生比较满意，表示需要商量一下。本周末跟进。</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                </form>

                <div className="modal fade" id="myModal" tabindex="-1">
                    <div className="modal-dialog">
                        <div className="modal-content">
                            <div className="modal-header">
                                <p className="h5 modal-title">分配给：权天恒</p>
                                <button type="button" className="close" data-dismiss="modal">
                                    <span>&times;</span>
                                </button>
                            </div>
                            <div className="modal-body">
                                <ul>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">所属组织</label>
                                        <div className="flex-cell">
                                            <div className="btn-group btn-block">
                                                <input type="text" className="form-control" data-toggle="dropdown" value={this.state.selected ? this.state.selected.name : ''} readOnly />
                                                <div className="dropdown-menu">
                                                    <OrgTree data={this.state.orgList} selected={this.selectOrg} defaults={this.state.selected ? this.state.selected.id : null} />
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">所属用户</label>
                                        <div className="flex-cell">
                                            <select className="form-control" required={true}>
                                                <option>请选择</option>
                                            </select>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-secondary" data-dismiss="modal">取消</button>
                                <button type="button" className="btn btn-primary">确定</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}