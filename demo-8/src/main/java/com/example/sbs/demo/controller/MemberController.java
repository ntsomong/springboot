package com.example.sbs.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sbs.demo.service.MemberService;

@Controller
public class MemberController {

	@Autowired	
	private MemberService memberService;
	
	@RequestMapping("member/join")
	String ShowJoin() {
		return "member/join";
	}

	@RequestMapping("member/login")
	String ShowLogoin() {
		return "member/login";
	}
	
	@RequestMapping("member/doJoin")
	String doJoin(Model model, @RequestParam Map<String, Object> param) {
		Map<String, Object> rs = memberService.join(param);	
		
		String resultCode = (String)rs.get("resultCode");
		
		if (resultCode.startsWith("S-")) {
			String redirectUrl = "/member/login";

			model.addAttribute("jsAlertMsg", rs.get("msg"));
			model.addAttribute("jsLocationReplaceUrl", redirectUrl);
		}
		else {
			model.addAttribute("jsAlertMsg", rs.get("msg"));
			model.addAttribute("jsHistoryBack", true);
		}
		
		return "redirect";
	}

	@RequestMapping("member/doLogin")
	String doLogin(HttpSession session, Model model, @RequestParam Map<String, Object> param) {
		Map<String, Object> rs = memberService.checkLoginAvailable(param);	
		
		String resultCode = (String)rs.get("resultCode");
		String msg = (String)rs.get("msg");
		
		if (resultCode.startsWith("S-")) {
			msg = "로그인 되었습니다.";
			int loginedMemberId = (int)rs.get("id");
			session.setAttribute("loginedMemberId", loginedMemberId);
		
			String redirectUrl = "/article/list";

			model.addAttribute("jsAlertMsg", msg);
			model.addAttribute("jsLocationReplaceUrl", redirectUrl);	

		} else {
			model.addAttribute("jsAlertMsg", msg);
			model.addAttribute("jsHistoryBack", true);
		}
				
		return "redirect";
	}
	
	@RequestMapping("member/doLogout")
	String doLogin(HttpSession session, Model model) {

		session.removeAttribute("loginedMemberId");

			String redirectUrl = "/article/list";
		
			model.addAttribute("jsAlertMsg", "로그아웃 되었습니다.");
			model.addAttribute("jsLocationReplaceUrl", redirectUrl);	

		return "redirect";
	}

}
