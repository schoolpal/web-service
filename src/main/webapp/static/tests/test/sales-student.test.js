/// <reference path="../typings/index.d.ts" />

describe('/ajax/sales/customer/student APIs', function() {

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
            url: buildUrl(host, salesStudentApiPath, 'add.do'),
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
            url: buildUrl(host, salesStudentApiPath, 'add.do'),
            dataType: 'json',
            data: {
                code: orgCodeVal,
                name: 'parent name',
                genderId: 1,
                idType: 1,
                idCode: orgCodeVal,
                birthday: new Date(1981, 12, 12),
                schoolGrade: 'school grade',
                classGrade: 'class grade',
                schoolName: 'school name',
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
            url: buildUrl(host, salesStudentApiPath, 'query.do'),
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
            url: buildUrl(host, salesStudentApiPath, 'query.do'),
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

    it('queryByCode.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, salesStudentApiPath, 'queryByCode.do'),
            dataType: 'json',
            data: {
                code: orgCodeVal,
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('queryByCode.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.data).to.not.empty;
        expect(jsonData.detail).to.be.equal('Ok');
    });

    it('list.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, salesStudentApiPath, 'list.do'),
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
            url: buildUrl(host, salesStudentApiPath, 'mod.do'),
            dataType: 'json',
            data: {
                id: userIdVal,
                code: orgCodeVal,
                name: 'parent name mod',
                genderId: 1,
                idType: 1,
                idCode: orgCodeVal + ' mod',
                birthday: new Date(1981, 12, 14),
                schoolGrade: 'school grade mod',
                classGrade: 'class grade mod',
                schoolName: 'school name mod',
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
            url: buildUrl(host, salesStudentApiPath, 'del.do'),
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