window.SCHOOLPAL_CONFIG = {
    ROOTPATH: '/web/html/',
    AJAXPATH: '/web/ajax/',

    XHR_DONE: 'XHR_DONE',
    XHR_BUSINESS_ERROR: 'XHR_BUSINESS_ERROR',
    XHR_ERROR: 'XHR_ERROR',
    NOT_SIGNIN: 'NOT_SIGNIN',

    AUTH_DIC: {
        '1-1': { PATH: 'crm/market/activity', PATH_RULE: /^crm\/market\/activity(\/\w+)?(\/)?$/, ICON: 'fa-pie-chart' },
        '1-1-1': { PATH_RULE: /^crm\/market\/activity\/edit\/create(\/)?$/ },
        '1-1-2': { PATH_RULE: /^crm\/market\/activity\/edit\/\w+(\/)?$/ },

        '1-2': { PATH: 'crm/market/sales', PATH_RULE: /^crm\/market\/sales(\/\w+)?(\/)?$/, ICON: 'fa-bar-chart' },
        '1-2-1': { PATH_RULE: /^crm\/market\/sales\/edit\/create(\/)?$/ },
        '1-2-2': { PATH_RULE: /^crm\/market\/sales\/edit\/\w+(\/)?$/ },

        '7-1': { PATH: 'org', PATH_RULE: /^org(\/)?$/, ICON: 'fa-sitemap' },
        '7-1-1': { PATH_RULE: /^org\/create(\/)?$/ },
        '7-1-2': { PATH_RULE: /^org\/\w+(\/)?$/ },
        '7-2': { PATH: 'role', PATH_RULE: /^role(\/)?$/, ICON: 'fa-users' },
        '7-2-1': { PATH_RULE: /^role\/\w+\/create(\/)?$/ },
        '7-2-2': { PATH_RULE: /^role\/\w+\/\w+(\/)?$/ },
        '7-3': { PATH: 'auth', PATH_RULE: /^auth(\/)?$/, ICON: 'fa-shield' },
        '7-4': { PATH: 'user', PATH_RULE: /^user(\/)?$/, ICON: 'fa-user' },
        '7-4-1': { PATH_RULE: /^user\/\w+\/create(\/)?$/ },
        '7-4-2': { PATH_RULE: /^user\/\w+\/\w+(\/)?$/ },
    }
};

import { _, $ } from './utils/vendor';

require('bootstrap/dist/css/bootstrap.min.css');
require('./font/css/font-awesome.css');
require('./less/bundle.less');
require('bootstrap/dist/js/bootstrap');

import React from 'react'
import ReactDOM from 'react-dom'
import { Router, Route, browserHistory } from 'react-router'
import Dashboard from './components/Dashboard'

import Crm from './components/Crm'

import MarketActivityList from './components/market/activity/List'
import MarketActivityEditor from './components/market/activity/Editor'
import MarketActivityView from './components/market/activity/View'
import MarketSalesList from './components/market/sales/List'
import MarketSalesEditor from './components/market/sales/Editor'
import MarketSalesView from './components/market/sales/View'

import OrgList from './components/org/List';
import OrgEditor from './components/org/Editor';
import RoleList from './components/role/List';
import RoleEditor from './components/role/Editor';
import AuthList from './components/auth/List';
import UserList from './components/user/List';
import UserEditor from './components/user/Editor';
import Login from './components/login';
import Error from './components/public/Error';
import checkAuth from './utils/checkAuth';

ReactDOM.render((
    <Router history={browserHistory}>
        <Route path={SCHOOLPAL_CONFIG.ROOTPATH + 'login'} component={Login} />

        <Route path={SCHOOLPAL_CONFIG.ROOTPATH} component={Dashboard}>
            <Route path={'crm'} component={Crm}>
                <Route path="market/activity" component={MarketActivityList} onEnter={checkAuth} />
                <Route path="market/activity/:id" component={MarketActivityView} onEnter={checkAuth} />
                <Route path="market/activity/edit/:id" component={MarketActivityEditor} onEnter={checkAuth} />

                <Route path="market/sales" component={MarketSalesList} onEnter={checkAuth} />
                <Route path="market/sales/:id" component={MarketSalesView} onEnter={checkAuth} />
                <Route path="market/sales/edit/:id" component={MarketSalesEditor} onEnter={checkAuth} />
            </Route>

            <Route path="org" component={OrgList} onEnter={checkAuth} />
            <Route path="org/:id" component={OrgEditor} onEnter={checkAuth} />
            <Route path="role" component={RoleList} onEnter={checkAuth} />
            <Route path="role/:oid/:rid" component={RoleEditor} onEnter={checkAuth} />
            <Route path="auth" component={AuthList} onEnter={checkAuth} />
            <Route path="user" component={UserList} onEnter={checkAuth} />
            <Route path="user/:oid/:uid" component={UserEditor} onEnter={checkAuth} />
            <Route path='*' component={Error} />
        </Route>
    </Router>
), document.querySelector('#app'));
