import React from 'react';
import subTitle from '../../../utils/subTitle';
import { EditorButton, DelButton, BackButton } from '../../public/Button';

export default class Editor extends React.Component {
    constructor(props) {
        super(props)
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
                        <i className="fa fa-pie-chart" aria-hidden="true"></i>&nbsp;我的合同&nbsp;&nbsp;|&nbsp;&nbsp;<p className="d-inline text-muted">{subTitle(this.props.router.params.id, '销售线索')}</p>
                        <div className="btn-group float-right mr-4" role="group">
                            <button type="button" className="btn btn-secondary">上一条</button>
                            <button type="button" className="btn btn-secondary">下一条</button>
                        </div>
                        <div className="btn-group float-right mr-4" role="group">
                            <BackButton router={this.props.router} />
                        </div>
                        <div className="btn-group float-right mr-4" role="group">
                            {this.renderCommand()}
                        </div>
                    </h5>

                    <div className="main-container">
                        <p className="ht pb-3 b-b">基本信息</p>
                        <div className="row">
                            <div className="col">
                                <ul>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100"><em className="text-danger">*</em>学员ID</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">学员编号</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100"><em className="text-danger">*</em>学员姓名</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">姓别</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">出生年月</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">年龄</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div className="col">
                                <ul>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100"><em className="text-danger">*</em>证件类型</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100"><em className="text-danger">*</em>证件号码</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100"><em className="text-danger">*</em>在读年级</label>
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
                                        <label for="name" className="col-form-label d-block w100">家长姓名</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">与孩子关系</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">联系电话</label>
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
                                        <label for="name" className="col-form-label d-block w100">电子邮箱</label>
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
                            <div className="col"></div>
                        </div>

                        <p className="ht pt-3 pb-3 b-t b-b">合同信息</p>
                        <div className="row">
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
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">课时</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">课次</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div className="col">
                                <ul>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">合同金额</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">折扣金额</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">应付金额</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">已付金额</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div className="col">
                                <ul>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">合同编号</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">合同类型</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">签约日期</label>
                                        <div className="flex-cell">
                                            <p className="form-control-static">xxxxxxxx</p>
                                        </div>
                                    </li>
                                    <li className="d-flex">
                                        <label for="name" className="col-form-label d-block w100">到期日期</label>
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
                    </div>

                </form>

            </div>
        )
    }
}