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
	//public Map<String, Object> doWrite(@RequestParam Map<String, Object> param) {
	//	Map<String, Object> rs = articleService.write(param);	
	//	return rs;
	public String doWrite(@RequestParam Map<String, Object> param) {
		Map<String, Object> rs = articleService.write(param);	
		
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		sb.append("alert('" + rs.get("msg") + "');");
		sb.append("location.replace('/article/list');");
		sb.append("</script>");
				
		return sb.toString();
	}
	
	@RequestMapping("/article/detail")
	public String showDetail(Model model, int id) {
		Article article = articleService.getArticle(id);
		model.addAttribute("article", article);
		
		return "article/detail";
	}
	
	@RequestMapping("/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		Map<String, Object> rs = articleService.delete(id);	
		
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		sb.append("alert('" + rs.get("msg") + "');");
		sb.append("location.replace('/article/list');");
		sb.append("</script>");

			return sb.toString();
	}

	@RequestMapping("/article/modify")
	public String showModify(Model model, int id) {
		Article article = articleService.getArticle(id);
		model.addAttribute("article", article);
		
		return "article/modify";
	}
	
	@RequestMapping("/article/doModify")
	@ResponseBody
	public String doModify(int id) {
		Map<String, Object> rs = articleService.modify(id);	
		
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		sb.append("alert('" + rs.get("msg") + "');");
		sb.append("location.replace('/article/list');");
		sb.append("</script>");

			return sb.toString();
	}
	
}
