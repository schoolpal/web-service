import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';
import OrgTree from '../public/OrgTree';

function TableLine(data) {
    const spacingClass = 'tree-spacing-' + data.level;
    const childrenClass = data.children ? '' : 'not-child';

    return (
        <tr key={data.id} data-id={data.id}>
            <td>
                <p className={'tree-node ' + childrenClass + ' ' + spacingClass}>{data.name}</p>
            </td>
            <td>
                <div className="form-check form-check-inline">
                    <label className="form-check-label">
                        <input className="form-check-input" type="checkbox" value="option1" />
                    </label>
                </div>
            </td>
            <td>
                <div className="form-check form-check-inline">
                    <label className="form-check-label">
                        <input className="form-check-input" type="checkbox" value="option1" /> 查询
                    </label>
                </div>
                <div className="form-check form-check-inline">
                    <label className="form-check-label">
                        <input className="form-check-input" type="checkbox" value="option1" /> 新建
                    </label>
                </div>
                <div className="form-check form-check-inline">
                    <label className="form-check-label">
                        <input className="form-check-input" type="checkbox" value="option1" /> 编辑
                    </label>
                </div>
                <div className="form-check form-check-inline">
                    <label className="form-check-label">
                        <input className="form-check-input" type="checkbox" value="option1" /> 删除
                    </label>
                </div>
            </td>
        </tr>
    );
};

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

    renderTable(data) {
        let table = [];

        if (data.children && data.children.length) {
            let children = [];

            table.push(TableLine(data));

            data.children.forEach((item) => {
                children.push(this.renderTable(item));
            });

            table.push(children);
        } else {
            table.push(TableLine(data));
        };

        return table;
    }

    render() {
        return (
            <div className="auth">
                <h5>
                    <i className='fa fa-shield' aria-hidden="true"></i>&nbsp;权限管理
                    <div className="btn-group float-right" role="group">
                        <button className="btn btn-primary"><i className='fa fa-shield' aria-hidden="true"></i> 授权</button>
                    </div>
                </h5>

                <div className="d-flex align-items-stretch flex-nowrap">
                    <div>
                        <OrgTree data={this.state.data} />
                    </div>
                    <div className="p-4 b-lr">
                        <div className="form-check m-b-2">
                            <label className="form-check-label">
                                <input className="form-check-input" type="checkbox" value="option1" /> 校长
                            </label>
                        </div>
                        <div className="form-check m-b-2">
                            <label className="form-check-label">
                                <input className="form-check-input" type="checkbox" value="option1" /> 市场主管
                            </label>
                        </div>
                        <div className="form-check m-b-2">
                            <label className="form-check-label">
                                <input className="form-check-input" type="checkbox" value="option1" /> 销售专员
                            </label>
                        </div>
                        <div className="form-check m-b-2">
                            <label className="form-check-label">
                                <input className="form-check-input" type="checkbox" value="option1" /> 客服主管
                            </label>
                        </div>
                        <div className="form-check m-b-2">
                            <label className="form-check-label">
                                <input className="form-check-input" type="checkbox" value="option1" /> 财务专员
                            </label>
                        </div>
                        <div className="form-check m-b-2">
                            <label className="form-check-label">
                                <input className="form-check-input" type="checkbox" value="option1" /> 教务主管
                            </label>
                        </div>
                        <div className="form-check m-b-2">
                            <label className="form-check-label">
                                <input className="form-check-input" type="checkbox" value="option1" /> 教师
                            </label>
                        </div>
                    </div>
                    <div className="flex-cell p-2">
                        <table className="table">
                            <thead>
                                <tr>
                                    <th>系统菜单</th>
                                    <th>选取</th>
                                    <th>功能权限</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.renderTable(this.state.data)}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        )
    }
}