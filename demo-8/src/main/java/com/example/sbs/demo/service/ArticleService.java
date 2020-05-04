package com.example.sbs.demo.service;

import java.util.List;
import java.util.Map;

import com.example.sbs.demo.dto.Article;

public interface ArticleService {

	List<Article> getArticles();

	Map<String, Object> write(Map<String, Object> param);

	Article getArticle(int id);

	Map<String, Object> modify(Map<String, Object> param);

	Map<String, Object> delete(int id);

}
