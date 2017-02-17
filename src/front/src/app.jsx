window.OMS_CONFIG = {
    ROOTPATH: '/web/html/'
};

require('./less/bundle.less');

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
        <Route path={OMS_CONFIG.ROOTPATH} component={Dashboard}>
            <Route path="org" component={OrgList} />
            <Route path="org/:id" component={OrgEditor} />
            <Route path="role" component={RoleList} />
            <Route path="role/:id" component={RoleEditor} />
            <Route path="auth" component={AuthList} />
            <Route path="user" component={UserList} />
            <Route path="user/:id" component={UserEditor} />
        </Route>
        <Route path={OMS_CONFIG.ROOTPATH + 'login'} component={Login} />
    </Router>
), document.querySelector('#app'));
