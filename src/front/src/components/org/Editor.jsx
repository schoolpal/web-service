import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';
import OrgTree from '../public/OrgTree';
import subTitle from '../../utils/subTitle';
import { SaveButton, BackButton } from '../public/Button';
import { orgList, orgDetails, orgAdd, orgMod } from '../../utils/api';
import DialogTips from '../../utils/DialogTips';

require('../../utils/city');

export default class Editor extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            orgList: [],
            selected: null,
        };
        this.selectOrg = this.selectOrg.bind(this);
        this.editorSubmit = this.editorSubmit.bind(this);
    }

    componentDidMount() {
        const dialogTips = DialogTips({ type: 'loading' })

        dialogTips.open()

        if (this.props.params.id === 'create') {
            orgList()
                .done((data) => {
                    this.setState({
                        orgList: data.tree
                    })
                })
                .always(() => {
                    dialogTips.close()
                })

            $('#citys').citys();
        } else {
            orgDetails(this.props.params.id)
                .done((data) => {
                    this.setState({
                        editorId: data.cId,
                        selected: {
                            id: data.parentOrg.cId,
                            name: data.parentOrg.cName
                        }
                    })

                    $(this.editorDom)
                        .find('[name=name]')
                        .val(data.cName)
                        .end()
                        .find('[name=code]')
                        .val(data.cCode)
                        .end()
                        .find('[name=address]')
                        .val(data.cAddress)
                        .end()
                        .find('[name=owner]')
                        .val(data.cOwner)
                        .end()
                        .find('[name=phone]')
                        .val(data.cOwnerPhone)

                    $('#citys').citys({
                        province: data.cStateCode,
                        city: data.cCityCode,
                        area: data.cCountyCode || null
                    });
                })
                .always(() => {
                    dialogTips.close()
                })
        }
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
        const successPath = SCHOOLPAL_CONFIG.ROOTPATH + 'org';
        const loading = DialogTips({ type: 'loading' })
        const success = DialogTips({ type: 'success' })
        const fail = DialogTips({ type: 'fail', autoClose: true })
        let param = {};

        $(this.editorDom).serializeArray().map((item) => {
            param[item.name] = item.value;
        })

        param.parentId = this.state.selected.id;
        param.state = $('#citys').find('[name="stateCode"]').find("option:selected").text();
        param.city = $('#citys').find('[name="cityCode"]').find("option:selected").text();
        param.county = $('#citys').find('[name="countyCode"]').find("option:selected").text();

        loading.open()

        if (this.state.editorId) {
            param.id = this.state.editorId;

            orgMod(param)
                .done(() => {
                    loading.close()
                    success.open()
                    setTimeout(() => {
                        success.close()
                        this.props.router.push(successPath)
                    }, 2000)
                })
                .fail((data) => {
                    loading.close()
                    fail.open()
                })
        } else {
            orgAdd(param)
                .done(() => {
                    loading.close()
                    success.open()
                    setTimeout(() => {
                        success.close()
                        this.props.router.push(successPath)
                    }, 2000)
                })
                .fail((data) => {
                    loading.close()
                    fail.open()
                })
        }
    }

    render() {
        return (
            <div className="org">
                <h5>
                    <i className="fa fa-sitemap" aria-hidden="true"></i>&nbsp;组织管理&nbsp;&nbsp;|&nbsp;&nbsp;<p className="d-inline text-muted">{subTitle(this.props.router.params.id, '组织')}</p>
                    <div className="btn-group float-right" role="group">
                        <BackButton router={this.props.router} />
                        <SaveButton action={this.editorSubmit} text="保存" />
                    </div>
                </h5>

                <div className="main-container">
                    <div className="d-flex align-items-stretch flex-nowrap">
                        <form ref={(dom) => { this.editorDom = dom }} className="flex-cell">
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
                                    <label for="name"><em className="text-danger">*</em>父级组织：</label>
                                    <div className="form-group">
                                        <div className="btn-group">
                                            <button type="button" className="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <span className="d-inline-block minw210 text-left">{this.state.selected ? this.state.selected.name : ''}</span>
                                            </button>
                                            <div className="dropdown-menu">
                                                <OrgTree data={this.state.orgList} selected={this.selectOrg} defaults={this.state.selected ? this.state.selected.id : null} />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="form-group">
                                    <label for="name"><em className="text-danger">*</em>所在地区</label>
                                    <div id="citys" className="row">
                                        <div className="col">
                                            <select name="stateCode" className="form-control"></select>
                                        </div>
                                        <div className="col">
                                            <select name="cityCode" className="form-control"></select>
                                        </div>
                                        <div className="col">
                                            <select name="countyCode" className="form-control"></select>
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
                </div>
            </div>
        )
    }
}