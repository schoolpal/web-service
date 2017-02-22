import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';

export default function AsideBar(props) {
    if (props.hasRole === true) {
        let listItems = [];

        $.each(SCHOOLPAL_CONFIG.auth, (k, v) => {
            listItems.push(
                <Link key={v.id} to={SCHOOLPAL_CONFIG.ROOTPATH + v.PATH} className="btn btn-block btn-link">
                    <i className={'fa ' + v.ICON + ' fa-lg'} aria-hidden="true"></i>
                </Link>
            )
        })

        return (
            <div className="aside-bar bg-faded">
                {listItems}
            </div>
        )
    } else {
        return <div className="aside-bar bg-faded"></div>
    };
}