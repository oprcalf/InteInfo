package com.InteInfo.test;

import org.apache.log4j.Logger;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.InteInfo.server.IUserService;

public class testSpring {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(testSpring.class);

	@Test
	public void test() {

		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "classpath:applicationcontext.xml", "classpath:spring-hibernate.xml" });
		IUserService us = (IUserService) ac.getBean("userServiceImpl");
		logger.info("测试");
		us.getUserByStaffID("op838");

		// MD5 md5 = new MD5();
		// md5.getMDThirtytwo("zhujie13923529859");
		// logger.info(md5.getMDThirtytwo("zhujie13923529859"));
	}

}
