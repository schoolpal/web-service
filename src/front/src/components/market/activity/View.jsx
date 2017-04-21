import React from 'react';
import { EditorButton, DelButton, BackButton } from '../../public/Button';
import subTitle from '../../../utils/subTitle';
import command from '../../../utils/command'

require('../../../utils/datepicker');


export default class View extends React.Component {
    constructor(props) {
        super(props)

        this.renderCommand = this.renderCommand.bind(this)
        this.handleEditor = this.handleEditor.bind(this)
        this.confirmDel = this.confirmDel.bind(this)
    }

    componentDidMount() {
        require.ensure(["echarts"], (require) => {
            const echarts = require('echarts');
            const myChart = echarts.init(document.getElementById('chart'));

            myChart.setOption({
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c}"
                },
                series: [
                    {
                        name: '预期',
                        type: 'funnel',
                        left: '10%',
                        width: '80%',
                        label: {
                            normal: {
                                formatter: '{b}预期'
                            },
                            emphasis: {
                                position: 'inside',
                                formatter: '{b}预期: {c}'
                            }
                        },
                        labelLine: {
                            normal: {
                                show: false
                            }
                        },
                        itemStyle: {
                            normal: {
                                opacity: 0.7
                            }
                        },
                        data: [
                            { value: 10, name: '签约客户量' },
                            { value: 50, name: '转化机会量' },
                            { value: 100, name: '获取线索量' }
                        ]
                    },
                    {
                        name: '实际',
                        type: 'funnel',
                        left: '10%',
                        width: '80%',
                        maxSize: '80%',
                        label: {
                            normal: {
                                position: 'inside',
                                formatter: '{c}',
                                textStyle: {
                                    color: '#fff'
                                }
                            },
                            emphasis: {
                                position: 'inside',
                                formatter: '{b}实际: {c}'
                            }
                        },
                        itemStyle: {
                            normal: {
                                opacity: 0.5,
                                borderColor: '#fff',
                                borderWidth: 2
                            }
                        },
                        data: [
                            { value: 5, name: '签约客户量' },
                            { value: 30, name: '转化机会量' },
                            { value: 100, name: '获取线索量' }
                        ]
                    }
                ]
            });
        }, 'echarts')
    }

    renderCommand() {
        const path = this.props.location.pathname.replace(SCHOOLPAL_CONFIG.ROOTPATH, '');
        const commands = command(path);
        let temp = [];

        commands.map((item, index) => {
            if (item === 'Mod') {
                temp.push(<EditorButton key={index} action={this.handleEditor} />)
            }

            if (item === 'Del') {
                temp.push(<DelButton key={index} action={this.confirmDel} />)
            }
        })

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
                    <div className="d-flex align-items-stretch flex-nowrap">
                        <div className="w300 pr-3 b-r">
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
                        <div id="chart" className="chart"></div>
                        <div className="flex-cell">
                            <p className="mb-0">签约客户金额</p>
                            <p className="mb-3">180000.00</p>
                            <p className="mb-0">投资回报率（ROI）</p>
                            <p>40%</p>
                        </div>
                    </div>
                </div>

            </div>
        )
    }
}