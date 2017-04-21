window.SCHOOLPAL_CONFIG = {
    ROOTPATH: '/web/html/',
    AJAXPATH: '/web/ajax/',

    SESSION_STORAGE_KYENAME: 'user',

    XHR_DONE: 'XHR_DONE',
    XHR_BUSINESS_ERROR: 'XHR_BUSINESS_ERROR',
    XHR_ERROR: 'XHR_ERROR',

    AUTH_DIC: {
        '1-1': { PATH: 'crm/market/activity', PATH_RULE: /^crm\/market\/activity(\/\w+)?(\/)?$/, ICON: 'fa-pie-chart' },
        '1-1-1': { PATH_RULE: /^crm\/market\/activity\/edit\/create(\/)?$/ },
        '1-1-2': { PATH_RULE: /^crm\/market\/activity\/edit\/\w+(\/)?$/ },

        '1-2': { PATH: 'crm/market/chance', PATH_RULE: /^crm\/market\/chance(\/\w+)?(\/)?$/, ICON: 'fa-bar-chart' },
        '1-2-1': { PATH_RULE: /^crm\/market\/chance\/edit\/create(\/)?$/ },
        '1-2-2': { PATH_RULE: /^crm\/market\/chance\/edit\/\w+(\/)?$/ },

        '7-1': { PATH: 'sys/org', PATH_RULE: /^sys\/org(\/)?$/, ICON: 'fa-sitemap' },
        '7-1-1': { PATH_RULE: /^sys\/org\/create(\/)?$/ },
        '7-1-2': { PATH_RULE: /^sys\/org\/\w+(\/)?$/ },
        '7-2': { PATH: 'sys/role', PATH_RULE: /^sys\/role(\/)?$/, ICON: 'fa-users' },
        '7-2-1': { PATH_RULE: /^sys\/role\/\w+\/create(\/)?$/ },
        '7-2-2': { PATH_RULE: /^sys\/role\/\w+\/\w+(\/)?$/ },
        '7-3': { PATH: 'sys/auth', PATH_RULE: /^sys\/auth(\/)?$/, ICON: 'fa-shield' },
        '7-4': { PATH: 'sys/user', PATH_RULE: /^sys\/user(\/)?$/, ICON: 'fa-user' },
        '7-4-1': { PATH_RULE: /^sys\/user\/\w+\/create(\/)?$/ },
        '7-4-2': { PATH_RULE: /^sys\/user\/\w+\/\w+(\/)?$/ },
    }
};

import { $ } from './utils/vendor';

require('bootstrap/dist/css/bootstrap.min.css');
require('./font/css/font-awesome.css');
require('./less/bundle.less');
require('bootstrap/dist/js/bootstrap');

import React from 'react'
import ReactDOM from 'react-dom'
import { Router, Route, browserHistory } from 'react-router'
import Dashboard from './components/Dashboard'

import App from './components/App'
import Sys from './components/Sys'
import Crm from './components/Crm'

import MarketActivityList from './components/market/activity/List'
import MarketActivityEditor from './components/market/activity/Editor'
import MarketActivityView from './components/market/activity/View'
import MarketChanceList from './components/market/chance/List'
import MarketChanceEditor from './components/market/chance/Editor'
import MarketChanceView from './components/market/chance/View'

import SalesChanceList from './components/sales/chance/List'
import SalesChanceEditor from './components/sales/chance/Editor'
import SalesChanceView from './components/sales/chance/View'
import SalesContractList from './components/sales/contract/List'
import SalesContractEditor from './components/sales/contract/Editor'
import SalesContractView from './components/sales/contract/View'
import SalesStudentList from './components/sales/student/List'
import SalesStudentView from './components/sales/student/View'

import OrgList from './components/org/List';
import OrgEditor from './components/org/Editor';
import RoleList from './components/role/List';
import RoleEditor from './components/role/Editor';
import AuthList from './components/auth/List';
import UserList from './components/user/List';
import UserEditor from './components/user/Editor';

import Login from './components/login';
import Error from './components/Error';

import checkAuth from './utils/checkAuth';

ReactDOM.render((
    <Router history={browserHistory}>
        <Route path={SCHOOLPAL_CONFIG.ROOTPATH + 'login'} component={Login} />

        <Route path={SCHOOLPAL_CONFIG.ROOTPATH} component={App} onEnter={checkAuth} onChange={checkAuth}>

            <Route path="sys" component={Sys}>
                <Route path="org" component={OrgList} />
                <Route path="org/:id" component={OrgEditor} />
                <Route path="role" component={RoleList} />
                <Route path="role/:oid/:rid" component={RoleEditor} />
                <Route path="auth" component={AuthList} />
                <Route path="user" component={UserList} />
                <Route path="user/:oid/:uid" component={UserEditor} />
            </Route>

            <Route path={'crm'} component={Crm}>
                <Route path="market/activity" component={MarketActivityList} />
                <Route path="market/activity/:id" component={MarketActivityView} />
                <Route path="market/activity/edit/:id" component={MarketActivityEditor} />

                <Route path="market/chance" component={MarketChanceList} />
                <Route path="market/chance/:id" component={MarketChanceView} />
                <Route path="market/chance/edit/:id" component={MarketChanceEditor} />

                <Route path="sales/chance" component={SalesChanceList} />
                <Route path="sales/chance/:id" component={SalesChanceView} />
                <Route path="sales/chance/edit/:id" component={SalesChanceEditor} />

                <Route path="sales/contract" component={SalesContractList} />
                <Route path="sales/contract/:id" component={SalesContractView} />
                <Route path="sales/contract/edit/:id" component={SalesContractEditor} />

                <Route path="sales/student" component={SalesStudentList} />
                <Route path="sales/student/:id" component={SalesStudentView} />
            </Route>

            <Route path='*' component={Error} />
        </Route>
    </Router>
), document.querySelector('#app'));
