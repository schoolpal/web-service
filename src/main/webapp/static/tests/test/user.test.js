/// <reference path="../typings/index.d.ts" />

describe('/ajax/user/ APIs', function() {

    this.timeout(0);

    var loginIdVal = sysLoginIdval;

	var loginNameVal = 'testLoginName' + dateNow.getTime();
	var phoneVal = '139' + dateNow.getTime();
	
	it('salt.do', function() {
		var xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, userApiPath, 'salt.do'),
			dataType : 'json'
		});

		expect(xhr.status).to.be.equal(200);
		var jsonData = xhr.responseJSON;
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		expect(jsonData.data.length).to.be.equal(4);
		salt = jsonData.data;
		expect(jsonData.detail).to.be.equal('Ok');
	});

    it('login.do - Empty values', function() {
        xhr = $.ajax({
            async : false,
            method : 'POST',
            url : buildUrl(host, userApiPath, 'login.do'),
            dataType : 'json',
            data : {
                loginName : '',
                mixedPWD : ''
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        expect(jsonData.code).to.be.equal(400);
    });

    it('login.do - Wrong credential', function() {
        xhr = $.ajax({
            async : false,
            method : 'POST',
            url : buildUrl(host, userApiPath, 'login.do'),
            dataType : 'json',
            data : {
                loginName : 'aaa',
                mixedPWD : 'bbb'
            }
        });

        expect(xhr.status).to.be.equal(200);
        var jsonData = xhr.responseJSON;
        expect(jsonData.code).to.be.equal(401);
    });

    it('login.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, userApiPath, 'login.do'),
			dataType : 'json',
			data : {
				loginName : loginIdVal,
				mixedPWD : MD5(MD5(MD5(passVal)) + salt)
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.be.empty;
		expect(jsonData.detail).to.be.equal('Ok');
	});

	it('status.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, userApiPath, 'status.do'),
			dataType : 'json'
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.be.empty;
		// expect(jsonData.detail).to.be.equal('Ok');
	});

    it('changePassword.do - empty values', function() {
        xhr = $.ajax({
            async : false,
            method : 'POST',
            url : buildUrl(host, userApiPath, 'changePassword.do'),
            dataType : 'json',
            data : {
                oriPass: '',
                newPass: '',
            }
        });

        expect(xhr.status).to.be.equal(200);
        jsonData = xhr.responseJSON;
        expect(jsonData.code).to.be.equal(400);
    });

    it('changePassword.do - same values', function() {
        xhr = $.ajax({
            async : false,
            method : 'POST',
            url : buildUrl(host, userApiPath, 'changePassword.do'),
            dataType : 'json',
            data : {
                oriPass: MD5(MD5(passVal)),
                newPass: MD5(MD5(passVal)),
            }
        });

        expect(xhr.status).to.be.equal(200);
        jsonData = xhr.responseJSON;
        expect(jsonData.code).to.be.equal(400);
    });

    it('changePassword.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, userApiPath, 'changePassword.do'),
			dataType : 'json',
			data : {
				oriPass: MD5(MD5(passVal)),
				newPass: MD5(MD5(passVal + 'Mod')),
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
			url : buildUrl(host, userApiPath, 'changePassword.do'),
			dataType : 'json',
			data : {
				oriPass: MD5(MD5(passVal + 'Mod')),
				newPass: MD5(MD5(passVal)),
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
			url : buildUrl(host, userApiPath, 'profile.do'),
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
			url : buildUrl(host, userApiPath, 'listFuncs.do'),
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
			url : buildUrl(host, userApiPath, 'listOrgs.do'),
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
			url : buildUrl(host, userApiPath, 'listRoles.do'),
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
			url : buildUrl(host, userApiPath, 'listFuncsByRole.do'),
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
			url : buildUrl(host, sysUserApiPath, 'add.do'),
			dataType : 'json',
			data : {
				loginName: loginNameVal,
				loginPass: MD5(MD5(passVal)),
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
			url : buildUrl(host, sysUserApiPath, 'query.do'),
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
			url : buildUrl(host, sysUserApiPath, 'checkName.do'),
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
			url : buildUrl(host, sysUserApiPath, 'mod.do'),
			dataType : 'json',
			data : {
				userId: userIdVal,
				loginPass: MD5(MD5(passVal)),
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
	});

	it('enable.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sysUserApiPath, 'enable.do'),
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
	});

	it('disable.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sysUserApiPath, 'enable.do'),
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
	});

	it('query.do - verify mod.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sysUserApiPath, 'query.do'),
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
			url : buildUrl(host, sysUserApiPath, 'del.do'),
			dataType : 'json',
			data : {
				id: userIdVal
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('del.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
	});


	it('logout.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, userApiPath, 'logout.do'),
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
