import { conversionOrg, conversionFunc } from './conversion';

function io(options, callback) {
    if (!(this instanceof io)) {
        return new io(options, callback);
    };

    const defaults = {
        type: 'POST',
        dataType: 'json'
    };
    const settings = $.extend({}, defaults, options);
    const jqxhr = $.ajax({
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
            })
        };
    })

    jqxhr.fail(function (jqXHR, textStatus, errorThrown) {
        console.log(jqXHR.status, textStatus, errorThrown)
        callback({
            type: jqXHR.status === 401 ? SCHOOLPAL_CONFIG.NOT_SIGNIN : SCHOOLPAL_CONFIG.XHR_ERROR
        })
    })
}

function formatUrl(url) {
    return SCHOOLPAL_CONFIG.AJAXPATH + url;
}

export function salt() {
    const defer = $.Deferred();
    const url = 'user/salt.do';

    io({ url: url }, function (data) {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    });

    return defer.promise();
}

export function login(data) {
    const defer = $.Deferred();
    const url = 'user/login.do';
    const settings = $.extend({ url: url }, { data: data });

    io(settings, function (data) {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    });

    return defer.promise();
}

export function logout() {
    const defer = $.Deferred();
    const url = 'user/logout.do';

    io({ url: url }, function (data) {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    });

    return defer.promise();
}

export function permissions() {
    const defer = $.Deferred();
    const url = 'user/listFuncs.do';

    io({ url: url }, (data) => {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            let auth = {};
            let authPath = [];

            if (data.data.length) {
                $.each(data.data, (i, item) => {
                    if (item.WidgetType === 'MenuItem') {
                        const temp = $.extend({}, { id: item.cId, command: [] }, SCHOOLPAL_CONFIG.AUTH_DIC[item.cId]);

                        if (SCHOOLPAL_CONFIG.AUTH_DIC[item.cId] && SCHOOLPAL_CONFIG.AUTH_DIC[item.cId].PATH) {
                            auth[SCHOOLPAL_CONFIG.AUTH_DIC[item.cId].PATH] = temp;
                        }
                    };

                    if (item.WidgetType === 'Command') {
                        $.each(auth, (k, v) => {
                            if (v.id === item.cParentId) {
                                v.command.push(item.CommandCode)
                            };
                        })
                    };

                    if (SCHOOLPAL_CONFIG.AUTH_DIC[item.cId]) {
                        authPath.push(SCHOOLPAL_CONFIG.AUTH_DIC[item.cId].PATH_RULE)
                    };
                })
            };

            SCHOOLPAL_CONFIG.auth = auth;
            SCHOOLPAL_CONFIG.authPath = authPath;

            defer.resolve();
        } else {
            defer.reject(data);
        }
    });

    return defer.promise();
}

export function orgList() {
    const defer = $.Deferred();
    const url = 'user/listOrgs.do';

    io({ url: url }, (data) => {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(conversionOrg(data.data));
        } else {
            defer.reject(data);
        }
    });

    return defer.promise();
}

export function orgDetails(oid) {
    const defer = $.Deferred();
    const url = 'org/query.do';

    io({ url: url, data: { id: oid } }, (data) => {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    })

    return defer.promise();
}

export function orgAdd(data) {
    const defer = $.Deferred();
    const url = 'sys/org/add.do';
    const settings = $.extend({ url: url }, { data: data });

    io(settings, function (data) {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    });

    return defer.promise();
}

export function orgMod(data) {
    const defer = $.Deferred();
    const url = 'sys/org/mod.do';
    const settings = $.extend({ url: url }, { data: data });

    io(settings, function (data) {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    });

    return defer.promise();
}

export function orgDel(oid) {
    const defer = $.Deferred();
    const url = 'sys/org/del.do';

    io({ url: url, data: { id: oid } }, (data) => {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    })

    return defer.promise();
}

export function roleList(oid) {
    const defer = $.Deferred();
    const url = 'org/listRoles.do';

    io({ url: url, data: { id: oid } }, (data) => {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    })

    return defer.promise();
}

export function rankDic() {
    const defer = $.Deferred();
    const url = 'role/ranks.do';

    io({ url: url }, (data) => {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    })

    return defer.promise();
}

export function funcDic() {
    const defer = $.Deferred();
    const url = 'func/listAllFuncs.do';

    io({ url: url }, (data) => {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    })

    return defer.promise();
}

export function roleAdd(data) {
    const defer = $.Deferred();
    const url = 'sys/role/add.do';
    const settings = $.extend({ url: url }, { data: data });

    io(settings, function (data) {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    });

    return defer.promise();
}

export function roleDel(rid) {
    const defer = $.Deferred();
    const url = 'sys/role/del.do';

    io({ url: url, data: { id: rid } }, (data) => {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    })

    return defer.promise();
}

export function roleDetails(rid) {
    const defer = $.Deferred();
    const url = 'role/query.do';

    io({ url: url, data: { id: rid } }, (data) => {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    })

    return defer.promise();
}

export function roleMod(data) {
    const defer = $.Deferred();
    const url = 'sys/role/mod.do';
    const settings = $.extend({ url: url }, { data: data });

    io(settings, function (data) {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    });

    return defer.promise();
}

export function roleAuth(data) {
    const defer = $.Deferred();
    const url = 'sys/role/auth.do';
    const settings = $.extend({ url: url }, { data: data });

    io(settings, function (data) {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    });

    return defer.promise();
}

export function funcByIds(fids) {
    const defer = $.Deferred();
    const url = 'func/list.do';

    io({ url: url, data: { ids: fids } }, (data) => {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            const conversionFuncData = conversionFunc(data.data)

            defer.resolve({
                tree: conversionFuncData,
                data: data.data
            });
        } else {
            defer.reject(data);
        }
    })

    return defer.promise();
}

export function userList(oid) {
    const defer = $.Deferred();
    const url = 'org/listUsers.do';

    io({ url: url, data: { id: oid } }, (data) => {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    })

    return defer.promise();
}

export function userAdd(data) {
    const defer = $.Deferred();
    const url = 'sys/user/add.do';
    const settings = $.extend({ url: url }, { data: data });

    io(settings, function (data) {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    });

    return defer.promise();
}

export function userDetails(uid) {
    const defer = $.Deferred();
    const url = 'sys/user/query.do';

    io({ url: url, data: { id: uid } }, (data) => {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    })

    return defer.promise();
}

export function userMod(data) {
    const defer = $.Deferred();
    const url = 'sys/user/mod.do';
    const settings = $.extend({ url: url }, { data: data });

    io(settings, function (data) {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    });

    return defer.promise();
}

export function userEnable(uid, enable) {
    const defer = $.Deferred();
    const url = 'sys/user/enable.do';

    io({ url: url, data: { id: uid, enabled: enable } }, (data) => {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    })

    return defer.promise();
}

export function userDel(uid) {
    const defer = $.Deferred();
    const url = 'sys/user/del.do';

    io({ url: url, data: { id: uid } }, (data) => {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    })

    return defer.promise();
}

export function checkName(name) {
    const defer = $.Deferred();
    const url = 'sys/user/checkName.do';

    io({ url: url, data: { loginName: name } }, (data) => {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {

            if (data.data === true) {
                defer.reject(data);
            } else {
                defer.resolve(data.data);
            }

        } else {
            defer.reject(data);
        }
    })

    return defer.promise();
}