/// <reference path="../typings/index.d.ts" />

describe('/ajax/sales/customer/parent APIs', function() {

    this.timeout(0);

    var loginIdVal = crmLoginIdVal;

    it('salt.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, userApiPath, 'salt.do'),
            dataType: 'json'
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('salt.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.data).to.not.empty;
        expect(jsonData.data.length).to.be.equal(4);
        saltVal = jsonData.data;
        expect(jsonData.detail).to.be.equal('Ok');
    });

    it('login.do - null values', function() {
        xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, userApiPath, 'login.do'),
            dataType: 'json',
            data: {
                loginName: null,
                mixedPWD: null
            }
        });

        expect(xhr.status).to.be.equal(200);
        jsonData = xhr.responseJSON;
        resDump('login.do', jsonData);
        expect(jsonData.code).to.be.equal(400);
    });

    it('login.do', function() {
        xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, userApiPath, 'login.do'),
            dataType: 'json',
            data: {
                loginName: loginIdVal,
                mixedPWD: MD5(MD5(MD5(passVal)) + saltVal)
            }
        });

        expect(xhr.status).to.be.equal(200);
        jsonData = xhr.responseJSON;
        resDump('login.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.data).to.be.empty;
        expect(jsonData.detail).to.be.equal('Ok');
    });

    it('profile.do', function() {
        xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, userApiPath, 'profile.do'),
            dataType: 'json'
        });

        expect(xhr.status).to.be.equal(200);
        jsonData = xhr.responseJSON;
        resDump('profile.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.data).to.not.empty;
        orgIdVal = jsonData.data.cOrgId;
    });

    it('add.do - null values', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, salesParentApiPath, 'add.do'),
            dataType: 'json',
            data: {
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('add.do', jsonData);
        expect(jsonData.code).to.be.equal(400);
    });

    it('add.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, salesParentApiPath, 'add.do'),
            dataType: 'json',
            data: {
                name: 'parent name',
                genderId: 1,
                cellphone: '13800010002',
                wechat: '123456',
                email: 'parent mail',
                address: 'parent addr',
                idType: 1,
                idCode: orgCodeVal,
                birthday: new Date(1981, 12, 12),
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('add.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.data).to.not.empty;
        expect(jsonData.detail).to.be.equal('Ok');
        userIdVal = jsonData.data;
    });

    it('query.do - null values', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, salesParentApiPath, 'query.do'),
            dataType: 'json',
            data: {
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('query.do', jsonData);
        expect(jsonData.code).to.be.equal(400);
    });

    it('query.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, salesParentApiPath, 'query.do'),
            dataType: 'json',
            data: {
                id: userIdVal,
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('query.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.data).to.not.empty;
        expect(jsonData.detail).to.be.equal('Ok');
    });

    it('list.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, salesParentApiPath, 'list.do'),
            dataType: 'json',
            data: {
                organizationId: orgIdVal
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('list.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.data).to.not.empty;
        expect(jsonData.detail).to.be.equal('Ok');
    });

    it('mod.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, salesParentApiPath, 'mod.do'),
            dataType: 'json',
            data: {
                id: userIdVal,
                name: 'parent name mode',
                genderId: 2,
                cellphone: '13800010002 mod',
                wechat: '123456 mod',
                email: 'parent mail mod',
                address: 'parent addr mod',
                idType: 2,
                idCode: orgCodeVal + ' mod',
                birthday: new Date(1981, 12, 12),
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('mod.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.detail).to.be.equal('Ok');
    });

    it('del.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, salesParentApiPath, 'del.do'),
            dataType: 'json',
            data: {
                id: userIdVal
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('del.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.detail).to.be.equal('Ok');
    });

    it('logout.do', function() {
        xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, userApiPath, 'logout.do'),
            dataType: 'json'
        });

        expect(xhr.status).to.be.equal(200);
        jsonData = xhr.responseJSON;
        resDump('logout.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.data).to.be.empty;
        expect(jsonData.detail).to.be.equal('Ok');
    });
});