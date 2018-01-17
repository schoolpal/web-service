/// <reference path="../typings/index.d.ts" />

describe('/ajax/service/contract/ APIs', function() {

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

    it('add.do - null values', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, serviceContractApiPath, 'add.do'),
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
            url: buildUrl(host, serviceContractApiPath, 'add.do'),
            dataType: 'json',
            data: {
                code: orgCodeVal,
                type: '新招',
                startDate: new Date(2016, 6, 6),
                endDate: new Date(2017, 7, 7),
                oriPrice: 100000.79,
                discPrice: 88888.61,
                finalPrice: 88888.68,
                paid: 88888.68,
                courseId: '16122700000002',
                courseName: '默认产品2018第一期课程',
                courseType: '默认类型',
                courseHours: 10,
                courseTimes: 5,
                stuName: 'student name',
                stuCode: orgCodeVal,
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
                orgId: orgIdVal,
                oriId: '16122700000000',
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
            url: buildUrl(host, serviceContractApiPath, 'query.do'),
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
            url: buildUrl(host, serviceContractApiPath, 'query.do'),
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
        studentIdVal = jsonData.data.stuId;
    });

    it('queryListByStudentId.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, serviceContractApiPath, 'queryListByStudentId.do'),
            dataType: 'json',
            data: {
                id: studentIdVal
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('list.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.data).to.not.empty;
    });

    it('queryListByStudentId.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, serviceParentApiPath, 'queryListByStudentId.do'),
            dataType: 'json',
            data: {
                id: studentIdVal
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        resDump('list.do', jsonData);
        expect(jsonData.code).to.be.equal(200);
        expect(jsonData.data).to.not.empty;
    });

    it('list.do', function() {
        var xhr = $.ajax({
            async: false,
            method: 'POST',
            url: buildUrl(host, serviceContractApiPath, 'list.do'),
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
            url: buildUrl(host, serviceContractApiPath, 'mod.do'),
            dataType: 'json',
            data: {
                id: userIdVal,
                code: orgCodeVal + '_mod',
                type: '新招',
                startDate: new Date(2016, 6, 6),
                endDate: new Date(2017, 7, 7),
                oriPrice: 100000.79,
                discPrice: 88888.61,
                finalPrice: 88888.68,
                paid: 88888.68,
                courseId: '16122700000002',
                courseName: '默认产品2018第一期课程',
                courseType: '默认类型',
                courseHours: 10,
                courseTimes: 5,
                stuName: 'student name mod',
                stuCode: orgCodeVal + '_mod',
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
                orgId: orgIdVal,
                oriId: '16122700000000',
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
            url: buildUrl(host, serviceContractApiPath, 'del.do'),
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