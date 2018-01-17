/// <reference path="../typings/index.d.ts" />

describe('/ajax/course/ APIs', function() {

    this.timeout(0);

    var loginIdVal = sysLoginIdval;
    var courseTypeIdVal = null;

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
			url : buildUrl(host, courseTypeApiPath, 'list.do'),
			dataType : 'json'
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		expect(jsonData.code).to.be.equal(200);
        expect(jsonData.data).to.not.empty;
        expect(jsonData.data.length).to.be.greaterThan(0);

        courseTypeIdVal = jsonData.data[0].id;
	});

    it('queryListByTypeId.do', function() {
        xhr = $.ajax({
            async : false,
            method : 'POST',
            url : buildUrl(host, courseSessionApiPath, 'queryListByTypeId.do'),
            dataType : 'json',
            data : {
				id: courseTypeIdVal
            }
        });

        expect(xhr.status).to.be.equal(200);
        jsonData = xhr.responseJSON;
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
