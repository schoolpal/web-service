import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';

function TableLine(data) {
    const spacingClass = 'tree-spacing-' + data.level;
    const childrenClass = data.children ? '' : 'not-child';

    return (
        <tr key={data.id} data-id={data.id}>
            <th scope="row">
                <div className="form-check form-check-inline">
                    <label className="form-check-label">
                        <input className="form-check-input" type="checkbox" value="option1" />
                    </label>
                </div>
            </th>
            <td>
                <p className={'tree-node ' + childrenClass + ' ' + spacingClass}>{data.name}</p>
            </td>
            <td>北京市朝阳区</td>
            <td>北京市朝阳区望京西里11号二层</td>
            <td></td>
            <td></td>
            <td>
                <button type="button" className="btn btn-link"><i className="fa fa-pencil-square-o fa-lg" aria-hidden="true"></i></button>
                <button type="button" className="btn btn-link"><i className="fa fa-trash-o fa-lg text-danger" aria-hidden="true"></i></button>
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
        console.log(this.props)
        return (
            <div className="org">
                <h5>
                    <i className="fa fa-sitemap" aria-hidden="true"></i>&nbsp;组织管理
                    <div className="btn-group float-right" role="group">
                        <Link to={`/org/create`} className="btn btn-primary"><i className="fa fa-clone" aria-hidden="true"></i> 新建</Link>
                        <button type="button" className="btn btn-danger"><i className="fa fa-trash-o" aria-hidden="true"></i> 删除</button>
                    </div>
                </h5>

                <table className="table table-bordered">
                    <thead>
                        <tr>
                            <th>&nbsp;</th>
                            <th>组织名称</th>
                            <th>所在地区</th>
                            <th>详细地址</th>
                            <th>负责人</th>
                            <th>联系电话</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.renderTable(this.state.data)}
                    </tbody>
                </table>
            </div>
        )
    }
}