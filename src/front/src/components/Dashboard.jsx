import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';
import NavBar from './public/NavBar';
import AsideBar from './public/AsideBar';

export default class Dashboard extends React.Component {
    constructor(props) {
        super(props)
    }

    render() {
        return (
            <div className="view">
                <NavBar router={this.props.router} isLogin={true} />
                <AsideBar />
                <div className="main">
                    {this.props.children}
                </div>
            </div>
        )
    }
}