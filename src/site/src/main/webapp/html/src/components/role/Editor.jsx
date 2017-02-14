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
        <div className="org">
            <h5>
                <i className='fa fa-glass'></i>&nbsp;角色管理&nbsp;|&nbsp;<p className="d-inline text-muted">角色组织</p>
                <div className="btn-group float-right" role="group">
                    <button type="button" className="btn btn-secondary">保存</button>
                    <button type="button" className="btn btn-secondary">取消</button>
                </div>
            </h5>
            <form>
                <div className="form-group row">
                    <label for="name" className="col-2 col-form-label">所属组织</label>
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
                    <label for="name" className="col-2 col-form-label">角色职能</label>
                    <div className="col-10">
                        <div className="form-check form-check-inline">
                            <label className="form-check-label">
                                <input className="form-check-input" type="checkbox" value="option1" /> 市场
                            </label>
                        </div>
                        <div className="form-check form-check-inline">
                            <label className="form-check-label">
                                <input className="form-check-input" type="checkbox" value="option1" /> 销售
                            </label>
                        </div>
                        <div className="form-check form-check-inline">
                            <label className="form-check-label">
                                <input className="form-check-input" type="checkbox" value="option1" /> 客服
                            </label>
                        </div>
                        <div className="form-check form-check-inline">
                            <label className="form-check-label">
                                <input className="form-check-input" type="checkbox" value="option1" /> 财务
                            </label>
                        </div>
                        <div className="form-check form-check-inline">
                            <label className="form-check-label">
                                <input className="form-check-input" type="checkbox" value="option1" /> 教务
                            </label>
                        </div>
                        <div className="form-check form-check-inline">
                            <label className="form-check-label">
                                <input className="form-check-input" type="checkbox" value="option1" /> 教学
                            </label>
                        </div>
                        <div className="form-check form-check-inline">
                            <label className="form-check-label">
                                <input className="form-check-input" type="radio" name="inlineRadioOptions" value="option1" /> 系统管理
                            </label>
                        </div>
                    </div>
                </div>
                <div className="form-group row">
                    <label for="name" className="col-2 col-form-label">角色职级</label>
                    <div className="col-10">
                        <div className="form-check form-check-inline">
                            <label className="form-check-label">
                                <input className="form-check-input" type="radio" name="rank" value="option1" /> 经理
                            </label>
                        </div>
                        <div className="form-check form-check-inline">
                            <label className="form-check-label">
                                <input className="form-check-input" type="radio" name="rank" value="option1" /> 主管
                            </label>
                        </div>
                        <div className="form-check form-check-inline">
                            <label className="form-check-label">
                                <input className="form-check-input" type="radio" name="rank" value="option1" /> 专员
                            </label>
                        </div>
                        <div className="form-check form-check-inline">
                            <label className="form-check-label">
                                <input className="form-check-input" type="radio" name="inlineRadioOptions" value="option1" /> 系统管理员
                            </label>
                        </div>
                    </div>
                </div>
                <div className="form-group row">
                    <label for="name" className="col-2 col-form-label">负责人</label>
                    <div className="col-4">
                        <input className="form-control" type="text" id="name" />
                    </div>
                </div>
                <div className="form-group row">
                    <label for="addr" className="col-2 col-form-label">角色描述</label>
                    <div className="col-4">
                        <textarea className="form-control" id="addr" rows="3"></textarea>
                    </div>
                </div>
            </form>
            <OrgTree data={data} panel={true} />
        </div>
    )
}