import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';
import { SaveButton } from '../public/Button';
import subTitle from '../../utils/subTitle';
import { orgDetails } from '../../utils/api';

export default class Editor extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            loading: true,
            org: null,
        }
    }

    componentDidMount() {
        orgDetails(this.props.params.oid)
            .done((data) => {
                this.setState({
                    loading: false,
                    org: {
                        id: data.cId,
                        name: data.cName
                    }
                })
            })
    }

    render() {
        return (
            <div className="user">
                <h5>
                    <i className="fa fa-user" aria-hidden="true"></i>&nbsp;用户管理&nbsp;&nbsp;|&nbsp;&nbsp;<p className="d-inline text-muted">{subTitle(this.props.router.params.uid, '用户')}</p>
                    <div className="btn-group float-right mr-4" role="group">
                        <SaveButton action={this.editorSubmit} text="保存" loading={this.state.saveLoading} />
                    </div>
                </h5>

                <div className="main-container">
                    <p className={this.state.loading === true ? 'hide' : 'h6 pb-3 b-b'}>所属组织：{this.state.org ? this.state.org.name : ''}</p>

                    {this.state.loading === true ? <p>数据加载中 ...</p> : ''}
                </div>
            </div>
        )
    }
}