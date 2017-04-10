import React from 'react'
import { Link } from 'react-router'

export default class List extends React.Component {
    constructor(props) {
        super(props)
    }

    render() {
        return (
            <div className="contract">
                <h5>
                    <i className="fa fa-pie-chart" aria-hidden="true"></i>&nbsp;我的合同
                </h5>

                <div className="main-container">
                    <table className='table table-bordered table-sm'>
                        <thead>
                            <tr>
                                <th>序号</th>
                                <th>创建人</th>
                                <th>创建时间</th>
                                <th>所属组织</th>
                                <th>所属用户</th>
                                <th>合同类型</th>
                                <th>合同编号</th>
                                <th>签约时间</th>
                                <th>到期时间</th>
                                <th>学员姓名</th>
                                <th>家长姓名</th>
                                <th>联系电话</th>
                                <th>课程类别</th>
                                <th>课程</th>
                                <th>合同金额</th>
                                <th>折扣金额</th>
                                <th>应付金额</th>
                                <th>已付金额</th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        )
    }
}