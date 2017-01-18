package com.school.db;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.schoolpal.db.inf.*;
import com.schoolpal.db.model.*;

public class TestTUserMapper {

	private static TUserMapper userDao = null;
	private static TOrgMapper orgDao = null;
	private static TRoleMapper roleDao = null;
	private static TFunctionMapper funcDao = null;

	private static String testUserLoginName = "sp-admin";
	private static String testUserLoginPass = "14e1b600b1fd579f47433b88e8d85291";
	private static String testUserOrgId = "16010100000001";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring4test.xml");
		userDao = (TUserMapper) context.getBean("TUserMapper");
		Assert.assertNotNull(userDao);
		orgDao = (TOrgMapper) context.getBean("TOrgMapper");
		Assert.assertNotNull(orgDao);
		roleDao = (TRoleMapper) context.getBean("TRoleMapper");
		Assert.assertNotNull(roleDao);
		funcDao = (TFunctionMapper) context.getBean("TFunctionMapper");
		Assert.assertNotNull(orgDao);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSelectByLoginName() {
		
		TUser user = userDao.selectOneByLoginName(testUserLoginName);
		Assert.assertNotNull(user);
		Assert.assertEquals(testUserLoginName, user.getcLoginname());
		Assert.assertEquals(testUserLoginPass, user.getcLoginpass());
		Assert.assertEquals(testUserOrgId, user.getcOrgId());
		
		TOrg org = orgDao.selectOneById(user.getcOrgId());
		Assert.assertNotNull(org);
		Assert.assertEquals(testUserOrgId, org.getcId());
		
		TOrg parentOrg = org.getParentOrg();
		Assert.assertNotNull(parentOrg);
		Assert.assertEquals(testUserOrgId, parentOrg.getcId());
		
		TOrg rootOrg = org.getParentOrg();
		Assert.assertNotNull(rootOrg);
		Assert.assertEquals(testUserOrgId, rootOrg.getcId());
		
		user.setOrg(org);
		
		Assert.assertNotNull(user.getcId());
		List<TRole> roles = roleDao.selectRolesByUserId(user.getcId());
		for(TRole role : roles){
			List<TFunction> funcs = funcDao.selectFuncsByRoleId(role.getcId());
			role.setWidgets(funcs);
		}
		Assert.assertTrue(roles.size() > 0);
		
		user.setRoles(roles);
	}

	@Test
	public final void testSelectPasswordByLoginName() {
		String password = userDao.selectPasswordByLoginName(testUserLoginName);
		Assert.assertEquals(testUserLoginPass, password);
	}

	@Test
	public final void testUpdateLastVisitByLoginName() {
		TUser user = userDao.selectOneByLoginName(testUserLoginName);
		Assert.assertNotNull(user);
		Date date = user.getcLastVisitTime();
		Assert.assertNotNull(date);
		
		String currentDateText = (new Date()).toString();
		userDao.updateLastVisitByLoginName(testUserLoginName, currentDateText);
		
		user = userDao.selectOneByLoginName(testUserLoginName);
		Assert.assertNotNull(user);
		Assert.assertTrue(user.getcLastVisitTime().compareTo(date) > 0);
		Assert.assertEquals(user.getcLastVisitIp(), currentDateText);
	}

}
