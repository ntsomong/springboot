package com.example.sbs.demo.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.sbs.demo.dto.Member;

@Mapper
public interface MemberDao {

	void join(Map<String, Object> param);

	Member getMemberByLoginId(String loginId);
	//Member getMemberByLoginId(@Param("loginId") String loginId);

	Member getMemberById(Integer loginedMemberId);
	//Member getMemberById(int id);


}
