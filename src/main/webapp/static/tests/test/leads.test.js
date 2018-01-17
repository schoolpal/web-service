/// <reference path="../typings/index.d.ts" />

describe('/ajax/mkt/leads/ APIs', function() {

    var loginIdVal = crmLoginIdVal;

    this.timeout(0);

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

    it('source/list.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, leadsApiPath, 'source/list.do'),
            dataType: 'json',
            data: {
                typeId: 1,
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('source/list.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.detail).to.be.equal('Ok');
        expect(jsonData.data).to.not.empty;
    });

    it('stage/list.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, leadsApiPath, 'stage/list.do'),
            dataType: 'json',
            data: {
                typeId: 1,
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('stage/list.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.detail).to.be.equal('Ok');
        expect(jsonData.data).to.not.empty;
    });

    it('status/list.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, leadsApiPath, 'status/list.do'),
            dataType: 'json',
            data: {
                typeId: 1,
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('status/list.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.detail).to.be.equal('Ok');
        expect(jsonData.data).to.not.empty;
    });

    it('gender/list.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, mktApiPath, 'gender/list.do'),
            dataType: 'json',
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('listGenders.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.detail).to.be.equal('Ok');
        expect(jsonData.data).to.not.empty;
    });

    it('relation/list.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, mktApiPath, 'relation/list.do'),
            dataType: 'json',
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('relation/list.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.detail).to.be.equal('Ok');
        expect(jsonData.data).to.not.empty;
    });

    it('add.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, leadsApiPath, 'add.do'),
            dataType: 'json',
            data: {
                organizationId: orgIdVal,
                sourceId: 1,
                channelId: '16122700000076',
                stageId: 3,
                statusId: 4,
                studentName: 'student name',
                studentGender: '男',
                age: 3,
                classGrade: 1,
                schoolName: 'school name',
                parentName: 'parent name',
                relation: 'father',
                cellphone: 1,
                wechat: 'wechat',
                address: 'addr',
                courseType: null,
                courseName: null,
                note: ''
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('add.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.data).to.not.empty;
        expect(jsonData.detail).to.be.equal('Ok');
        leadsIdVal = jsonData.data;
    });

    it('query.do - null value', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, leadsApiPath, 'query.do'),
            dataType: 'json',
            data: {
                id: null
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
            url: buildUrl(host, leadsApiPath, 'query.do'),
            dataType: 'json',
            data: {
                id: leadsIdVal
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('query.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.data).to.not.empty;
        expect(jsonData.detail).to.be.equal('Ok');
        leadsIdVal = jsonData.data.id;
        parentIdVal = jsonData.data.parentId;
        studentIdVal = jsonData.data.studentId;
    });

    it('list.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, leadsApiPath, 'list.do'),
            dataType: 'json',
            data: {
                orgId: orgIdVal
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
            url: buildUrl(host, leadsApiPath, 'mod.do'),
            dataType: 'json',
            data: {
                id: leadsIdVal,
                organizationId: orgIdVal,
                sourceId: 1,
                channelId: '16122700000076',
                stageId: 3,
                statusId: 4,
                studentName: 'student name mod',
                studentGender: '男',
                age: 3,
                classGrade: 1,
                schoolName: 'school name mod',
                parentName: 'parent name mod',
                relation: 'father mod',
                cellphone: 1,
                wechat: 'mod',
                address: 'mod',
                courseType: null,
                courseName: null,
                note: 'mod'
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('mod.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.detail).to.be.equal('Ok');
    });

    it('assign.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, leadsApiPath, 'assign.do'),
            dataType: 'json',
            data: {
                id: leadsIdVal,
                assigneeId: '16122700000036'
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('assign.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
    });

    it('convert.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, leadsApiPath, 'convert.do'),
            dataType: 'json',
            data: {
                id: leadsIdVal,
                assigneeId: '16122700000036'
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('convert.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
    });

    it('contact/approach - list.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, contactApiPath + 'approach/', 'list.do'),
            dataType: 'json'
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('list.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.detail).to.be.equal('Ok');
        expect(jsonData.data).to.not.empty;
    });

    it('contact - add.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, contactApiPath, 'add.do'),
            dataType: 'json',
            data: {
                leadsId: leadsIdVal,
                approachId: '1',
                datetime: new Date(),
                summary: 'Summary ... '
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('add.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.detail).to.be.equal('Ok');
        expect(jsonData.data).to.not.empty;
        contactIdVal = jsonData.data;
    });

    it('contact - query.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, contactApiPath, 'query.do'),
            dataType: 'json',
            data: {
                id: contactIdVal,
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('query.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.detail).to.be.equal('Ok');
        expect(jsonData.data).to.not.empty;
    });

    it('contact - list.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, contactApiPath, 'list.do'),
            dataType: 'json',
            data: {
                leadsId: leadsIdVal,
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('list.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.detail).to.be.equal('Ok');
        expect(jsonData.data).to.not.empty;
    });

    it('contact - mod.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, contactApiPath, 'mod.do'),
            dataType: 'json',
            data: {
                id: contactIdVal,
                summary: 'Summary ... mod'
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('mod.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.detail).to.be.equal('Ok');
    });

    it('contact - del.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, contactApiPath, 'del.do'),
            dataType: 'json',
            data: {
                id: contactIdVal,
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('mod.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.detail).to.be.equal('Ok');
    });

    it('del.do - null value', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, leadsApiPath, 'del.do'),
            dataType: 'json',
            data: {
                id: null
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('del.do', jsonData);
        expect(jsonData.code).to.be.equal(400);
    });

    it('del.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, leadsApiPath, 'del.do'),
            dataType: 'json',
            data: {
                id: leadsIdVal
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