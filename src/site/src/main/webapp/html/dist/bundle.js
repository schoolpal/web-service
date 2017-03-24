webpackJsonp([0],{

/***/ 0:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	var _vendor = __webpack_require__(4);

	var _react = __webpack_require__(9);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(40);

	var _reactDom2 = _interopRequireDefault(_reactDom);

	var _reactRouter = __webpack_require__(174);

	var _Dashboard = __webpack_require__(229);

	var _Dashboard2 = _interopRequireDefault(_Dashboard);

	var _List = __webpack_require__(237);

	var _List2 = _interopRequireDefault(_List);

	var _Editor = __webpack_require__(240);

	var _Editor2 = _interopRequireDefault(_Editor);

	var _List3 = __webpack_require__(244);

	var _List4 = _interopRequireDefault(_List3);

	var _Editor3 = __webpack_require__(245);

	var _Editor4 = _interopRequireDefault(_Editor3);

	var _List5 = __webpack_require__(246);

	var _List6 = _interopRequireDefault(_List5);

	var _List7 = __webpack_require__(247);

	var _List8 = _interopRequireDefault(_List7);

	var _Editor5 = __webpack_require__(248);

	var _Editor6 = _interopRequireDefault(_Editor5);

	var _login = __webpack_require__(252);

	var _login2 = _interopRequireDefault(_login);

	var _Error = __webpack_require__(253);

	var _Error2 = _interopRequireDefault(_Error);

	var _checkAuth = __webpack_require__(254);

	var _checkAuth2 = _interopRequireDefault(_checkAuth);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	window.SCHOOLPAL_CONFIG = {
	    ROOTPATH: '/web/html/',
	    AJAXPATH: '/web/ajax/',

	    XHR_DONE: 'XHR_DONE',
	    XHR_BUSINESS_ERROR: 'XHR_BUSINESS_ERROR',
	    XHR_ERROR: 'XHR_ERROR',
	    NOT_SIGNIN: 'NOT_SIGNIN',

	    AUTH_DIC: {
	        '7-1': { PATH: 'org', PATH_RULE: /^org(\/)?$/, ICON: 'fa-sitemap' },
	        '7-1-1': { PATH_RULE: /^org\/create(\/)?$/ },
	        '7-1-2': { PATH_RULE: /^org\/\w+(\/)?$/ },
	        '7-2': { PATH: 'role', PATH_RULE: /^role(\/)?$/, ICON: 'fa-users' },
	        '7-2-1': { PATH_RULE: /^role\/\w+\/create(\/)?$/ },
	        '7-2-2': { PATH_RULE: /^role\/\w+\/\w+(\/)?$/ },
	        '7-3': { PATH: 'auth', PATH_RULE: /^auth(\/)?$/, ICON: 'fa-shield' },
	        '7-4': { PATH: 'user', PATH_RULE: /^user(\/)?$/, ICON: 'fa-user' },
	        '7-4-1': { PATH_RULE: /^user\/\w+\/create(\/)?$/ },
	        '7-4-2': { PATH_RULE: /^user\/\w+\/\w+(\/)?$/ }
	    }
	};

	__webpack_require__(255);
	__webpack_require__(259);
	__webpack_require__(262);
	__webpack_require__(264);

	_reactDom2.default.render(_react2.default.createElement(
	    _reactRouter.Router,
	    { history: _reactRouter.browserHistory },
	    _react2.default.createElement(_reactRouter.Route, { path: SCHOOLPAL_CONFIG.ROOTPATH + 'login', component: _login2.default }),
	    _react2.default.createElement(
	        _reactRouter.Route,
	        { path: SCHOOLPAL_CONFIG.ROOTPATH, component: _Dashboard2.default },
	        _react2.default.createElement(_reactRouter.Route, { path: 'org', component: _List2.default, onEnter: _checkAuth2.default }),
	        _react2.default.createElement(_reactRouter.Route, { path: 'org/:id', component: _Editor2.default, onEnter: _checkAuth2.default }),
	        _react2.default.createElement(_reactRouter.Route, { path: 'role', component: _List4.default, onEnter: _checkAuth2.default }),
	        _react2.default.createElement(_reactRouter.Route, { path: 'role/:oid/:rid', component: _Editor4.default, onEnter: _checkAuth2.default }),
	        _react2.default.createElement(_reactRouter.Route, { path: 'auth', component: _List6.default, onEnter: _checkAuth2.default }),
	        _react2.default.createElement(_reactRouter.Route, { path: 'user', component: _List8.default, onEnter: _checkAuth2.default }),
	        _react2.default.createElement(_reactRouter.Route, { path: 'user/:oid/:uid', component: _Editor6.default, onEnter: _checkAuth2.default }),
	        _react2.default.createElement(_reactRouter.Route, { path: '*', component: _Error2.default })
	    )
	), document.querySelector('#app'));

/***/ },

/***/ 229:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

	var _react = __webpack_require__(9);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(40);

	var _reactDom2 = _interopRequireDefault(_reactDom);

	var _reactRouter = __webpack_require__(174);

	var _NavBar = __webpack_require__(230);

	var _NavBar2 = _interopRequireDefault(_NavBar);

	var _AsideBar = __webpack_require__(234);

	var _AsideBar2 = _interopRequireDefault(_AsideBar);

	var _Alerts = __webpack_require__(235);

	var _Alerts2 = _interopRequireDefault(_Alerts);

	var _api = __webpack_require__(231);

	var _errorHandle = __webpack_require__(236);

	var _errorHandle2 = _interopRequireDefault(_errorHandle);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

	var Dashboard = function (_React$Component) {
	    _inherits(Dashboard, _React$Component);

	    function Dashboard(props) {
	        _classCallCheck(this, Dashboard);

	        var _this = _possibleConstructorReturn(this, (Dashboard.__proto__ || Object.getPrototypeOf(Dashboard)).call(this, props));

	        _this.state = { isLoading: true };
	        return _this;
	    }

	    _createClass(Dashboard, [{
	        key: 'componentWillMount',
	        value: function componentWillMount() {
	            var _this2 = this;

	            (0, _api.permissions)().done(function () {
	                _this2.setState({ isLoading: false });
	            }).fail(function (data) {
	                (0, _errorHandle2.default)({ data: data, router: _this2.props.router });
	            });
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            if (this.state.isLoading === true) {
	                return _react2.default.createElement(
	                    'div',
	                    { className: 'view' },
	                    _react2.default.createElement(_NavBar2.default, null),
	                    _react2.default.createElement(_AsideBar2.default, null),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'main' },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'p-3' },
	                            '\u6743\u9650\u521D\u59CB\u5316\u4E2D ...'
	                        )
	                    )
	                );
	            } else {
	                if (this.props.children) {
	                    return _react2.default.createElement(
	                        'div',
	                        { className: 'view' },
	                        _react2.default.createElement(_NavBar2.default, { router: this.props.router, isSignin: true }),
	                        _react2.default.createElement(_AsideBar2.default, null),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'main' },
	                            this.props.children
	                        )
	                    );
	                } else {
	                    return _react2.default.createElement(
	                        'div',
	                        { className: 'view' },
	                        _react2.default.createElement(_NavBar2.default, { router: this.props.router, isSignin: true }),
	                        _react2.default.createElement(_AsideBar2.default, null),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'main' },
	                            _react2.default.createElement(
	                                'p',
	                                { className: 'h6 pb-3 b-b' },
	                                '\u63A7\u5236\u53F0'
	                            )
	                        )
	                    );
	                }
	            };
	        }
	    }]);

	    return Dashboard;
	}(_react2.default.Component);

	exports.default = Dashboard;

/***/ },

/***/ 230:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

	var _react = __webpack_require__(9);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(40);

	var _reactDom2 = _interopRequireDefault(_reactDom);

	var _reactRouter = __webpack_require__(174);

	var _api = __webpack_require__(231);

	var _Dialog = __webpack_require__(233);

	var _Dialog2 = _interopRequireDefault(_Dialog);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

	var NavBar = function (_React$Component) {
	    _inherits(NavBar, _React$Component);

	    function NavBar(props) {
	        _classCallCheck(this, NavBar);

	        var _this = _possibleConstructorReturn(this, (NavBar.__proto__ || Object.getPrototypeOf(NavBar)).call(this, props));

	        _this.confrimSignout = _this.confrimSignout.bind(_this);
	        _this.signout = _this.signout.bind(_this);
	        return _this;
	    }

	    _createClass(NavBar, [{
	        key: 'confrimSignout',
	        value: function confrimSignout() {
	            var div = document.createElement('div');

	            _reactDom2.default.render(_react2.default.createElement(_Dialog2.default, {
	                container: div,
	                text: '\u662F\u5426\u9000\u51FA\u7CFB\u7EDF\uFF1F',
	                action: this.signout
	            }), document.body.appendChild(div));
	        }
	    }, {
	        key: 'signout',
	        value: function signout() {
	            (0, _api.logout)();
	            this.props.router.replace(SCHOOLPAL_CONFIG.ROOTPATH + 'login');
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            if (this.props.isSignin) {
	                return _react2.default.createElement(
	                    'nav',
	                    { className: 'navbar navbar-inverse bg-primary' },
	                    _react2.default.createElement(
	                        'form',
	                        null,
	                        _react2.default.createElement(
	                            _reactRouter.Link,
	                            { to: SCHOOLPAL_CONFIG.ROOTPATH, className: 'text-white' },
	                            '\u6821\u5BA2'
	                        ),
	                        _react2.default.createElement(
	                            'button',
	                            { type: 'button', onClick: this.confrimSignout, className: 'btn btn-warning float-right' },
	                            _react2.default.createElement('i', { className: 'fa fa-sign-out fa-lg', 'aria-hidden': 'true' }),
	                            ' \u9000\u51FA\u7CFB\u7EDF'
	                        )
	                    )
	                );
	            } else {
	                return _react2.default.createElement(
	                    'nav',
	                    { className: 'navbar navbar-inverse bg-primary' },
	                    _react2.default.createElement(
	                        'form',
	                        null,
	                        _react2.default.createElement(
	                            'a',
	                            { className: 'text-white' },
	                            '\u6821\u5BA2'
	                        )
	                    )
	                );
	            };
	        }
	    }]);

	    return NavBar;
	}(_react2.default.Component);

	exports.default = NavBar;

/***/ },

/***/ 231:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.salt = salt;
	exports.login = login;
	exports.logout = logout;
	exports.permissions = permissions;
	exports.orgList = orgList;
	exports.orgDetails = orgDetails;
	exports.orgAdd = orgAdd;
	exports.orgMod = orgMod;
	exports.orgDel = orgDel;
	exports.roleList = roleList;
	exports.rankDic = rankDic;
	exports.funcDic = funcDic;
	exports.roleAdd = roleAdd;
	exports.roleDel = roleDel;
	exports.roleDetails = roleDetails;
	exports.roleMod = roleMod;
	exports.roleAuth = roleAuth;
	exports.funcByIds = funcByIds;
	exports.userList = userList;
	exports.userAdd = userAdd;
	exports.userDetails = userDetails;
	exports.userMod = userMod;
	exports.userEnable = userEnable;
	exports.userDel = userDel;
	exports.checkName = checkName;

	var _conversion = __webpack_require__(232);

	function io(options, callback) {
	    if (!(this instanceof io)) {
	        return new io(options, callback);
	    };

	    var defaults = {
	        type: 'POST',
	        dataType: 'json'
	    };
	    var settings = $.extend({}, defaults, options);
	    var jqxhr = $.ajax({
	        url: formatUrl(settings.url),
	        type: settings.type,
	        data: settings.data || {},
	        dataType: settings.dataType
	    });

	    jqxhr.done(function (data, textStatus, jqXHR) {
	        console.log(data, textStatus, jqXHR.status);

	        if (data.code === 200) {
	            callback({
	                type: SCHOOLPAL_CONFIG.XHR_DONE,
	                data: data.data
	            });
	        } else {
	            callback({
	                type: SCHOOLPAL_CONFIG.XHR_BUSINESS_ERROR,
	                data: data
	            });
	        };
	    });

	    jqxhr.fail(function (jqXHR, textStatus, errorThrown) {
	        console.log(jqXHR.status, textStatus, errorThrown);
	        callback({
	            type: jqXHR.status === 401 ? SCHOOLPAL_CONFIG.NOT_SIGNIN : SCHOOLPAL_CONFIG.XHR_ERROR
	        });
	    });
	}

	function formatUrl(url) {
	    return SCHOOLPAL_CONFIG.AJAXPATH + url;
	}

	function salt() {
	    var defer = $.Deferred();
	    var url = 'user/salt.do';

	    io({ url: url }, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function login(data) {
	    var defer = $.Deferred();
	    var url = 'user/login.do';
	    var settings = $.extend({ url: url }, { data: data });

	    io(settings, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function logout() {
	    var defer = $.Deferred();
	    var url = 'user/logout.do';

	    io({ url: url }, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function permissions() {
	    var defer = $.Deferred();
	    var url = 'user/listFuncs.do';

	    io({ url: url }, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            (function () {
	                var auth = {};
	                var authPath = [];

	                if (data.data.length) {
	                    $.each(data.data, function (i, item) {
	                        if (item.WidgetType === 'MenuItem') {
	                            var temp = $.extend({}, { id: item.cId, command: [] }, SCHOOLPAL_CONFIG.AUTH_DIC[item.cId]);

	                            if (SCHOOLPAL_CONFIG.AUTH_DIC[item.cId] && SCHOOLPAL_CONFIG.AUTH_DIC[item.cId].PATH) {
	                                auth[SCHOOLPAL_CONFIG.AUTH_DIC[item.cId].PATH] = temp;
	                            }
	                        };

	                        if (item.WidgetType === 'Command') {
	                            $.each(auth, function (k, v) {
	                                if (v.id === item.cParentId) {
	                                    v.command.push(item.CommandCode);
	                                };
	                            });
	                        };

	                        if (SCHOOLPAL_CONFIG.AUTH_DIC[item.cId]) {
	                            authPath.push(SCHOOLPAL_CONFIG.AUTH_DIC[item.cId].PATH_RULE);
	                        };
	                    });
	                };

	                SCHOOLPAL_CONFIG.auth = auth;
	                SCHOOLPAL_CONFIG.authPath = authPath;

	                defer.resolve();
	            })();
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function orgList() {
	    var defer = $.Deferred();
	    var url = 'user/listOrgs.do';

	    io({ url: url }, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve((0, _conversion.conversionOrg)(data.data));
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function orgDetails(oid) {
	    var defer = $.Deferred();
	    var url = 'org/query.do';

	    io({ url: url, data: { id: oid } }, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function orgAdd(data) {
	    var defer = $.Deferred();
	    var url = 'sys/org/add.do';
	    var settings = $.extend({ url: url }, { data: data });

	    io(settings, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function orgMod(data) {
	    var defer = $.Deferred();
	    var url = 'sys/org/mod.do';
	    var settings = $.extend({ url: url }, { data: data });

	    io(settings, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function orgDel(oid) {
	    var defer = $.Deferred();
	    var url = 'sys/org/del.do';

	    io({ url: url, data: { id: oid } }, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function roleList(oid) {
	    var defer = $.Deferred();
	    var url = 'org/listRoles.do';

	    io({ url: url, data: { id: oid } }, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function rankDic() {
	    var defer = $.Deferred();
	    var url = 'role/ranks.do';

	    io({ url: url }, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function funcDic() {
	    var defer = $.Deferred();
	    var url = 'func/listAllFuncs.do';

	    io({ url: url }, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function roleAdd(data) {
	    var defer = $.Deferred();
	    var url = 'sys/role/add.do';
	    var settings = $.extend({ url: url }, { data: data });

	    io(settings, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function roleDel(rid) {
	    var defer = $.Deferred();
	    var url = 'sys/role/del.do';

	    io({ url: url, data: { id: rid } }, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function roleDetails(rid) {
	    var defer = $.Deferred();
	    var url = 'role/query.do';

	    io({ url: url, data: { id: rid } }, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function roleMod(data) {
	    var defer = $.Deferred();
	    var url = 'sys/role/mod.do';
	    var settings = $.extend({ url: url }, { data: data });

	    io(settings, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function roleAuth(data) {
	    var defer = $.Deferred();
	    var url = 'sys/role/auth.do';
	    var settings = $.extend({ url: url }, { data: data });

	    io(settings, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function funcByIds(fids) {
	    var defer = $.Deferred();
	    var url = 'func/list.do';

	    io({ url: url, data: { ids: fids } }, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            var conversionFuncData = (0, _conversion.conversionFunc)(data.data);

	            defer.resolve({
	                tree: conversionFuncData,
	                data: data.data
	            });
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function userList(oid) {
	    var defer = $.Deferred();
	    var url = 'org/listUsers.do';

	    io({ url: url, data: { id: oid } }, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function userAdd(data) {
	    var defer = $.Deferred();
	    var url = 'sys/user/add.do';
	    var settings = $.extend({ url: url }, { data: data });

	    io(settings, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function userDetails(uid) {
	    var defer = $.Deferred();
	    var url = 'sys/user/query.do';

	    io({ url: url, data: { id: uid } }, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function userMod(data) {
	    var defer = $.Deferred();
	    var url = 'sys/user/mod.do';
	    var settings = $.extend({ url: url }, { data: data });

	    io(settings, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function userEnable(uid, enable) {
	    var defer = $.Deferred();
	    var url = 'sys/user/enable.do';

	    io({ url: url, data: { id: uid, enabled: enable } }, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function userDel(uid) {
	    var defer = $.Deferred();
	    var url = 'sys/user/del.do';

	    io({ url: url, data: { id: uid } }, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

	function checkName(name) {
	    var defer = $.Deferred();
	    var url = 'sys/user/checkName.do';

	    io({ url: url, data: { loginName: name } }, function (data) {
	        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
	            defer.resolve(data.data);
	        } else {
	            defer.reject(data);
	        }
	    });

	    return defer.promise();
	}

/***/ },

/***/ 232:
/***/ function(module, exports) {

	"use strict";

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.conversionOrg = conversionOrg;
	exports.conversionFunc = conversionFunc;

	function _toConsumableArray(arr) { if (Array.isArray(arr)) { for (var i = 0, arr2 = Array(arr.length); i < arr.length; i++) { arr2[i] = arr[i]; } return arr2; } else { return Array.from(arr); } }

	function insertTree(rootData, data) {
	    if (rootData.cId === data.cParentId) {
	        if (!rootData.children) {
	            rootData.children = [];
	        };

	        rootData.children.push(data);
	    } else {
	        if (rootData.children && rootData.children.length) {
	            $.each(rootData.children, function (i, item) {
	                insertTree(item, data);
	            });
	        };
	    }
	}

	function conversionOrg(original) {
	    var data = original.map(function (item) {
	        return $.extend({}, item);
	    });
	    var tree = [];
	    var rootLevel = [];

	    if (data.length) {
	        $.each(data, function (i, item) {
	            rootLevel.push(item.level);

	            if (item.cId === item.cParentId) {
	                tree.push(item);
	            } else {
	                var rootIndex = _.findIndex(tree, { cId: item.cRootId });

	                insertTree(tree[rootIndex], item);
	            }
	        });
	    }

	    rootLevel = _.uniq(rootLevel);

	    return {
	        original: original,
	        tree: tree,
	        rootLevel: rootLevel.length ? Math.min.apply(Math, _toConsumableArray(rootLevel)) : null
	    };
	}

	function insertFunc(rootData, data) {
	    if (rootData.cId === data.cParentId) {
	        if (data.cCommandTypeId) {
	            if (!rootData.action) {
	                rootData.action = [];
	            };

	            rootData.action.push(data);
	        } else {
	            if (!rootData.children) {
	                rootData.children = [];
	            };

	            rootData.children.push(data);
	        }
	    } else {
	        if (rootData.children && rootData.children.length) {
	            rootData.children.map(function (item) {
	                insertFunc(item, data);
	            });
	        };
	    }
	}

	function conversionFunc(original) {
	    var data = original.map(function (item) {
	        return $.extend({}, item);
	    });
	    var tree = [];

	    if (data.length) {
	        data.map(function (item) {
	            if (item.cId === item.cRootId) {
	                tree.push(item);
	            } else {
	                var rootIndex = _.findIndex(tree, { cId: item.cRootId });

	                insertFunc(tree[rootIndex], item);
	            };
	        });
	    }

	    return tree;
	}

/***/ },

/***/ 233:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

	var _react = __webpack_require__(9);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(40);

	var _reactDom2 = _interopRequireDefault(_reactDom);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

	var Dialog = function (_React$Component) {
	    _inherits(Dialog, _React$Component);

	    function Dialog(props) {
	        _classCallCheck(this, Dialog);

	        var _this = _possibleConstructorReturn(this, (Dialog.__proto__ || Object.getPrototypeOf(Dialog)).call(this, props));

	        _this.closed = _this.closed.bind(_this);
	        _this.confrimAction = _this.confrimAction.bind(_this);
	        return _this;
	    }

	    _createClass(Dialog, [{
	        key: 'componentDidMount',
	        value: function componentDidMount() {
	            var _this2 = this;

	            $(this.confrim).modal('show').one('hidden.bs.modal', function () {
	                _this2.closed();
	            });
	        }
	    }, {
	        key: 'componentWillUnmount',
	        value: function componentWillUnmount() {
	            document.body.removeChild(this.props.container);
	        }
	    }, {
	        key: 'closed',
	        value: function closed() {
	            _reactDom2.default.unmountComponentAtNode(this.props.container);
	        }
	    }, {
	        key: 'confrimAction',
	        value: function confrimAction() {
	            $(this.confrim).modal('hide');

	            if (this.props.action) {
	                this.props.action();
	            };
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            var _this3 = this;

	            var title = this.props.title || '提示';

	            return _react2.default.createElement(
	                'div',
	                { ref: function ref(dom) {
	                        _this3.confrim = dom;
	                    }, className: 'modal fade' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'modal-dialog', role: 'document' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'modal-content' },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'modal-header' },
	                            _react2.default.createElement(
	                                'p',
	                                { className: 'modal-title' },
	                                title
	                            ),
	                            _react2.default.createElement(
	                                'button',
	                                { type: 'button', className: 'close', 'data-dismiss': 'modal', 'aria-label': 'Close' },
	                                _react2.default.createElement(
	                                    'span',
	                                    { 'aria-hidden': 'true' },
	                                    '\xD7'
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'modal-body' },
	                            _react2.default.createElement(
	                                'p',
	                                null,
	                                this.props.text
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'modal-footer' },
	                            _react2.default.createElement(
	                                'button',
	                                { onClick: this.confrimAction, type: 'button', className: 'btn btn-primary' },
	                                '\u786E\u8BA4'
	                            )
	                        )
	                    )
	                )
	            );
	        }
	    }]);

	    return Dialog;
	}(_react2.default.Component);

	exports.default = Dialog;

/***/ },

/***/ 234:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = AsideBar;

	var _react = __webpack_require__(9);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(40);

	var _reactDom2 = _interopRequireDefault(_reactDom);

	var _reactRouter = __webpack_require__(174);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	function AsideBar(props) {
	    var listItems = [];

	    $.each(SCHOOLPAL_CONFIG.auth, function (k, v) {
	        listItems.push(_react2.default.createElement(
	            _reactRouter.Link,
	            { key: v.id, to: SCHOOLPAL_CONFIG.ROOTPATH + v.PATH, className: 'btn btn-block btn-link' },
	            _react2.default.createElement('i', { className: 'fa ' + v.ICON + ' fa-lg', 'aria-hidden': 'true' })
	        ));
	    });

	    return _react2.default.createElement(
	        'div',
	        { className: 'aside-bar bg-faded' },
	        listItems
	    );
	}

/***/ },

/***/ 235:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = Alerts;

	var _react = __webpack_require__(9);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	function Alerts(props) {
	    return _react2.default.createElement(
	        'div',
	        { className: 'alert alert-' + props.type + ' border-right-0 border-left-0 rounded-0', role: 'alert' },
	        _react2.default.createElement(
	            'strong',
	            null,
	            props.title
	        ),
	        ' ',
	        props.text,
	        ' ',
	        props.children
	    );
	}

/***/ },

/***/ 236:
/***/ function(module, exports) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = errorHandle;
	function errorHandle(query) {
	    if (query.data.type === SCHOOLPAL_CONFIG.NOT_SIGNIN) {
	        query.router.replace({
	            pathname: SCHOOLPAL_CONFIG.ROOTPATH + 'login',
	            state: { nextPathname: query.router.location.pathname }
	        });
	    };
	}

/***/ },

/***/ 237:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

	var _react = __webpack_require__(9);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(40);

	var _reactDom2 = _interopRequireDefault(_reactDom);

	var _Button = __webpack_require__(238);

	var _Dialog = __webpack_require__(233);

	var _Dialog2 = _interopRequireDefault(_Dialog);

	var _api = __webpack_require__(231);

	var _DialogTips = __webpack_require__(239);

	var _DialogTips2 = _interopRequireDefault(_DialogTips);

	var _conversion = __webpack_require__(232);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

	var List = function (_React$Component) {
	    _inherits(List, _React$Component);

	    function List(props) {
	        _classCallCheck(this, List);

	        var _this = _possibleConstructorReturn(this, (List.__proto__ || Object.getPrototypeOf(List)).call(this, props));

	        _this.state = {
	            list: [],
	            treeList: [],
	            rootLevel: null,

	            selected: null
	        };

	        _this.renderCommand = _this.renderCommand.bind(_this);
	        _this.renderTable = _this.renderTable.bind(_this);
	        _this.tableLine = _this.tableLine.bind(_this);
	        _this.checkedOrg = _this.checkedOrg.bind(_this);
	        _this.handleCreate = _this.handleCreate.bind(_this);
	        _this.handleEditor = _this.handleEditor.bind(_this);
	        _this.handleDel = _this.handleDel.bind(_this);
	        _this.handleNode = _this.handleNode.bind(_this);
	        _this.confirmDel = _this.confirmDel.bind(_this);
	        return _this;
	    }

	    _createClass(List, [{
	        key: 'componentDidMount',
	        value: function componentDidMount() {
	            var _this2 = this;

	            var dialogTips = (0, _DialogTips2.default)({ type: 'loading' });

	            dialogTips.open();

	            (0, _api.orgList)().done(function (data) {
	                _this2.setState({
	                    list: data.original,
	                    treeList: data.tree,
	                    rootLevel: data.rootLevel
	                });
	            }).always(function () {
	                dialogTips.close();
	            });
	        }
	    }, {
	        key: 'renderCommand',
	        value: function renderCommand() {
	            var _this3 = this;

	            var temp = [];
	            var isDisabled = void 0;

	            if (this.state.selected && this.state.selected.level) {
	                isDisabled = false;
	            } else {
	                isDisabled = true;
	            };

	            if (SCHOOLPAL_CONFIG.auth[this.props.route.path] && SCHOOLPAL_CONFIG.auth[this.props.route.path].command.length) {
	                SCHOOLPAL_CONFIG.auth[this.props.route.path].command.map(function (item, index) {
	                    if (item === 'Add') {
	                        temp.push(_react2.default.createElement(_Button.CreateButton, { key: index, action: _this3.handleCreate }));
	                    };

	                    if (item === 'Mod') {
	                        temp.push(_react2.default.createElement(_Button.EditorButton, { key: index, action: _this3.handleEditor, disabled: isDisabled }));
	                    }

	                    if (item === 'Del') {
	                        temp.push(_react2.default.createElement(_Button.DelButton, { key: index, action: _this3.confirmDel, disabled: isDisabled }));
	                    }
	                });
	            }

	            return temp;
	        }
	    }, {
	        key: 'renderTable',
	        value: function renderTable(data) {
	            var _this4 = this;

	            var table = [];

	            if (data.length) {
	                $.each(data, function (i, item) {
	                    table.push(_this4.tableLine(item));

	                    if (item.children && item.children.length) {
	                        var children = [];

	                        children.push(_this4.renderTable(item.children));
	                        table.push(children);
	                    }
	                });
	            }

	            return table;
	        }
	    }, {
	        key: 'tableLine',
	        value: function tableLine(data) {
	            var selectedClass = 'select' + (this.state.selected && this.state.selected.toString() === data.cId ? ' selected' : '');
	            var spacingStyle = { marginLeft: 40 * data.level + 'px' };
	            var childrenClass = data.children ? '' : 'not-child';
	            var area = data.cState + ' ' + data.cCity + ' ' + data.cCounty;
	            var addr = area + ' ' + data.cAddress;

	            return _react2.default.createElement(
	                'tr',
	                { key: data.cId, 'data-id': data.cId, 'data-level': data.level },
	                _react2.default.createElement(
	                    'th',
	                    { scope: 'row' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'form-check' },
	                        _react2.default.createElement(
	                            'label',
	                            { className: 'form-check-label' },
	                            _react2.default.createElement('input', {
	                                onChange: this.checkedOrg,
	                                className: 'form-check-input',
	                                type: 'radio',
	                                name: 'org',
	                                checked: this.state.selected && data.cId.toString() === this.state.selected.id ? true : false,
	                                value: data.cId
	                            })
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'td',
	                    null,
	                    _react2.default.createElement(
	                        'p',
	                        { onClick: this.handleNode, className: 'tree-node ' + childrenClass, style: spacingStyle },
	                        data.cName
	                    )
	                ),
	                _react2.default.createElement(
	                    'td',
	                    null,
	                    area
	                ),
	                _react2.default.createElement(
	                    'td',
	                    null,
	                    addr
	                ),
	                _react2.default.createElement(
	                    'td',
	                    null,
	                    data.cOwner
	                ),
	                _react2.default.createElement(
	                    'td',
	                    null,
	                    data.cOwnerPhone
	                )
	            );
	        }
	    }, {
	        key: 'checkedOrg',
	        value: function checkedOrg(event) {
	            if (event.target.checked === true) {
	                this.setState({
	                    selected: {
	                        id: event.target.value,
	                        name: $(event.target).parents('tr').find('p').text(),
	                        level: $(event.target).parents('tr').data('level')
	                    }
	                });
	            }
	        }
	    }, {
	        key: 'handleCreate',
	        value: function handleCreate() {
	            this.props.router.push({
	                pathname: SCHOOLPAL_CONFIG.ROOTPATH + 'org/create',
	                state: { selected: this.state.selected }
	            });
	        }
	    }, {
	        key: 'handleEditor',
	        value: function handleEditor() {
	            var editorPath = SCHOOLPAL_CONFIG.ROOTPATH + 'org/' + this.state.selected.id;

	            this.props.router.push(editorPath);
	        }
	    }, {
	        key: 'confirmDel',
	        value: function confirmDel() {
	            var div = document.createElement('div');

	            _reactDom2.default.render(_react2.default.createElement(_Dialog2.default, {
	                container: div,
	                text: '是否确认删除 ' + this.state.selected.name + ' 组织 ？',
	                action: this.handleDel
	            }), document.body.appendChild(div));
	        }
	    }, {
	        key: 'handleDel',
	        value: function handleDel() {
	            var _this5 = this;

	            var loading = (0, _DialogTips2.default)({ type: 'loading' });
	            var success = (0, _DialogTips2.default)({ type: 'success', autoClose: true });
	            var fail = (0, _DialogTips2.default)({ type: 'fail', autoClose: true });

	            loading.open();

	            (0, _api.orgDel)(this.state.selected.id).done(function () {
	                var tempList = _this5.state.list.filter(function (item) {
	                    return item.cId !== _this5.state.selected.id;
	                });
	                var temp = (0, _conversion.conversionOrg)(tempList);

	                loading.close();
	                success.open();

	                _this5.setState({
	                    list: temp.original,
	                    treeList: temp.tree,
	                    rootLevel: temp.rootLevel,

	                    selected: null
	                });
	            }).fail(function () {
	                loading.close();
	                fail.open();
	            });
	        }
	    }, {
	        key: 'handleNode',
	        value: function handleNode(event) {
	            if ($(event.target).hasClass('not-child')) {
	                return;
	            };

	            var tr = $(event.target).parents('tr');
	            var level = tr.data('level');

	            tr.nextAll('tr').each(function (i, item) {
	                if ($(item).data('level') <= level) {
	                    return false;
	                };

	                if ($(event.target).hasClass('closed')) {
	                    if ($(item).data('level') === level + 1) {
	                        $(item).show();
	                    }
	                } else {
	                    $(item).hide().find('.tree-node').addClass('closed');
	                }
	            });

	            $(event.target).toggleClass('closed');
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            return _react2.default.createElement(
	                'div',
	                { className: 'org' },
	                _react2.default.createElement(
	                    'h5',
	                    null,
	                    _react2.default.createElement('i', { className: 'fa fa-sitemap', 'aria-hidden': 'true' }),
	                    '\xA0\u7EC4\u7EC7\u7BA1\u7406',
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'btn-group float-right', role: 'group' },
	                        this.renderCommand()
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'main-container' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'table table-bordered table-sm' },
	                        _react2.default.createElement(
	                            'thead',
	                            null,
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'th',
	                                    null,
	                                    '\xA0'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    null,
	                                    '\u7EC4\u7EC7\u540D\u79F0'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    null,
	                                    '\u6240\u5728\u5730\u533A'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    null,
	                                    '\u8BE6\u7EC6\u5730\u5740'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    null,
	                                    '\u8D1F\u8D23\u4EBA'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    null,
	                                    '\u8054\u7CFB\u7535\u8BDD'
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.renderTable(this.state.treeList)
	                        )
	                    )
	                )
	            );
	        }
	    }]);

	    return List;
	}(_react2.default.Component);

	exports.default = List;

/***/ },

/***/ 238:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.LoginButton = LoginButton;
	exports.CreateButton = CreateButton;
	exports.EditorButton = EditorButton;
	exports.DelButton = DelButton;
	exports.AuthButton = AuthButton;
	exports.SaveButton = SaveButton;
	exports.BackButton = BackButton;
	exports.ToggleButton = ToggleButton;

	var _react = __webpack_require__(9);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(174);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	function LoginButton(props) {
	    if (props.loading === true) {
	        return _react2.default.createElement(
	            'div',
	            { className: 'login-submit text-danger' },
	            _react2.default.createElement('i', { className: 'fa fa-circle-o-notch fa-spin fa-3x fa-fw', 'aria-hidden': 'true' })
	        );
	    } else {
	        return _react2.default.createElement(
	            'button',
	            { type: 'submit', className: 'btn btn-link login-submit' },
	            _react2.default.createElement('i', { className: 'fa fa-sign-in fa-3x', 'aria-hidden': 'true' }),
	            _react2.default.createElement(
	                'span',
	                null,
	                '\u767B\u9646'
	            )
	        );
	    }
	}

	function CreateButton(props) {
	    if (props.action) {
	        if (props.disabled === true) {
	            return _react2.default.createElement(
	                'button',
	                { type: 'button', className: 'btn btn-primary', disabled: 'disabled' },
	                _react2.default.createElement('i', { className: 'fa fa-clone', 'aria-hidden': 'true' }),
	                ' \u65B0\u5EFA'
	            );
	        } else {
	            return _react2.default.createElement(
	                'button',
	                { onClick: props.action, type: 'button', className: 'btn btn-primary' },
	                _react2.default.createElement('i', { className: 'fa fa-clone', 'aria-hidden': 'true' }),
	                ' \u65B0\u5EFA'
	            );
	        }
	    } else {
	        return _react2.default.createElement(
	            _reactRouter.Link,
	            { to: props.link, className: 'btn btn-primary' },
	            _react2.default.createElement('i', { className: 'fa fa-clone', 'aria-hidden': 'true' }),
	            ' \u65B0\u5EFA'
	        );
	    }
	}

	function EditorButton(props) {
	    if (props.disabled === true) {
	        return _react2.default.createElement(
	            'button',
	            { type: 'button', className: 'btn btn-primary', disabled: 'disabled' },
	            _react2.default.createElement('i', { className: 'fa fa-pencil-square-o', 'aria-hidden': 'true' }),
	            ' \u7F16\u8F91'
	        );
	    } else {
	        return _react2.default.createElement(
	            'button',
	            { onClick: props.action, type: 'button', className: 'btn btn-primary' },
	            _react2.default.createElement('i', { className: 'fa fa-pencil-square-o', 'aria-hidden': 'true' }),
	            ' \u7F16\u8F91'
	        );
	    }
	}

	function DelButton(props) {
	    var text = props.loading === true ? '' : ' 删除';

	    if (props.disabled === true) {
	        return _react2.default.createElement(
	            'button',
	            { type: 'button', className: 'btn btn-danger', disabled: 'disabled' },
	            _react2.default.createElement(Icon, null),
	            text
	        );
	    } else {
	        return _react2.default.createElement(
	            'button',
	            { type: 'button', className: 'btn btn-danger', onClick: props.action },
	            _react2.default.createElement(Icon, null),
	            text
	        );
	    }

	    function Icon() {
	        if (props.loading === true) {
	            return _react2.default.createElement('i', { className: 'fa fa-circle-o-notch fa-spin fa-fw', 'aria-hidden': 'true' });
	        } else {
	            return _react2.default.createElement('i', { className: 'fa fa-trash-o', 'aria-hidden': 'true' });
	        }
	    }
	}

	function AuthButton(props) {
	    return _react2.default.createElement(
	        'button',
	        { className: 'btn btn-danger', type: 'submit' },
	        _react2.default.createElement('i', { className: 'fa fa-shield', 'aria-hidden': 'true' }),
	        ' \u6388\u6743'
	    );
	}

	function SaveButton(props) {
	    return _react2.default.createElement(
	        'button',
	        { type: 'submit', className: 'btn btn-primary' },
	        props.text
	    );
	}

	function BackButton(props) {
	    return _react2.default.createElement(
	        'button',
	        { onClick: function onClick() {
	                props.router.goBack();
	            }, type: 'button', className: 'btn btn-secondary' },
	        '\u8FD4\u56DE'
	    );
	}

	function ToggleButton(props) {
	    if (props.enable === true) {
	        if (props.available === true) {
	            return _react2.default.createElement(
	                'button',
	                { onClick: action, type: 'button', className: 'btn btn-link text-success' },
	                _react2.default.createElement('i', { className: 'fa fa-toggle-on fa-2x', 'aria-hidden': 'true' })
	            );
	        } else {
	            return _react2.default.createElement(
	                'button',
	                { onClick: action, type: 'button', className: 'btn btn-link text-danger' },
	                _react2.default.createElement('i', { className: 'fa fa-toggle-off fa-2x', 'aria-hidden': 'true' })
	            );
	        }
	    } else {
	        return _react2.default.createElement(
	            'span',
	            null,
	            props.available === true ? '启用' : '禁用'
	        );
	    }

	    function action() {
	        props.action({
	            uid: props.uid,
	            available: props.available
	        });
	    }
	}

/***/ },

/***/ 239:
/***/ function(module, exports) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = DialogTips;
	var ICON_LOADING = '<i class="fa fa-circle-o-notch fa-spin fa-3x fa-fw" aria-hidden="true"></i>';
	var ICON_SUCCESS = '<i class="fa fa-hand-peace-o fa-3x" aria-hidden="true"></i>';
	var ICON_FAIL = '<i class="fa fa-close fa-3x" aria-hidden="true"></i>';
	var AUTO_CLOSED = 2000;

	function DialogTips(options) {
	    if (!(this instanceof DialogTips)) {
	        return new DialogTips(options);
	    }

	    var $elem = $(getTipsHtml());

	    function getTipsHtml() {
	        if (options.type === 'loading') {
	            return '\n                <div class="dialog-tips">\n                    <div class="content">\n                        ' + ICON_LOADING + '\n                        <span>\u52A0\u8F7D\u4E2D</span>\n                    </div>\n                </div>\n            ';
	        };

	        if (options.type === 'success') {
	            return '\n                <div class="dialog-tips">\n                    <div class="content">\n                        ' + ICON_SUCCESS + '\n                        <span>\u64CD\u4F5C\u6210\u529F</span>\n                    </div>\n                </div>\n            ';
	        };

	        if (options.type === 'fail') {
	            return '\n                <div class="dialog-tips">\n                    <div class="content">\n                        ' + ICON_FAIL + '\n                        <span>\u64CD\u4F5C\u5931\u8D25</span>\n                    </div>\n                </div>\n            ';
	        };
	    }

	    function open() {
	        $elem.appendTo('#app');

	        if (options.autoClose && options.autoClose === true) {
	            setTimeout(function () {
	                $elem.detach();
	            }, AUTO_CLOSED);
	        }
	    }

	    function close() {
	        $elem.detach();
	    }

	    return {
	        open: open,
	        close: close
	    };
	}

/***/ },

/***/ 240:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

	var _react = __webpack_require__(9);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(40);

	var _reactDom2 = _interopRequireDefault(_reactDom);

	var _reactRouter = __webpack_require__(174);

	var _OrgTree = __webpack_require__(241);

	var _OrgTree2 = _interopRequireDefault(_OrgTree);

	var _subTitle = __webpack_require__(242);

	var _subTitle2 = _interopRequireDefault(_subTitle);

	var _Button = __webpack_require__(238);

	var _api = __webpack_require__(231);

	var _DialogTips = __webpack_require__(239);

	var _DialogTips2 = _interopRequireDefault(_DialogTips);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

	__webpack_require__(243);

	var Editor = function (_React$Component) {
	    _inherits(Editor, _React$Component);

	    function Editor(props) {
	        _classCallCheck(this, Editor);

	        var _this = _possibleConstructorReturn(this, (Editor.__proto__ || Object.getPrototypeOf(Editor)).call(this, props));

	        _this.state = {
	            orgList: [],
	            selected: null
	        };
	        _this.selectOrg = _this.selectOrg.bind(_this);
	        _this.editorSubmit = _this.editorSubmit.bind(_this);
	        return _this;
	    }

	    _createClass(Editor, [{
	        key: 'componentDidMount',
	        value: function componentDidMount() {
	            var _this2 = this;

	            var dialogTips = (0, _DialogTips2.default)({ type: 'loading' });

	            dialogTips.open();

	            if (this.props.params.id === 'create') {
	                (0, _api.orgList)().done(function (data) {
	                    if (_this2.props.router.location.state && _this2.props.router.location.state.selected) {
	                        _this2.setState({
	                            orgList: data.tree,
	                            selected: {
	                                id: _this2.props.router.location.state.selected.id,
	                                name: _this2.props.router.location.state.selected.name
	                            }
	                        });
	                    } else {
	                        _this2.setState({
	                            orgList: data.tree,
	                            selected: {
	                                id: data.tree[0].cId,
	                                name: data.tree[0].cName
	                            }
	                        });
	                    }
	                }).always(function () {
	                    dialogTips.close();
	                });

	                $('#citys').citys();
	            } else {
	                $.when((0, _api.orgList)(), (0, _api.orgDetails)(this.props.params.id)).done(function (list, details) {
	                    _this2.setState({
	                        editorId: details.cId,
	                        orgList: list.tree,
	                        selected: {
	                            id: details.parentOrg.cId,
	                            name: details.parentOrg.cName
	                        }
	                    });

	                    $(_this2.editorDom).find('[name=name]').val(details.cName).end().find('[name=code]').val(details.cCode).end().find('[name=address]').val(details.cAddress).end().find('[name=owner]').val(details.cOwner).end().find('[name=phone]').val(details.cOwnerPhone);

	                    $('#citys').citys({
	                        province: details.cStateCode,
	                        city: details.cCityCode,
	                        area: details.cCountyCode || null
	                    });
	                }).always(function () {
	                    dialogTips.close();
	                });
	            }
	        }
	    }, {
	        key: 'selectOrg',
	        value: function selectOrg(org) {
	            if (org) {
	                this.setState({
	                    selected: org
	                });
	            } else {
	                this.setState({
	                    selected: null
	                });
	            };
	        }
	    }, {
	        key: 'editorSubmit',
	        value: function editorSubmit(event) {
	            var _this3 = this;

	            if (this.editorDom.checkValidity() === true) {
	                event.preventDefault();
	            };

	            var successPath = SCHOOLPAL_CONFIG.ROOTPATH + 'org';
	            var loading = (0, _DialogTips2.default)({ type: 'loading' });
	            var success = (0, _DialogTips2.default)({ type: 'success' });
	            var fail = (0, _DialogTips2.default)({ type: 'fail', autoClose: true });
	            var param = {};

	            $(this.editorDom).serializeArray().map(function (item) {
	                param[item.name] = item.value;
	            });

	            param.parentId = this.state.selected.id;
	            param.state = $('#citys').find('[name="stateCode"]').find("option:selected").text();
	            param.city = $('#citys').find('[name="cityCode"]').find("option:selected").text();
	            param.county = $('#citys').find('[name="countyCode"]').find("option:selected").text();

	            loading.open();

	            if (this.state.editorId) {
	                param.id = this.state.editorId;

	                (0, _api.orgMod)(param).done(function () {
	                    loading.close();
	                    success.open();
	                    setTimeout(function () {
	                        success.close();
	                        _this3.props.router.push(successPath);
	                    }, 2000);
	                }).fail(function (data) {
	                    loading.close();
	                    fail.open();
	                });
	            } else {
	                (0, _api.orgAdd)(param).done(function () {
	                    loading.close();
	                    success.open();
	                    setTimeout(function () {
	                        success.close();
	                        _this3.props.router.push(successPath);
	                    }, 2000);
	                }).fail(function (data) {
	                    loading.close();
	                    fail.open();
	                });
	            }
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            var _this4 = this;

	            return _react2.default.createElement(
	                'div',
	                { className: 'org' },
	                _react2.default.createElement(
	                    'form',
	                    { ref: function ref(dom) {
	                            _this4.editorDom = dom;
	                        }, onSubmit: this.editorSubmit },
	                    _react2.default.createElement(
	                        'h5',
	                        null,
	                        _react2.default.createElement('i', { className: 'fa fa-sitemap', 'aria-hidden': 'true' }),
	                        '\xA0\u7EC4\u7EC7\u7BA1\u7406\xA0\xA0|\xA0\xA0',
	                        _react2.default.createElement(
	                            'p',
	                            { className: 'd-inline text-muted' },
	                            (0, _subTitle2.default)(this.props.router.params.id, '组织')
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'btn-group float-right', role: 'group' },
	                            _react2.default.createElement(_Button.BackButton, { router: this.props.router }),
	                            _react2.default.createElement(_Button.SaveButton, { text: '\u4FDD\u5B58' })
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'main-container' },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'd-flex align-items-stretch flex-nowrap' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'w400' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'form-group' },
	                                    _react2.default.createElement(
	                                        'label',
	                                        { 'for': 'name' },
	                                        _react2.default.createElement(
	                                            'em',
	                                            { className: 'text-danger' },
	                                            '*'
	                                        ),
	                                        '\u7EC4\u7EC7\u540D\u79F0'
	                                    ),
	                                    _react2.default.createElement('input', { type: 'text', className: 'form-control', name: 'name', required: 'required' })
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'form-group' },
	                                    _react2.default.createElement(
	                                        'label',
	                                        { 'for': 'name' },
	                                        _react2.default.createElement(
	                                            'em',
	                                            { className: 'text-danger' },
	                                            '*'
	                                        ),
	                                        '\u7EC4\u7EC7\u4EE3\u7801'
	                                    ),
	                                    _react2.default.createElement('input', { type: 'text', className: 'form-control', name: 'code', required: 'required' })
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'form-group' },
	                                    _react2.default.createElement(
	                                        'label',
	                                        { 'for': 'name' },
	                                        _react2.default.createElement(
	                                            'em',
	                                            { className: 'text-danger' },
	                                            '*'
	                                        ),
	                                        '\u7236\u7EA7\u7EC4\u7EC7\uFF1A'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'form-group' },
	                                        _react2.default.createElement(
	                                            'div',
	                                            { className: 'btn-group btn-block' },
	                                            _react2.default.createElement('input', { type: 'text', className: 'form-control', 'data-toggle': 'dropdown', value: this.state.selected ? this.state.selected.name : '', readOnly: true }),
	                                            _react2.default.createElement(
	                                                'div',
	                                                { className: 'dropdown-menu' },
	                                                _react2.default.createElement(_OrgTree2.default, { data: this.state.orgList, selected: this.selectOrg, defaults: this.state.selected ? this.state.selected.id : null })
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'form-group' },
	                                    _react2.default.createElement(
	                                        'label',
	                                        { 'for': 'name' },
	                                        _react2.default.createElement(
	                                            'em',
	                                            { className: 'text-danger' },
	                                            '*'
	                                        ),
	                                        '\u6240\u5728\u5730\u533A'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { id: 'citys', className: 'row' },
	                                        _react2.default.createElement(
	                                            'div',
	                                            { className: 'col' },
	                                            _react2.default.createElement('select', { name: 'stateCode', className: 'form-control' })
	                                        ),
	                                        _react2.default.createElement(
	                                            'div',
	                                            { className: 'col' },
	                                            _react2.default.createElement('select', { name: 'cityCode', className: 'form-control' })
	                                        ),
	                                        _react2.default.createElement(
	                                            'div',
	                                            { className: 'col' },
	                                            _react2.default.createElement('select', { name: 'countyCode', className: 'form-control' })
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'form-group' },
	                                    _react2.default.createElement(
	                                        'label',
	                                        { 'for': 'name' },
	                                        _react2.default.createElement(
	                                            'em',
	                                            { className: 'text-danger' },
	                                            '*'
	                                        ),
	                                        '\u8BE6\u7EC6\u5730\u5740'
	                                    ),
	                                    _react2.default.createElement('textarea', { name: 'address', className: 'form-control', rows: '3', required: 'required' })
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'form-group' },
	                                    _react2.default.createElement(
	                                        'label',
	                                        { 'for': 'name' },
	                                        _react2.default.createElement(
	                                            'em',
	                                            { className: 'text-danger' },
	                                            '*'
	                                        ),
	                                        '\u8D1F\u8D23\u4EBA'
	                                    ),
	                                    _react2.default.createElement('input', { type: 'text', className: 'form-control', name: 'owner', required: 'required' })
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'form-group' },
	                                    _react2.default.createElement(
	                                        'label',
	                                        { 'for': 'name' },
	                                        _react2.default.createElement(
	                                            'em',
	                                            { className: 'text-danger' },
	                                            '*'
	                                        ),
	                                        '\u8054\u7CFB\u7535\u8BDD'
	                                    ),
	                                    _react2.default.createElement('input', { type: 'text', className: 'form-control', name: 'phone', pattern: '^1\\d{10}$', required: 'required' })
	                                )
	                            )
	                        )
	                    )
	                )
	            );
	        }
	    }]);

	    return Editor;
	}(_react2.default.Component);

	exports.default = Editor;

/***/ },

/***/ 241:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

	var _react = __webpack_require__(9);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

	var OrgTree = function (_React$Component) {
	    _inherits(OrgTree, _React$Component);

	    function OrgTree(props) {
	        _classCallCheck(this, OrgTree);

	        var _this = _possibleConstructorReturn(this, (OrgTree.__proto__ || Object.getPrototypeOf(OrgTree)).call(this, props));

	        _this.renderTree = _this.renderTree.bind(_this);
	        _this.renderTreeItem = _this.renderTreeItem.bind(_this);
	        _this.handleSelect = _this.handleSelect.bind(_this);
	        return _this;
	    }

	    _createClass(OrgTree, [{
	        key: 'componentDidMount',
	        value: function componentDidMount() {
	            $(this.treeDom).on('click', '[data-node]', function (event) {
	                event.stopPropagation();

	                if ($(this).hasClass('not-child')) {
	                    return;
	                };

	                if ($(this).hasClass('closed')) {
	                    $(this).removeClass('closed').closest('li').children('ul').show();
	                } else {
	                    $(this).closest('li').find('[data-node]').addClass('closed').end().closest('li').find('ul').hide();
	                };
	            });
	        }
	    }, {
	        key: 'renderTree',
	        value: function renderTree(data) {
	            var _this2 = this;

	            var tree = [];

	            data.map(function (item) {
	                var children = [];

	                if (item.children && item.children.length) {
	                    var _children = [];

	                    _children.push(_this2.renderTree(item.children));
	                    tree.push(_react2.default.createElement(
	                        'li',
	                        { key: item.cId },
	                        _this2.renderTreeItem(item),
	                        _react2.default.createElement(
	                            'ul',
	                            null,
	                            _children
	                        )
	                    ));
	                } else {
	                    tree.push(_react2.default.createElement(
	                        'li',
	                        { key: item.cId },
	                        _this2.renderTreeItem(item)
	                    ));
	                }
	            });

	            return tree;
	        }
	    }, {
	        key: 'renderTreeItem',
	        value: function renderTreeItem(data) {
	            var nodeClass = 'tree-node ' + (data.children && data.children.length ? '' : 'not-child');
	            var nodeSelectClass = 'select ' + (this.props.defaults && this.props.defaults.toString() === data.cId ? 'selected' : '');

	            return _react2.default.createElement(
	                'div',
	                { className: 'hd' },
	                _react2.default.createElement('i', { onClick: this.handleNode, 'data-node': true, className: nodeClass }),
	                _react2.default.createElement(
	                    'p',
	                    { onClick: this.handleSelect, 'data-o': data.cId, className: nodeSelectClass },
	                    _react2.default.createElement(
	                        'span',
	                        null,
	                        data.cName
	                    )
	                )
	            );
	        }
	    }, {
	        key: 'handleSelect',
	        value: function handleSelect(event) {
	            var elem = $(event.target).data('o') ? $(event.target) : $(event.target).parent();

	            if (elem.hasClass('selected')) {
	                return;
	            }

	            this.props.selected({
	                id: elem.data('o'),
	                name: elem.children('span').text()
	            });
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            var _this3 = this;

	            return _react2.default.createElement(
	                'div',
	                { ref: function ref(dom) {
	                        _this3.treeDom = dom;
	                    }, className: 'tree' },
	                _react2.default.createElement(
	                    'ul',
	                    null,
	                    this.renderTree(this.props.data)
	                )
	            );
	        }
	    }]);

	    return OrgTree;
	}(_react2.default.Component);

	exports.default = OrgTree;

/***/ },

/***/ 242:
/***/ function(module, exports) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = subTitle;
	function subTitle(id, menu) {
	    if (id === 'create') {
	        return '新建' + menu;
	    } else {
	        return '编辑' + menu;
	    }
	}

/***/ },

/***/ 243:
/***/ function(module, exports) {

	'use strict';

	/**
	 * jquery.citys.js 1.0
	 * http://jquerywidget.com
	 */

	$.fn.citys = function (parameter, getApi) {
	    if (typeof parameter == 'function') {
	        //重载
	        getApi = parameter;
	        parameter = {};
	    } else {
	        parameter = parameter || {};
	        getApi = getApi || function () {};
	    }
	    var defaults = {
	        dataUrl: 'http://passer-by.com/data_location/list.json', //数据库地址
	        dataType: 'json', //数据库类型:'json'或'jsonp'
	        provinceField: 'stateCode', //省份字段名
	        cityField: 'cityCode', //城市字段名
	        areaField: 'countyCode', //地区字段名
	        code: 0, //地区编码
	        province: 0, //省份,可以为地区编码或者名称
	        city: 0, //城市,可以为地区编码或者名称
	        area: 0, //地区,可以为地区编码或者名称
	        required: true, //是否必须选一个
	        nodata: 'hidden', //当无数据时的表现形式:'hidden'隐藏,'disabled'禁用,为空不做任何处理
	        onChange: function onChange() {} //地区切换时触发,回调函数传入地区数据
	    };
	    var options = $.extend({}, defaults, parameter);
	    return this.each(function () {
	        //对象定义
	        var _api = {};
	        var $this = $(this);
	        var $province = $this.find('select[name="' + options.provinceField + '"]'),
	            $city = $this.find('select[name="' + options.cityField + '"]'),
	            $area = $this.find('select[name="' + options.areaField + '"]');
	        $.ajax({
	            url: options.dataUrl,
	            type: 'GET',
	            crossDomain: true,
	            dataType: options.dataType,
	            jsonpCallback: 'jsonp_location',
	            success: function success(data) {
	                var _province, _city, _area, hasCity;
	                if (options.code) {
	                    //如果设置地区编码，则忽略单独设置的信息
	                    var c = options.code - options.code % 1e4;
	                    if (data[c]) {
	                        options.province = c;
	                    }
	                    c = options.code - (options.code % 1e4 ? options.code % 1e2 : options.code);
	                    if (data[c]) {
	                        options.city = c;
	                    }
	                    c = options.code % 1e2 ? options.code : 0;
	                    if (data[c]) {
	                        options.area = c;
	                    }
	                }
	                var updateData = function updateData() {
	                    _province = {}, _city = {}, _area = {};
	                    hasCity = false; //判断是非有地级城市
	                    for (var code in data) {
	                        if (!(code % 1e4)) {
	                            //获取所有的省级行政单位
	                            _province[code] = data[code];
	                            if (options.required && !options.province) {
	                                if (options.city && !(options.city % 1e4)) {
	                                    //省未填，并判断为直辖市
	                                    options.province = options.city;
	                                } else {
	                                    options.province = code;
	                                }
	                            } else if (data[code].indexOf(options.province) > -1) {
	                                options.province = isNaN(options.province) ? code : options.province;
	                            }
	                        } else {
	                            var p = code - options.province;
	                            if (options.province && p > 0 && p < 1e4) {
	                                //同省的城市或地区
	                                if (!(code % 100)) {
	                                    hasCity = true;
	                                    _city[code] = data[code];
	                                    if (options.required && !options.city) {
	                                        options.city = code;
	                                    } else if (data[code].indexOf(options.city) > -1) {
	                                        options.city = isNaN(options.city) ? code : options.city;
	                                    }
	                                } else if (p > 9000) {
	                                    //省直辖县级行政单位
	                                    _city[code] = data[code];
	                                    if (options.required && !options.city) {
	                                        options.city = code;
	                                    } else if (data[code].indexOf(options.city) > -1) {
	                                        options.city = isNaN(options.city) ? code : options.city;
	                                    }
	                                } else if (hasCity) {
	                                    //非直辖市
	                                    var c = code - options.city;
	                                    if (options.city && c > 0 && c < 100) {
	                                        //同个城市的地区
	                                        _area[code] = data[code];
	                                        if (options.required && !options.area) {
	                                            options.area = code;
	                                        } else if (data[code].indexOf(options.area) > -1) {
	                                            options.area = isNaN(options.area) ? code : options.area;
	                                        }
	                                    }
	                                } else {
	                                    _city[code] = data[code]; //直辖市
	                                    if (options.area) {
	                                        options.city = options.area;
	                                        options.area = '';
	                                    }
	                                    if (options.required && !options.city) {
	                                        options.city = code;
	                                    } else if (data[code].indexOf(options.city) > -1) {
	                                        options.city = isNaN(options.city) ? code : options.city;
	                                    }
	                                }
	                            }
	                        }
	                    }
	                };
	                var format = {
	                    province: function province() {
	                        $province.empty();
	                        if (!options.required) {
	                            $province.append('<option value=""> - 请选择 - </option>');
	                        }
	                        for (var i in _province) {
	                            $province.append('<option value="' + i + '">' + _province[i] + '</option>');
	                        }
	                        if (options.province) {
	                            $province.val(options.province);
	                        }
	                        this.city();
	                    },
	                    city: function city() {
	                        $city.empty();
	                        if (!options.required) {
	                            $city.append('<option value=""> - 请选择 - </option>');
	                        }
	                        if (options.nodata == 'disabled') {
	                            $city.prop('disabled', $.isEmptyObject(_city));
	                        } else if (options.nodata == 'hidden') {
	                            $city.css('display', $.isEmptyObject(_city) ? 'none' : '');
	                        }
	                        for (var i in _city) {
	                            $city.append('<option value="' + i + '">' + _city[i] + '</option>');
	                        }
	                        if (options.city) {
	                            $city.val(options.city);
	                        }
	                        this.area();
	                    },
	                    area: function area() {
	                        $area.empty();
	                        if (!hasCity) {
	                            $area.css('display', 'none');
	                        } else {
	                            $area.css('display', '');
	                            if (!options.required) {
	                                $area.append('<option value=""> - 请选择 - </option>');
	                            }
	                            if (options.nodata == 'disabled') {
	                                $area.prop('disabled', $.isEmptyObject(_area));
	                            } else if (options.nodata == 'hidden') {
	                                $area.css('display', $.isEmptyObject(_area) ? 'none' : '');
	                            }
	                            for (var i in _area) {
	                                $area.append('<option value="' + i + '">' + _area[i] + '</option>');
	                            }
	                            if (options.area) {
	                                $area.val(options.area);
	                            }
	                        }
	                    }
	                };
	                //获取当前地理信息
	                _api.getInfo = function () {
	                    var status = {
	                        direct: !hasCity,
	                        province: data[options.province] || '',
	                        city: data[options.city] || '',
	                        area: data[options.area] || '',
	                        code: options.area || options.city || options.province
	                    };
	                    return status;
	                };
	                //事件绑定
	                $province.on('change', function () {
	                    options.province = $(this).val();
	                    options.city = 0;
	                    options.area = 0;
	                    updateData();
	                    format.city();
	                    options.onChange(_api.getInfo());
	                });
	                $city.on('change', function () {
	                    options.city = $(this).val();
	                    options.area = 0;
	                    updateData();
	                    format.area();
	                    options.onChange(_api.getInfo());
	                });
	                $area.on('change', function () {
	                    options.area = $(this).val();
	                    options.onChange(_api.getInfo());
	                });
	                //初始化
	                updateData();
	                format.province();
	                if (options.code) {
	                    options.onChange(_api.getInfo());
	                }
	                getApi(_api);
	            }
	        });
	    });
	};

/***/ },

/***/ 244:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

	var _react = __webpack_require__(9);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(40);

	var _reactDom2 = _interopRequireDefault(_reactDom);

	var _reactRouter = __webpack_require__(174);

	var _OrgTree = __webpack_require__(241);

	var _OrgTree2 = _interopRequireDefault(_OrgTree);

	var _Dialog = __webpack_require__(233);

	var _Dialog2 = _interopRequireDefault(_Dialog);

	var _Button = __webpack_require__(238);

	var _api = __webpack_require__(231);

	var _DialogTips = __webpack_require__(239);

	var _DialogTips2 = _interopRequireDefault(_DialogTips);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

	function getFuncStr(data) {
	    var funcArr = [];

	    data.map(function (item) {
	        funcArr.push(item.cNameShort);
	    });

	    return funcArr.join(',');
	}

	var List = function (_React$Component) {
	    _inherits(List, _React$Component);

	    function List(props) {
	        _classCallCheck(this, List);

	        var _this = _possibleConstructorReturn(this, (List.__proto__ || Object.getPrototypeOf(List)).call(this, props));

	        _this.state = {
	            orgList: [],
	            org: null,

	            roleList: [],
	            selected: null
	        };

	        _this.renderCommand = _this.renderCommand.bind(_this);
	        _this.selectOrg = _this.selectOrg.bind(_this);
	        _this.checkedRole = _this.checkedRole.bind(_this);
	        _this.handleCreate = _this.handleCreate.bind(_this);
	        _this.handleEditor = _this.handleEditor.bind(_this);
	        _this.handleDel = _this.handleDel.bind(_this);
	        _this.confirmDel = _this.confirmDel.bind(_this);
	        return _this;
	    }

	    _createClass(List, [{
	        key: 'componentDidMount',
	        value: function componentDidMount() {
	            var _this2 = this;

	            var dialogTips = (0, _DialogTips2.default)({ type: 'loading' });

	            dialogTips.open();

	            (0, _api.orgList)().done(function (org) {
	                (0, _api.roleList)(org.original[0].cId).done(function (role) {
	                    _this2.setState({
	                        orgList: org.tree,
	                        org: {
	                            id: org.original[0].cId,
	                            name: org.original[0].cName
	                        },

	                        roleList: role
	                    });
	                }).always(function () {
	                    dialogTips.close();
	                });
	            });
	        }
	    }, {
	        key: 'renderCommand',
	        value: function renderCommand() {
	            var _this3 = this;

	            var temp = [];

	            if (SCHOOLPAL_CONFIG.auth[this.props.route.path] && SCHOOLPAL_CONFIG.auth[this.props.route.path].command.length) {
	                SCHOOLPAL_CONFIG.auth[this.props.route.path].command.map(function (item, index) {
	                    if (item === 'Add') {
	                        temp.push(_react2.default.createElement(_Button.CreateButton, { key: index, action: _this3.handleCreate }));
	                    };

	                    if (item === 'Mod') {
	                        temp.push(_react2.default.createElement(_Button.EditorButton, { key: index, action: _this3.handleEditor, disabled: _this3.state.selected === null ? true : false }));
	                    }

	                    if (item === 'Del') {
	                        temp.push(_react2.default.createElement(_Button.DelButton, { key: index, action: _this3.confirmDel, disabled: _this3.state.selected === null ? true : false }));
	                    }
	                });
	            }

	            return temp;
	        }
	    }, {
	        key: 'selectOrg',
	        value: function selectOrg(org) {
	            var _this4 = this;

	            var dialogTips = (0, _DialogTips2.default)({ type: 'loading' });

	            if (org) {
	                this.setState({ org: org });

	                dialogTips.open();

	                (0, _api.roleList)(org.id).done(function (data) {
	                    _this4.setState({ roleList: data });
	                }).always(function () {
	                    dialogTips.close();
	                });
	            }
	        }
	    }, {
	        key: 'checkedRole',
	        value: function checkedRole(event) {
	            if (event.target.checked === true) {
	                this.setState({
	                    selected: {
	                        id: event.target.value,
	                        name: $(event.target).parents('tr').find('[data-name]').text()
	                    }
	                });
	            }
	        }
	    }, {
	        key: 'handleCreate',
	        value: function handleCreate() {
	            var editorPath = SCHOOLPAL_CONFIG.ROOTPATH + 'role/' + this.state.org.id + '/create';

	            this.props.router.push(editorPath);
	        }
	    }, {
	        key: 'handleEditor',
	        value: function handleEditor() {
	            var editorPath = SCHOOLPAL_CONFIG.ROOTPATH + 'role/' + this.state.org.id + '/' + this.state.selected.id;

	            this.props.router.push(editorPath);
	        }
	    }, {
	        key: 'handleDel',
	        value: function handleDel() {
	            var _this5 = this;

	            var loading = (0, _DialogTips2.default)({ type: 'loading' });
	            var success = (0, _DialogTips2.default)({ type: 'success', autoClose: true });
	            var fail = (0, _DialogTips2.default)({ type: 'fail', autoClose: true });

	            loading.open();

	            (0, _api.roleDel)(this.state.selected.id).done(function () {
	                var tempList = _this5.state.roleList.filter(function (item) {
	                    return item.cId !== _this5.state.selected.id;
	                });

	                loading.close();
	                success.open();

	                _this5.setState({
	                    roleList: tempList,
	                    selected: null
	                });
	            }).fail(function () {
	                loading.close();
	                fail.open();
	            });
	        }
	    }, {
	        key: 'confirmDel',
	        value: function confirmDel() {
	            var div = document.createElement('div');

	            _reactDom2.default.render(_react2.default.createElement(_Dialog2.default, {
	                container: div,
	                text: '是否确认删除 ' + this.state.selected.name + ' 角色 ？',
	                action: this.handleDel
	            }), document.body.appendChild(div));
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            var _this6 = this;

	            return _react2.default.createElement(
	                'div',
	                { className: 'role' },
	                _react2.default.createElement(
	                    'h5',
	                    null,
	                    _react2.default.createElement('i', { className: 'fa fa-glass' }),
	                    '\xA0\u89D2\u8272\u7BA1\u7406',
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'btn-group float-right', role: 'group' },
	                        this.renderCommand()
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'main-container' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'd-flex align-items-stretch flex-nowrap' },
	                        _react2.default.createElement(
	                            'div',
	                            { className: this.state.org === null ? 'hide' : 'w300' },
	                            _react2.default.createElement(_OrgTree2.default, { data: this.state.orgList, selected: this.selectOrg, defaults: this.state.org ? this.state.org.id : null })
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: this.state.org === null ? 'hide' : 'flex-cell pl-3 b-l' },
	                            _react2.default.createElement(
	                                'table',
	                                { className: this.state.roleList === null ? 'hide' : 'table table-bordered table-sm' },
	                                _react2.default.createElement(
	                                    'thead',
	                                    null,
	                                    _react2.default.createElement(
	                                        'tr',
	                                        null,
	                                        _react2.default.createElement(
	                                            'th',
	                                            null,
	                                            '#'
	                                        ),
	                                        _react2.default.createElement(
	                                            'th',
	                                            null,
	                                            '\u89D2\u8272\u804C\u80FD'
	                                        ),
	                                        _react2.default.createElement(
	                                            'th',
	                                            null,
	                                            '\u89D2\u8272\u804C\u7EA7'
	                                        ),
	                                        _react2.default.createElement(
	                                            'th',
	                                            null,
	                                            '\u89D2\u8272\u540D\u79F0'
	                                        ),
	                                        _react2.default.createElement(
	                                            'th',
	                                            null,
	                                            '\u89D2\u8272\u63CF\u8FF0'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tbody',
	                                    null,
	                                    this.state.roleList.map(function (item) {
	                                        return _react2.default.createElement(
	                                            'tr',
	                                            { key: item.cId },
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'div',
	                                                    { className: 'form-check' },
	                                                    _react2.default.createElement(
	                                                        'label',
	                                                        { className: 'form-check-label' },
	                                                        _react2.default.createElement('input', {
	                                                            onChange: _this6.checkedRole,
	                                                            className: 'form-check-input',
	                                                            type: 'radio',
	                                                            name: 'org',
	                                                            checked: _this6.state.selected && item.cId === _this6.state.selected.id ? true : false,
	                                                            value: item.cId
	                                                        })
	                                                    )
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                getFuncStr(item.rootFuncs)
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                item.cRankName
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { 'data-name': true },
	                                                item.cName
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                item.cDesc
	                                            )
	                                        );
	                                    })
	                                )
	                            )
	                        )
	                    )
	                )
	            );
	        }
	    }]);

	    return List;
	}(_react2.default.Component);

	exports.default = List;

/***/ },

/***/ 245:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

	var _react = __webpack_require__(9);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(40);

	var _reactDom2 = _interopRequireDefault(_reactDom);

	var _reactRouter = __webpack_require__(174);

	var _Button = __webpack_require__(238);

	var _subTitle = __webpack_require__(242);

	var _subTitle2 = _interopRequireDefault(_subTitle);

	var _api = __webpack_require__(231);

	var _DialogTips = __webpack_require__(239);

	var _DialogTips2 = _interopRequireDefault(_DialogTips);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

	var FUNC_ADMIN_ID = '7';
	var RANK_ADMIN_ID = '4';
	var RANK_MANAGER_ID = '1';

	function formatFuncData(data) {
	    var temp = [];

	    data.map(function (item) {
	        if (item.cId === item.cRootId) {
	            temp.push(item);
	        }
	    });

	    return temp;
	}

	var Editor = function (_React$Component) {
	    _inherits(Editor, _React$Component);

	    function Editor(props) {
	        _classCallCheck(this, Editor);

	        var _this = _possibleConstructorReturn(this, (Editor.__proto__ || Object.getPrototypeOf(Editor)).call(this, props));

	        _this.state = {
	            org: null,

	            rank: [],
	            func: [],

	            isAdmin: false,
	            checkedFunc: [],
	            checkedRank: null
	        };

	        _this.checkedFunc = _this.checkedFunc.bind(_this);
	        _this.checkedRank = _this.checkedRank.bind(_this);
	        _this.editorSubmit = _this.editorSubmit.bind(_this);
	        return _this;
	    }

	    _createClass(Editor, [{
	        key: 'componentDidMount',
	        value: function componentDidMount() {
	            var _this2 = this;

	            var dialogTips = (0, _DialogTips2.default)({ type: 'loading' });

	            dialogTips.open();

	            if (this.props.params.rid === 'create') {
	                $.when((0, _api.orgDetails)(this.props.params.oid), (0, _api.funcDic)(), (0, _api.rankDic)()).done(function (org, func, rank) {
	                    _this2.setState({
	                        org: {
	                            id: org.cId,
	                            name: org.cName
	                        },
	                        rank: rank,
	                        func: formatFuncData(func)
	                    });
	                }).always(function () {
	                    dialogTips.close();
	                });
	            } else {
	                $.when((0, _api.orgDetails)(this.props.params.oid), (0, _api.funcDic)(), (0, _api.rankDic)(), (0, _api.roleDetails)(this.props.params.rid)).done(function (org, func, rank, role) {
	                    var tempCheckedFunc = {};

	                    role.rootFuncs.map(function (item) {
	                        tempCheckedFunc[item.cId] = true;
	                    });

	                    _this2.setState({
	                        editorId: role.cId,
	                        org: {
	                            id: org.cId,
	                            name: org.cName
	                        },
	                        rank: rank,
	                        func: formatFuncData(func),

	                        checkedFunc: tempCheckedFunc,
	                        checkedRank: role.cRankId.toString()
	                    });

	                    $(_this2.editorDom).find('[name=name]').val(role.cName).end().find('[name=desc]').val(role.cDesc);
	                }).always(function () {
	                    dialogTips.close();
	                });
	            }
	        }
	    }, {
	        key: 'checkedFunc',
	        value: function checkedFunc(event) {
	            var isAdmin = event.target.value === FUNC_ADMIN_ID ? true : false;
	            var tempFunc = [];
	            var tempRank = this.state.checkedRank;

	            if (event.target.checked === true) {
	                tempFunc.push(event.target.value);

	                if (isAdmin !== true) {
	                    tempFunc = tempFunc.concat(this.state.checkedFunc.filter(function (item) {
	                        return item !== FUNC_ADMIN_ID;
	                    }));
	                }
	            } else {
	                tempFunc = this.state.checkedFunc.filter(function (item) {
	                    return item !== event.target.value;
	                });
	            }

	            if (tempFunc.findIndex(function (id) {
	                return id === FUNC_ADMIN_ID;
	            }) >= 0) {
	                tempRank = RANK_ADMIN_ID;
	            } else {
	                if (tempRank === RANK_ADMIN_ID) {
	                    tempRank = null;
	                }

	                if (tempFunc.length === 1 && this.state.checkedRank === RANK_MANAGER_ID) {
	                    tempRank = null;
	                }

	                if (tempFunc.length > 1) {
	                    tempRank = RANK_MANAGER_ID;
	                }
	            }

	            if (tempFunc.length) {
	                $(this.editorDom).find('input[type=checkbox]').removeAttr('required');
	            } else {
	                $(this.editorDom).find('input[type=checkbox]').attr('required', 'required');
	            }

	            this.setState({
	                isAdmin: isAdmin === true && event.target.checked === true ? true : false,
	                checkedFunc: tempFunc,
	                checkedRank: tempRank
	            });
	        }
	    }, {
	        key: 'checkedRank',
	        value: function checkedRank(event) {
	            var tempFunc = [];
	            var tempRank = this.state.checkedRank;

	            if (event.target.value === RANK_ADMIN_ID) {
	                tempFunc.push(FUNC_ADMIN_ID);
	            } else if (event.target.value !== RANK_MANAGER_ID && this.state.checkedFunc.length > 1) {
	                tempFunc = this.state.checkedFunc.filter(function (id, index) {
	                    return index === 0;
	                });
	            } else {
	                tempFunc = this.state.checkedFunc.filter(function (id) {
	                    return id !== FUNC_ADMIN_ID;
	                });
	            }

	            this.setState({
	                checkedFunc: tempFunc,
	                checkedRank: event.target.value
	            });
	        }
	    }, {
	        key: 'editorSubmit',
	        value: function editorSubmit(event) {
	            var _this3 = this;

	            if (this.editorDom.checkValidity() === true) {
	                event.preventDefault();
	            };

	            var successPath = SCHOOLPAL_CONFIG.ROOTPATH + 'role';
	            var loading = (0, _DialogTips2.default)({ type: 'loading' });
	            var success = (0, _DialogTips2.default)({ type: 'success' });
	            var fail = (0, _DialogTips2.default)({ type: 'fail', autoClose: true });
	            var param = {};

	            param.orgId = this.state.org.id;
	            param.strFuncIds = this.state.checkedFunc.join(',');
	            param.rankId = this.state.checkedRank;
	            param.name = $(this.editorDom).find('[name=name]').val();
	            param.desc = $(this.editorDom).find('[name=desc]').val();

	            loading.open();

	            if (this.state.editorId) {
	                param.id = this.state.editorId;
	                (0, _api.roleMod)(param).done(function () {
	                    loading.close();
	                    success.open();
	                    setTimeout(function () {
	                        success.close();
	                        _this3.props.router.push(successPath);
	                    }, 2000);
	                }).fail(function (data) {
	                    loading.close();
	                    fail.open();
	                });
	            } else {
	                (0, _api.roleAdd)(param).done(function () {
	                    loading.close();
	                    success.open();
	                    setTimeout(function () {
	                        success.close();
	                        _this3.props.router.push(successPath);
	                    }, 2000);
	                }).fail(function (data) {
	                    loading.close();
	                    fail.open();
	                });
	            }
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            var _this4 = this;

	            return _react2.default.createElement(
	                'div',
	                { className: 'org' },
	                _react2.default.createElement(
	                    'form',
	                    { ref: function ref(dom) {
	                            _this4.editorDom = dom;
	                        }, onSubmit: this.editorSubmit },
	                    _react2.default.createElement(
	                        'h5',
	                        null,
	                        _react2.default.createElement('i', { className: 'fa fa-glass' }),
	                        '\xA0\u89D2\u8272\u7BA1\u7406\xA0|\xA0',
	                        _react2.default.createElement(
	                            'p',
	                            { className: 'd-inline text-muted' },
	                            (0, _subTitle2.default)(this.props.router.params.id, '角色')
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'btn-group float-right', role: 'group' },
	                            _react2.default.createElement(_Button.BackButton, { router: this.props.router }),
	                            _react2.default.createElement(_Button.SaveButton, { action: this.editorSubmit, text: '\u4FDD\u5B58' })
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'main-container' },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'd-flex align-items-stretch flex-nowrap' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: this.state.org === null ? 'hide' : 'w500' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'form-group' },
	                                    _react2.default.createElement(
	                                        'label',
	                                        { 'for': 'name' },
	                                        _react2.default.createElement(
	                                            'em',
	                                            { className: 'text-danger' },
	                                            '*'
	                                        ),
	                                        '\u6240\u5C5E\u7EC4\u7EC7\uFF1A'
	                                    ),
	                                    _react2.default.createElement('input', { type: 'text', className: 'form-control', value: this.state.org ? this.state.org.name : '', disabled: 'disabled' })
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'form-group' },
	                                    _react2.default.createElement(
	                                        'label',
	                                        { 'for': 'name' },
	                                        _react2.default.createElement(
	                                            'em',
	                                            { className: 'text-danger' },
	                                            '*'
	                                        ),
	                                        '\u89D2\u8272\u804C\u80FD'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        null,
	                                        this.state.func.map(function (item) {
	                                            var adminClass = item.cId === FUNC_ADMIN_ID ? 'form-check form-check-inline b-l pl-3' : 'form-check form-check-inline';

	                                            return _react2.default.createElement(
	                                                'div',
	                                                { key: item.cId, className: adminClass },
	                                                _react2.default.createElement(
	                                                    'label',
	                                                    { className: 'form-check-label' },
	                                                    _react2.default.createElement('input', {
	                                                        onChange: _this4.checkedFunc,
	                                                        className: 'form-check-input',
	                                                        type: 'checkbox',
	                                                        value: item.cId,
	                                                        checked: _this4.state.checkedFunc.findIndex(function (id) {
	                                                            return id === item.cId;
	                                                        }) < 0 ? false : true,
	                                                        name: 'func',
	                                                        required: 'required'
	                                                    }),
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        item.cNameShort
	                                                    )
	                                                )
	                                            );
	                                        })
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'form-group' },
	                                    _react2.default.createElement(
	                                        'label',
	                                        { 'for': 'name' },
	                                        _react2.default.createElement(
	                                            'em',
	                                            { className: 'text-danger' },
	                                            '*'
	                                        ),
	                                        '\u89D2\u8272\u804C\u7EA7'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        null,
	                                        this.state.rank.map(function (item) {
	                                            var adminClass = item.cId.toString() === RANK_ADMIN_ID ? 'form-check form-check-inline b-l pl-3' : 'form-check form-check-inline';
	                                            var isDisabled = false;

	                                            if (_this4.state.isAdmin === true && item.cId.toString() !== RANK_ADMIN_ID) {
	                                                isDisabled = true;
	                                            }

	                                            if (_this4.state.isAdmin === false && item.cId.toString() === RANK_ADMIN_ID) {
	                                                isDisabled = true;
	                                            }

	                                            if (_this4.state.checkedFunc.length === 1 && item.cId.toString() === RANK_MANAGER_ID) {
	                                                isDisabled = true;
	                                            }

	                                            return _react2.default.createElement(
	                                                'div',
	                                                { key: item.cId, className: adminClass },
	                                                _react2.default.createElement(
	                                                    'label',
	                                                    { className: 'form-check-label' },
	                                                    _react2.default.createElement('input', {
	                                                        onChange: _this4.checkedRank,
	                                                        className: 'form-check-input',
	                                                        type: 'radio',
	                                                        name: 'rank',
	                                                        checked: item.cId.toString() === _this4.state.checkedRank ? true : false,
	                                                        value: item.cId,
	                                                        disabled: isDisabled,
	                                                        required: 'required'
	                                                    }),
	                                                    _react2.default.createElement(
	                                                        'span',
	                                                        null,
	                                                        item.cName
	                                                    )
	                                                )
	                                            );
	                                        })
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'form-group' },
	                                    _react2.default.createElement(
	                                        'label',
	                                        { 'for': 'name' },
	                                        _react2.default.createElement(
	                                            'em',
	                                            { className: 'text-danger' },
	                                            '*'
	                                        ),
	                                        '\u89D2\u8272\u540D\u79F0'
	                                    ),
	                                    _react2.default.createElement('input', { type: 'text', className: 'form-control', name: 'name', required: 'required' })
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'form-group' },
	                                    _react2.default.createElement(
	                                        'label',
	                                        { 'for': 'name' },
	                                        '\u89D2\u8272\u63CF\u8FF0'
	                                    ),
	                                    _react2.default.createElement('textarea', { name: 'desc', className: 'form-control', rows: '3' })
	                                )
	                            )
	                        )
	                    )
	                )
	            );
	        }
	    }]);

	    return Editor;
	}(_react2.default.Component);

	exports.default = Editor;

/***/ },

/***/ 246:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

	var _react = __webpack_require__(9);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(40);

	var _reactDom2 = _interopRequireDefault(_reactDom);

	var _reactRouter = __webpack_require__(174);

	var _OrgTree = __webpack_require__(241);

	var _OrgTree2 = _interopRequireDefault(_OrgTree);

	var _Button = __webpack_require__(238);

	var _Alerts = __webpack_require__(235);

	var _Alerts2 = _interopRequireDefault(_Alerts);

	var _api = __webpack_require__(231);

	var _DialogTips = __webpack_require__(239);

	var _DialogTips2 = _interopRequireDefault(_DialogTips);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

	var List = function (_React$Component) {
	    _inherits(List, _React$Component);

	    function List(props) {
	        _classCallCheck(this, List);

	        var _this = _possibleConstructorReturn(this, (List.__proto__ || Object.getPrototypeOf(List)).call(this, props));

	        _this.state = {
	            orgList: [],
	            selected: null,

	            roleList: [],
	            checkedRole: null,

	            funcList: [],
	            checkedFunc: {}
	        };

	        _this.renderCommand = _this.renderCommand.bind(_this);
	        _this.renderTable = _this.renderTable.bind(_this);
	        _this.tableLine = _this.tableLine.bind(_this);
	        _this.handleNode = _this.handleNode.bind(_this);
	        _this.selectOrg = _this.selectOrg.bind(_this);
	        _this.checkedRole = _this.checkedRole.bind(_this);
	        _this.checkedFunc = _this.checkedFunc.bind(_this);
	        _this.handleAuth = _this.handleAuth.bind(_this);
	        return _this;
	    }

	    _createClass(List, [{
	        key: 'componentDidMount',
	        value: function componentDidMount() {
	            var _this2 = this;

	            var dialogTips = (0, _DialogTips2.default)({ type: 'loading' });

	            dialogTips.open();

	            (0, _api.orgList)().done(function (org) {
	                var selected = {
	                    id: org.tree[0].cId,
	                    name: org.tree[0].cName
	                };

	                (0, _api.roleList)(selected.id).done(function (role) {
	                    var checkedRole = {
	                        id: role[0].cId,
	                        name: role[0].cName
	                    };

	                    (0, _api.roleDetails)(checkedRole.id).done(function (roleFunc) {
	                        var fids = roleFunc.rootFuncs.map(function (item) {
	                            return item.cId;
	                        });

	                        (0, _api.funcByIds)(fids.join(',')).done(function (func) {
	                            var checked = {};

	                            func.data.map(function (item) {
	                                if (roleFunc.functions.findIndex(function (elem) {
	                                    return elem.cId === item.cId;
	                                }) < 0) {
	                                    checked[item.cId] = false;
	                                } else {
	                                    checked[item.cId] = true;
	                                }
	                            });

	                            dialogTips.close();

	                            _this2.setState({
	                                orgList: org.tree,
	                                selected: selected,

	                                roleList: role,
	                                checkedRole: checkedRole,

	                                funcList: func.tree,
	                                checkedFunc: checked
	                            });
	                        }).fail(function () {
	                            dialogTips.close();
	                        });
	                    }).fail(function () {
	                        dialogTips.close();
	                    });
	                }).fail(function () {
	                    dialogTips.close();
	                });
	            }).fail(function () {
	                dialogTips.close();
	            });
	        }
	    }, {
	        key: 'renderCommand',
	        value: function renderCommand() {
	            var _this3 = this;

	            var isDisabled = $.isEmptyObject(this.state.checkedFunc);
	            var temp = [];

	            if (SCHOOLPAL_CONFIG.auth[this.props.route.path] && SCHOOLPAL_CONFIG.auth[this.props.route.path].command.length) {
	                SCHOOLPAL_CONFIG.auth[this.props.route.path].command.map(function (item, index) {
	                    if (item === 'Auth') {
	                        temp.push(_react2.default.createElement(_Button.AuthButton, {
	                            key: index,
	                            action: _this3.handleAuth,
	                            disabled: isDisabled
	                        }));
	                    };
	                });
	            }

	            return temp;
	        }
	    }, {
	        key: 'selectOrg',
	        value: function selectOrg(org) {
	            var _this4 = this;

	            if (org) {
	                (function () {
	                    _this4.setState({
	                        selected: org,

	                        roleList: [],
	                        checkedRole: null,

	                        funcList: [],
	                        checkedFunc: {}
	                    });

	                    var dialogTips = (0, _DialogTips2.default)({ type: 'loading' });

	                    dialogTips.open();

	                    (0, _api.roleList)(org.id).done(function (role) {
	                        var checkedRole = {
	                            id: role[0].cId,
	                            name: role[0].cName
	                        };

	                        (0, _api.roleDetails)(checkedRole.id).done(function (roleFunc) {
	                            var fids = roleFunc.rootFuncs.map(function (item) {
	                                return item.cId;
	                            });

	                            (0, _api.funcByIds)(fids.join(',')).done(function (func) {
	                                var checked = {};

	                                func.data.map(function (item) {
	                                    if (roleFunc.functions.findIndex(function (elem) {
	                                        return elem.cId === item.cId;
	                                    }) < 0) {
	                                        checked[item.cId] = false;
	                                    } else {
	                                        checked[item.cId] = true;
	                                    }
	                                });

	                                dialogTips.close();

	                                _this4.setState({
	                                    roleList: role,
	                                    checkedRole: checkedRole,

	                                    funcList: func.tree,
	                                    checkedFunc: checked
	                                });
	                            }).fail(function () {
	                                dialogTips.close();
	                            });
	                        }).fail(function () {
	                            dialogTips.close();
	                        });
	                    }).fail(function () {
	                        dialogTips.close();
	                    });
	                })();
	            }
	        }
	    }, {
	        key: 'checkedRole',
	        value: function checkedRole(event) {
	            var _this5 = this;

	            if (event.target.value === this.state.checkedRole.id) {
	                return;
	            }

	            this.setState({
	                checkedRole: {
	                    id: event.target.value,
	                    name: $(event.target).parent().text()
	                }
	            });

	            var dialogTips = (0, _DialogTips2.default)({ type: 'loading' });

	            dialogTips.open();

	            (0, _api.roleDetails)(event.target.value).done(function (roleFunc) {
	                var fids = roleFunc.rootFuncs.map(function (item) {
	                    return item.cId;
	                });

	                (0, _api.funcByIds)(fids.join(',')).done(function (func) {
	                    var checked = {};

	                    func.data.map(function (item) {
	                        if (roleFunc.functions.findIndex(function (elem) {
	                            return elem.cId === item.cId;
	                        }) < 0) {
	                            checked[item.cId] = false;
	                        } else {
	                            checked[item.cId] = true;
	                        }
	                    });

	                    dialogTips.close();

	                    _this5.setState({
	                        funcList: func.tree,
	                        checkedFunc: checked
	                    });
	                }).fail(function () {
	                    dialogTips.close();
	                });
	            }).fail(function () {
	                dialogTips.close();
	            });
	        }
	    }, {
	        key: 'checkedFunc',
	        value: function checkedFunc(event) {
	            var temp = $.extend({}, this.state.checkedFunc);

	            temp[event.target.value] = !temp[event.target.value];

	            if (temp[event.target.value] === false) {
	                if ($('[data-parent=' + event.target.value + ']').length) {
	                    $('[data-parent=' + event.target.value + ']').each(function (i, elem) {
	                        temp[$(elem).val()] = false;
	                    });
	                };
	            }

	            this.setState({
	                checkedFunc: temp
	            });
	        }
	    }, {
	        key: 'handleAuth',
	        value: function handleAuth(event) {
	            if (this.editorDom.checkValidity() === true) {
	                event.preventDefault();
	            };

	            var loading = (0, _DialogTips2.default)({ type: 'loading' });
	            var success = (0, _DialogTips2.default)({ type: 'success', autoClose: true });
	            var fail = (0, _DialogTips2.default)({ type: 'fail', autoClose: true });

	            var funcIdArr = [];

	            for (var key in this.state.checkedFunc) {
	                if (this.state.checkedFunc[key] === true) {
	                    funcIdArr.push(key);
	                }
	            }

	            var param = {
	                id: this.state.checkedRole.id,
	                funcIds: funcIdArr.join(',')
	            };

	            loading.open();

	            (0, _api.roleAuth)(param).done(function () {
	                loading.close();
	                success.open();
	            }).fail(function (data) {
	                loading.close();
	                fail.open();
	            });
	        }
	    }, {
	        key: 'renderTable',
	        value: function renderTable(data) {
	            var _this6 = this;

	            var table = [];

	            if (data.length) {
	                data.map(function (item) {
	                    table.push(_this6.tableLine(item));

	                    if (item.children && item.children.length) {
	                        var children = [];

	                        children.push(_this6.renderTable(item.children));
	                        table.push(children);
	                    }
	                });
	            }

	            return table;
	        }
	    }, {
	        key: 'tableLine',
	        value: function tableLine(data) {
	            var _this7 = this;

	            var level = data.cId.split('-').length;
	            var spacingStyle = { marginLeft: 40 * level + 'px' };
	            var childrenClass = data.children ? '' : 'not-child';
	            var action = [];

	            if (data.action) {
	                action = data.action.map(function (item) {
	                    return _react2.default.createElement(
	                        'div',
	                        { key: item.cId, className: 'form-check form-check-inline' },
	                        _react2.default.createElement(
	                            'label',
	                            { className: 'form-check-label' },
	                            _react2.default.createElement('input', {
	                                onChange: _this7.checkedFunc,
	                                className: 'form-check-input',
	                                type: 'checkbox',
	                                'data-parent': item.cParentId,
	                                value: item.cId,
	                                checked: _this7.state.checkedFunc[item.cId]
	                            }),
	                            _react2.default.createElement(
	                                'span',
	                                null,
	                                item.cNameLong
	                            )
	                        )
	                    );
	                });
	            };

	            return _react2.default.createElement(
	                'tr',
	                { key: data.cId, 'data-id': data.cId, 'data-level': level },
	                _react2.default.createElement(
	                    'td',
	                    null,
	                    _react2.default.createElement(
	                        'p',
	                        { onClick: this.handleNode, className: 'tree-node ' + childrenClass, style: spacingStyle },
	                        data.cNameLong
	                    )
	                ),
	                _react2.default.createElement(
	                    'td',
	                    null,
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'form-check' },
	                        _react2.default.createElement(
	                            'label',
	                            { className: 'form-check-label' },
	                            _react2.default.createElement('input', {
	                                onChange: this.checkedFunc,
	                                className: 'form-check-input',
	                                type: 'checkbox',
	                                value: data.cId,
	                                checked: this.state.checkedFunc[data.cId]
	                            })
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'td',
	                    null,
	                    action
	                )
	            );
	        }
	    }, {
	        key: 'handleNode',
	        value: function handleNode(event) {
	            if ($(event.target).hasClass('not-child')) {
	                return;
	            };

	            var tr = $(event.target).parents('tr');
	            var level = tr.data('level');

	            tr.nextAll('tr').each(function (i, item) {
	                if ($(item).data('level') <= level) {
	                    return false;
	                };

	                if ($(event.target).hasClass('closed')) {
	                    if ($(item).data('level') === level + 1) {
	                        $(item).show();
	                    }
	                } else {
	                    $(item).hide().find('.tree-node').addClass('closed');
	                }
	            });

	            $(event.target).toggleClass('closed');
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            var _this8 = this;

	            return _react2.default.createElement(
	                'div',
	                { className: 'auth' },
	                _react2.default.createElement(
	                    'form',
	                    { ref: function ref(dom) {
	                            _this8.editorDom = dom;
	                        }, onSubmit: this.handleAuth },
	                    _react2.default.createElement(
	                        'h5',
	                        null,
	                        _react2.default.createElement('i', { className: 'fa fa-shield', 'aria-hidden': 'true' }),
	                        '\xA0\u6743\u9650\u7BA1\u7406',
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'btn-group float-right', role: 'group' },
	                            this.renderCommand()
	                        )
	                    ),
	                    _react2.default.createElement(_Alerts2.default, { type: 'danger', title: '\u91CD\u8981\u63D0\u793A !', text: '\u6743\u9650\u4FEE\u6539\u6210\u529F\u540E\uFF0C\u9700\u8981\u91CD\u65B0\u767B\u9646\u624D\u80FD\u751F\u6548\u3002' }),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'main-container' },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'd-flex align-items-stretch flex-nowrap' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: this.state.orgList === null ? 'hide' : 'w300' },
	                                _react2.default.createElement(_OrgTree2.default, { data: this.state.orgList, selected: this.selectOrg, defaults: this.state.selected ? this.state.selected.id : null })
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: this.state.selected === null ? 'hide' : 'w200 pl-3 b-l' },
	                                this.state.roleList.map(function (item) {
	                                    return _react2.default.createElement(
	                                        'div',
	                                        { key: item.cId, className: 'form-check' },
	                                        _react2.default.createElement(
	                                            'label',
	                                            { className: 'form-check-label' },
	                                            _react2.default.createElement('input', {
	                                                onChange: _this8.checkedRole,
	                                                className: 'form-check-input',
	                                                type: 'radio',
	                                                name: 'role',
	                                                value: item.cId,
	                                                checked: _this8.state.checkedRole.id === item.cId ? true : false
	                                            }),
	                                            _react2.default.createElement(
	                                                'span',
	                                                null,
	                                                item.cName
	                                            )
	                                        )
	                                    );
	                                })
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: this.state.checkedRole === null ? 'hide' : 'flex-cell pl-3 b-l' },
	                                _react2.default.createElement(
	                                    'p',
	                                    { className: 'h6 pb-3 b-b' },
	                                    this.state.checkedRole ? this.state.checkedRole.name : ''
	                                ),
	                                _react2.default.createElement(
	                                    'table',
	                                    { className: this.state.funcLoading === true ? 'hide' : 'table table-bordered table-sm' },
	                                    _react2.default.createElement(
	                                        'thead',
	                                        null,
	                                        _react2.default.createElement(
	                                            'tr',
	                                            null,
	                                            _react2.default.createElement(
	                                                'th',
	                                                null,
	                                                '\u7CFB\u7EDF\u83DC\u5355'
	                                            ),
	                                            _react2.default.createElement(
	                                                'th',
	                                                null,
	                                                '\u9009\u53D6'
	                                            ),
	                                            _react2.default.createElement(
	                                                'th',
	                                                null,
	                                                '\u529F\u80FD\u6743\u9650'
	                                            )
	                                        )
	                                    ),
	                                    _react2.default.createElement(
	                                        'tbody',
	                                        null,
	                                        this.renderTable(this.state.funcList)
	                                    )
	                                )
	                            )
	                        )
	                    )
	                )
	            );
	        }
	    }]);

	    return List;
	}(_react2.default.Component);

	exports.default = List;

/***/ },

/***/ 247:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

	var _react = __webpack_require__(9);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(40);

	var _reactDom2 = _interopRequireDefault(_reactDom);

	var _reactRouter = __webpack_require__(174);

	var _OrgTree = __webpack_require__(241);

	var _OrgTree2 = _interopRequireDefault(_OrgTree);

	var _Dialog = __webpack_require__(233);

	var _Dialog2 = _interopRequireDefault(_Dialog);

	var _Button = __webpack_require__(238);

	var _api = __webpack_require__(231);

	var _DialogTips = __webpack_require__(239);

	var _DialogTips2 = _interopRequireDefault(_DialogTips);

	var _errorHandle = __webpack_require__(236);

	var _errorHandle2 = _interopRequireDefault(_errorHandle);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

	var List = function (_React$Component) {
	    _inherits(List, _React$Component);

	    function List(props) {
	        _classCallCheck(this, List);

	        var _this = _possibleConstructorReturn(this, (List.__proto__ || Object.getPrototypeOf(List)).call(this, props));

	        _this.state = {
	            orgList: [],
	            selected: null,

	            userList: [],

	            enable: false,

	            checkedUser: null
	        };

	        _this.selectOrg = _this.selectOrg.bind(_this);
	        _this.checkedUser = _this.checkedUser.bind(_this);
	        _this.renderCommand = _this.renderCommand.bind(_this);
	        _this.handleCreate = _this.handleCreate.bind(_this);
	        _this.handleEditor = _this.handleEditor.bind(_this);
	        _this.confirmDel = _this.confirmDel.bind(_this);
	        _this.handleDel = _this.handleDel.bind(_this);
	        _this.handleToggle = _this.handleToggle.bind(_this);
	        _this.toggleAvailable = _this.toggleAvailable.bind(_this);
	        return _this;
	    }

	    _createClass(List, [{
	        key: 'componentDidMount',
	        value: function componentDidMount() {
	            var _this2 = this;

	            var dialogTips = (0, _DialogTips2.default)({ type: 'loading' });

	            var enable = false;
	            var disable = false;

	            if (SCHOOLPAL_CONFIG.auth[this.props.route.path] && SCHOOLPAL_CONFIG.auth[this.props.route.path].command.length) {
	                SCHOOLPAL_CONFIG.auth[this.props.route.path].command.map(function (item, index) {
	                    if (item === 'Enable') {
	                        enable = true;
	                    }
	                });
	            }

	            this.setState({
	                enable: enable
	            });

	            dialogTips.open();

	            (0, _api.orgList)().done(function (org) {
	                var oid = org.tree[0].cId;
	                var oname = org.tree[0].cName;

	                (0, _api.userList)(oid).done(function (user) {
	                    _this2.setState({
	                        orgList: org.tree,
	                        selected: {
	                            id: oid,
	                            name: oname
	                        },
	                        userList: user
	                    });

	                    dialogTips.close();
	                }).fail(function (data) {
	                    dialogTips.close();
	                    (0, _errorHandle2.default)({ data: data, router: _this2.props.router });
	                });
	            }).fail(function (data) {
	                dialogTips.close();
	                (0, _errorHandle2.default)({ data: data, router: _this2.props.router });
	            });
	        }
	    }, {
	        key: 'renderCommand',
	        value: function renderCommand() {
	            var _this3 = this;

	            var temp = [];

	            if (SCHOOLPAL_CONFIG.auth[this.props.route.path] && SCHOOLPAL_CONFIG.auth[this.props.route.path].command.length) {
	                SCHOOLPAL_CONFIG.auth[this.props.route.path].command.map(function (item, index) {
	                    if (item === 'Add') {
	                        temp.push(_react2.default.createElement(_Button.CreateButton, { key: index, action: _this3.handleCreate, disabled: _this3.state.selected === null ? true : false }));
	                    };

	                    if (item === 'Mod') {
	                        temp.push(_react2.default.createElement(_Button.EditorButton, { key: index, action: _this3.handleEditor, disabled: _this3.state.checkedUser === null ? true : false }));
	                    }

	                    if (item === 'Del') {
	                        temp.push(_react2.default.createElement(_Button.DelButton, { key: index, action: _this3.confirmDel, disabled: _this3.state.checkedUser === null ? true : false }));
	                    }
	                });
	            }

	            return temp;
	        }
	    }, {
	        key: 'selectOrg',
	        value: function selectOrg(org) {
	            var _this4 = this;

	            if (org) {
	                (function () {
	                    var dialogTips = (0, _DialogTips2.default)({ type: 'loading' });

	                    _this4.setState({
	                        selected: org,
	                        userList: [],
	                        checkedUser: null
	                    });

	                    dialogTips.open();

	                    (0, _api.userList)(org.id).done(function (data) {
	                        _this4.setState({
	                            userList: data
	                        });
	                    }).fail(function (data) {
	                        (0, _errorHandle2.default)({ data: data, router: _this4.props.router });
	                    }).always(function () {
	                        dialogTips.close();
	                    });
	                })();
	            }
	        }
	    }, {
	        key: 'checkedUser',
	        value: function checkedUser(event) {
	            if (event.target.checked === true) {
	                this.setState({
	                    checkedUser: {
	                        id: event.target.value,
	                        name: $(event.target).parents('tr').find('[data-name]').text()
	                    }
	                });
	            }
	        }
	    }, {
	        key: 'handleCreate',
	        value: function handleCreate() {
	            var editorPath = SCHOOLPAL_CONFIG.ROOTPATH + 'user/' + this.state.selected.id + '/create';

	            this.props.router.push(editorPath);
	        }
	    }, {
	        key: 'handleEditor',
	        value: function handleEditor() {
	            var editorPath = SCHOOLPAL_CONFIG.ROOTPATH + 'user/' + this.state.selected.id + '/' + this.state.checkedUser.id;

	            this.props.router.push(editorPath);
	        }
	    }, {
	        key: 'confirmDel',
	        value: function confirmDel() {
	            var div = document.createElement('div');

	            _reactDom2.default.render(_react2.default.createElement(_Dialog2.default, {
	                container: div,
	                text: '是否确认删除 ' + this.state.checkedUser.name + ' ？',
	                action: this.handleDel
	            }), document.body.appendChild(div));
	        }
	    }, {
	        key: 'handleDel',
	        value: function handleDel() {
	            var _this5 = this;

	            var loading = (0, _DialogTips2.default)({ type: 'loading' });
	            var success = (0, _DialogTips2.default)({ type: 'success', autoClose: true });
	            var fail = (0, _DialogTips2.default)({ type: 'fail', autoClose: true });

	            loading.open();

	            (0, _api.userDel)(this.state.checkedUser.id).done(function () {
	                var tempList = _this5.state.userList.filter(function (item) {
	                    return item.cId !== _this5.state.checkedUser.id;
	                });

	                loading.close();
	                success.open();

	                _this5.setState({
	                    userList: tempList,
	                    checkedUser: null
	                });
	            }).fail(function (data) {
	                loading.close();
	                fail.open();
	            });
	        }
	    }, {
	        key: 'handleToggle',
	        value: function handleToggle(param) {
	            var _this6 = this;

	            var loading = (0, _DialogTips2.default)({ type: 'loading' });
	            var success = (0, _DialogTips2.default)({ type: 'success', autoClose: true });
	            var fail = (0, _DialogTips2.default)({ type: 'fail', autoClose: true });
	            var nextAvailable = !param.available;

	            loading.open();

	            this.toggleAvailable(param.uid, nextAvailable);

	            (0, _api.userEnable)(param.uid, !param.available).done(function () {
	                loading.close();
	                success.open();
	            }).fail(function () {
	                _this6.toggleAvailable(param.uid, param.available);
	                loading.close();
	                fail.open();
	            });
	        }
	    }, {
	        key: 'toggleAvailable',
	        value: function toggleAvailable(uid, nextAvailable) {
	            var tempList = void 0;

	            tempList = this.state.userList.filter(function (item) {
	                if (item.cId === uid) {
	                    item.cAvailable = nextAvailable;
	                }

	                return item;
	            });

	            this.setState({
	                userList: tempList
	            });
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            var _this7 = this;

	            return _react2.default.createElement(
	                'div',
	                { className: 'user' },
	                _react2.default.createElement(
	                    'h5',
	                    null,
	                    _react2.default.createElement('i', { className: 'fa fa-user', 'aria-hidden': 'true' }),
	                    '\xA0\u7528\u6237\u7BA1\u7406',
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'btn-group float-right mr-4', role: 'group' },
	                        this.renderCommand()
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'main-container' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'd-flex align-items-stretch flex-nowrap' },
	                        _react2.default.createElement(
	                            'div',
	                            { className: this.state.orgList === null ? 'hide' : 'w300' },
	                            _react2.default.createElement(_OrgTree2.default, { data: this.state.orgList, selected: this.selectOrg, defaults: this.state.selected ? this.state.selected.id : null })
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: this.state.selected === null ? 'hide' : 'flex-cell pl-3 b-l' },
	                            _react2.default.createElement(
	                                'p',
	                                { className: this.state.selected === null ? 'hide' : 'h6 pb-3 b-b' },
	                                this.state.selected ? this.state.selected.name : ''
	                            ),
	                            _react2.default.createElement(
	                                'table',
	                                { className: this.state.userList === null ? 'hide' : 'table table-bordered table-sm' },
	                                _react2.default.createElement(
	                                    'thead',
	                                    null,
	                                    _react2.default.createElement(
	                                        'tr',
	                                        null,
	                                        _react2.default.createElement(
	                                            'th',
	                                            null,
	                                            '\xA0'
	                                        ),
	                                        _react2.default.createElement(
	                                            'th',
	                                            null,
	                                            '\u72B6\u6001'
	                                        ),
	                                        _react2.default.createElement(
	                                            'th',
	                                            null,
	                                            '\u7528\u6237\u540D'
	                                        ),
	                                        _react2.default.createElement(
	                                            'th',
	                                            null,
	                                            '\u59D3\u540D'
	                                        ),
	                                        _react2.default.createElement(
	                                            'th',
	                                            null,
	                                            '\u6635\u79F0'
	                                        ),
	                                        _react2.default.createElement(
	                                            'th',
	                                            null,
	                                            '\u7535\u8BDD\u53F7\u7801'
	                                        ),
	                                        _react2.default.createElement(
	                                            'th',
	                                            null,
	                                            '\u7535\u5B50\u90AE\u4EF6'
	                                        ),
	                                        _react2.default.createElement(
	                                            'th',
	                                            null,
	                                            'IM(QQ)'
	                                        ),
	                                        _react2.default.createElement(
	                                            'th',
	                                            null,
	                                            '\u7528\u6237\u89D2\u8272'
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tbody',
	                                    null,
	                                    this.state.userList.map(function (item) {
	                                        return _react2.default.createElement(
	                                            'tr',
	                                            { key: item.cId, 'data-uid': item.cId },
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'div',
	                                                    { className: 'form-check form-check' },
	                                                    _react2.default.createElement(
	                                                        'label',
	                                                        { className: 'form-check-label' },
	                                                        _react2.default.createElement('input', {
	                                                            className: 'form-check-input',
	                                                            type: 'radio',
	                                                            name: 'user',
	                                                            value: item.cId,
	                                                            onChange: _this7.checkedUser,
	                                                            checked: _this7.state.checkedUser && _this7.state.checkedUser.id === item.cId ? true : false
	                                                        })
	                                                    )
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                _react2.default.createElement(_Button.ToggleButton, {
	                                                    uid: item.cId,
	                                                    enable: _this7.state.enable,
	                                                    available: item.cAvailable,
	                                                    action: _this7.handleToggle
	                                                })
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                item.cLoginname
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { 'data-name': true },
	                                                item.cRealname
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                item.cNickname
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                item.cPhone
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                item.cEmail
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                item.cQq
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                null,
	                                                item.roles.map(function (role) {
	                                                    return role.cName;
	                                                }).join(',')
	                                            )
	                                        );
	                                    })
	                                )
	                            )
	                        )
	                    )
	                )
	            );
	        }
	    }]);

	    return List;
	}(_react2.default.Component);

	exports.default = List;

/***/ },

/***/ 248:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

	var _react = __webpack_require__(9);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(40);

	var _reactDom2 = _interopRequireDefault(_reactDom);

	var _reactRouter = __webpack_require__(174);

	var _Button = __webpack_require__(238);

	var _Alerts = __webpack_require__(235);

	var _Alerts2 = _interopRequireDefault(_Alerts);

	var _subTitle = __webpack_require__(242);

	var _subTitle2 = _interopRequireDefault(_subTitle);

	var _api = __webpack_require__(231);

	var _mixedMD = __webpack_require__(249);

	var _mixedMD2 = _interopRequireDefault(_mixedMD);

	var _DialogTips = __webpack_require__(239);

	var _DialogTips2 = _interopRequireDefault(_DialogTips);

	var _errorHandle = __webpack_require__(236);

	var _errorHandle2 = _interopRequireDefault(_errorHandle);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

	var RANK_ADMIN_ID = '4';

	var Editor = function (_React$Component) {
	    _inherits(Editor, _React$Component);

	    function Editor(props) {
	        _classCallCheck(this, Editor);

	        var _this = _possibleConstructorReturn(this, (Editor.__proto__ || Object.getPrototypeOf(Editor)).call(this, props));

	        _this.state = {
	            org: null,
	            roleList: [],
	            checkedRole: []
	        };

	        _this.checkedRole = _this.checkedRole.bind(_this);
	        _this.editorSubmit = _this.editorSubmit.bind(_this);
	        return _this;
	    }

	    _createClass(Editor, [{
	        key: 'componentDidMount',
	        value: function componentDidMount() {
	            var _this2 = this;

	            var dialogTips = (0, _DialogTips2.default)({ type: 'loading' });

	            dialogTips.open();

	            $.when((0, _api.orgDetails)(this.props.params.oid), (0, _api.roleList)(this.props.params.oid)).done(function (org, role) {
	                _this2.setState({
	                    org: {
	                        id: org.cId,
	                        name: org.cName
	                    },
	                    roleList: role
	                });

	                if (_this2.props.params.uid === 'create') {
	                    dialogTips.close();
	                } else {
	                    (0, _api.userDetails)(_this2.props.params.uid).done(function (user) {
	                        var checkedRole = [];

	                        user.roles.map(function (item) {
	                            checkedRole.push(item.cId);
	                        });

	                        _this2.setState({
	                            checkedRole: checkedRole
	                        });

	                        $(_this2.editorDom).find('[name=loginName]').val(user.cLoginname).end().find('[name=realName]').val(user.cRealname).end().find('[name=nickName]').val(user.cNickname).end().find('[name=phone]').val(user.cPhone).end().find('[name=email]').val(user.cEmail).end().find('[name=im]').val(user.cQq);
	                    }).fail(function (data) {
	                        (0, _errorHandle2.default)({ data: data, router: _this2.props.router });
	                    }).always(function () {
	                        dialogTips.close();
	                    });
	                }
	            }).fail(function () {
	                dialogTips.close();
	                (0, _errorHandle2.default)({ data: data, router: _this2.props.router });
	            });
	        }
	    }, {
	        key: 'checkedRole',
	        value: function checkedRole(event) {
	            var _this3 = this;

	            var tempRole = [];

	            if (event.target.checked === true) {
	                (function () {
	                    var isAdmin = $(event.target).data('rank').toString() === RANK_ADMIN_ID;
	                    var adminId = $('[data-rank=' + RANK_ADMIN_ID + ']').val();
	                    console.log($(event.target).data('rank').toString() + '/' + RANK_ADMIN_ID);
	                    console.log(isAdmin);
	                    tempRole.push(event.target.value);

	                    if (isAdmin === false) {
	                        tempRole = tempRole.concat(_this3.state.checkedRole.filter(function (id) {
	                            return id !== adminId;
	                        }));
	                    }
	                })();
	            } else {
	                tempRole = this.state.checkedRole.filter(function (id) {
	                    return id !== event.target.value;
	                });
	            }

	            this.setState({
	                checkedRole: tempRole
	            });

	            if (tempRole.length) {
	                $(this.editorDom).find('input[type=checkbox]').removeAttr('required');
	            } else {
	                $(this.editorDom).find('input[type=checkbox]').attr('required', 'required');
	            }
	        }
	    }, {
	        key: 'editorSubmit',
	        value: function editorSubmit(event) {
	            var _this4 = this;

	            if (this.editorDom.checkValidity() === true) {
	                event.preventDefault();
	            };

	            var successPath = SCHOOLPAL_CONFIG.ROOTPATH + 'user';
	            var loading = (0, _DialogTips2.default)({ type: 'loading' });
	            var success = (0, _DialogTips2.default)({ type: 'success' });
	            var fail = (0, _DialogTips2.default)({ type: 'fail', autoClose: true });

	            loading.open();

	            (0, _api.checkName)($(this.editorDom).find('[name=loginName]').val()).done(function (data) {
	                if (data === true) {
	                    loading.close();
	                    $(_this4.editorDom).find('[name=loginName]')[0].setCustomValidity('登陆名已存在 ！');
	                    $(_this4.editorDom).find('[type=submit]').trigger('click');

	                    return;
	                }

	                var param = {};
	                var temp = $(_this4.editorDom).serializeArray();

	                if (_this4.props.params.uid !== 'create') {
	                    param.userId = _this4.props.params.uid;
	                }

	                param.orgId = _this4.state.org.id;
	                param.roles = _this4.state.checkedRole.join(',');

	                temp.map(function (item) {
	                    if (item.name === 'loginPass') {
	                        if (_this4.props.params.uid === 'create' || item.value) {
	                            param[item.name] = (0, _mixedMD2.default)((0, _mixedMD2.default)(item.value));
	                        }
	                    } else {
	                        param[item.name] = item.value;
	                    }
	                });

	                delete temp['org'];

	                if (_this4.props.params.uid === 'create') {
	                    (0, _api.userAdd)(param).done(function () {
	                        loading.close();
	                        success.open();
	                        setTimeout(function () {
	                            success.close();
	                            _this4.props.router.push(successPath);
	                        }, 2000);
	                    }).fail(function (data) {
	                        loading.close();
	                        fail.open();
	                    });
	                } else {
	                    (0, _api.userMod)(param).done(function () {
	                        loading.close();
	                        success.open();
	                        setTimeout(function () {
	                            success.close();
	                            _this4.props.router.push(successPath);
	                        }, 2000);
	                    }).fail(function (data) {
	                        loading.close();
	                        fail.open();
	                    });
	                }
	            }).fail(function (data) {
	                (0, _errorHandle2.default)({ data: data, router: _this4.props.router });
	            });
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            var _this5 = this;

	            return _react2.default.createElement(
	                'div',
	                { className: 'user' },
	                _react2.default.createElement(
	                    'form',
	                    { ref: function ref(dom) {
	                            _this5.editorDom = dom;
	                        }, onSubmit: this.editorSubmit },
	                    _react2.default.createElement(
	                        'h5',
	                        null,
	                        _react2.default.createElement('i', { className: 'fa fa-user', 'aria-hidden': 'true' }),
	                        '\xA0\u7528\u6237\u7BA1\u7406\xA0\xA0|\xA0\xA0',
	                        _react2.default.createElement(
	                            'p',
	                            { className: 'd-inline text-muted' },
	                            (0, _subTitle2.default)(this.props.router.params.uid, '用户')
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'btn-group float-right mr-4', role: 'group' },
	                            _react2.default.createElement(_Button.BackButton, { router: this.props.router }),
	                            _react2.default.createElement(_Button.SaveButton, { text: '\u4FDD\u5B58' })
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'main-container' },
	                        _react2.default.createElement(
	                            'div',
	                            { className: this.state.roleList.length ? 'd-flex align-items-stretch flex-nowrap' : 'hide' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'w500 pr-3' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'form-group' },
	                                    _react2.default.createElement(
	                                        'label',
	                                        { 'for': 'name' },
	                                        _react2.default.createElement(
	                                            'em',
	                                            { className: 'text-danger' },
	                                            '*'
	                                        ),
	                                        '\u6240\u5C5E\u7EC4\u7EC7'
	                                    ),
	                                    _react2.default.createElement('input', { type: 'text', className: 'form-control', name: 'org', value: this.state.org ? this.state.org.name : '', readOnly: 'readOnly' })
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'form-group' },
	                                    _react2.default.createElement(
	                                        'label',
	                                        { 'for': 'name' },
	                                        _react2.default.createElement(
	                                            'em',
	                                            { className: 'text-danger' },
	                                            '*'
	                                        ),
	                                        '\u7528\u6237\u540D'
	                                    ),
	                                    _react2.default.createElement('input', { type: 'text', className: 'form-control', name: 'loginName', onChange: function onChange(event) {
	                                            event.target.setCustomValidity('');
	                                        }, readOnly: this.props.params.uid === 'create' ? false : true, required: 'required' })
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'form-group' },
	                                    _react2.default.createElement(
	                                        'label',
	                                        { 'for': 'name' },
	                                        _react2.default.createElement(
	                                            'em',
	                                            { className: 'text-danger' },
	                                            '*'
	                                        ),
	                                        '\u767B\u9646\u5BC6\u7801'
	                                    ),
	                                    _react2.default.createElement('input', { type: 'password', className: 'form-control', name: 'loginPass', required: this.props.params.uid === 'create' ? true : false })
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'form-group' },
	                                    _react2.default.createElement(
	                                        'label',
	                                        { 'for': 'name' },
	                                        _react2.default.createElement(
	                                            'em',
	                                            { className: 'text-danger' },
	                                            '*'
	                                        ),
	                                        '\u59D3\u540D'
	                                    ),
	                                    _react2.default.createElement('input', { type: 'text', className: 'form-control', name: 'realName', required: 'required' })
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'form-group' },
	                                    _react2.default.createElement(
	                                        'label',
	                                        { 'for': 'name' },
	                                        _react2.default.createElement(
	                                            'em',
	                                            { className: 'text-danger' },
	                                            '*'
	                                        ),
	                                        '\u7535\u8BDD\u53F7\u7801'
	                                    ),
	                                    _react2.default.createElement('input', { type: 'text', className: 'form-control', name: 'phone', pattern: '^1\\d{10}$', required: 'required' })
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'form-group' },
	                                    _react2.default.createElement(
	                                        'label',
	                                        { 'for': 'name' },
	                                        _react2.default.createElement(
	                                            'em',
	                                            { className: 'text-danger' },
	                                            '*'
	                                        ),
	                                        '\u7535\u5B50\u90AE\u7BB1'
	                                    ),
	                                    _react2.default.createElement('input', { type: 'text', className: 'form-control', name: 'email', required: 'required' })
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'form-group' },
	                                    _react2.default.createElement(
	                                        'label',
	                                        { 'for': 'name' },
	                                        '\u6635\u79F0'
	                                    ),
	                                    _react2.default.createElement('input', { type: 'text', className: 'form-control', name: 'nickName' })
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'form-group' },
	                                    _react2.default.createElement(
	                                        'label',
	                                        { 'for': 'name' },
	                                        'IM(QQ...)'
	                                    ),
	                                    _react2.default.createElement('input', { type: 'text', className: 'form-control', name: 'im' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'flex-cell pl-3 b-l' },
	                                _react2.default.createElement(
	                                    'p',
	                                    { className: 'ht pb-3 b-b' },
	                                    '\u7528\u6237\u89D2\u8272'
	                                ),
	                                this.state.roleList.map(function (item) {
	                                    return _react2.default.createElement(
	                                        'div',
	                                        { key: item.cId, className: 'form-check' },
	                                        _react2.default.createElement(
	                                            'label',
	                                            { className: 'form-check-label' },
	                                            _react2.default.createElement('input', {
	                                                onChange: _this5.checkedRole,
	                                                className: 'form-check-input',
	                                                type: 'checkbox',
	                                                value: item.cId,
	                                                'data-rank': item.cRankId,
	                                                checked: _this5.state.checkedRole.findIndex(function (id) {
	                                                    return id === item.cId;
	                                                }) < 0 ? false : true,
	                                                required: 'required'
	                                            }),
	                                            _react2.default.createElement(
	                                                'span',
	                                                null,
	                                                item.cName
	                                            )
	                                        )
	                                    );
	                                })
	                            )
	                        )
	                    )
	                )
	            );
	        }
	    }]);

	    return Editor;
	}(_react2.default.Component);

	exports.default = Editor;

/***/ },

/***/ 249:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = mixedMD5;

	var _md = __webpack_require__(250);

	var _md2 = _interopRequireDefault(_md);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	function mixedMD5(string) {
	    return (0, _md2.default)(string).toString();
	}

/***/ },

/***/ 250:
/***/ function(module, exports, __webpack_require__) {

	;(function (root, factory) {
		if (true) {
			// CommonJS
			module.exports = exports = factory(__webpack_require__(251));
		}
		else if (typeof define === "function" && define.amd) {
			// AMD
			define(["./core"], factory);
		}
		else {
			// Global (browser)
			factory(root.CryptoJS);
		}
	}(this, function (CryptoJS) {

		(function (Math) {
		    // Shortcuts
		    var C = CryptoJS;
		    var C_lib = C.lib;
		    var WordArray = C_lib.WordArray;
		    var Hasher = C_lib.Hasher;
		    var C_algo = C.algo;

		    // Constants table
		    var T = [];

		    // Compute constants
		    (function () {
		        for (var i = 0; i < 64; i++) {
		            T[i] = (Math.abs(Math.sin(i + 1)) * 0x100000000) | 0;
		        }
		    }());

		    /**
		     * MD5 hash algorithm.
		     */
		    var MD5 = C_algo.MD5 = Hasher.extend({
		        _doReset: function () {
		            this._hash = new WordArray.init([
		                0x67452301, 0xefcdab89,
		                0x98badcfe, 0x10325476
		            ]);
		        },

		        _doProcessBlock: function (M, offset) {
		            // Swap endian
		            for (var i = 0; i < 16; i++) {
		                // Shortcuts
		                var offset_i = offset + i;
		                var M_offset_i = M[offset_i];

		                M[offset_i] = (
		                    (((M_offset_i << 8)  | (M_offset_i >>> 24)) & 0x00ff00ff) |
		                    (((M_offset_i << 24) | (M_offset_i >>> 8))  & 0xff00ff00)
		                );
		            }

		            // Shortcuts
		            var H = this._hash.words;

		            var M_offset_0  = M[offset + 0];
		            var M_offset_1  = M[offset + 1];
		            var M_offset_2  = M[offset + 2];
		            var M_offset_3  = M[offset + 3];
		            var M_offset_4  = M[offset + 4];
		            var M_offset_5  = M[offset + 5];
		            var M_offset_6  = M[offset + 6];
		            var M_offset_7  = M[offset + 7];
		            var M_offset_8  = M[offset + 8];
		            var M_offset_9  = M[offset + 9];
		            var M_offset_10 = M[offset + 10];
		            var M_offset_11 = M[offset + 11];
		            var M_offset_12 = M[offset + 12];
		            var M_offset_13 = M[offset + 13];
		            var M_offset_14 = M[offset + 14];
		            var M_offset_15 = M[offset + 15];

		            // Working varialbes
		            var a = H[0];
		            var b = H[1];
		            var c = H[2];
		            var d = H[3];

		            // Computation
		            a = FF(a, b, c, d, M_offset_0,  7,  T[0]);
		            d = FF(d, a, b, c, M_offset_1,  12, T[1]);
		            c = FF(c, d, a, b, M_offset_2,  17, T[2]);
		            b = FF(b, c, d, a, M_offset_3,  22, T[3]);
		            a = FF(a, b, c, d, M_offset_4,  7,  T[4]);
		            d = FF(d, a, b, c, M_offset_5,  12, T[5]);
		            c = FF(c, d, a, b, M_offset_6,  17, T[6]);
		            b = FF(b, c, d, a, M_offset_7,  22, T[7]);
		            a = FF(a, b, c, d, M_offset_8,  7,  T[8]);
		            d = FF(d, a, b, c, M_offset_9,  12, T[9]);
		            c = FF(c, d, a, b, M_offset_10, 17, T[10]);
		            b = FF(b, c, d, a, M_offset_11, 22, T[11]);
		            a = FF(a, b, c, d, M_offset_12, 7,  T[12]);
		            d = FF(d, a, b, c, M_offset_13, 12, T[13]);
		            c = FF(c, d, a, b, M_offset_14, 17, T[14]);
		            b = FF(b, c, d, a, M_offset_15, 22, T[15]);

		            a = GG(a, b, c, d, M_offset_1,  5,  T[16]);
		            d = GG(d, a, b, c, M_offset_6,  9,  T[17]);
		            c = GG(c, d, a, b, M_offset_11, 14, T[18]);
		            b = GG(b, c, d, a, M_offset_0,  20, T[19]);
		            a = GG(a, b, c, d, M_offset_5,  5,  T[20]);
		            d = GG(d, a, b, c, M_offset_10, 9,  T[21]);
		            c = GG(c, d, a, b, M_offset_15, 14, T[22]);
		            b = GG(b, c, d, a, M_offset_4,  20, T[23]);
		            a = GG(a, b, c, d, M_offset_9,  5,  T[24]);
		            d = GG(d, a, b, c, M_offset_14, 9,  T[25]);
		            c = GG(c, d, a, b, M_offset_3,  14, T[26]);
		            b = GG(b, c, d, a, M_offset_8,  20, T[27]);
		            a = GG(a, b, c, d, M_offset_13, 5,  T[28]);
		            d = GG(d, a, b, c, M_offset_2,  9,  T[29]);
		            c = GG(c, d, a, b, M_offset_7,  14, T[30]);
		            b = GG(b, c, d, a, M_offset_12, 20, T[31]);

		            a = HH(a, b, c, d, M_offset_5,  4,  T[32]);
		            d = HH(d, a, b, c, M_offset_8,  11, T[33]);
		            c = HH(c, d, a, b, M_offset_11, 16, T[34]);
		            b = HH(b, c, d, a, M_offset_14, 23, T[35]);
		            a = HH(a, b, c, d, M_offset_1,  4,  T[36]);
		            d = HH(d, a, b, c, M_offset_4,  11, T[37]);
		            c = HH(c, d, a, b, M_offset_7,  16, T[38]);
		            b = HH(b, c, d, a, M_offset_10, 23, T[39]);
		            a = HH(a, b, c, d, M_offset_13, 4,  T[40]);
		            d = HH(d, a, b, c, M_offset_0,  11, T[41]);
		            c = HH(c, d, a, b, M_offset_3,  16, T[42]);
		            b = HH(b, c, d, a, M_offset_6,  23, T[43]);
		            a = HH(a, b, c, d, M_offset_9,  4,  T[44]);
		            d = HH(d, a, b, c, M_offset_12, 11, T[45]);
		            c = HH(c, d, a, b, M_offset_15, 16, T[46]);
		            b = HH(b, c, d, a, M_offset_2,  23, T[47]);

		            a = II(a, b, c, d, M_offset_0,  6,  T[48]);
		            d = II(d, a, b, c, M_offset_7,  10, T[49]);
		            c = II(c, d, a, b, M_offset_14, 15, T[50]);
		            b = II(b, c, d, a, M_offset_5,  21, T[51]);
		            a = II(a, b, c, d, M_offset_12, 6,  T[52]);
		            d = II(d, a, b, c, M_offset_3,  10, T[53]);
		            c = II(c, d, a, b, M_offset_10, 15, T[54]);
		            b = II(b, c, d, a, M_offset_1,  21, T[55]);
		            a = II(a, b, c, d, M_offset_8,  6,  T[56]);
		            d = II(d, a, b, c, M_offset_15, 10, T[57]);
		            c = II(c, d, a, b, M_offset_6,  15, T[58]);
		            b = II(b, c, d, a, M_offset_13, 21, T[59]);
		            a = II(a, b, c, d, M_offset_4,  6,  T[60]);
		            d = II(d, a, b, c, M_offset_11, 10, T[61]);
		            c = II(c, d, a, b, M_offset_2,  15, T[62]);
		            b = II(b, c, d, a, M_offset_9,  21, T[63]);

		            // Intermediate hash value
		            H[0] = (H[0] + a) | 0;
		            H[1] = (H[1] + b) | 0;
		            H[2] = (H[2] + c) | 0;
		            H[3] = (H[3] + d) | 0;
		        },

		        _doFinalize: function () {
		            // Shortcuts
		            var data = this._data;
		            var dataWords = data.words;

		            var nBitsTotal = this._nDataBytes * 8;
		            var nBitsLeft = data.sigBytes * 8;

		            // Add padding
		            dataWords[nBitsLeft >>> 5] |= 0x80 << (24 - nBitsLeft % 32);

		            var nBitsTotalH = Math.floor(nBitsTotal / 0x100000000);
		            var nBitsTotalL = nBitsTotal;
		            dataWords[(((nBitsLeft + 64) >>> 9) << 4) + 15] = (
		                (((nBitsTotalH << 8)  | (nBitsTotalH >>> 24)) & 0x00ff00ff) |
		                (((nBitsTotalH << 24) | (nBitsTotalH >>> 8))  & 0xff00ff00)
		            );
		            dataWords[(((nBitsLeft + 64) >>> 9) << 4) + 14] = (
		                (((nBitsTotalL << 8)  | (nBitsTotalL >>> 24)) & 0x00ff00ff) |
		                (((nBitsTotalL << 24) | (nBitsTotalL >>> 8))  & 0xff00ff00)
		            );

		            data.sigBytes = (dataWords.length + 1) * 4;

		            // Hash final blocks
		            this._process();

		            // Shortcuts
		            var hash = this._hash;
		            var H = hash.words;

		            // Swap endian
		            for (var i = 0; i < 4; i++) {
		                // Shortcut
		                var H_i = H[i];

		                H[i] = (((H_i << 8)  | (H_i >>> 24)) & 0x00ff00ff) |
		                       (((H_i << 24) | (H_i >>> 8))  & 0xff00ff00);
		            }

		            // Return final computed hash
		            return hash;
		        },

		        clone: function () {
		            var clone = Hasher.clone.call(this);
		            clone._hash = this._hash.clone();

		            return clone;
		        }
		    });

		    function FF(a, b, c, d, x, s, t) {
		        var n = a + ((b & c) | (~b & d)) + x + t;
		        return ((n << s) | (n >>> (32 - s))) + b;
		    }

		    function GG(a, b, c, d, x, s, t) {
		        var n = a + ((b & d) | (c & ~d)) + x + t;
		        return ((n << s) | (n >>> (32 - s))) + b;
		    }

		    function HH(a, b, c, d, x, s, t) {
		        var n = a + (b ^ c ^ d) + x + t;
		        return ((n << s) | (n >>> (32 - s))) + b;
		    }

		    function II(a, b, c, d, x, s, t) {
		        var n = a + (c ^ (b | ~d)) + x + t;
		        return ((n << s) | (n >>> (32 - s))) + b;
		    }

		    /**
		     * Shortcut function to the hasher's object interface.
		     *
		     * @param {WordArray|string} message The message to hash.
		     *
		     * @return {WordArray} The hash.
		     *
		     * @static
		     *
		     * @example
		     *
		     *     var hash = CryptoJS.MD5('message');
		     *     var hash = CryptoJS.MD5(wordArray);
		     */
		    C.MD5 = Hasher._createHelper(MD5);

		    /**
		     * Shortcut function to the HMAC's object interface.
		     *
		     * @param {WordArray|string} message The message to hash.
		     * @param {WordArray|string} key The secret key.
		     *
		     * @return {WordArray} The HMAC.
		     *
		     * @static
		     *
		     * @example
		     *
		     *     var hmac = CryptoJS.HmacMD5(message, key);
		     */
		    C.HmacMD5 = Hasher._createHmacHelper(MD5);
		}(Math));


		return CryptoJS.MD5;

	}));

/***/ },

/***/ 251:
/***/ function(module, exports, __webpack_require__) {

	;(function (root, factory) {
		if (true) {
			// CommonJS
			module.exports = exports = factory();
		}
		else if (typeof define === "function" && define.amd) {
			// AMD
			define([], factory);
		}
		else {
			// Global (browser)
			root.CryptoJS = factory();
		}
	}(this, function () {

		/**
		 * CryptoJS core components.
		 */
		var CryptoJS = CryptoJS || (function (Math, undefined) {
		    /*
		     * Local polyfil of Object.create
		     */
		    var create = Object.create || (function () {
		        function F() {};

		        return function (obj) {
		            var subtype;

		            F.prototype = obj;

		            subtype = new F();

		            F.prototype = null;

		            return subtype;
		        };
		    }())

		    /**
		     * CryptoJS namespace.
		     */
		    var C = {};

		    /**
		     * Library namespace.
		     */
		    var C_lib = C.lib = {};

		    /**
		     * Base object for prototypal inheritance.
		     */
		    var Base = C_lib.Base = (function () {


		        return {
		            /**
		             * Creates a new object that inherits from this object.
		             *
		             * @param {Object} overrides Properties to copy into the new object.
		             *
		             * @return {Object} The new object.
		             *
		             * @static
		             *
		             * @example
		             *
		             *     var MyType = CryptoJS.lib.Base.extend({
		             *         field: 'value',
		             *
		             *         method: function () {
		             *         }
		             *     });
		             */
		            extend: function (overrides) {
		                // Spawn
		                var subtype = create(this);

		                // Augment
		                if (overrides) {
		                    subtype.mixIn(overrides);
		                }

		                // Create default initializer
		                if (!subtype.hasOwnProperty('init') || this.init === subtype.init) {
		                    subtype.init = function () {
		                        subtype.$super.init.apply(this, arguments);
		                    };
		                }

		                // Initializer's prototype is the subtype object
		                subtype.init.prototype = subtype;

		                // Reference supertype
		                subtype.$super = this;

		                return subtype;
		            },

		            /**
		             * Extends this object and runs the init method.
		             * Arguments to create() will be passed to init().
		             *
		             * @return {Object} The new object.
		             *
		             * @static
		             *
		             * @example
		             *
		             *     var instance = MyType.create();
		             */
		            create: function () {
		                var instance = this.extend();
		                instance.init.apply(instance, arguments);

		                return instance;
		            },

		            /**
		             * Initializes a newly created object.
		             * Override this method to add some logic when your objects are created.
		             *
		             * @example
		             *
		             *     var MyType = CryptoJS.lib.Base.extend({
		             *         init: function () {
		             *             // ...
		             *         }
		             *     });
		             */
		            init: function () {
		            },

		            /**
		             * Copies properties into this object.
		             *
		             * @param {Object} properties The properties to mix in.
		             *
		             * @example
		             *
		             *     MyType.mixIn({
		             *         field: 'value'
		             *     });
		             */
		            mixIn: function (properties) {
		                for (var propertyName in properties) {
		                    if (properties.hasOwnProperty(propertyName)) {
		                        this[propertyName] = properties[propertyName];
		                    }
		                }

		                // IE won't copy toString using the loop above
		                if (properties.hasOwnProperty('toString')) {
		                    this.toString = properties.toString;
		                }
		            },

		            /**
		             * Creates a copy of this object.
		             *
		             * @return {Object} The clone.
		             *
		             * @example
		             *
		             *     var clone = instance.clone();
		             */
		            clone: function () {
		                return this.init.prototype.extend(this);
		            }
		        };
		    }());

		    /**
		     * An array of 32-bit words.
		     *
		     * @property {Array} words The array of 32-bit words.
		     * @property {number} sigBytes The number of significant bytes in this word array.
		     */
		    var WordArray = C_lib.WordArray = Base.extend({
		        /**
		         * Initializes a newly created word array.
		         *
		         * @param {Array} words (Optional) An array of 32-bit words.
		         * @param {number} sigBytes (Optional) The number of significant bytes in the words.
		         *
		         * @example
		         *
		         *     var wordArray = CryptoJS.lib.WordArray.create();
		         *     var wordArray = CryptoJS.lib.WordArray.create([0x00010203, 0x04050607]);
		         *     var wordArray = CryptoJS.lib.WordArray.create([0x00010203, 0x04050607], 6);
		         */
		        init: function (words, sigBytes) {
		            words = this.words = words || [];

		            if (sigBytes != undefined) {
		                this.sigBytes = sigBytes;
		            } else {
		                this.sigBytes = words.length * 4;
		            }
		        },

		        /**
		         * Converts this word array to a string.
		         *
		         * @param {Encoder} encoder (Optional) The encoding strategy to use. Default: CryptoJS.enc.Hex
		         *
		         * @return {string} The stringified word array.
		         *
		         * @example
		         *
		         *     var string = wordArray + '';
		         *     var string = wordArray.toString();
		         *     var string = wordArray.toString(CryptoJS.enc.Utf8);
		         */
		        toString: function (encoder) {
		            return (encoder || Hex).stringify(this);
		        },

		        /**
		         * Concatenates a word array to this word array.
		         *
		         * @param {WordArray} wordArray The word array to append.
		         *
		         * @return {WordArray} This word array.
		         *
		         * @example
		         *
		         *     wordArray1.concat(wordArray2);
		         */
		        concat: function (wordArray) {
		            // Shortcuts
		            var thisWords = this.words;
		            var thatWords = wordArray.words;
		            var thisSigBytes = this.sigBytes;
		            var thatSigBytes = wordArray.sigBytes;

		            // Clamp excess bits
		            this.clamp();

		            // Concat
		            if (thisSigBytes % 4) {
		                // Copy one byte at a time
		                for (var i = 0; i < thatSigBytes; i++) {
		                    var thatByte = (thatWords[i >>> 2] >>> (24 - (i % 4) * 8)) & 0xff;
		                    thisWords[(thisSigBytes + i) >>> 2] |= thatByte << (24 - ((thisSigBytes + i) % 4) * 8);
		                }
		            } else {
		                // Copy one word at a time
		                for (var i = 0; i < thatSigBytes; i += 4) {
		                    thisWords[(thisSigBytes + i) >>> 2] = thatWords[i >>> 2];
		                }
		            }
		            this.sigBytes += thatSigBytes;

		            // Chainable
		            return this;
		        },

		        /**
		         * Removes insignificant bits.
		         *
		         * @example
		         *
		         *     wordArray.clamp();
		         */
		        clamp: function () {
		            // Shortcuts
		            var words = this.words;
		            var sigBytes = this.sigBytes;

		            // Clamp
		            words[sigBytes >>> 2] &= 0xffffffff << (32 - (sigBytes % 4) * 8);
		            words.length = Math.ceil(sigBytes / 4);
		        },

		        /**
		         * Creates a copy of this word array.
		         *
		         * @return {WordArray} The clone.
		         *
		         * @example
		         *
		         *     var clone = wordArray.clone();
		         */
		        clone: function () {
		            var clone = Base.clone.call(this);
		            clone.words = this.words.slice(0);

		            return clone;
		        },

		        /**
		         * Creates a word array filled with random bytes.
		         *
		         * @param {number} nBytes The number of random bytes to generate.
		         *
		         * @return {WordArray} The random word array.
		         *
		         * @static
		         *
		         * @example
		         *
		         *     var wordArray = CryptoJS.lib.WordArray.random(16);
		         */
		        random: function (nBytes) {
		            var words = [];

		            var r = (function (m_w) {
		                var m_w = m_w;
		                var m_z = 0x3ade68b1;
		                var mask = 0xffffffff;

		                return function () {
		                    m_z = (0x9069 * (m_z & 0xFFFF) + (m_z >> 0x10)) & mask;
		                    m_w = (0x4650 * (m_w & 0xFFFF) + (m_w >> 0x10)) & mask;
		                    var result = ((m_z << 0x10) + m_w) & mask;
		                    result /= 0x100000000;
		                    result += 0.5;
		                    return result * (Math.random() > .5 ? 1 : -1);
		                }
		            });

		            for (var i = 0, rcache; i < nBytes; i += 4) {
		                var _r = r((rcache || Math.random()) * 0x100000000);

		                rcache = _r() * 0x3ade67b7;
		                words.push((_r() * 0x100000000) | 0);
		            }

		            return new WordArray.init(words, nBytes);
		        }
		    });

		    /**
		     * Encoder namespace.
		     */
		    var C_enc = C.enc = {};

		    /**
		     * Hex encoding strategy.
		     */
		    var Hex = C_enc.Hex = {
		        /**
		         * Converts a word array to a hex string.
		         *
		         * @param {WordArray} wordArray The word array.
		         *
		         * @return {string} The hex string.
		         *
		         * @static
		         *
		         * @example
		         *
		         *     var hexString = CryptoJS.enc.Hex.stringify(wordArray);
		         */
		        stringify: function (wordArray) {
		            // Shortcuts
		            var words = wordArray.words;
		            var sigBytes = wordArray.sigBytes;

		            // Convert
		            var hexChars = [];
		            for (var i = 0; i < sigBytes; i++) {
		                var bite = (words[i >>> 2] >>> (24 - (i % 4) * 8)) & 0xff;
		                hexChars.push((bite >>> 4).toString(16));
		                hexChars.push((bite & 0x0f).toString(16));
		            }

		            return hexChars.join('');
		        },

		        /**
		         * Converts a hex string to a word array.
		         *
		         * @param {string} hexStr The hex string.
		         *
		         * @return {WordArray} The word array.
		         *
		         * @static
		         *
		         * @example
		         *
		         *     var wordArray = CryptoJS.enc.Hex.parse(hexString);
		         */
		        parse: function (hexStr) {
		            // Shortcut
		            var hexStrLength = hexStr.length;

		            // Convert
		            var words = [];
		            for (var i = 0; i < hexStrLength; i += 2) {
		                words[i >>> 3] |= parseInt(hexStr.substr(i, 2), 16) << (24 - (i % 8) * 4);
		            }

		            return new WordArray.init(words, hexStrLength / 2);
		        }
		    };

		    /**
		     * Latin1 encoding strategy.
		     */
		    var Latin1 = C_enc.Latin1 = {
		        /**
		         * Converts a word array to a Latin1 string.
		         *
		         * @param {WordArray} wordArray The word array.
		         *
		         * @return {string} The Latin1 string.
		         *
		         * @static
		         *
		         * @example
		         *
		         *     var latin1String = CryptoJS.enc.Latin1.stringify(wordArray);
		         */
		        stringify: function (wordArray) {
		            // Shortcuts
		            var words = wordArray.words;
		            var sigBytes = wordArray.sigBytes;

		            // Convert
		            var latin1Chars = [];
		            for (var i = 0; i < sigBytes; i++) {
		                var bite = (words[i >>> 2] >>> (24 - (i % 4) * 8)) & 0xff;
		                latin1Chars.push(String.fromCharCode(bite));
		            }

		            return latin1Chars.join('');
		        },

		        /**
		         * Converts a Latin1 string to a word array.
		         *
		         * @param {string} latin1Str The Latin1 string.
		         *
		         * @return {WordArray} The word array.
		         *
		         * @static
		         *
		         * @example
		         *
		         *     var wordArray = CryptoJS.enc.Latin1.parse(latin1String);
		         */
		        parse: function (latin1Str) {
		            // Shortcut
		            var latin1StrLength = latin1Str.length;

		            // Convert
		            var words = [];
		            for (var i = 0; i < latin1StrLength; i++) {
		                words[i >>> 2] |= (latin1Str.charCodeAt(i) & 0xff) << (24 - (i % 4) * 8);
		            }

		            return new WordArray.init(words, latin1StrLength);
		        }
		    };

		    /**
		     * UTF-8 encoding strategy.
		     */
		    var Utf8 = C_enc.Utf8 = {
		        /**
		         * Converts a word array to a UTF-8 string.
		         *
		         * @param {WordArray} wordArray The word array.
		         *
		         * @return {string} The UTF-8 string.
		         *
		         * @static
		         *
		         * @example
		         *
		         *     var utf8String = CryptoJS.enc.Utf8.stringify(wordArray);
		         */
		        stringify: function (wordArray) {
		            try {
		                return decodeURIComponent(escape(Latin1.stringify(wordArray)));
		            } catch (e) {
		                throw new Error('Malformed UTF-8 data');
		            }
		        },

		        /**
		         * Converts a UTF-8 string to a word array.
		         *
		         * @param {string} utf8Str The UTF-8 string.
		         *
		         * @return {WordArray} The word array.
		         *
		         * @static
		         *
		         * @example
		         *
		         *     var wordArray = CryptoJS.enc.Utf8.parse(utf8String);
		         */
		        parse: function (utf8Str) {
		            return Latin1.parse(unescape(encodeURIComponent(utf8Str)));
		        }
		    };

		    /**
		     * Abstract buffered block algorithm template.
		     *
		     * The property blockSize must be implemented in a concrete subtype.
		     *
		     * @property {number} _minBufferSize The number of blocks that should be kept unprocessed in the buffer. Default: 0
		     */
		    var BufferedBlockAlgorithm = C_lib.BufferedBlockAlgorithm = Base.extend({
		        /**
		         * Resets this block algorithm's data buffer to its initial state.
		         *
		         * @example
		         *
		         *     bufferedBlockAlgorithm.reset();
		         */
		        reset: function () {
		            // Initial values
		            this._data = new WordArray.init();
		            this._nDataBytes = 0;
		        },

		        /**
		         * Adds new data to this block algorithm's buffer.
		         *
		         * @param {WordArray|string} data The data to append. Strings are converted to a WordArray using UTF-8.
		         *
		         * @example
		         *
		         *     bufferedBlockAlgorithm._append('data');
		         *     bufferedBlockAlgorithm._append(wordArray);
		         */
		        _append: function (data) {
		            // Convert string to WordArray, else assume WordArray already
		            if (typeof data == 'string') {
		                data = Utf8.parse(data);
		            }

		            // Append
		            this._data.concat(data);
		            this._nDataBytes += data.sigBytes;
		        },

		        /**
		         * Processes available data blocks.
		         *
		         * This method invokes _doProcessBlock(offset), which must be implemented by a concrete subtype.
		         *
		         * @param {boolean} doFlush Whether all blocks and partial blocks should be processed.
		         *
		         * @return {WordArray} The processed data.
		         *
		         * @example
		         *
		         *     var processedData = bufferedBlockAlgorithm._process();
		         *     var processedData = bufferedBlockAlgorithm._process(!!'flush');
		         */
		        _process: function (doFlush) {
		            // Shortcuts
		            var data = this._data;
		            var dataWords = data.words;
		            var dataSigBytes = data.sigBytes;
		            var blockSize = this.blockSize;
		            var blockSizeBytes = blockSize * 4;

		            // Count blocks ready
		            var nBlocksReady = dataSigBytes / blockSizeBytes;
		            if (doFlush) {
		                // Round up to include partial blocks
		                nBlocksReady = Math.ceil(nBlocksReady);
		            } else {
		                // Round down to include only full blocks,
		                // less the number of blocks that must remain in the buffer
		                nBlocksReady = Math.max((nBlocksReady | 0) - this._minBufferSize, 0);
		            }

		            // Count words ready
		            var nWordsReady = nBlocksReady * blockSize;

		            // Count bytes ready
		            var nBytesReady = Math.min(nWordsReady * 4, dataSigBytes);

		            // Process blocks
		            if (nWordsReady) {
		                for (var offset = 0; offset < nWordsReady; offset += blockSize) {
		                    // Perform concrete-algorithm logic
		                    this._doProcessBlock(dataWords, offset);
		                }

		                // Remove processed words
		                var processedWords = dataWords.splice(0, nWordsReady);
		                data.sigBytes -= nBytesReady;
		            }

		            // Return processed words
		            return new WordArray.init(processedWords, nBytesReady);
		        },

		        /**
		         * Creates a copy of this object.
		         *
		         * @return {Object} The clone.
		         *
		         * @example
		         *
		         *     var clone = bufferedBlockAlgorithm.clone();
		         */
		        clone: function () {
		            var clone = Base.clone.call(this);
		            clone._data = this._data.clone();

		            return clone;
		        },

		        _minBufferSize: 0
		    });

		    /**
		     * Abstract hasher template.
		     *
		     * @property {number} blockSize The number of 32-bit words this hasher operates on. Default: 16 (512 bits)
		     */
		    var Hasher = C_lib.Hasher = BufferedBlockAlgorithm.extend({
		        /**
		         * Configuration options.
		         */
		        cfg: Base.extend(),

		        /**
		         * Initializes a newly created hasher.
		         *
		         * @param {Object} cfg (Optional) The configuration options to use for this hash computation.
		         *
		         * @example
		         *
		         *     var hasher = CryptoJS.algo.SHA256.create();
		         */
		        init: function (cfg) {
		            // Apply config defaults
		            this.cfg = this.cfg.extend(cfg);

		            // Set initial values
		            this.reset();
		        },

		        /**
		         * Resets this hasher to its initial state.
		         *
		         * @example
		         *
		         *     hasher.reset();
		         */
		        reset: function () {
		            // Reset data buffer
		            BufferedBlockAlgorithm.reset.call(this);

		            // Perform concrete-hasher logic
		            this._doReset();
		        },

		        /**
		         * Updates this hasher with a message.
		         *
		         * @param {WordArray|string} messageUpdate The message to append.
		         *
		         * @return {Hasher} This hasher.
		         *
		         * @example
		         *
		         *     hasher.update('message');
		         *     hasher.update(wordArray);
		         */
		        update: function (messageUpdate) {
		            // Append
		            this._append(messageUpdate);

		            // Update the hash
		            this._process();

		            // Chainable
		            return this;
		        },

		        /**
		         * Finalizes the hash computation.
		         * Note that the finalize operation is effectively a destructive, read-once operation.
		         *
		         * @param {WordArray|string} messageUpdate (Optional) A final message update.
		         *
		         * @return {WordArray} The hash.
		         *
		         * @example
		         *
		         *     var hash = hasher.finalize();
		         *     var hash = hasher.finalize('message');
		         *     var hash = hasher.finalize(wordArray);
		         */
		        finalize: function (messageUpdate) {
		            // Final message update
		            if (messageUpdate) {
		                this._append(messageUpdate);
		            }

		            // Perform concrete-hasher logic
		            var hash = this._doFinalize();

		            return hash;
		        },

		        blockSize: 512/32,

		        /**
		         * Creates a shortcut function to a hasher's object interface.
		         *
		         * @param {Hasher} hasher The hasher to create a helper for.
		         *
		         * @return {Function} The shortcut function.
		         *
		         * @static
		         *
		         * @example
		         *
		         *     var SHA256 = CryptoJS.lib.Hasher._createHelper(CryptoJS.algo.SHA256);
		         */
		        _createHelper: function (hasher) {
		            return function (message, cfg) {
		                return new hasher.init(cfg).finalize(message);
		            };
		        },

		        /**
		         * Creates a shortcut function to the HMAC's object interface.
		         *
		         * @param {Hasher} hasher The hasher to use in this HMAC helper.
		         *
		         * @return {Function} The shortcut function.
		         *
		         * @static
		         *
		         * @example
		         *
		         *     var HmacSHA256 = CryptoJS.lib.Hasher._createHmacHelper(CryptoJS.algo.SHA256);
		         */
		        _createHmacHelper: function (hasher) {
		            return function (message, key) {
		                return new C_algo.HMAC.init(hasher, key).finalize(message);
		            };
		        }
		    });

		    /**
		     * Algorithm namespace.
		     */
		    var C_algo = C.algo = {};

		    return C;
		}(Math));


		return CryptoJS;

	}));

/***/ },

/***/ 252:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

	var _react = __webpack_require__(9);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(40);

	var _reactDom2 = _interopRequireDefault(_reactDom);

	var _NavBar = __webpack_require__(230);

	var _NavBar2 = _interopRequireDefault(_NavBar);

	var _Button = __webpack_require__(238);

	var _Dialog = __webpack_require__(233);

	var _Dialog2 = _interopRequireDefault(_Dialog);

	var _api = __webpack_require__(231);

	var _mixedMD = __webpack_require__(249);

	var _mixedMD2 = _interopRequireDefault(_mixedMD);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

	function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

	function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

	var Login = function (_React$Component) {
	    _inherits(Login, _React$Component);

	    function Login(props) {
	        _classCallCheck(this, Login);

	        var _this = _possibleConstructorReturn(this, (Login.__proto__ || Object.getPrototypeOf(Login)).call(this, props));

	        _this.state = {
	            loading: false
	        };
	        _this.signin = _this.signin.bind(_this);
	        _this.signinErrorDialog = _this.signinErrorDialog.bind(_this);
	        return _this;
	    }

	    _createClass(Login, [{
	        key: 'signinErrorDialog',
	        value: function signinErrorDialog(text) {
	            var div = document.createElement('div');

	            _reactDom2.default.render(_react2.default.createElement(_Dialog2.default, {
	                container: div,
	                text: text
	            }), document.body.appendChild(div));
	        }
	    }, {
	        key: 'signin',
	        value: function signin(event) {
	            var _this2 = this;

	            if (this.from.checkValidity() === true) {
	                event.preventDefault();
	            };

	            var $from = $(this.from);
	            var username = $from.find('[name=username]').val();
	            var mixedPWD = $from.find('[name=mixedPWD]').val();

	            this.setState({
	                loading: true
	            });

	            (0, _api.salt)().done(function (salt) {
	                (0, _api.login)({
	                    loginname: username,
	                    mixedPWD: (0, _mixedMD2.default)((0, _mixedMD2.default)((0, _mixedMD2.default)(mixedPWD)) + salt)
	                }).done(function () {
	                    if (_this2.props.router.location.state && _this2.props.router.location.state.nextPathname) {
	                        _this2.props.router.replace(_this2.props.router.location.state.nextPathname);
	                    } else {
	                        _this2.props.router.replace(SCHOOLPAL_CONFIG.ROOTPATH);
	                    }
	                }).fail(function (data) {
	                    _this2.setState({
	                        loading: false
	                    });
	                    _this2.signinErrorDialog('[' + data.data.code + '] - ' + data.data.detail);
	                });
	            });
	        }
	    }, {
	        key: 'render',
	        value: function render() {
	            var _this3 = this;

	            return _react2.default.createElement(
	                'div',
	                { className: 'view' },
	                _react2.default.createElement(_NavBar2.default, null),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'login bg-faded' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'login-form' },
	                        _react2.default.createElement(
	                            'h5',
	                            { className: 'text-primary' },
	                            'LOGIN'
	                        ),
	                        _react2.default.createElement(
	                            'form',
	                            { ref: function ref(dom) {
	                                    _this3.from = dom;
	                                }, onSubmit: this.signin },
	                            _react2.default.createElement(
	                                'ul',
	                                null,
	                                _react2.default.createElement(
	                                    'li',
	                                    null,
	                                    _react2.default.createElement('input', { name: 'username', type: 'text', placeholder: '\u8F93\u5165\u7528\u6237\u540D ...', required: 'required' })
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    null,
	                                    _react2.default.createElement('input', { name: 'mixedPWD', type: 'password', placeholder: '\u8F93\u5165\u5BC6\u7801 ...', required: 'required' })
	                                )
	                            ),
	                            _react2.default.createElement(_Button.LoginButton, { loading: this.state.loading })
	                        )
	                    )
	                )
	            );
	        }
	    }]);

	    return Login;
	}(_react2.default.Component);

	exports.default = Login;

/***/ },

/***/ 253:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = Error;

	var _react = __webpack_require__(9);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	function Error(props) {
	    return _react2.default.createElement(
	        'p',
	        null,
	        '\u6CA1\u6709\u6743\u9650\u8BBF\u95EE\u6B64\u9875\u9762 \uFF01'
	    );
	}

/***/ },

/***/ 254:
/***/ function(module, exports) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = checkAuth;
	function checkAuth(nextState, replace) {
	    var hasMatch = 0;

	    if (SCHOOLPAL_CONFIG.authPath) {
	        SCHOOLPAL_CONFIG.authPath.map(function (rule) {
	            var temp = nextState.location.pathname.replace(SCHOOLPAL_CONFIG.ROOTPATH, '');

	            if (rule.test(temp) === true) {
	                hasMatch++;
	            }
	        });

	        if (!hasMatch) {
	            replace({
	                pathname: SCHOOLPAL_CONFIG.ROOTPATH + 'error'
	            });
	        }
	    };
	}

/***/ },

/***/ 255:
/***/ function(module, exports) {

	// removed by extract-text-webpack-plugin

/***/ },

/***/ 257:
/***/ function(module, exports) {

	/*
		MIT License http://www.opensource.org/licenses/mit-license.php
		Author Tobias Koppers @sokra
	*/
	// css base code, injected by the css-loader
	module.exports = function() {
		var list = [];

		// return the list of modules as css string
		list.toString = function toString() {
			var result = [];
			for(var i = 0; i < this.length; i++) {
				var item = this[i];
				if(item[2]) {
					result.push("@media " + item[2] + "{" + item[1] + "}");
				} else {
					result.push(item[1]);
				}
			}
			return result.join("");
		};

		// import a list of modules into the list
		list.i = function(modules, mediaQuery) {
			if(typeof modules === "string")
				modules = [[null, modules, ""]];
			var alreadyImportedModules = {};
			for(var i = 0; i < this.length; i++) {
				var id = this[i][0];
				if(typeof id === "number")
					alreadyImportedModules[id] = true;
			}
			for(i = 0; i < modules.length; i++) {
				var item = modules[i];
				// skip already imported module
				// this implementation is not 100% perfect for weird media query combinations
				//  when a module is imported multiple times with different media queries.
				//  I hope this will never occur (Hey this way we have smaller bundles)
				if(typeof item[0] !== "number" || !alreadyImportedModules[item[0]]) {
					if(mediaQuery && !item[2]) {
						item[2] = mediaQuery;
					} else if(mediaQuery) {
						item[2] = "(" + item[2] + ") and (" + mediaQuery + ")";
					}
					list.push(item);
				}
			}
		};
		return list;
	};


/***/ },

/***/ 258:
/***/ function(module, exports, __webpack_require__) {

	/*
		MIT License http://www.opensource.org/licenses/mit-license.php
		Author Tobias Koppers @sokra
	*/
	var stylesInDom = {},
		memoize = function(fn) {
			var memo;
			return function () {
				if (typeof memo === "undefined") memo = fn.apply(this, arguments);
				return memo;
			};
		},
		isOldIE = memoize(function() {
			return /msie [6-9]\b/.test(window.navigator.userAgent.toLowerCase());
		}),
		getHeadElement = memoize(function () {
			return document.head || document.getElementsByTagName("head")[0];
		}),
		singletonElement = null,
		singletonCounter = 0,
		styleElementsInsertedAtTop = [];

	module.exports = function(list, options) {
		if(false) {
			if(typeof document !== "object") throw new Error("The style-loader cannot be used in a non-browser environment");
		}

		options = options || {};
		// Force single-tag solution on IE6-9, which has a hard limit on the # of <style>
		// tags it will allow on a page
		if (typeof options.singleton === "undefined") options.singleton = isOldIE();

		// By default, add <style> tags to the bottom of <head>.
		if (typeof options.insertAt === "undefined") options.insertAt = "bottom";

		var styles = listToStyles(list);
		addStylesToDom(styles, options);

		return function update(newList) {
			var mayRemove = [];
			for(var i = 0; i < styles.length; i++) {
				var item = styles[i];
				var domStyle = stylesInDom[item.id];
				domStyle.refs--;
				mayRemove.push(domStyle);
			}
			if(newList) {
				var newStyles = listToStyles(newList);
				addStylesToDom(newStyles, options);
			}
			for(var i = 0; i < mayRemove.length; i++) {
				var domStyle = mayRemove[i];
				if(domStyle.refs === 0) {
					for(var j = 0; j < domStyle.parts.length; j++)
						domStyle.parts[j]();
					delete stylesInDom[domStyle.id];
				}
			}
		};
	}

	function addStylesToDom(styles, options) {
		for(var i = 0; i < styles.length; i++) {
			var item = styles[i];
			var domStyle = stylesInDom[item.id];
			if(domStyle) {
				domStyle.refs++;
				for(var j = 0; j < domStyle.parts.length; j++) {
					domStyle.parts[j](item.parts[j]);
				}
				for(; j < item.parts.length; j++) {
					domStyle.parts.push(addStyle(item.parts[j], options));
				}
			} else {
				var parts = [];
				for(var j = 0; j < item.parts.length; j++) {
					parts.push(addStyle(item.parts[j], options));
				}
				stylesInDom[item.id] = {id: item.id, refs: 1, parts: parts};
			}
		}
	}

	function listToStyles(list) {
		var styles = [];
		var newStyles = {};
		for(var i = 0; i < list.length; i++) {
			var item = list[i];
			var id = item[0];
			var css = item[1];
			var media = item[2];
			var sourceMap = item[3];
			var part = {css: css, media: media, sourceMap: sourceMap};
			if(!newStyles[id])
				styles.push(newStyles[id] = {id: id, parts: [part]});
			else
				newStyles[id].parts.push(part);
		}
		return styles;
	}

	function insertStyleElement(options, styleElement) {
		var head = getHeadElement();
		var lastStyleElementInsertedAtTop = styleElementsInsertedAtTop[styleElementsInsertedAtTop.length - 1];
		if (options.insertAt === "top") {
			if(!lastStyleElementInsertedAtTop) {
				head.insertBefore(styleElement, head.firstChild);
			} else if(lastStyleElementInsertedAtTop.nextSibling) {
				head.insertBefore(styleElement, lastStyleElementInsertedAtTop.nextSibling);
			} else {
				head.appendChild(styleElement);
			}
			styleElementsInsertedAtTop.push(styleElement);
		} else if (options.insertAt === "bottom") {
			head.appendChild(styleElement);
		} else {
			throw new Error("Invalid value for parameter 'insertAt'. Must be 'top' or 'bottom'.");
		}
	}

	function removeStyleElement(styleElement) {
		styleElement.parentNode.removeChild(styleElement);
		var idx = styleElementsInsertedAtTop.indexOf(styleElement);
		if(idx >= 0) {
			styleElementsInsertedAtTop.splice(idx, 1);
		}
	}

	function createStyleElement(options) {
		var styleElement = document.createElement("style");
		styleElement.type = "text/css";
		insertStyleElement(options, styleElement);
		return styleElement;
	}

	function createLinkElement(options) {
		var linkElement = document.createElement("link");
		linkElement.rel = "stylesheet";
		insertStyleElement(options, linkElement);
		return linkElement;
	}

	function addStyle(obj, options) {
		var styleElement, update, remove;

		if (options.singleton) {
			var styleIndex = singletonCounter++;
			styleElement = singletonElement || (singletonElement = createStyleElement(options));
			update = applyToSingletonTag.bind(null, styleElement, styleIndex, false);
			remove = applyToSingletonTag.bind(null, styleElement, styleIndex, true);
		} else if(obj.sourceMap &&
			typeof URL === "function" &&
			typeof URL.createObjectURL === "function" &&
			typeof URL.revokeObjectURL === "function" &&
			typeof Blob === "function" &&
			typeof btoa === "function") {
			styleElement = createLinkElement(options);
			update = updateLink.bind(null, styleElement);
			remove = function() {
				removeStyleElement(styleElement);
				if(styleElement.href)
					URL.revokeObjectURL(styleElement.href);
			};
		} else {
			styleElement = createStyleElement(options);
			update = applyToTag.bind(null, styleElement);
			remove = function() {
				removeStyleElement(styleElement);
			};
		}

		update(obj);

		return function updateStyle(newObj) {
			if(newObj) {
				if(newObj.css === obj.css && newObj.media === obj.media && newObj.sourceMap === obj.sourceMap)
					return;
				update(obj = newObj);
			} else {
				remove();
			}
		};
	}

	var replaceText = (function () {
		var textStore = [];

		return function (index, replacement) {
			textStore[index] = replacement;
			return textStore.filter(Boolean).join('\n');
		};
	})();

	function applyToSingletonTag(styleElement, index, remove, obj) {
		var css = remove ? "" : obj.css;

		if (styleElement.styleSheet) {
			styleElement.styleSheet.cssText = replaceText(index, css);
		} else {
			var cssNode = document.createTextNode(css);
			var childNodes = styleElement.childNodes;
			if (childNodes[index]) styleElement.removeChild(childNodes[index]);
			if (childNodes.length) {
				styleElement.insertBefore(cssNode, childNodes[index]);
			} else {
				styleElement.appendChild(cssNode);
			}
		}
	}

	function applyToTag(styleElement, obj) {
		var css = obj.css;
		var media = obj.media;

		if(media) {
			styleElement.setAttribute("media", media)
		}

		if(styleElement.styleSheet) {
			styleElement.styleSheet.cssText = css;
		} else {
			while(styleElement.firstChild) {
				styleElement.removeChild(styleElement.firstChild);
			}
			styleElement.appendChild(document.createTextNode(css));
		}
	}

	function updateLink(linkElement, obj) {
		var css = obj.css;
		var sourceMap = obj.sourceMap;

		if(sourceMap) {
			// http://stackoverflow.com/a/26603875
			css += "\n/*# sourceMappingURL=data:application/json;base64," + btoa(unescape(encodeURIComponent(JSON.stringify(sourceMap)))) + " */";
		}

		var blob = new Blob([css], { type: "text/css" });

		var oldSrc = linkElement.href;

		linkElement.href = URL.createObjectURL(blob);

		if(oldSrc)
			URL.revokeObjectURL(oldSrc);
	}


/***/ },

/***/ 259:
/***/ function(module, exports) {

	// removed by extract-text-webpack-plugin

/***/ },

/***/ 262:
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(263);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(258)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(false) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept("!!./../../../../../node_modules/.0.26.1@css-loader/index.js!./../../../../../node_modules/less-loader/index.js!./bundle.less", function() {
				var newContent = require("!!./../../../../../node_modules/.0.26.1@css-loader/index.js!./../../../../../node_modules/less-loader/index.js!./bundle.less");
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },

/***/ 263:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(257)();
	// imports


	// module
	exports.push([module.id, ".aside-bar {\n  position: absolute;\n  top: 54px;\n  left: 0;\n  bottom: 0;\n  padding-top: 16px;\n  width: 60px;\n}\n.aside-bar a {\n  margin-bottom: 16px;\n}\n.tree {\n  padding: 10px 20px;\n}\n.tree li,\n.tree ul {\n  margin: 0;\n  padding: 0;\n  list-style: none;\n}\n.tree li {\n  position: relative;\n  min-height: 24px;\n  line-height: 24px;\n  font-size: 16px;\n}\n.tree li li {\n  margin-left: 23px;\n}\n.tree li .hd {\n  padding-left: 5px;\n  min-height: 24px;\n  line-height: 24px;\n  margin-bottom: 10px;\n}\n.tree li .hd p {\n  margin-bottom: 0;\n}\n.tree-node {\n  margin-bottom: 0;\n}\n.tree-node:before {\n  content: \"\\F147\";\n  display: inline-block;\n  margin-right: 10px;\n  font: normal normal normal 14px/1 FontAwesome;\n  font-size: inherit;\n  text-rendering: auto;\n  -webkit-font-smoothing: antialiased;\n  -moz-osx-font-smoothing: grayscale;\n}\n.tree-node.closed:before {\n  content: \"\\F196\";\n}\n.tree-node.not-child:before {\n  visibility: hidden;\n}\n.show > .dropdown-menu {\n  min-width: 100%;\n}\n.table td,\n.table th {\n  vertical-align: middle;\n}\n.table thead th {\n  white-space: nowrap;\n}\n.navbar {\n  padding: 0;\n}\n.navbar a {\n  padding-left: 1rem;\n  line-height: 54px;\n}\n.navbar a:hover {\n  text-decoration: none;\n}\n.navbar .btn {\n  height: 54px;\n}\n.show > .dropdown-menu {\n  min-width: 400px;\n}\n.b-l {\n  position: relative;\n}\n.b-l:before {\n  content: \"\";\n  position: absolute;\n  top: 0;\n  left: 0;\n  bottom: 0;\n  width: 1px;\n  background: #eceeef;\n}\n.b-r {\n  position: relative;\n}\n.b-r:after {\n  content: \"\";\n  position: absolute;\n  top: 0;\n  right: 0;\n  bottom: 0;\n  width: 1px;\n  background: #eceeef;\n}\n.b-b {\n  position: relative;\n}\n.b-b:after {\n  content: \"\";\n  position: absolute;\n  left: 0;\n  right: 0;\n  bottom: 0;\n  height: 1px;\n  background: #eceeef;\n}\n.b-lr {\n  position: relative;\n}\n.b-lr:before {\n  content: \"\";\n  position: absolute;\n  top: 0;\n  left: 0;\n  bottom: 0;\n  width: 1px;\n  background: #eceeef;\n}\n.b-lr:after {\n  content: \"\";\n  position: absolute;\n  top: 0;\n  right: 0;\n  bottom: 0;\n  width: 1px;\n  background: #eceeef;\n}\n.hide {\n  display: none;\n}\n.w200 {\n  width: 200px;\n}\n.w300 {\n  width: 300px;\n}\n.w400 {\n  width: 400px;\n}\n.w500 {\n  width: 500px;\n}\n.minw210 {\n  min-width: 210px;\n}\n.flex-cell {\n  -webkit-box-flex: 1;\n  -webkit-flex: 1;\n  -ms-flex: 1;\n  flex: 1;\n  width: 0;\n  -webkit-flex-basis: 0;\n  -ms-flex-preferred-size: 0;\n  flex-basis: 0;\n  max-width: 100%;\n  display: block;\n  position: relative;\n}\n.select {\n  display: inline-block;\n  cursor: pointer;\n}\n.select:before {\n  content: \"\\F096\";\n  display: inline-block;\n  margin-right: 5px;\n  min-width: 20px;\n  font: normal normal normal 14px/1 FontAwesome;\n  font-size: inherit;\n  text-rendering: auto;\n  -webkit-font-smoothing: antialiased;\n  -moz-osx-font-smoothing: grayscale;\n}\n.select.selected {\n  color: #d9534f;\n}\n.select.selected:before {\n  content: \"\\F046\";\n}\n.main {\n  position: absolute;\n  top: 54px;\n  left: 60px;\n  right: 0;\n  bottom: 0;\n}\n.main h5 {\n  position: relative;\n  margin-bottom: 1rem;\n  padding: 1rem 20px;\n  line-height: 38px;\n}\n.main h5:after {\n  content: '';\n  position: absolute;\n  left: 0;\n  right: 0;\n  bottom: 0;\n  height: 1px;\n  background: #eceeef;\n}\n.main h5 p {\n  font-size: .8em;\n  font-weight: normal;\n}\n.main .main-container {\n  margin: 0 20px 20px;\n}\n.login {\n  position: absolute;\n  top: 54px;\n  left: 0;\n  right: 0;\n  bottom: 0;\n}\n.login .login-form {\n  margin: 50px auto;\n  padding: 0 20px;\n  width: 600px;\n  height: 370px;\n  background: #fff;\n}\n.login .login-form h5 {\n  position: relative;\n  margin-bottom: 0;\n  padding: 20px 0;\n  font-size: 30px;\n  font-weight: normal;\n}\n.login .login-form li,\n.login .login-form ul {\n  margin: 0;\n  padding: 0;\n  list-style: none;\n}\n.login .login-form li {\n  margin-top: 30px;\n  border-bottom: 1px solid #eceeef;\n}\n.login .login-form input {\n  display: block;\n  padding: 0 10px;\n  width: 100%;\n  font-size: 30px;\n  border: 0;\n  outline: none;\n  -webkit-appearance: none;\n}\n.login .login-form .login-submit {\n  float: right;\n  margin-top: 70px;\n  cursor: pointer;\n}\n.login .login-form .login-submit:hover {\n  text-decoration: none;\n}\n.login .login-form .login-submit i,\n.login .login-form .login-submit span {\n  vertical-align: middle;\n}\n.login .login-form .login-submit span {\n  margin-left: 10px;\n  font-size: 24px;\n}\n.dialog-tips {\n  position: absolute;\n  top: 0;\n  left: 0;\n  right: 0;\n  bottom: 0;\n  overflow: hidden;\n  z-index: 1000;\n}\n.dialog-tips .content {\n  position: absolute;\n  top: 30%;\n  left: 50%;\n  margin-left: -50px;\n  width: 100px;\n  height: 100px;\n  background: rgba(0, 0, 0, 0.7);\n  color: #fff;\n  text-align: center;\n  border-radius: 5px;\n}\n.dialog-tips .content i {\n  display: inline-block;\n  margin: 15px 0 5px;\n}\n.dialog-tips .content span {\n  display: block;\n}\n", ""]);

	// exports


/***/ }

});