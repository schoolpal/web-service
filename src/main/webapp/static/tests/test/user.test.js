/// <reference path="../typings/index.d.ts" />

describe('/ajax/user/ APIs', function() {

	var host = window.location.protocol + "//" + window.location.host;
	var path = '/web/ajax/user/';
	var sys_path = '/web/ajax/sys/user/';

	var user = 'sp-admin';
	var pass = '123456';
	var salt = null;
	
	var userIdVal = null;
	var orgIdVal = null;
	var roleIdVal = null;

	var date = new Date()
	var loginNameVal = 'testLoginName' + date.getTime();
	var phoneVal = '139' + date.getTime();
	
	this.timeout(0);

	it('salt.do', function() {
		var xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, path, 'salt.do'),
			dataType : 'json'
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

    it('login.do - Empty data', function() {
        xhr = $.ajax({
            async : false,
            method : 'POST',
            url : buildUrl(host, path, 'login.do'),
            dataType : 'json',
            data : {
                loginName : '',
                mixedPWD : ''
            }
        });

        expect(xhr.status).to.be.equal(400);
    });

    it('login.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, path, 'login.do'),
			dataType : 'json',
			data : {
				loginName : user,
				mixedPWD : MD5(MD5(MD5(pass)) + salt)
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('login.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.be.empty;
		expect(jsonData.detail).to.be.equal('Ok');
	});

	it('status.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, path, 'status.do'),
			dataType : 'json'
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('status.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.be.empty;
		// expect(jsonData.detail).to.be.equal('Ok');
	});

	it('changePassword.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, path, 'changePassword.do'),
			dataType : 'json',
			data : {
				oriPass: MD5(MD5(pass)),
				newPass: MD5(MD5(pass + 'Mod')),
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('changePassword.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		expect(jsonData.data).to.be.equal(true);
	});

	it('changePassword.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, path, 'changePassword.do'),
			dataType : 'json',
			data : {
				oriPass: MD5(MD5(pass + 'Mod')),
				newPass: MD5(MD5(pass)),
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('changePassword.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		expect(jsonData.data).to.be.equal(true);
	});

	it('profile.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, path, 'profile.do'),
			dataType : 'json'
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('profile.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		orgIdVal = jsonData.data.cOrgId;
		// expect(jsonData.detail).to.be.equal('Ok');
	});

	it('listFuncs.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, path, 'listFuncs.do'),
			dataType : 'json'
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('listFuncs.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		// expect(jsonData.detail).to.be.equal('Ok');
	});

	it('listOrgs.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, path, 'listOrgs.do'),
			dataType : 'json'
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('listOrgs.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		// expect(jsonData.detail).to.be.equal('Ok');
	});

	it('listRoles.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, path, 'listRoles.do'),
			dataType : 'json'
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('listRoles.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		expect(jsonData.data[0].cId).to.not.empty;
		roleIdVal = jsonData.data[0].cId;
		// expect(jsonData.detail).to.be.equal('Ok');
	});

	it('listFuncsByRole.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, path, 'listFuncsByRole.do'),
			dataType : 'json',
			data : {
				id : roleIdVal
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('listFuncsByRole.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		// expect(jsonData.detail).to.be.equal('Ok');
	});

	it('add.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sys_path, 'add.do'),
			dataType : 'json',
			data : {
				loginName: loginNameVal,
				loginPass: MD5(MD5(pass)),
				realName: 'testRealName',
				nickName: 'testNickName',
				phone: phoneVal,
				email: 'test@mail.com',
				im: '13678990',
				orgId: orgIdVal,
				roles: roleIdVal
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('add.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		userIdVal = jsonData.data;
		expect(jsonData.detail).to.be.equal('Ok');
	});

	it('query.do - verify add.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sys_path, 'query.do'),
			dataType : 'json',
			data : {
				id: userIdVal
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('query.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
	});

	it('checkName.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sys_path, 'checkName.do'),
			dataType : 'json',
			data : {
				loginName: loginNameVal
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('checkName.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
	});

	it('mod.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sys_path, 'mod.do'),
			dataType : 'json',
			data : {
				userId: userIdVal,
				loginPass: MD5(MD5(pass)),
				realName: 'testRealNameMod',
				nickName: 'testNickNameMod',
				phone: phoneVal + 'Mod',
				email: 'test@mail.comMod',
				im: '13678990Mod',
				orgId: orgIdVal,
				roles: roleIdVal
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('mod.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.be.empty;
		expect(jsonData.detail).to.be.equal('Ok');
	});

	it('enable.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sys_path, 'enable.do'),
			dataType : 'json',
			data : {
				id: userIdVal,
				enabled: true
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('enable.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.be.empty;
		expect(jsonData.detail).to.be.equal('Ok');
	});

	it('disable.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sys_path, 'enable.do'),
			dataType : 'json',
			data : {
				id: userIdVal, 
				enabled: false
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('disable.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.be.empty;
		expect(jsonData.detail).to.be.equal('Ok');
	});

	it('query.do - verify mod.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sys_path, 'query.do'),
			dataType : 'json',
			data : {
				id: userIdVal
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('query.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
	});
	
	it('del.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sys_path, 'del.do'),
			dataType : 'json',
			data : {
				id: userIdVal
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('del.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.be.empty;
		expect(jsonData.detail).to.be.equal('Ok');
	});


	it('logout.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, path, 'logout.do'),
			dataType : 'json'
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('logout.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.be.empty;
		expect(jsonData.detail).to.be.equal('Ok');
	});
});
