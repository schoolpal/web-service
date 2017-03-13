import React from 'react';
import ReactDOM from 'react-dom';
import NavBar from './public/NavBar';
import { LoginButton } from './public/Button';
import Dialog from './public/Dialog';
import { salt, login, permissions } from '../utils/api';
import mixedMD5 from '../utils/mixedMD5'

export default class Login extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            loading: false
        }
        this.signin = this.signin.bind(this);
        this.signinErrorDialog = this.signinErrorDialog.bind(this);
    }

    signinErrorDialog(text) {
        const div = document.createElement('div');

        ReactDOM.render(
            <Dialog
                container={div}
                text={text}
            />,
            document.body.appendChild(div)
        )
    }

    signin() {
        const $from = $(this.from);
        const username = $from.find('[name=username]').val();
        const mixedPWD = $from.find('[name=mixedPWD]').val();

        if (!username) {
            this.signinErrorDialog('请输入用户名 ！');
            return;
        }

        if (!mixedPWD) {
            this.signinErrorDialog('请输入密码 ！');
            return;
        }

        this.setState({
            loading: true
        });

        salt().done((salt) => {
            login({
                loginname: username,
                mixedPWD: mixedMD5(mixedMD5(mixedMD5(mixedPWD)) + salt)
            }).done(() => {
                if (this.props.router.location.state && this.props.router.location.state.nextPathname) {
                    this.props.router.replace(this.props.router.location.state.nextPathname);
                } else {
                    this.props.router.replace(SCHOOLPAL_CONFIG.ROOTPATH);
                }
            }).fail((data) => {
                this.setState({
                    loading: false
                });
                this.signinErrorDialog('[' + data.data.code + '] - ' + data.data.detail);
            });
        });
    }

    render() {
        return (
            <div className="view">
                <NavBar />
                <div className="login bg-faded">
                    <div className="login-form">
                        <h5 className="text-primary">LOGIN</h5>
                        <form ref={(dom) => { this.from = dom }}>
                            <ul>
                                <li><input name="username" type="text" placeholder="Enter your Email ..." /></li>
                                <li><input name="mixedPWD" type="password" placeholder="Enter your Password ..." /></li>
                            </ul>
                        </form>
                        <LoginButton loading={this.state.loading} action={this.signin} />
                    </div>
                </div>
            </div>
        )
    }
}