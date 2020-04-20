package com.example.sbs.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sbs.demo.dao.ArticleDao;
import com.example.sbs.demo.dto.Article;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	ArticleDao articleDao;
	
	@Override
	public List<Article> getArticles() {
		List<Article> articles = new ArrayList<>();
		
		articles.add(new Article(1, "20202020", "제목", "내용"));
		
		return articles;
	}

}
