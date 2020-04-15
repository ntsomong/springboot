package com.example.sbs.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.sbs.demo.dto.Article;

@Mapper
public interface ArticleDao {

	List<Article> getArticles();

	void write(Map<String, Object> param);

	Article getArticle(@Param(value = "ID") int id);

	void remove(@Param(value = "ID") int id);

	void modify(Map<String, Object> param);

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
