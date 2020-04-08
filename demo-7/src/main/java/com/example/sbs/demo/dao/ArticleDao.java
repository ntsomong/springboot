package com.example.sbs.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sbs.demo.dto.Article;

@Mapper
public interface ArticleDao {

	List<Article> getArticles();

}

/*
@Autowired	
public List<Article> getArticles() {
	
	List<Article> articles = new ArrayList<>();
	
	Article article1 = new Article(1, "00", "t", "b");
	
	articles.add(article1);
	
	return articles;
}
*/
