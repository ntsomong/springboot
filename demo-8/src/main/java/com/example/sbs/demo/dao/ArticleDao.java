package com.example.sbs.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.sbs.demo.dto.Article;

@Mapper
public interface ArticleDao {

	List<Article> getArticles();

	void write(Map<String, Object> param);
	

}
