/// <reference path="../typings/index.d.ts" />

var expect = chai.expect;

function buildUrl(host, path, method) {
	return host + path + method;
}

function resDump(id, jsonData) {
	console.log(id + " code: " + jsonData.code);
	console.log(id + " data: " + jsonData.data);
	console.log(id + " detail: " + jsonData.detail);
}

describe('User APIs', function() {

	var host = window.location.protocol + "//" + window.location.host;
	var path = '/web/ajax/user/';

	var user = 'sp-admin';
	var pass = '123456';
	var salt = null;

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

	it('permissions.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, path, 'permissions.do'),
			dataType : 'json'
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('permissions.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		// expect(jsonData.detail).to.be.equal('Ok');
	});

	it('orglist.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, path, 'orglist.do'),
			dataType : 'json'
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('orglist.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		// expect(jsonData.detail).to.be.equal('Ok');
	});

	it('rolelist.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, path, 'rolelist.do'),
			dataType : 'json',
			data : {
				orgId : '16010100000001'
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('rolelist.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		// expect(jsonData.detail).to.be.equal('Ok');
	});

	it('funclist.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, path, 'funclist.do'),
			dataType : 'json',
			data : {
				roleId : '16010100000001'
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('funclist.do', jsonData);
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
