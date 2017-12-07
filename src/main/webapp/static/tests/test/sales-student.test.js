/// <reference path="../typings/index.d.ts" />

describe('/ajax/sales/customer/student APIs', function() {

	var host = window.location.protocol + "//" + window.location.host;
	var path = '/web/ajax/user/';
	var act_path = '/web/ajax/sales/customer/student/';

	var user = 'sp-crm';
	var pass = '123456';
	var salt = null;
	
	var id_val = 0;
	var org_val = 16122700000009;

	var date = new Date()
	var codeVal = date.getTime();

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

	it('add.do', function() {
		var xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, act_path, 'add.do'),
			dataType : 'json',
			data : {
			    code: codeVal, 
			    name: 'parent name', 
			    genderId: 1, 
			    idType: 1,
			    idCode: codeVal,
			    birthday: new Date(1981,12,12),
			    schoolGrade: 'school grade',
			    classGrade: 'class grade',
			    schoolName: 'school name',
			}
		});

		expect(xhr.status).to.be.equal(200);
		var jsonData = xhr.responseJSON;
		resDump('add.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		expect(jsonData.detail).to.be.equal('Ok');
		id_val = jsonData.data;
	});

	it('query.do', function() {
		var xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, act_path, 'query.do'),
			dataType : 'json',
			data : {
				id: id_val,
			}
		});

		expect(xhr.status).to.be.equal(200);
		var jsonData = xhr.responseJSON;
		resDump('query.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		expect(jsonData.detail).to.be.equal('Ok');
	});
	
	it('queryByCode.do', function() {
		var xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, act_path, 'queryByCode.do'),
			dataType : 'json',
			data : {
				code: codeVal,
			}
		});

		expect(xhr.status).to.be.equal(200);
		var jsonData = xhr.responseJSON;
		resDump('queryByCode.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		expect(jsonData.detail).to.be.equal('Ok');
	});
	
	it('list.do', function() {
		var xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, act_path, 'list.do'),
			dataType : 'json',
			data: {
				orgnizationId: org_val
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
			async : false,
			method : 'POST',
			url : buildUrl(host, act_path, 'mod.do'),
			dataType : 'json',
			data : {
				id: id_val,
			    code: codeVal, 
			    name: 'parent name mod', 
			    genderId: 1, 
			    idType: 1,
			    idCode: codeVal + ' mod',
			    birthday: new Date(1981,12,14),
			    schoolGrade: 'school grade mod',
			    classGrade: 'class grade mod',
			    schoolName: 'school name mod',
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
			async : false,
			method : 'POST',
			url : buildUrl(host, act_path, 'del.do'),
			dataType : 'json',
			data : {
				id : id_val
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
