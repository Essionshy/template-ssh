package com.tingyu.template.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tingyu.template.ssh.dao.UserDao;
import com.tingyu.template.ssh.entities.User;
import com.tingyu.template.ssh.query.UserQuery;
import com.tingyu.template.ssh.service.UserService;

/**
 * 
 * @author Essionshy
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public User select(Integer id) {
		return userDao.select(id);
	}
	
	@Override
	public List<User> listByConditional(UserQuery userQuery) {
		List<User> list = userDao.listByConditional(userQuery);		
		return list;
	}
}
