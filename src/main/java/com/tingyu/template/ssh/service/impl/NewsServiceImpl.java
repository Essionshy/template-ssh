package com.tingyu.template.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tingyu.template.ssh.dao.NewsDao;
import com.tingyu.template.ssh.entities.News;
import com.tingyu.template.ssh.query.NewsQuery;
import com.tingyu.template.ssh.service.NewsService;

@Service
public class NewsServiceImpl extends BaseServiceImpl<News, NewsQuery> implements NewsService {

	@SuppressWarnings("unused")

	private NewsDao newsDao;

	@Autowired
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
		this.baseDao = newsDao;
	}
}
