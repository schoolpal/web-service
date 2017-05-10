import React from 'react';
import subTitle from '../../../utils/subTitle';
import { SaveButton, BackButton } from '../../public/Button';
import { marketActivityAdd } from '../../../utils/api';
import DialogTips from '../../../utils/DialogTips';

require('../../../utils/datepicker');

export default class Editor extends React.Component {
    constructor(props) {
        super(props)

        this.editorSubmit = this.editorSubmit.bind(this)
    }

    editorSubmit(event) {
        if (this.editorDom.checkValidity() === true) {
            event.preventDefault()
        };

        const addSuccessPath = SCHOOLPAL_CONFIG.ROOTPATH + 'crm/market/activity';
        const loading = DialogTips({ type: 'loading' })
        const success = DialogTips({ type: 'success' })
        const fail = DialogTips({ type: 'fail', autoClose: true })
        let param = {};

        param.orgnizationId = this.props.org.id;
        //param.parentId = null;
        param.name = $(this.editorDom).find('[name=name]').val()
        param.startDate = new Date($(this.editorDom).find('[name=startDate]').val())
        param.endDate = new Date($(this.editorDom).find('[name=endDate]').val())
        param.budget = $(this.editorDom).find('[name=budget]').val() ? $(this.editorDom).find('[name=budget]').val() : 0;
        param.cost = $(this.editorDom).find('[name=cost]').val() ? $(this.editorDom).find('[name=cost]').val() : 0;

        loading.open()

        //if (this.state.editorId) {
        //param.id = this.state.editorId;
        //} else {
        marketActivityAdd(param)
            .done(() => {
                loading.close()
                success.open()
                setTimeout(() => {
                    success.close()
                    this.props.router.push(addSuccessPath)
                }, 2000)
            })
            .fail((data) => {
                loading.close()
                fail.open()
            })
        //}
    }

    render() {
        return (
            <div className="market">
                <form ref={(dom) => { this.editorDom = dom }} onSubmit={this.editorSubmit}>

                    <h5>
                        <i className="fa fa-pie-chart" aria-hidden="true"></i>&nbsp;市场活动&nbsp;&nbsp;|&nbsp;&nbsp;<p className="d-inline text-muted">{subTitle(this.props.router.params.id, '市场活动')}</p>
                        <div className="btn-group float-right mr-4" role="group">
                            <BackButton router={this.props.router} />
                            <SaveButton text="保存" />
                        </div>
                    </h5>

                    <div className="main-container">
                        <div className="w500">

                            <div className="form-group">
                                <label for="name"><em className="text-danger">*</em>活动名称</label>
                                <input type="text" className="form-control" name="name" required={true} />
                            </div>

                            <div className="form-group">
                                <label for="name"><em className="text-danger">*</em>父级市场活动</label>
                                <select className="form-control" required={true}>
                                    <option>作为一级活动</option>
                                </select>
                            </div>

                            <div className="form-group">
                                <label for="name">时间范围</label>
                                <div data-toggle="datepicker" className="form-inline input-daterange">
                                    <input type="text" className="form-control input-date w200" name="startDate" />
                                    <span className="form-control-static">&nbsp;-&nbsp;</span>
                                    <input type="text" className="form-control input-date w200" name="endDate" />
                                </div>
                            </div>

                            <div className="form-group">
                                <label for="name">预算费用</label>
                                <input type="text" className="form-control" name="budget" />
                            </div>

                            <div className="form-group">
                                <label for="name">实际费用</label>
                                <input type="text" className="form-control" name="cost" />
                            </div>

                        </div>
                    </div>

                </form>
            </div>
        )
    }
}