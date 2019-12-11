package com.tingyu.template.ssh.dao;

import java.io.Serializable;
import java.util.List;



/**
 * BaseDao<E,Q> 通用 DAO 接口
 * E 实体类
 * Q 实体类对应的查询对象
 * @auEhor Essionshy
 *
 */
public interface BaseDao<E,Q> {

	public void save(E e);
	
	public void delete(Serializable id);
	
	public void update(E e);
	
	public E select(Serializable id);
	
	public List<E> listByConditional(Q q);
}
