import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';
import OrgTree from '../public/OrgTree';
import { orgList } from '../../utils/api';

export default class Editor extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            loading: true,
            orgList: [],
            selected: null,
        }
    }

    componentDidMount() {
        orgList()
            .done((data) => {
                this.setState({
                    loading: false,
                    orgList: data
                })
            })
    }

    selectOrg(org) {
        if (org) {
            this.setState({
                selected: org
            })
        } else {
            this.setState({
                selected: null
            })
        };
    }

    render() {
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
                            <OrgTree data={this.state.orgList} selected={this.selectOrg} defaults={this.state.selected ? this.state.selected.id : null} />
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
            </div>
        )
    }

}