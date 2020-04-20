package com.example.sbs.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sbs.demo.dto.Article;

@Service
public interface ArticleService {

	List<Article> getArticles();

}
