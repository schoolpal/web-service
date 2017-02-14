import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';
import OrgTree from '../public/OrgTree';

export default function Editor(props) {
    const data = {
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

    return (
        <div className="user">
            <h5>
                <i className="fa fa-user" aria-hidden="true"></i>&nbsp;用户管理&nbsp;&nbsp;|&nbsp;&nbsp;<p className="d-inline text-muted">新建用户</p>
                <div className="btn-group float-right mr-4" role="group">
                    <Link to={`/user/create`} className="btn btn-primary"><i className="fa fa-clone" aria-hidden="true"></i> 新建</Link>
                    <button type="button" className="btn btn-danger"><i className="fa fa-trash-o" aria-hidden="true"></i> 删除</button>
                </div>
            </h5>
            <form>
                <div className="row">
                    <div className="col-4 b-r">
                        <div className="form-group row">
                            <label for="name" className="col-3 col-form-label">所属组织</label>
                            <div className="col-9">
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
                            <label for="name" className="col-3 col-form-label">用户名</label>
                            <div className="col-9">
                                <input className="form-control" type="text" id="name" />
                            </div>
                        </div>
                        <div className="form-group row">
                            <label for="name" className="col-3 col-form-label">负责人</label>
                            <div className="col-9">
                                <input className="form-control" type="text" id="name" />
                            </div>
                        </div>
                        <div className="form-group row">
                            <label for="name" className="col-3 col-form-label">登录密码</label>
                            <div className="col-9">
                                <input className="form-control" type="text" id="name" />
                            </div>
                        </div>
                        <div className="form-group row">
                            <label for="name" className="col-3 col-form-label">姓名</label>
                            <div className="col-9">
                                <input className="form-control" type="text" id="name" />
                            </div>
                        </div>
                        <div className="form-group row">
                            <label for="name" className="col-3 col-form-label">英文名</label>
                            <div className="col-9">
                                <input className="form-control" type="text" id="name" />
                            </div>
                        </div>
                        <div className="form-group row">
                            <label for="name" className="col-3 col-form-label">电话号码</label>
                            <div className="col-9">
                                <input className="form-control" type="text" id="name" />
                            </div>
                        </div>
                        <div className="form-group row">
                            <label for="name" className="col-3 col-form-label">电子邮箱</label>
                            <div className="col-9">
                                <input className="form-control" type="text" id="name" />
                            </div>
                        </div>
                        <div className="form-group row">
                            <label for="name" className="col-3 col-form-label">QQ</label>
                            <div className="col-9">
                                <input className="form-control" type="text" id="name" />
                            </div>
                        </div>
                    </div>
                    <div className="col-2">
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
                </div>
            </form>
            <OrgTree data={data} panel={true} />
        </div>
    )
}