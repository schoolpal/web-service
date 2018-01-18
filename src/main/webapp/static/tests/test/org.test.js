/// <reference path="../typings/index.d.ts" />

describe('/ajax/org/ APIs', function() {

    this.timeout(0);

    var loginIdVal = sysLoginIdval;

    var dateNow = new Date()
    var orgCodeVal = dateNow.getTime().toString();

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

    it('listRoles.do - null value', function() {
        xhr = $.ajax({
            async : false,
            method : 'POST',
            url : buildUrl(host, orgApiPath, 'listRoles.do'),
            dataType : 'json',
            data : {
                id: null
            }
        });

        expect(xhr.status).to.be.equal(200);
        jsonData = xhr.responseJSON;
        resDump('listRoles.do', jsonData);
        expect(jsonData.code).to.be.equal(400);
        expect(jsonData.data).to.not.empty;
        // expect(jsonData.detail).to.be.equal('Ok');
    });

    it('listRoles.do - empty value', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, orgApiPath, 'listRoles.do'),
			dataType : 'json',
			data : {
				id: ''
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('listRoles.do', jsonData);
		expect(jsonData.code).to.be.equal(400);
		expect(jsonData.data).to.not.empty;
		// expect(jsonData.detail).to.be.equal('Ok');
	});

    it('listRoles.do', function() {
        xhr = $.ajax({
            async : false,
            method : 'POST',
            url : buildUrl(host, orgApiPath, 'listRoles.do'),
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
			url : buildUrl(host, orgApiPath, 'listUsers.do'),
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
			url : buildUrl(host, sysOrgApiPath, 'list.do'),
			dataType : 'json'
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		// expect(jsonData.detail).to.be.equal('Ok');
	});

    it('add.do - empty values', function() {
        xhr = $.ajax({
            async : false,
            method : 'POST',
            url : buildUrl(host, sysOrgApiPath, 'add.do'),
            dataType : 'json',
            data : {
                code: '',
                parentId: ''
            }
        });

        expect(xhr.status).to.be.equal(200);
        jsonData = xhr.responseJSON;
        expect(jsonData.code).to.be.equal(400);
    });

    it('add.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sysOrgApiPath, 'add.do'),
			dataType : 'json',
			data : {
				id: null,
				name: 'testName',
				code: orgCodeVal,
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
		orgIdVal = jsonData.data;
	});

	it('query.do - verify add.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, orgApiPath, 'query.do'),
			dataType : 'json',
			data : {
				id: orgIdVal
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('query.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		expect(jsonData.data.cId).to.be.equal(orgIdVal);
		expect(jsonData.data.cCode).to.be.equal(orgCodeVal);
		expect(jsonData.data.cCounty).to.be.equal("testCounty");
		expect(jsonData.data.cCountyCode).to.be.equal("000000");
	});

    it('mod.do - empty values', function() {
        xhr = $.ajax({
            async : false,
            method : 'POST',
            url : buildUrl(host, sysOrgApiPath, 'mod.do'),
            dataType : 'json',
            data : {
                id: '',
                code: '',
                parentId: ''
            }
        });

        expect(xhr.status).to.be.equal(200);
        jsonData = xhr.responseJSON;
        expect(jsonData.code).to.be.equal(400);
    });

	it('mod.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sysOrgApiPath, 'mod.do'),
			dataType : 'json',
			data : {
				id: orgIdVal,
				name: 'testNameMod',
				code: orgCodeVal + "Mod",
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
			url : buildUrl(host, orgApiPath, 'query.do'),
			dataType : 'json',
			data : {
				id: orgIdVal
			}
		});

		expect(xhr.status).to.be.equal(200);
		jsonData = xhr.responseJSON;
		resDump('query.do', jsonData);
		expect(jsonData.code).to.be.equal(200);
		expect(jsonData.data).to.not.empty;
		expect(jsonData.data.cId).to.be.equal(orgIdVal);
		expect(jsonData.data.cCode).to.be.equal(orgCodeVal + "Mod");
		expect(jsonData.data.cCounty).to.be.equal("testCountyMod");
		expect(jsonData.data.cCountyCode).to.be.equal("000000Mod");
		// expect(jsonData.detail).to.be.equal('Ok');
	});
	
	it('del.do', function() {
		xhr = $.ajax({
			async : false,
			method : 'POST',
			url : buildUrl(host, sysOrgApiPath, 'del.do'),
			dataType : 'json',
			data : {
				id: orgIdVal,
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
