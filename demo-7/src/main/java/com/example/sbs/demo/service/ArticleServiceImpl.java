package com.example.sbs.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sbs.demo.dao.ArticleDao;
import com.example.sbs.demo.dto.Article;

@Service
public class ArticleServiceImpl implements ArticelService {
	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public List<Article> getArticles() {
		return articleDao.getArticles();
	}

}
