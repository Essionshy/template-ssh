package com.tingyu.template.ssh.dao.impl;

import org.springframework.stereotype.Repository;

import com.tingyu.template.ssh.dao.NewsDao;
import com.tingyu.template.ssh.entities.News;
import com.tingyu.template.ssh.query.NewsQuery;

/**
 * 
 * @author Essionshy
 *
 */
@Repository
public class NewsDaoImpl extends BaseDaoImpl<News, NewsQuery> implements NewsDao {

	@Override
	public String createHQL(NewsQuery q) {
		// TODO Auto-generated method stub
		return null;
	}
}
