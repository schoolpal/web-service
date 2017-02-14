import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';
import OrgTree from '../public/OrgTree';

export default class List extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            data: {
                id: 1,
                name: 'root',
                level: 1,
                children: [
                    {
                        id: 2,
                        name: 'root-1',
                        level: 2,
                        children: [
                            {
                                id: 3,
                                name: 'root-1-1',
                                level: 3
                            }
                        ]
                    },
                    {
                        id: 4,
                        name: 'root-2',
                        level: 2
                    }
                ]
            }
        };
    }

    render() {
        return (
            <div className="user">
                <h5>
                    <i className="fa fa-user" aria-hidden="true"></i>&nbsp;用户管理
                    <div className="btn-group float-right" role="group">
                        <button type="button" className="btn btn-success"><i className="fa fa-unlock" aria-hidden="true"></i> 启用</button>
                        <button type="button" className="btn btn-danger"><i className="fa fa-lock" aria-hidden="true"></i> 停用</button>
                    </div>
                    <div className="btn-group float-right mr-4" role="group">
                        <Link to={`/user/create`} className="btn btn-primary"><i className="fa fa-clone" aria-hidden="true"></i> 新建</Link>
                        <button type="button" className="btn btn-danger"><i className="fa fa-trash-o" aria-hidden="true"></i> 删除</button>
                    </div>
                </h5>
                <div className="d-flex align-items-stretch flex-nowrap">
                    <div>
                        <OrgTree data={this.state.data} />
                    </div>
                    <div className="flex-cell pl-4 pr-4 b-l">
                        <table className="table table-bordered table-sm">
                            <thead>
                                <tr>
                                    <th>&nbsp;</th>
                                    <th>状态</th>
                                    <th>用户名</th>
                                    <th>登录密码</th>
                                    <th>姓名</th>
                                    <th>英文名</th>
                                    <th>电话号码</th>
                                    <th>电子邮件</th>
                                    <th>QQ</th>
                                    <th>用户角色</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <div className="form-check form-check-inline">
                                            <label className="form-check-label">
                                                <input className="form-check-input" type="checkbox" value="option1" />
                                            </label>
                                        </div>
                                    </td>
                                    <td>启用</td>
                                    <td>Admin</td>
                                    <td>123456</td>
                                    <td>宋文杰</td>
                                    <td>jesse</td>
                                    <td>13810293403</td>
                                    <td>13810293403@139.com</td>
                                    <td>470777731</td>
                                    <td>系统管理员</td>
                                    <td>
                                        <button type="button" className="btn btn-link"><i className="fa fa-pencil-square-o fa-lg" aria-hidden="true"></i></button>
                                        <button type="button" className="btn btn-link"><i className="fa fa-trash-o fa-lg text-danger" aria-hidden="true"></i></button>
                                        <button type="button" className="btn btn-link"><i className="fa fa-lock fa-lg" aria-hidden="true"></i></button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        )
    }
}