import React from 'react';
import subTitle from '../../../utils/subTitle';
import OrgTree from '../../public/OrgTree';
import { SaveButton, BackButton } from '../../public/Button';
import { orgList } from '../../../utils/api';
import DialogTips from '../../../utils/DialogTips';

export default class Editor extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            orgList: [],
            selected: null
        }
        this.selectOrg = this.selectOrg.bind(this)
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

    render() {
        return (
            <div className="market">
                <form ref={(dom) => { this.editorDom = dom }}>

                    <h5>
                        <i className="fa fa-pie-chart" aria-hidden="true"></i>&nbsp;销售线索&nbsp;&nbsp;|&nbsp;&nbsp;<p className="d-inline text-muted">{subTitle(this.props.router.params.id, '销售线索')}</p>
                        <div className="btn-group float-right mr-4" role="group">
                            <BackButton router={this.props.router} />
                            <SaveButton text="保存" />
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
                                            <input type="text" className="form-control" name="name" required={true} />
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">学员姓别</label>
                                        <div className="flex-cell">
                                            <div className="form-check form-check-inline">
                                                <label className="form-check-label">
                                                    <input
                                                        className="form-check-input"
                                                        type="radio"
                                                        name="gender"
                                                    />
                                                    <span>男</span>
                                                </label>
                                            </div>
                                            <div className="form-check form-check-inline">
                                                <label className="form-check-label">
                                                    <input
                                                        className="form-check-input"
                                                        type="radio"
                                                        name="gender"
                                                    />
                                                    <span>女</span>
                                                </label>
                                            </div>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100"><em className="text-danger">*</em>学员年龄</label>
                                        <div className="flex-cell">
                                            <select className="form-control" required={true}>
                                                <option>请选择</option>
                                            </select>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">在读年级</label>
                                        <div className="flex-cell">
                                            <input type="text" className="form-control" name="name" required={true} />
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">所在学校</label>
                                        <div className="flex-cell">
                                            <input type="text" className="form-control" name="name" required={true} />
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div className="col">
                                <ul>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100"><em className="text-danger">*</em>家长姓名</label>
                                        <div className="flex-cell">
                                            <input type="text" className="form-control" name="name" required={true} />
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100"><em className="text-danger">*</em>与孩子关系</label>
                                        <div className="flex-cell">
                                            <select className="form-control" required={true}>
                                                <option>请选择</option>
                                            </select>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100"><em className="text-danger">*</em>联系电话</label>
                                        <div className="flex-cell">
                                            <input type="text" className="form-control" name="name" required={true} />
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">微信号</label>
                                        <div className="flex-cell">
                                            <input type="text" className="form-control" name="name" required={true} />
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">家庭住址</label>
                                        <div className="flex-cell">
                                            <input type="text" className="form-control" name="name" required={true} />
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div className="col">
                                <ul>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">课程类别</label>
                                        <div className="flex-cell">
                                            <select className="form-control" required={true}>
                                                <option>请选择</option>
                                            </select>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">课程产品</label>
                                        <div className="flex-cell">
                                            <select className="form-control" required={true}>
                                                <option>请选择</option>
                                            </select>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div className="col">
                                <ul>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">备注</label>
                                        <div className="flex-cell">
                                            <textarea className="form-control" rows='3'></textarea>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <p className="ht pb-3 b-b">线索信息</p>
                        <div className="row">
                            <div className="col">
                                <ul>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">信息来源</label>
                                        <div className="flex-cell">
                                            <select className="form-control" required={true}>
                                                <option>请选择</option>
                                            </select>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">具体渠道</label>
                                        <div className="flex-cell">
                                            <select className="form-control" required={true}>
                                                <option>请选择</option>
                                            </select>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div className="col">
                                <ul>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">线索阶段</label>
                                        <div className="flex-cell">
                                            <select className="form-control" required={true}>
                                                <option>请选择</option>
                                            </select>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">线索状态</label>
                                        <div className="flex-cell">
                                            <select className="form-control" required={true}>
                                                <option>请选择</option>
                                            </select>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div className="col">
                                <ul>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">所属组织</label>
                                        <div className="flex-cell">
                                            <select className="form-control" required={true}>
                                                <option>请选择</option>
                                            </select>
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
                            <div className="col">
                                <ul>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">创建人</label>
                                        <div className="flex-cell">
                                            <select className="form-control" required={true}>
                                                <option>请选择</option>
                                            </select>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">创建时间</label>
                                        <div className="flex-cell">
                                            <select className="form-control" required={true}>
                                                <option>请选择</option>
                                            </select>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <p className="ht pb-3 b-b">沟通记录</p>
                        <table className="table table-bordered">
                            <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>沟通方式</th>
                                    <th>咨询时间</th>
                                    <th>所属组织</th>
                                    <th>所属用户</th>
                                    <th>沟通记录</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td></td>
                                    <td>
                                        <select className="form-control">
                                            <option>请选择</option>
                                        </select>
                                    </td>
                                    <td>
                                        <input type="text" className="form-control" name="name" />
                                    </td>
                                    <td>
                                        <div className="btn-group btn-block">
                                            <input type="text" className="form-control" data-toggle="dropdown" value={this.state.selected ? this.state.selected.name : ''} readOnly />
                                            <div className="dropdown-menu">
                                                <OrgTree data={this.state.orgList} selected={this.selectOrg} defaults={this.state.selected ? this.state.selected.id : null} />
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <select className="form-control">
                                            <option>请选择</option>
                                        </select>
                                    </td>
                                    <td>
                                        <input type="text" className="form-control" name="name" />
                                    </td>
                                    <td>
                                        <button type="submit" className="btn btn-primary">保存</button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                </form>
            </div>
        )
    }
}