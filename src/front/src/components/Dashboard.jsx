import React from 'react'
import ReactDOM from 'react-dom'
import { Link } from 'react-router'
import NavBar from './public/NavBar'
import AsideBar from './public/AsideBar'
import Alerts from './public/Alerts'
import { permissions } from '../utils/api'
import errorHandle from '../utils/errorHandle'

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
                errorHandle({ data: data, router: this.props.router })
            });
    }

    render() {
        if (this.state.isLoading === true) {
            return (
                <div className="view">
                    <NavBar />
                    <AsideBar />
                    <div className="main">
                        <div className="p-3">权限初始化中 ...</div>
                    </div>
                </div>
            )
        } else {
            if (this.props.children) {
                return (
                    <div className="view">
                        <NavBar router={this.props.router} isSignin={true} />
                        <AsideBar />
                        <div className="main">
                            {this.props.children}
                        </div>
                    </div>
                )
            } else {
                return (
                    <div className="view">
                        <NavBar router={this.props.router} isSignin={true} />
                        <AsideBar />
                        <div className="main">
                            <p className="h6 pb-3 b-b">控制台</p>
                        </div>
                    </div>
                )
            }
        };
    }
}