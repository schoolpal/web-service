/// <reference path="../typings/index.d.ts" />

describe('/ajax/role/ APIs', function() {

    this.timeout(0);

    var loginIdVal = sysLoginIdval;
    var orgIdVal = '16010100000001';

	it('salt.do', function() {
		var xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, userApiPath, 'salt.do'),
			dataType : 'json'
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
			async : false,
			method : 'POST',
			url : buildUrl(host, userApiPath, 'login.do'),
			dataType : 'json',
			data : {
				loginName : loginIdVal,
				mixedPWD : MD5(MD5(MD5(passVal)) + saltVal)
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('login.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.be.empty;
		expect(jsonData.detail).to.be.equal('Ok');
	});

	it('list.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sysRoleApiPath, 'list.do'),
			dataType : 'json',
			data : {
				id: orgIdVal
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('list.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		//expect(jsonData.data).to.be.empty;
		// expect(jsonData.detail).to.be.equal('Ok');
	});
	
	it('add.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sysRoleApiPath, 'add.do'),
			dataType : 'json',
			data : {
				id: null,
				orgId: orgIdVal,
				strFuncIds: "1,7",
				rankId: 1,
				name: "testName",
				desc: "testDesc"
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('add.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		roleIdVal = jsonData.data;
	});

	it('auth.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sysRoleApiPath, 'auth.do'),
			dataType : 'json',
			data : {
				id: roleIdVal,
				funcIds: '1,1-1,1-1-1,1-1-2,1-1-3'
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('auth.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
	});

	it('query.do - verify add.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, roleApiPath, 'query.do'),
			dataType : 'json',
			data : {
				id: roleIdVal
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('query.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		expect(jsonData.data.cId).to.be.equal(roleIdVal);
		expect(jsonData.data.cName).to.be.equal("testName");
		expect(jsonData.data.cDesc).to.be.equal("testDesc");
	});

	it('mod.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sysRoleApiPath, 'mod.do'),
			dataType : 'json',
			data : {
				id: roleIdVal,
				orgId: orgIdVal,
				strFuncIds: "7",
				rankId: 4,
				name: "testNameMod",
				desc: "testDescMod"
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('mod.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		//expect(jsonData.data).to.be.empty;
		// expect(jsonData.detail).to.be.equal('Ok');
	});
	
	it('query.do - verify mod.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, roleApiPath, 'query.do'),
			dataType : 'json',
			data : {
				id: roleIdVal
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('query.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		expect(jsonData.data.cId).to.be.equal(roleIdVal);
		expect(jsonData.data.cName).to.be.equal("testNameMod");
		expect(jsonData.data.cDesc).to.be.equal("testDescMod");
	});
	
	it('del.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sysRoleApiPath, 'del.do'),
			dataType : 'json',
			data : {
				id: roleIdVal,
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('del.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
	});

	it('ranks.do', function() {
		var xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, roleApiPath, 'ranks.do'),
			dataType : 'json'
		});

		expect(xhr.status).to.be.equal(200);
		var jsonData = xhr.responseJSON;
		resDump('ranks.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
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
