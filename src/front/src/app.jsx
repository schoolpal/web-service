window.SCHOOLPAL_CONFIG = {
    ROOTPATH: '/web/html/',
    AJAXPATH: '/web/ajax/',

    XHR_DONE: 'XHR_DONE',
    XHR_BUSINESS_ERROR: 'XHR_BUSINESS_ERROR',
    XHR_ERROR: 'XHR_ERROR',
    NOT_SIGNIN: 'NOT_SIGNIN',

    AUTH_DIC: {
        '7-1': {
            PATH: 'org',
            ICON: 'fa-sitemap'
        },
        '7-2': {
            PATH: 'role',
            ICON: 'fa-users'
        },
        '7-3': {
            PATH: 'auth',
            ICON: 'fa-shield'
        },
        '7-4': {
            PATH: 'user',
            ICON: 'fa-user'
        }
    }
};

import { $ } from './utils/vendor';

require('bootstrap/dist/css/bootstrap.min.css');
require('./font/css/font-awesome.css');
require('./less/bundle.less');
require('bootstrap/dist/js/bootstrap');

import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, browserHistory } from 'react-router';
import Dashboard from './components/Dashboard';
import OrgList from './components/org/List';
import OrgEditor from './components/org/Editor';
import RoleList from './components/role/List';
import RoleEditor from './components/role/Editor';
import AuthList from './components/auth/List';
import UserList from './components/user/List';
import UserEditor from './components/user/Editor';
import Login from './components/login';

ReactDOM.render((
    <Router history={browserHistory}>
        <Route path={SCHOOLPAL_CONFIG.ROOTPATH} component={Dashboard}>
            <Route path="org" component={OrgList} />
            <Route path="org/:id" component={OrgEditor} />
            <Route path="role" component={RoleList} />
            <Route path="role/:id" component={RoleEditor} />
            <Route path="auth" component={AuthList} />
            <Route path="user" component={UserList} />
            <Route path="user/:id" component={UserEditor} />
        </Route>
        <Route path={SCHOOLPAL_CONFIG.ROOTPATH + 'login'} component={Login} />
    </Router>
), document.querySelector('#app'));
