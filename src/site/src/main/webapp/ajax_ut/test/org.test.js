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

describe('org api test', function() {
	
	var date = new Date()
	
	var host = window.location.protocol + "//" + window.location.host;
	var user_path = '/web/ajax/user/';
	var org_path = '/web/ajax/org/';

	var user = 'sp-admin';
	var pass = '123456';
	var salt = null;
	
	var orgId = null;
	var orgCode = 'test' + date.getTime();

	it('salt.do', function() {
		var xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, user_path, 'salt.do'),
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
			url : buildUrl(host, user_path, 'login.do'),
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

	it('add.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, org_path, 'add.do'),
			dataType : 'json',
			data : {
				id: null,
				name: 'testname',
				code: orgCode,
				parentId: '16010100000001',
				parentName: null,
				state: 'teststate',
				city: 'testcity',
				county: 'testcountry',
				state_code: '000000',
				city_code: '000000',
				county_code: '000000',
				address: 'testaddr',
				owner: 'testOwner',
				phone: 'testphone'
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('add.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		orgId = jsonData.data;
		// expect(jsonData.detail).to.be.equal('Ok');
	});

	var orgId = null;
	it('del.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, org_path, 'del.do'),
			dataType : 'json',
			data : {
				id: orgId,
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('del.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.be.empty;
		// expect(jsonData.detail).to.be.equal('Ok');
	});

	it('logout.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, user_path, 'logout.do'),
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
