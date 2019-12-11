package com.tingyu.template.ssh.service.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tingyu.template.ssh.entities.User;
import com.tingyu.template.ssh.query.UserQuery;
import com.tingyu.template.ssh.service.UserService;
/**
 * 
 * @author Essionshy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceTest {
	
	private static Logger logger=LoggerFactory.getLogger(UserServiceTest.class);
	@Autowired
	UserService userService;
	/**
	 * org.hibernate.HibernateException: Could not obtain transaction-synchronized Session for current thread
	 * Method 需要在spring配置中声明事务
	 */
	@Test
	public void testSave() {
		logger.debug("---------------testSave-------------");
		User user = new User();
		user.setUsername("z3").setEmail("z3@163.com")
			.setPhone("183124232345").setAddress("四川");
		userService.save(user);
	}

	@Test
	public void testDelete() {
		logger.debug("---------------testDelete-------------");
		userService.delete(2);
	}

	@Test
	public void testUpdate() {
		logger.debug("---------------testUpdate-------------");
		User user = userService.select(1);
		user.setAddress("广西梧州").setBirth(new Date());
		userService.update(user);
	}

	@Test
	public void testSelect() {
		logger.debug("---------------testSelectById-------------");
		User user = userService.select(3);
		logger.debug("=========Query Result："+user);
	}
	@Test
	public void testListByConditional() {
		logger.debug("---------------testListByConditional-------------");		
		UserQuery userQuery = new UserQuery();
		userQuery.setUsername("li");
		List<User> list = userService.listByConditional(userQuery);
		for (User user : list) {
			System.out.println(""+user);
		}
	}	
}
