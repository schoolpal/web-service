import React from 'react'
import { Link } from 'react-router'
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
                    <i className="fa fa-pie-chart" aria-hidden="true"></i>&nbsp;销售线索
                    <div className="btn-group float-right mr-4" role="group">
                        <button type="button" className="btn btn-success"><i className="fa fa-file-excel-o" aria-hidden="true"></i> 导入</button>
                        {this.renderCommand()}
                    </div>
                </h5>

                <div className="main-container">
                    <ul className="nav nav-tabs mb-3">
                        <li className="nav-item">
                            <a className="nav-link active" href="#">新招</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="#">续报</a>
                        </li>
                    </ul>

                    <table className='table table-bordered table-sm'>
                        <thead>
                            <tr>
                                <th>创建人</th>
                                <th>创建时间</th>
                                <th>所属组织</th>
                                <th>所属用户</th>
                                <th>来源</th>
                                <th>市场活动</th>
                                <th>类型</th>
                                <th>阶段</th>
                                <th>状态</th>
                                <th>学员姓名</th>
                                <th>性别</th>
                                <th>年龄</th>
                                <th>在读年级</th>
                                <th>所在学校</th>
                                <th>家长姓名</th>
                                <th>与学员关系</th>
                                <th>电话号码</th>
                                <th>微信号</th>
                                <th>家庭住址</th>
                                <th>课程类别</th>
                                <th>课程产品</th>
                                <th>备注</th>
                                <th>沟通记录</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>曹磊</td>
                                <td>2015-05-05 10：00</td>
                                <td>门头沟龙湖校区</td>
                                <td>苗地</td>
                                <td>call in</td>
                                <td>百度推广1期</td>
                                <td>新招</td>
                                <td>已转化</td>
                                <td>已转化</td>
                                <td>
                                    <Link to={this.props.location.pathname + '/123'}>刁梦缘</Link>
                                </td>
                                <td>男</td>
                                <td>3</td>
                                <td>幼儿园小班</td>
                                <td>石景山第三幼儿园</td>
                                <td>
                                    <Link to={this.props.location.pathname + '/123'}>刁旭</Link>
                                </td>
                                <td>父亲</td>
                                <td>13911015199</td>
                                <td>dxyl218106</td>
                                <td>石景山区模式口大街60号院</td>
                                <td>ise-start</td>
                                <td>pre-k</td>
                                <td>--</td>
                                <td>2016-05-10</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}