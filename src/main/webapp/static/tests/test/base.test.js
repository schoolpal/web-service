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

var host = window.location.protocol + "//" + window.location.host;
var dateNow = new Date()

var sysOrgApiPath = '/web/ajax/sys/org/';
var sysRoleApiPath = '/web/ajax/sys/role/';
var sysUserApiPath = '/web/ajax/sys/user/';

var orgApiPath = '/web/ajax/org/';
var funcApiPath = '/web/ajax/func/';
var userApiPath = '/web/ajax/user/';
var roleApiPath = '/web/ajax/role/';

var mktApiPath = '/web/ajax/mkt/';
var actApiPath = '/web/ajax/mkt/activity/';
var leadsApiPath = '/web/ajax/mkt/leads/';
var opporApiPath = '/web/ajax/sales/oppor/';
var contactApiPath = '/web/ajax/contact/';

var salesContractApiPath = '/web/ajax/sales/contract/';
var salesStudentApiPath = '/web/ajax/sales/customer/student/';
var salesParentApiPath = '/web/ajax/sales/customer/parent/';

var serviceContractApiPath = '/web/ajax/service/contract/';
var serviceStudentApiPath = '/web/ajax/service/customer/student/';
var serviceParentApiPath = '/web/ajax/service/customer/parent/';

var sysLoginIdval = 'sp-admin';
var crmLoginIdVal = 'rise-01';

var userIdVal = null;
var passVal = '123456';
var saltVal = null;

var orgIdVal = null;
var orgCodeVal = dateNow.getTime().toString();

var roleIdVal = null;

var leadsIdVal = null;
var studentIdVal = null;
var parentIdVal = null;
var contactIdVal = null;
var contractIdVal = null;

