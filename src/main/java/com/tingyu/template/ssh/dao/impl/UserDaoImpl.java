package com.tingyu.template.ssh.dao.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;


import com.tingyu.template.ssh.dao.UserDao;
import com.tingyu.template.ssh.entities.User;
import com.tingyu.template.ssh.query.UserQuery;
/**
 * 
 * @author Essionshy
 *
 */
@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	/**
	 * Hibernate3可以直接调用 this.getHibernateTemplate()
	 * @param sessionFacotry
	 */
	@Resource  
    public void setSessionFacotry(SessionFactory sessionFacotry) {  
        super.setSessionFactory(sessionFacotry);  
    }
	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void delete(Integer id) {
		User user = this.getHibernateTemplate().get(User.class, id);
		this.getHibernateTemplate().delete(user);
	}

	@Override
	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}

	@Override
	public User select(Integer id) {
		return this.getHibernateTemplate().get(User.class, id);
	}
	/**
	 * listByConditional 动态条件查询
	 */
	@Override
	public List<User> listByConditional(UserQuery userQuery) {

		//1、动态拼接hql
		String hql="FROM User u WHERE 1=1 ";
		
		if(StringUtils.isNotBlank(userQuery.getUsername())) {
			hql=hql+"AND u.username like :username ";
		}
		if(StringUtils.isNotBlank(userQuery.getPhone())) {
			hql=hql+"AND u.phone like :phone ";
		}
		if(userQuery.getGender() != null) {
			hql=hql+"AND u.gender = :gender ";
		}
		if(userQuery.getStartBirth() != null ) {
			hql=hql+"AND u.birth >= :startBirth ";
		}
		if(userQuery.getEndBirth() != null ) {
			hql=hql+"AND u.birth <= :endBirth ";
		}
	
		final String userHQL=hql; 
		List<User> userList = this.getHibernateTemplate().execute(new HibernateCallback<List<User>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<User> doInHibernate(Session session) throws HibernateException {
				//2、创建查询对象Query
				Query query = session.createQuery(userHQL);
				//3、给查询对象参数进行赋值
				/*
				 * if(StringUtils.isNotBlank(userQuery.getUsername())) {
				 * query.setParameter("username","%"+userQuery.getUsername()+"%"); }
				 * if(StringUtils.isNotBlank(userQuery.getPhone())) {
				 * query.setParameter("phone","%"+userQuery.getPhone()+"%"); }
				 */
				setDynamicParam(query,userQuery);
				List<User> list = query.list();
				return list;
			}
		});
		return userList;
	}
	/**
	 * 
	 */
	public void setDynamicParam(Query query,UserQuery userQuery) {
		Field[] fields = userQuery.getClass().getDeclaredFields();
		Field[] superFields = userQuery.getClass().getSuperclass().getDeclaredFields();
		
		List<Field> childList = Arrays.asList(fields);
		List<Field> superList = Arrays.asList(superFields);
		
		List<Field> list=new ArrayList<>();
		list.addAll(childList);
		list.addAll(superList);
		
		for (Field field : list) {
			field.setAccessible(true);
			//获取属性名
			String fieldName = field.getName();			
			Object value=null;
			try {
				//获取属性值
				 value = field.get(userQuery);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			if(value != null) {
				if(value.getClass() == String.class) {
					query.setParameter(fieldName, "%"+value+"%");
				}else {
					query.setParameter(fieldName, value);
				}		
			}
				
		}
	}
}
