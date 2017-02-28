import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';
import OrgTree from '../public/OrgTree';
import subTitle from '../../utils/subTitle';
import Alerts from '../public/Alerts';
import { SaveButton } from '../public/Button';
import { orgList, orgAdd } from '../../utils/api';

require('../../utils/city');

export default class Editor extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            loading: true,
            saveLoading: false,
            orgList: [],
            selected: null,
            saveResult: null
        };
        this.selectOrg = this.selectOrg.bind(this);
        this.editorSubmit = this.editorSubmit.bind(this);
        this.editorSubmitCallback = this.editorSubmitCallback.bind(this);
        this.clearAlert = this.clearAlert.bind(this);
    }

    componentDidMount() {
        orgList()
            .done((data) => {
                this.setState({
                    loading: false,
                    orgList: data
                })
            })

        $('#citys').citys();
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

    editorSubmit() {
        let param = {};

        $(this.editorDom).serializeArray().map((item) => {
            param[item.name] = item.value;
        })

        param.parentId = this.state.selected.id;
        param.state = $('#citys').find('[name="state_code"]').find("option:selected").text();
        param.city = $('#citys').find('[name="city_code"]').find("option:selected").text();
        param.county = $('#citys').find('[name="county_code"]').find("option:selected").text();

        this.setState({
            saveLoading: true
        })

        orgAdd(param)
            .done(() => { this.editorSubmitCallback(); })
            .fail((data) => { this.editorSubmitCallback(data); })
    }

    editorSubmitCallback(data) {
        if (data) {
            this.setState({
                saveLoading: false,
                saveResult: {
                    type: 'danger',
                    'title': 'Oh snap!',
                    'text': '[' + data.data.code + '] ' + data.data.detail
                }
            })
        } else {
            this.setState({
                loading: true,
                saveLoading: false,
                selected: null,
                saveResult: {
                    type: 'success',
                    title: 'Well done!',
                    text: '添加成功 ！'
                }
            })

            $(this.editorDom)
                .find('input, textarea')
                .val('');

            $('#citys')
                .find('[name="state"]')
                .find('option')
                .eq(0)
                .attr('selected', true)
                .trigger('change');

            orgList()
                .done((data) => {
                    this.setState({
                        loading: false,
                        orgList: data
                    })
                })
        }
    }

    clearAlert() {
        this.setState({
            saveResult: null
        })
    }

    render() {
        return (
            <div className="org">
                <h5>
                    <i className="fa fa-sitemap" aria-hidden="true"></i>&nbsp;组织管理&nbsp;&nbsp;|&nbsp;&nbsp;<p className="d-inline text-muted">{subTitle(this.props.router.params.id, '组织')}</p>
                    <div className="btn-group float-right" role="group">
                        <SaveButton action={this.editorSubmit} text="保存" loading={this.state.saveLoading} />
                    </div>
                </h5>
                {this.state.saveResult ? <Alerts type={this.state.saveResult.type} title={this.state.saveResult.title} text={this.state.saveResult.text} /> : ''}
                <div onClick={this.clearAlert} className="main-container">
                    <div className="d-flex align-items-stretch flex-nowrap">
                        <div className={this.state.loading === true ? 'hide' : 'w400'}>
                            <OrgTree data={this.state.orgList} selected={this.selectOrg} defaults={this.state.selected ? this.state.selected.id : null} />
                        </div>
                        <form ref={(dom) => { this.editorDom = dom }} className={this.state.selected === null ? 'hide' : 'flex-cell pl-3 b-l'}>
                            <p className="h6 pb-3 b-b">父级组织：{this.state.selected ? this.state.selected.name : ''}</p>
                            <div className="w400">
                                <div className="form-group">
                                    <label for="name"><em className="text-danger">*</em>组织名称</label>
                                    <input type="text" className="form-control" name="name" />
                                </div>
                                <div className="form-group">
                                    <label for="name"><em className="text-danger">*</em>组织代码</label>
                                    <input type="text" className="form-control" name="code" />
                                </div>
                                <div className="form-group">
                                    <label for="name"><em className="text-danger">*</em>所在地区</label>
                                    <div id="citys" className="row">
                                        <div className="col">
                                            <select name="state_code" className="form-control"></select>
                                        </div>
                                        <div className="col">
                                            <select name="city_code" className="form-control"></select>
                                        </div>
                                        <div className="col">
                                            <select name="county_code" className="form-control"></select>
                                        </div>
                                    </div>
                                </div>
                                <div className="form-group">
                                    <label for="name"><em className="text-danger">*</em>详细地址</label>
                                    <textarea name="address" className="form-control" rows="3"></textarea>
                                </div>
                                <div className="form-group">
                                    <label for="name"><em className="text-danger">*</em>负责人</label>
                                    <input type="text" className="form-control" name="owner" />
                                </div>
                                <div className="form-group">
                                    <label for="name"><em className="text-danger">*</em>联系电话</label>
                                    <input type="text" className="form-control" name="phone" />
                                </div>
                            </div>
                        </form>
                    </div>

                    {this.state.loading === true ? <p>数据加载中 ...</p> : ''}
                </div>
            </div>
        )
    }
}