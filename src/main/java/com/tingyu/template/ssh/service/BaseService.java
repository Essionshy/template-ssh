package com.tingyu.template.ssh.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E, Q> {
	public void save(E e);

	public void delete(Serializable id);

	public void update(E e);

	public E select(Serializable id);

	public List<E> listByConditional(Q q);
}
