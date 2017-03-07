/// <reference path="../typings/index.d.ts" />

describe('/ajax/user/ APIs', function() {

	var host = window.location.protocol + "//" + window.location.host;
	var path = '/web/ajax/user/';

	var user = 'sp-admin';
	var pass = '123456';
	var salt = null;
	
	var roleId = null;

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

	it('login.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, path, 'login.do'),
			dataType : 'json',
			data : {
				loginname : user,
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
		roleId = jsonData.data[0].cId;
		// expect(jsonData.detail).to.be.equal('Ok');
	});

	it('listFuncsByRole.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, path, 'listFuncsByRole.do'),
			dataType : 'json',
			data : {
				id : roleId
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('listFuncsByRole.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		// expect(jsonData.detail).to.be.equal('Ok');
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
