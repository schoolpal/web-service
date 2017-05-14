/// <reference path="../typings/index.d.ts" />

describe('/ajax/mkt/leads/ APIs', function() {

	var host = window.location.protocol + "//" + window.location.host;
	var path = '/web/ajax/user/';
	var leads_path = '/web/ajax/mkt/leads/';

	var user = 'sp-crm';
	var pass = '123456';
	var salt = null;
	
	var leads_id_val = "";
	var student_id_val = "";
	var parent_id_val = "";
	var org_val = 16122700000009;
	
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
	
	it('listSources.do', function() {
		var xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, leads_path, 'listSources.do'),
			dataType : 'json',
		});

		expect(xhr.status).to.be.equal(200);
		var jsonData = xhr.responseJSON;
		resDump('listSources.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.detail).to.be.equal('Ok');
		expect(jsonData.data).to.not.empty;
	});

	it('listStages.do', function() {
		var xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, leads_path, 'listStages.do'),
			dataType : 'json',
		});

		expect(xhr.status).to.be.equal(200);
		var jsonData = xhr.responseJSON;
		resDump('listStages.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.detail).to.be.equal('Ok');
		expect(jsonData.data).to.not.empty;
	});

	it('listStatus.do', function() {
		var xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, leads_path, 'listStatus.do'),
			dataType : 'json',
		});

		expect(xhr.status).to.be.equal(200);
		var jsonData = xhr.responseJSON;
		resDump('listStatus.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.detail).to.be.equal('Ok');
		expect(jsonData.data).to.not.empty;
	});

	it('list.do', function() {
		var xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, leads_path, 'list.do'),
			dataType : 'json',
			data: {
				orgId: org_val
			}
		});

		expect(xhr.status).to.be.equal(200);
		var jsonData = xhr.responseJSON;
		resDump('list.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		expect(jsonData.detail).to.be.equal('Ok');
	});
	
	it('add.do', function() {
		var xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, leads_path, 'add.do'),
			dataType : 'json',
			data : {
				orgnizationId: org_val,
				source: 1,
				channel: 2,
				stage: 3,
				status: 4,
			    studentName: 'student name',
			    gender: 1,
			    age: 3,
			    classGrade: 1,
			    schoolName: 'school name',
			    parentName: 'parent name',
			    relation: 'father',
			    cellphone: 13800010002,
			    weichat: '13670804',
			    address: 'address'
			}
		});

		expect(xhr.status).to.be.equal(200);
		var jsonData = xhr.responseJSON;
		resDump('add.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		expect(jsonData.detail).to.be.equal('Ok');
		leads_id_val = jsonData.data.leads_id;
		parent_id_val = jsonData.data.parent_id;
		student_id_val = jsonData.data.student_id;
	});

	it('query.do', function() {
		var xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, leads_path, 'query.do'),
			dataType : 'json',
			data: {
				id: leads_id_val
			}
		});

		expect(xhr.status).to.be.equal(200);
		var jsonData = xhr.responseJSON;
		resDump('query.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		expect(jsonData.detail).to.be.equal('Ok');
	});
	
	it('mod.do', function() {
		var xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, leads_path, 'mod.do'),
			dataType : 'json',
			data : {
				leadsId : leads_id_val,
				parentId : parent_id_val,
				studentId : student_id_val,
				orgnizationId: org_val,
				source: 4,
				channel: 3,
				stage: 2,
				status: 1,
			    studentName: 'student name mod',
			    gender: 2,
			    age: 4,
			    classGrade: 2,
			    schoolName: 'school name mod',
			    parentName: 'parent name mod',
			    relation: 'father mod',
			    cellphone: 13800010009,
			    weichat: '13670808',
			    address: 'address mod'
			}
		});

		expect(xhr.status).to.be.equal(200);
		var jsonData = xhr.responseJSON;
		resDump('mod.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.detail).to.be.equal('Ok');
	});

//	it('del.do', function() {
//		var xhr = $.ajax({
//			async : false,
//			method : 'POST',
//			url : buildUrl(host, leads_path, 'del.do'),
//			dataType : 'json',
//			data : {
//				id : leads_id_val
//			}
//		});
//
//		expect(xhr.status).to.be.equal(200);
//		var jsonData = xhr.responseJSON;
//		resDump('del.do', jsonData);
//		expect(jsonData.code).to.be.equal(200);
//		expect(jsonData.detail).to.be.equal('Ok');
//	});

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
