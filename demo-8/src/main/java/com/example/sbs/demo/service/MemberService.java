package com.example.sbs.demo.service;

import java.util.Map;

import com.example.sbs.demo.dto.Member;

public interface MemberService {

	Map<String, Object> join(Map<String, Object> param);

	Map<String, Object> checkLoginAvailable(Map<String, Object> param);

	Member getMemberById(Integer loginedMemberId);

	//Member getMemberById(int id);

}
