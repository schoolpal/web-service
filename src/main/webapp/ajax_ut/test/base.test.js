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

