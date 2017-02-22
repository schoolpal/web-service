import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';
import NavBar from './public/NavBar';
import AsideBar from './public/AsideBar';
import Alerts from './public/Alerts';
import { permissions } from '../utils/api';

export default class Dashboard extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            isLoading: true,
            hasRole: false
        }
    }

    componentWillMount() {
        permissions()
            .done((data) => {
                if (data.length) {
                    let auth = {};

                    $.each(data, (i, item) => {
                        if (item.WidgetType === 'MenuItem') {
                            const temp = $.extend({}, { id: item.cId, command: [] }, SCHOOLPAL_CONFIG.AUTH_DIC[item.cId]);

                            auth[SCHOOLPAL_CONFIG.AUTH_DIC[item.cId].PATH] = temp;
                        };

                        if (item.WidgetType === 'Command') {
                            $.each(auth, (k, v) => {
                                if (v.id === item.cParentId) {
                                    v.command.push(item.CommandCode)
                                };
                            })
                        };
                    })

                    SCHOOLPAL_CONFIG.auth = auth;
                }

                this.setState({
                    isLoading: false,
                    hasRole: (SCHOOLPAL_CONFIG.auth && $.isEmptyObject(SCHOOLPAL_CONFIG.auth) === false) ? true : false
                })
            })
            .fail((data) => {
                if (data.type === SCHOOLPAL_CONFIG.NOT_SIGNIN) {
                    this.props.router.replace({
                        pathname: SCHOOLPAL_CONFIG.ROOTPATH + 'login',
                        state: { nextPathname: this.props.router.location.pathname }
                    })
                };
            });
    }

    render() {
        if (this.state.isLoading === true) {
            return (
                <div className="view">
                    <NavBar router={this.props.router} isSignin={true} />
                    <AsideBar hasRole={this.state.hasRole} />
                    <div className="main">
                        <p>数据加载中 ...</p>
                    </div>
                </div>
            )
        } else {
            return (
                <div className="view">
                    <NavBar router={this.props.router} isSignin={true} />
                    <AsideBar hasRole={this.state.hasRole} />
                    <div className="main">
                        {this.state.hasRole === true ? this.props.children : <Alerts title='警告 ！' text='没有权限访问该内容 ！' />}
                    </div>
                </div>
            )
        };
    }
}