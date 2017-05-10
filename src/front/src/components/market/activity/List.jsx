import React from 'react'
import { Link } from 'react-router';
import { CreateButton } from '../../public/Button'
import command from '../../../utils/command'
import formatDate from '../../../utils/formatDate'
import { marketActivityList } from '../../../utils/api';
import DialogTips from '../../../utils/DialogTips';

export default class List extends React.Component {
    constructor(props) {
        super(props)

        this.state = { list: [] }
        this.renderCommand = this.renderCommand.bind(this)
        this.renderItems = this.renderItems.bind(this)
    }

    componentDidMount() {
        if (this.props.org) {
            const dialogTips = DialogTips({ type: 'loading' })

            dialogTips.open()
            marketActivityList(this.props.org.id)
                .done((data) => {
                    this.setState({ list: data })
                })
                .always(() => {
                    dialogTips.close()
                })
        }
    }

    componentWillReceiveProps(nextProps) {
        if (nextProps.org) {
            if (!this.props.org || this.props.org.id !== nextProps.org.id) {
                const dialogTips = DialogTips({ type: 'loading' })

                dialogTips.open()
                marketActivityList(nextProps.org.id)
                    .done((data) => {
                        this.setState({ list: data })
                    })
                    .always(() => {
                        dialogTips.close()
                    })
            }
        }
    }

    renderCommand() {
        const path = this.props.location.pathname.replace(SCHOOLPAL_CONFIG.ROOTPATH, '');
        const commands = command(path);
        let temp = [];

        commands.map((item, index) => {
            if (item === 'Add') {
                temp.push(<CreateButton key={index} link={this.props.location.pathname + '/edit/create'} />)
            };
        })

        return temp;
    }

    renderItems(data) {
        return (
            <tr key={data.id}>
                <td>{data.id}</td>
                <td>--</td>
                <td>{formatDate(data.createTime)}</td>
                <td>
                    {
                        data.hasChild === false ? '' : <span className='tree-node'></span>
                    }
                    <Link to={this.props.location.pathname + '/' + data.id}>{data.name}</Link>
                </td>
                <td>{formatDate(data.startDate)}</td>
                <td>{formatDate(data.endDate)}</td>
                <td>{data.budget}</td>
                <td>{data.cost}</td>
                <td>{data.leads}</td>
                <td>{data.opportunities}</td>
                <td>{data.contracts}</td>
                <td>--</td>
                <td>--</td>
            </tr>
        )
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
                            {this.state.list.map(this.renderItems)}
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}