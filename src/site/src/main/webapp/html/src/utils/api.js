const DEV_SERVER_HOST = '//schoolpal.dinner3000.com:7180';
const DEV_HOST = '//127.0.0.1:7180';
const PATH = '/web/ajax/';

function io(options, callback, error) {
    const defaults = {
        type: 'GET',
        dataType: 'json'
    };
    const settings = $.extend({}, defaults, options);
    const jqxhr = $.ajax({
        url: formatUrl(settings.url),
        type: settings.tyoe,
        data: settings.data || {},
        dataType: settings.dataType,
        statusCode: {
            401: function () {
                console.log('not sign in ...')
            }
        }
    });

    jqxhr.done(function (data, textStatus, jqXHR) {
        console.log(data, textStatus, jqXHR.status);

        if (data.code === 200) {
            callback(data.data);
        } else {
            if (error) {
                error(data);
            };
        };
    })

    jqxhr.fail(function (jqXHR, textStatus, errorThrown) {
        console.log(jqXHR.status, textStatus, errorThrown)
    })
}

function formatUrl(url) {
    console.log(location.port)
    if (location.port === '3001') {
        return DEV_HOST + PATH + url;
    } else if (location.port === '3000') {
        return DEV_SERVER_HOST + PATH + url;
    } else {
        return PATH + url;
    }
}

export function salt() {
    const defer = $.Deferred();
    const url = 'user/salt.do';

    io({ url: url, tyoe: 'POST' }, function (data) {
        defer.resolve(data);
    });

    return defer.promise();
}

export function login(data) {
    const defer = $.Deferred();
    const url = 'user/login.do';
    const settings = $.extend({ url: url, tyoe: 'POST' }, { data: data });

    io(settings, function (data) {
        defer.resolve(data);
    }, function (data) {
        defer.reject(data);
    });

    return defer.promise();
}

export function logout() {
    const defer = $.Deferred();
    const url = 'user/logout.do';

    io({ url: url, tyoe: 'POST' }, function (data) {
        defer.resolve(data);
    });

    return defer.promise();
}