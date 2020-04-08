package com.example.sbs.demo.service;

import java.util.List;
import java.util.Map;

import com.example.sbs.demo.dto.Article;

public interface ArticelService {

	List<Article> getArticles();

	Map<String, Object> write(Map<String, Object> param);

	
}
