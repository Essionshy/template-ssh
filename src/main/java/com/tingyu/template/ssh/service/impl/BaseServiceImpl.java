package com.tingyu.template.ssh.service.impl;

import java.io.Serializable;
import java.util.List;

import com.tingyu.template.ssh.dao.BaseDao;
import com.tingyu.template.ssh.service.BaseService;

public class BaseServiceImpl<E, Q> implements BaseService<E, Q>{

	/**
	 * 注意：此处的baseDao需要在子类中赋上具体实体类对应的Dao，因此不能被private 修饰，
	 * 否则，子类无法获取父类属性，无法赋值
	 */
	BaseDao<E, Q> baseDao;
	
	
	public void setBaseDao(BaseDao<E, Q> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void save(E e) {
		baseDao.save(e);		
	}

	@Override
	public void delete(Serializable id) {
		baseDao.delete(id);		
	}

	@Override
	public void update(E e) {
		baseDao.update(e);		
	}

	@Override
	public E select(Serializable id) {
		return (E) baseDao.select(id);
	}

	@Override
	public List<E> listByConditional(Q q) {
		return baseDao.listByConditional(q);
	}

}
