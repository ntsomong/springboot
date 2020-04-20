package com.example.sbs.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sbs.demo.dto.Article;
import com.example.sbs.demo.service.ArticleService;

@Controller
public class ArticleController {

	@Autowired
	ArticleService articleService;

	@RequestMapping("article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		List<Article> articles = articleService.getArticles();
		
		return articles;
	}

	@RequestMapping("article/list")
	public String showList() {
		List<Article> articles = articleService.getArticles();
		
		return "article/list";
	}
}
