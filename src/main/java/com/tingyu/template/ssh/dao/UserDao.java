package com.tingyu.template.ssh.dao;

import java.util.List;

import com.tingyu.template.ssh.entities.User;
import com.tingyu.template.ssh.query.UserQuery;

/**
 * 
 * @author Essionshy
 *
 */
public interface UserDao {

	public void save(User user);
	
	public void delete(Integer id);
	
	public void update(User user);
	
	public User select(Integer id);
	
	public List<User> listByConditional(UserQuery userQuery);
}
