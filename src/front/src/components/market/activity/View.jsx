import React from 'react';
import subTitle from '../../../utils/subTitle';
import { EditorButton, DelButton, BackButton } from '../../public/Button';

require('../../../utils/datepicker');

export default class View extends React.Component {
    constructor(props) {
        super(props)

        this.renderCommand = this.renderCommand.bind(this)
        this.handleEditor = this.handleEditor.bind(this)
        this.confirmDel = this.confirmDel.bind(this)
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
        const editorPath = SCHOOLPAL_CONFIG.ROOTPATH + 'crm/market/activity/edit/' + this.props.params.id

        this.props.router.push(editorPath)
    }

    confirmDel() { } 

    render() {
        return (
            <div className="market">

                <h5>
                    <i className="fa fa-pie-chart" aria-hidden="true"></i>&nbsp;市场活动&nbsp;&nbsp;|&nbsp;&nbsp;<p className="d-inline text-muted">活动名称</p>

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
                    <div className="w500">
                        <dl>
                            <dt>活动名称</dt>
                            <dd className="b-l">xxxxx</dd>

                            <dt>父级市场活动</dt>
                            <dd className="b-l">xxxxx</dd>

                            <dt>时间周期</dt>
                            <dd className="b-l">xxxxx - xxxxx</dd>

                            <dt>预算费用</dt>
                            <dd className="b-l">xxxxx</dd>

                            <dt>实际费用</dt>
                            <dd className="b-l">xxxxx</dd>

                            <dt>创建人</dt>
                            <dd className="b-l">xxxxx</dd>

                            <dt>创建时间</dt>
                            <dd className="b-l">xxxxx</dd>
                        </dl>
                    </div>
                </div>

            </div>
        )
    }
}