/// <reference path="../typings/index.d.ts" />

describe('/ajax/service/contract/ APIs', function() {

    var host = window.location.protocol + "//" + window.location.host;
    var path = '/web/ajax/user/';
    var act_path = '/web/ajax/service/contract/';

    // var user = 'rise-01';
    var user = 'sp-crm';
    var pass = '123456';
    var salt = null;

    var id_val = 0;
    var org_val = 0;

    var date = new Date()
    var codeVal = date.getTime();

    this.timeout(0);

    it('salt.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, path, 'salt.do'),
            dataType: 'json'
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('salt.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.data).to.not.empty;
        expect(jsonData.data.length).to.be.equal(4);
        salt = jsonData.data;
        expect(jsonData.detail).to.be.equal('Ok');
    });

    it('login.do', function() {
        xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, path, 'login.do'),
            dataType: 'json',
            data: {
                loginName: user,
                mixedPWD: MD5(MD5(MD5(pass)) + salt)
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
            url: buildUrl(host, path, 'profile.do'),
            dataType: 'json'
        });

        expect(xhr.status).to.be.equal(200);
        jsonData = xhr.responseJSON;
        resDump('profile.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.data).to.not.empty;
        org_val = jsonData.data.cOrgId;
    });

    it('add.do - null values', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, act_path, 'add.do'),
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
            url: buildUrl(host, act_path, 'add.do'),
            dataType: 'json',
            data: {
                code: codeVal,
                type: '新招',
                startDate: new Date(2016, 6, 6),
                endDate: new Date(2017, 7, 7),
                oriPrice: 100000.79,
                discPrice: 88888.61,
                finalPrice: 88888.68,
                paid: 88888.68,
                courseType: 'course type',
                courseOriId: 1,
                courseSesId: 2,
                courseHours: 10,
                courseTimes: 5,
                stuName: 'student name',
                stuCode: codeVal,
                stuGenderId: 1,
                stuBirthday: new Date(2017, 7, 7),
                stuGrade: 'grade',
                stuSchool_name: 'school name',
                parName: 'parent name',
                parCellphone: '13800010002',
                parWechat: '123456',
                parEmail: 'parent mail',
                parAddress: 'parent addr',
                relation: '父子',
                orgId: org_val,
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('add.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.data).to.not.empty;
        expect(jsonData.detail).to.be.equal('Ok');
        id_val = jsonData.data;
    });

    it('query.do - null values', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, act_path, 'query.do'),
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
            url: buildUrl(host, act_path, 'query.do'),
            dataType: 'json',
            data: {
                id: id_val,
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
            url: buildUrl(host, act_path, 'list.do'),
            dataType: 'json',
            data: {
                orgnizationId: org_val
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
            url: buildUrl(host, act_path, 'mod.do'),
            dataType: 'json',
            data: {
                id: id_val,
                code: codeVal + '_mod',
                type: '新招',
                startDate: new Date(2016, 6, 6),
                endDate: new Date(2017, 7, 7),
                oriPrice: 100000.79,
                discPrice: 88888.61,
                finalPrice: 88888.68,
                paid: 88888.68,
                courseType: 'course type mod',
                courseOriId: 1,
                courseSesId: 2,
                courseHours: 10,
                courseTimes: 5,
                stuName: 'student name mod',
                stuCode: codeVal + '_mod',
                stuGenderId: 1,
                stuBirthday: new Date(2017, 7, 7),
                stuGrade: 'grade',
                stuSchool_name: 'school name',
                parName: 'parent name mod',
                parCellphone: '13800010002',
                parWechat: '123456',
                parEmail: 'parent mail',
                parAddress: 'parent addr',
                relation: '父子',
                orgId: org_val,
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
            url: buildUrl(host, act_path, 'del.do'),
            dataType: 'json',
            data: {
                id: id_val
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
            url: buildUrl(host, path, 'logout.do'),
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