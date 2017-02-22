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
    const url = 'user/permissions.do';

    io({ url: url }, (data) => {
        if (data.type === SCHOOLPAL_CONFIG.XHR_DONE) {
            defer.resolve(data.data);
        } else {
            defer.reject(data);
        }
    });

    return defer.promise();
}