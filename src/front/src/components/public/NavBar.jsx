import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';
import Dialog from './Dialog';

export default class NavBar extends React.Component {
    constructor(props) {
        super(props)
        this.confrimSignout = this.confrimSignout.bind(this)
        this.signout = this.signout.bind(this)
    }

    confrimSignout() {
        const div = document.createElement('div');

        ReactDOM.render(
            <Dialog
                container={div}
                text="是否退出系统？"
                action={this.signout}
            />,
            document.body.appendChild(div)
        )
    }

    signout() {
        this.props.router.replace('/login');
    }

    render() {
        if (this.props.isLogin) {
            return (
                <nav className="navbar navbar-inverse bg-primary">
                    <form>
                        <Link to={`/`} className="btn btn-link text-white">校客</Link>
                        <button type="button" className="btn btn-link text-white"><i className="fa fa-bars fa-lg" aria-hidden="true"></i></button>
                        <button type="button" onClick={this.confrimSignout} className="btn btn-link text-white float-right">
                            <i className="fa fa-sign-out fa-lg" aria-hidden="true"></i>
                        </button>
                    </form>
                </nav>
            )
        } else {
            return (
                <nav className="navbar navbar-inverse bg-primary">
                    <form>
                        <a className="btn btn-link text-white">校客</a>
                    </form>
                </nav>
            )
        };
    }
}