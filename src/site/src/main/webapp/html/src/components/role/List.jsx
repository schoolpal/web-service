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
            <div className="role">
                <h5>
                    <i className='fa fa-glass'></i>&nbsp;角色管理
                    <div className="btn-group float-right" role="group">
                        <Link to={`/role/create`} className="btn btn-secondary">新建</Link>
                        <button type="button" className="btn btn-secondary">删除</button>
                    </div>
                </h5>
                <div className="row">
                    <div className="col-4">
                        <OrgTree data={this.state.data} />
                    </div>
                    <div className="col-8">
                        <table className="table table-bordered">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>角色职能</th>
                                    <th>角色职级</th>
                                    <th>角色名称</th>
                                    <th>角色描述</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <label className="form-check-label">
                                            <input className="form-check-input" type="checkbox" id="blankCheckbox" value="option1" aria-label="..." />
                                        </label>
                                    </td>
                                    <td>市场、销售、客服、财务、教务、教学</td>
                                    <td>经理</td>
                                    <td>校长</td>
                                    <td></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        )
    }
}