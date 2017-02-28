import React from 'react';
import { Link } from 'react-router';

export function LoginButton(props) {
    if (props.loading === true) {
        return (
            <div className="login-submit text-danger">
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

export function CreateButton(props) {
    return (
        <Link to={props.link} className="btn btn-primary">
            <i className="fa fa-clone" aria-hidden="true"></i> 新建
        </Link>
    )
}

export function EditorButton(props) {
    if (props.disabled === true) {
        return (
            <button type="button" className="btn btn-primary" disabled="disabled">
                <i className="fa fa-pencil-square-o" aria-hidden="true"></i> 编辑
            </button>
        )
    } else {
        return (
            <button onClick={props.action} type="button" className="btn btn-primary">
                <i className="fa fa-pencil-square-o" aria-hidden="true"></i> 编辑
            </button>
        )
    }
}

export function DelButton(props) {
    const text = props.loading === true ? '' : ' 删除';

    if (props.disabled === true) {
        return (
            <button type="button" className="btn btn-danger" disabled="disabled">
                <Icon />{text}
            </button>
        )
    } else {
        return (
            <button type="button" className="btn btn-danger" onClick={props.action}>
                <Icon />{text}
            </button>
        )
    }

    function Icon() {
        if (props.loading === true) {
            return <i className="fa fa-circle-o-notch fa-spin fa-fw" aria-hidden="true"></i>;
        } else {
            return <i className="fa fa-trash-o" aria-hidden="true"></i>;
        }
    }
}

export function SaveButton(props) {
    const text = props.loading === true ? '' : props.text;

    function action() {
        if (props.loading === false) {
            props.action();
        };
    }
    return (
        <button onClick={action} type="button" className="btn btn-primary">
            <Icon /> {text}
        </button>
    )

    function Icon() {
        if (props.loading === true) {
            return <i className="fa fa-circle-o-notch fa-spin fa-fw" aria-hidden="true"></i>;
        } else {
            return <i></i>;
        }
    }
}