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
        this.state = { isLoading: true }
    }

    componentWillMount() {
        permissions()
            .done(() => {
                this.setState({ isLoading: false })
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
                    <AsideBar />
                    <div className="main">
                        <div className="main-container">权限初始化中 ...</div>
                    </div>
                </div>
            )
        } else {
            return (
                <div className="view">
                    <NavBar router={this.props.router} isSignin={true} />
                    <AsideBar />
                    <div className="main">
                        {this.props.children}
                    </div>
                </div>
            )
        };
    }
}