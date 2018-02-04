/// <reference path="../typings/index.d.ts" />

describe('/ajax/sales/oppor/ APIs', function() {

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

    it('source/list.do - new', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, leadsApiPath, 'source/list.do'),
            dataType: 'json',
            data: {
                typeId: 2,
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('source/list.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.detail).to.be.equal('Ok');
        expect(jsonData.data).to.not.empty;
    });

    //	it('source/list.do - renew', function() {
    //		var xhr = $.ajax({
    //			async : false,
    //			method : 'POST',
    //			url : buildUrl(host, leads_path, 'source/list.do'),
    //			dataType : 'json',
    //			data : {
    //				typeId : 3,
    //			}
    //		});
    //
    //		expect(xhr.status).to.be.equal(200);
    //		var jsonData = xhr.responseJSON;
    //		resDump('source/list.do', jsonData);
    //		expect(jsonData.code).to.be.equal(200);
    //		expect(jsonData.detail).to.be.equal('Ok');
    //		expect(jsonData.data).to.not.empty;
    //	});

    it('stage/list.do - new', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, leadsApiPath, 'stage/list.do'),
            dataType: 'json',
            data: {
                typeId: 2,
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('stage/list.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.detail).to.be.equal('Ok');
        expect(jsonData.data).to.not.empty;
    });

    it('stage/list.do - renew', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, leadsApiPath, 'stage/list.do'),
            dataType: 'json',
            data: {
                typeId: 3,
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('stage/list.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.detail).to.be.equal('Ok');
        expect(jsonData.data).to.not.empty;
    });

    it('status/list.do - new', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, leadsApiPath, 'status/list.do'),
            dataType: 'json',
            data: {
                typeId: 2,
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('status/list.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.detail).to.be.equal('Ok');
        expect(jsonData.data).to.not.empty;
    });

    it('status/list.do - renew', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, leadsApiPath, 'status/list.do'),
            dataType: 'json',
            data: {
                typeId: 3,
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('status/list.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.detail).to.be.equal('Ok');
        expect(jsonData.data).to.not.empty;
    });

    it('add.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, opporApiPath, 'add.do'),
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
            url: buildUrl(host, opporApiPath, 'add.do'),
            dataType: 'json',
            data: {
                typeId: 2,
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
                wechat: '',
                address: '',
                courseId: '16122700000002',
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

    it('query.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, opporApiPath, 'query.do'),
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
            url: buildUrl(host, opporApiPath, 'list.do'),
            dataType: 'json',
            data: {
                orgId: orgIdVal,
                typeId: 2
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('list.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.data).to.not.empty;
        expect(jsonData.detail).to.be.equal('Ok');
    });

    it('listAssignableUsers.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, leadsApiPath, 'listAssignableUsers.do'),
            dataType: 'json',
            data: {
                orgId: orgIdVal
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.data).to.not.empty;
    });

    it('mod.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, opporApiPath, 'mod.do'),
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
            url: buildUrl(host, opporApiPath, 'assign.do'),
            dataType: 'json',
            data: {
                id: leadsIdVal,
                assigneeId: '16122700000048'
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('assign.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
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