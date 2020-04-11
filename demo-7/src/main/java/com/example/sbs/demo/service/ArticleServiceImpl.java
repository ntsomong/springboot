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
public class ArticleServiceImpl implements ArticelService {
	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public List<Article> getArticles() {
		return articleDao.getArticles();
	}

	@Override
	public Map<String, Object> write(Map<String, Object> param) {
		articleDao.write(param);
		
		//int id = param.get("id");
		//param은 Map의 object로 값을 받으므로 int에 넣어주기 위해서는 형변환(casting)을 해야한다.
		
		int id = ((BigInteger) param.get("id")).intValue();
		
		Map<String, Object> rs = new HashMap<String, Object>();
		rs.put("result code", "S-1");
		rs.put("id", id);
		rs.put("msg", id+"번 게시글이 추가되었습니다.");
		
		return rs;
	}

	@Override
	public Article getArticle(int id) {
		return articleDao.getArticle(id);
	}


}
