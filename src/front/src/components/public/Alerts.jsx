import React from 'react';

export default function Alerts(props) {
    return (
        <div className={'alert alert-' + props.type} role="alert">
            <strong>{props.title}</strong> {props.text}
        </div>
    )
}