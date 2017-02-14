import React from 'react';
import ReactDOM from 'react-dom';
import { Link } from 'react-router';

export default function AsideBar(props) {
    return (
        <div className="aside-bar bg-faded">
            <Link to={`/org`} className="btn btn-block btn-link"><i className="fa fa-sitemap fa-lg" aria-hidden="true"></i></Link>
            <Link to={`/role`} className="btn btn-block btn-link"><i className="fa fa-users fa-lg" aria-hidden="true"></i></Link>
            <Link to={`/auth`} className="btn btn-block btn-link"><i className="fa fa-shield fa-lg" aria-hidden="true"></i></Link>
            <Link to={`/user`} className="btn btn-block btn-link"><i className="fa fa-user fa-lg" aria-hidden="true"></i></Link>
        </div>
    )
}