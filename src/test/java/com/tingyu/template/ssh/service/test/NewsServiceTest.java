package com.tingyu.template.ssh.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tingyu.template.ssh.entities.News;
import com.tingyu.template.ssh.service.NewsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class NewsServiceTest {

	@Autowired
	private NewsService newsService;
	@Test
	public void testSave() {
		System.out.println("---------------testSave-------------");
		
		News news = new News();
		news.setTitle("if i were you");
		newsService.save(news);
	}
}
