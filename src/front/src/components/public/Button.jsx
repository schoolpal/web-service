import React from 'react';

export function LoginButton(props) {
    if (props.loading === true) {
        return (
            <div onClick={props.action} className="login-submit text-danger">
                <i className="fa fa-circle-o-notch fa-spin fa-3x fa-fw" aria-hidden="true"></i>
            </div>
        )
    } else {
        return (
            <div onClick={props.action} className="login-submit text-primary">
                <i className="fa fa-sign-in fa-3x" aria-hidden="true"></i>
                <span>SING IN</span>
            </div>
        )
    }
} 