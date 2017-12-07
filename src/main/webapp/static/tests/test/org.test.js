/// <reference path="../typings/index.d.ts" />

describe('/ajax/org/ APIs', function() {
	
	var date = new Date()
	
	var host = window.location.protocol + "//" + window.location.host;
	var user_path = '/web/ajax/user/';
	var org_path = '/web/ajax/org/';
	var sys_org_path = '/web/ajax/sys/org/';

	var user = 'sp-admin';
	var pass = '123456';
	var salt = null;
	
	var orgId = null;
	var orgCode = 'test' + date.getTime();

	this.timeout(0);
	
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

	it('listRoles.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, org_path, 'listRoles.do'),
			dataType : 'json',
			data : {
				id: '16010100000001'
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('listRoles.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		// expect(jsonData.detail).to.be.equal('Ok');
	});

	it('listUsers.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, org_path, 'listUsers.do'),
			dataType : 'json',
			data : {
				id: '16010100000001'
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('listUsers.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		// expect(jsonData.detail).to.be.equal('Ok');
	});

	it('list.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sys_org_path, 'list.do'),
			dataType : 'json'
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('list.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		// expect(jsonData.detail).to.be.equal('Ok');
	});

	it('add.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sys_org_path, 'add.do'),
			dataType : 'json',
			data : {
				id: null,
				name: 'testName',
				code: orgCode,
				parentId: '16010100000001',
				parentName: null,
				state: 'testState',
				city: 'testCity',
				county: 'testCounty',
				stateCode: '000000',
				cityCode: '000000',
				countyCode: '000000',
				address: 'testAddr',
				owner: 'testOwner',
				phone: 'testPhone'
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

	it('query.do - verify add.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, org_path, 'query.do'),
			dataType : 'json',
			data : {
				id: orgId
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('query.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		expect(jsonData.data.cId).to.be.equal(orgId);
		expect(jsonData.data.cCode).to.be.equal(orgCode);
		expect(jsonData.data.cCounty).to.be.equal("testCounty");
		expect(jsonData.data.cCountyCode).to.be.equal("000000");
		// expect(jsonData.detail).to.be.equal('Ok');
	});

	it('mod.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sys_org_path, 'mod.do'),
			dataType : 'json',
			data : {
				id: orgId,
				name: 'testNameMod',
				code: orgCode + "Mod",
				parentId: '16010100000001',
				parentName: null,
				state: 'testStateMod',
				city: 'testCityMod',
				county: 'testCountyMod',
				stateCode: '000000Mod',
				cityCode: '000000Mod',
				countyCode: '000000Mod',
				address: 'testAddrMod',
				owner: 'testOwnerMod',
				phone: 'testphoneMod'
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
			url : buildUrl(host, org_path, 'query.do'),
			dataType : 'json',
			data : {
				id: orgId
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('query.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		expect(jsonData.data.cId).to.be.equal(orgId);
		expect(jsonData.data.cCode).to.be.equal(orgCode + "Mod");
		expect(jsonData.data.cCounty).to.be.equal("testCountyMod");
		expect(jsonData.data.cCountyCode).to.be.equal("000000Mod");
		// expect(jsonData.detail).to.be.equal('Ok');
	});
	
	it('del.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sys_org_path, 'del.do'),
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
