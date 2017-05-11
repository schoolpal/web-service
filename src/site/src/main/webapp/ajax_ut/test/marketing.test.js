/// <reference path="../typings/index.d.ts" />

describe('/ajax/activity/ APIs', function() {

	var host = window.location.protocol + "//" + window.location.host;
	var path = '/web/ajax/user/';
	var act_path = '/web/ajax/mkt/';

	var user = 'sp-crm';
	var pass = '123456';
	var salt = null;
	
	var id_val = 0;
	var org_val = 16122700000011;
	
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

	it('listActivities.do', function() {
		var xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, act_path, 'listActivities.do'),
			dataType : 'json',
			data: {
				orgId: org_val
			}
		});

		expect(xhr.status).to.be.equal(200);
		var jsonData = xhr.responseJSON;
		resDump('listActivities.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
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
