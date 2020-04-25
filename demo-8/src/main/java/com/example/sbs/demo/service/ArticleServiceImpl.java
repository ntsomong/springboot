package com.example.sbs.demo.service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sbs.demo.dao.ArticleDao;
import com.example.sbs.demo.dto.Article;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public List<Article> getArticles() {
	
		return articleDao.getArticles();
	}

	@Override
	public Map<String, Object> write(Map<String, Object> param) {
		articleDao.write(param);
			
		int id = ((BigInteger) param.get("id")).intValue();
		
		Map<String, Object> rs = new HashMap<String, Object>();
		rs.put("result code", "S-1");
		rs.put("id", id);
		rs.put("msg", id+"번 게시글이 추가되었습니다.");
		
		return rs;
	}

}
