package com.tingyu.template.ssh.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.tingyu.template.ssh.dao.BaseDao;
/**
 * 
 * @author Essionshy
 *
 * @param <E>
 * @param <Q>
 */
public abstract class BaseDaoImpl<E, Q> extends HibernateDaoSupport implements BaseDao<E, Q> {

	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	@Override
	public void save(E e) {
		this.getHibernateTemplate().save(e);

	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(Serializable id) {
		E e = (E) this.getHibernateTemplate().get(getEntityGenericClass(), id);
		this.getHibernateTemplate().delete(e);
	}

	@Override
	public void update(E e) {
		this.getHibernateTemplate().update(e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E select(Serializable id) {
		E e = (E) this.getHibernateTemplate().get(getEntityGenericClass(), id);
		return e;
	}

	@Override
	public List<E> listByConditional(Q q) {

		List<E> eList = this.getHibernateTemplate().execute(new HibernateCallback<List<E>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<E> doInHibernate(Session session) throws HibernateException {

				String hql = createHQL(q);
				Query query = session.createQuery(hql);
			
				setDynamicParam(query, q);
				List<E> list = query.list();
				return list;
			}
		});
		return eList;
	}

	/**
	 * 
	 * @param q
	 * @return
	 */
	public abstract String createHQL(Q q);

	/**
	 * 获取实体的
	 * @return
	 */
	public Class<?> getEntityGenericClass() {
		// 1、获取当前类的父类的泛型类型
		Type genericSuperclass = this.getClass().getGenericSuperclass();

		// 2、获取当前类父类的泛型的参数类型

		ParameterizedType pt = (ParameterizedType) genericSuperclass;

		Type[] arguments = pt.getActualTypeArguments();

		Class<?> clazz = (Class<?>) arguments[0];
		return clazz;
	}

	/**
	 * 动态设置参数
	 * @param query
	 * @param q  Class<? extends Object> clazz = q.getClass()
	 */
	public void setDynamicParam(Query query, Q q) {
		Class<? extends Object> clazz = q.getClass();
		
		Field[] fields = clazz.getClass().getDeclaredFields();
		Field[] superFields = clazz.getClass().getSuperclass().getDeclaredFields();

		List<Field> childList = Arrays.asList(fields);
		List<Field> superList = Arrays.asList(superFields);

		List<Field> list = new ArrayList<>();
		list.addAll(childList);
		list.addAll(superList);

		for (Field field : list) {
			field.setAccessible(true);
			// 获取属性名
			String fieldName = field.getName();
			Object value = null;
			try {
				// 获取属性值
				value = field.get(clazz);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			if (value != null) {
				if (value.getClass() == String.class) {
					query.setParameter(fieldName, "%" + value + "%");
				} else {
					query.setParameter(fieldName, value);
				}
			}

		}
	}
}
