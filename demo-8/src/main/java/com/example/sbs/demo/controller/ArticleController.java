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
	public String showList(Model model) {
		List<Article> articles = articleService.getArticles();
		
		model.addAttribute("articles", articles);
		
		return "article/list";
	}
	
	@RequestMapping("article/write")
	public String showWrite() {
	
		return "article/write";
	}
	
	@RequestMapping("article/doWrite")
	@ResponseBody
	public Map<String, Object> doWrite(@RequestParam Map<String, Object> param) {
		Map<String, Object> rs = articleService.write(param);	
		return rs;
	}
	/*
	@RequestMapping("article/doWrite")	
	@ResponseBody
	public String doWrite(@RequestParam Map<String, Object> param) {
		Map<String, Object> rs = articleService.write(param);	
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		sb.append("alert('" + rs.get("msg") + "');");
		sb.append("location.replace('/article/list');");
		sb.append("</script>");
		return sb.toString();
	}
	*/
	/*
	@RequestMapping("article/doWrite")
	public String doWrite(Model model, @RequestParam Map<String, Object> param) {
		Map<String, Object> rs = articleService.write(param);	
		
		String url = "/article/detail?id=" + rs.get("id");
		model.addAttribute("jsAlertMsg", rs.get("msg"));
		model.addAttribute("jsLocationReplaceUrl", rs.get("msg"));
		
		return "redirect";
	}
	*/

}
