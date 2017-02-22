import React from 'react';

export default function Alerts(props) {
    return (
        <div className="alert alert-danger" role="alert">
            <strong>{props.title}</strong> {props.text}
        </div>
    )
}