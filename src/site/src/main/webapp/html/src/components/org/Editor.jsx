import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';
import OrgTree from '../public/OrgTree';


export default class Editor extends React.Component {
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
            <div className="org">
                <h5>
                    <i className="fa fa-sitemap" aria-hidden="true"></i>&nbsp;组织管理&nbsp;&nbsp;|&nbsp;&nbsp;<p className="d-inline text-muted">新建组织</p>
                    <div className="btn-group float-right" role="group">
                        <button type="button" className="btn btn-secondary">保存</button>
                        <button type="button" className="btn btn-secondary">取消</button>
                    </div>
                </h5>
                <form>
                    <div className="form-group row">
                        <label for="name" className="col-2 col-form-label">组织名称</label>
                        <div className="col-4">
                            <input className="form-control" type="text" id="name" />
                        </div>
                    </div>
                    <div className="form-group row">
                        <label for="name" className="col-2 col-form-label">父级组织</label>
                        <div className="col-4">
                            <div className="input-group">
                                <input type="text" className="form-control" readOnly />
                                <span className="input-group-btn">
                                    <button data-toggle="modal" data-target="#orgTreePanel" className="btn btn-secondary" type="button">
                                        <i className="fa fa-sitemap" aria-hidden="true"></i>
                                    </button>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div className="form-group row">
                        <label for="name" className="col-2 col-form-label">所在地区</label>
                        <div className="col-4">
                            <div className="row">
                                <div className="col">
                                    <select className="form-control" id="exampleSelect1">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>
                                </div>
                                <div className="col">
                                    <select className="form-control" id="exampleSelect1">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>
                                </div>
                                <div className="col">
                                    <select className="form-control" id="exampleSelect1">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="form-group row">
                        <label for="addr" className="col-2 col-form-label">详细地址</label>
                        <div className="col-4">
                            <textarea className="form-control" id="addr" rows="3"></textarea>
                        </div>
                    </div>
                    <div className="form-group row">
                        <label for="name" className="col-2 col-form-label">负责人</label>
                        <div className="col-2">
                            <input className="form-control" type="text" id="name" />
                        </div>
                    </div>
                    <div className="form-group row">
                        <label for="name" className="col-2 col-form-label">联系电话</label>
                        <div className="col-2">
                            <input className="form-control" type="text" id="name" />
                        </div>
                    </div>
                </form>
                <OrgTree data={this.state.data} panel={true} />
            </div>
        )
    }
}