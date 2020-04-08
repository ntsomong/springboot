package com.example.sbs.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sbs.demo.dto.Article;
import com.example.sbs.demo.service.ArticelService;

@Controller
public class ArticleController {
	@Autowired
	private ArticelService articleService;
	
	@RequestMapping("/article/list")
	public String showList(Model model) {
		
		List<Article> articles = articleService.getArticles();
		
		model.addAttribute("age", 13);	
		model.addAttribute("articles", articles);
		
		return "article/list";
	}
	
	@RequestMapping("/article/write")
	public String showWrite() {
		return "article/write";
	}
	
	@RequestMapping("/article/doWrite")
	@ResponseBody
	public Map<String, Object> doWrite(@RequestParam Map<String, Object> param) {
		
		return param;
	}
}
