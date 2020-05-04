package com.example.sbs.demo.service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sbs.demo.dao.MemberDao;
import com.example.sbs.demo.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired	
	private MemberDao memberDao;
	
	@Override
	public Map<String, Object> join(Map<String, Object> param) {

		Map<String, Object> rs = new HashMap<String, Object>();

		String loginId = (String) param.get("loginId");
		Member member = memberDao.getMemberByLoginId(loginId);
		
		if (member == null) {
			memberDao.join(param);
			
			int id = ((BigInteger) param.get("id")).intValue();
			
			rs.put("resultCode", "S-1");
			rs.put("id", id);
			rs.put("msg", id+"번 회원가입이 완료되었습니다.");
		} 
		else {
			rs.put("resultCode", "F-1");
			rs.put("msg", "이미 존재하는 아이디입니다.");
		}
		
		return rs;
	}

	@Override
	public Map<String, Object> checkLoginAvailable(Map<String, Object> param) {
		Map<String, Object> rs = new HashMap<String, Object>();

		String loginId = (String) param.get("loginId");
		String loginPw = (String) param.get("loginPw");
		
		Member member = memberDao.getMemberByLoginId(loginId);
		
		if (member == null) {
			rs.put("resultCode", "F-1");
			rs.put("msg", "아이디가 존재하지 않습니다.");
		}
		else if ( member.getLoginPw().equals(loginPw) == false ) {
			rs.put("resultCode", "F-2");
			rs.put("msg", "패스워드가 일치하지 않습니다.");
		}
		else {
			rs.put("resultCode", "S-1");
			rs.put("msg", "로그인 가능");
			rs.put("id", member.getId());
		}
		
		return rs;
	}

	@Override
	public Member getMemberById(Integer loginedMemberId) {
		return memberDao.getMemberById(loginedMemberId);
	}

	/*
	 * @Override public Member getMemberById(int id) { return
	 * memberDao.getMemberById(id); }
	 */
	
}
