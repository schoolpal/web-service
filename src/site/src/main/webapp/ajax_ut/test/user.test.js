/// <reference path="../typings/index.d.ts" />

var expect = chai.expect;

var host = 'http://localhost:8080';
var path = '/web/ajax/user/';

var user = 'sp-admin';
var pass = '123456';

function buildUrl(host, path, method) {
  return host + path + method;
}

function resDump(id, jsonData) {
  console.log(id + " code: " + jsonData.code);
  console.log(id + " data: " + jsonData.data);
  console.log(id + " detail: " + jsonData.detail);
}

describe('user api test', function () {

  var salt = null;

  it('salt.do', function () {
    var xhr = $.ajax({
      async: false,
      method: 'POST',
      url: buildUrl(host, path, 'salt.do'),
      dataType: 'json'
    });

    expect(xhr.status).to.be.equal(200);
    var jsonData = xhr.responseJSON;
    resDump('salt.do', jsonData);
    expect(jsonData.code).to.be.equal(200);
    expect(jsonData.data).to.not.empty;
    expect(jsonData.data.length).to.be.equal(4);
    salt = jsonData.data;
  });

  it('login.do', function () {
    xhr = $.ajax({
      async: false,
      method: 'POST',
      url: buildUrl(host, path, 'login.do'),
      dataType: 'json',
      data: {
        loginname: user,
        mixedPWD: MD5(MD5(MD5(pass)) + salt)
      }
    });

    expect(xhr.status).to.be.equal(200);
    jsonData = xhr.responseJSON;
    resDump('login.do', jsonData);
    expect(jsonData.code).to.be.equal(200);
    expect(jsonData.data).to.be.empty;
    expect(jsonData.detail).to.be.equal('ok');
  });

  it('logout.do', function () {
    xhr = $.ajax({
      async: false,
      method: 'POST',
      url: buildUrl(host, path, 'logout.do'),
      dataType: 'json'
    });

    expect(xhr.status).to.be.equal(200);
    jsonData = xhr.responseJSON;
    resDump('logout.do', jsonData);
    expect(jsonData.code).to.be.equal(200);
    expect(jsonData.data).to.be.empty;
    expect(jsonData.detail).to.be.equal('ok');
  });
});
