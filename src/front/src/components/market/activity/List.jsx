import React from 'react'
import { Link } from 'react-router';
import { CreateButton } from '../../public/Button'

export default class List extends React.Component {
    constructor(props) {
        super(props)

        this.renderCommand = this.renderCommand.bind(this)
    }

    renderCommand() {
        const path = this.props.location.pathname.replace(SCHOOLPAL_CONFIG.ROOTPATH, '');
        const auth = SCHOOLPAL_CONFIG.commandRules.find((item) => { return item.PATH_RULE.test(path) === true });
        let temp = [];

        if (auth) {
            auth.command.map((item, index) => {
                if (item === 'Add') {
                    temp.push(<CreateButton key={index} link={this.props.location.pathname + '/edit/create'} />)
                };
            })
        }

        return temp;
    }

    render() {
        return (
            <div className="market">
                <h5>
                    <i className="fa fa-pie-chart" aria-hidden="true"></i>&nbsp;市场活动
                    <div className="btn-group float-right mr-4" role="group">
                        {this.renderCommand()}
                    </div>
                </h5>

                <div className="main-container">
                    <table className='table table-bordered table-sm'>
                        <thead>
                            <tr>
                                <th>序号(ID)</th>
                                <th>创建人</th>
                                <th>创建时间</th>
                                <th>活动名称</th>
                                <th>开始时间</th>
                                <th>结束时间</th>
                                <th>预计花费</th>
                                <th>实际花费</th>
                                <th>获取线索量</th>
                                <th>转化机会量</th>
                                <th>签约客户量</th>
                                <th>签约客户金额</th>
                                <th>ROI</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>曹磊</td>
                                <td>2016-03-28</td>
                                <td>
                                    <span className='tree-node'></span>
                                    <Link to={this.props.location.pathname + '/123'}>网络营销</Link>
                                </td>
                                <td>2016-04-01</td>
                                <td>2016-04-01</td>
                                <td>6000.00</td>
                                <td>6000.00</td>
                                <td>1000</td>
                                <td>1000</td>
                                <td>30</td>
                                <td>450000.00</td>
                                <td>40.00%</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}