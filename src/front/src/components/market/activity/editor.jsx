import React from 'react';
import subTitle from '../../../utils/subTitle';
import { SaveButton, BackButton } from '../../public/Button';

require('../../../utils/datepicker');

export default class Editor extends React.Component {
    constructor(props) {
        super(props)
    }

    render() {
        return (
            <div className="market">
                <form ref={(dom) => { this.editorDom = dom }}>

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
                                <label for="name"><em className="text-danger">*</em>时间范围</label>
                                <div data-toggle="datepicker" className="form-inline input-daterange">
                                    <input type="text" className="form-control input-date w200" name="name" required={true} />
                                    <span className="form-control-static">&nbsp;-&nbsp;</span>
                                    <input type="text" className="form-control input-date w200" name="name" required={true} />
                                </div>
                            </div>

                            <div className="form-group">
                                <label for="name"><em className="text-danger">*</em>预算费用</label>
                                <input type="text" className="form-control" name="name" required={true} />
                            </div>

                            <div className="form-group">
                                <label for="name"><em className="text-danger">*</em>实际费用</label>
                                <input type="text" className="form-control" name="name" required={true} />
                            </div>

                            <div className="form-group">
                                <label for="name"><em className="text-danger">*</em>创建人</label>
                                <input type="text" className="form-control" name="name" required={true} />
                            </div>

                            <div className="form-group">
                                <label for="name"><em className="text-danger">*</em>创建时间</label>
                                <input type="text" className="form-control" name="name" required={true} />
                            </div>

                        </div>
                    </div>

                </form>
            </div>
        )
    }
}