package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.model.dto.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginForm";
	}
	
//	@PostMapping("/login")
//	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw) {
//		// userService라는 친구를 통해서 실제 id/pw를 이용하여 DB까지 확인하고 실제 유저가 맞는지 확인해야됨
//		// 세션에 정보를 저장해야됨
//		
//		System.out.println(id);
//		
//		return "redirect:hello";
//	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		
		
		if(user.getId().equals("ssafy") &&user.getPw().equals("1234")) {
			
			session.setAttribute("loginUser", user.getId());
			return "redirect:hello";
		}
		
		return "redirect:login";
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//로그아웃을 하는 방법 2가지
		// 1. 세션에서 유저 속성을 지우는 작업
		//session.removeAttribute("loginUser");
		// 2. 세션 자체를 초기화
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	
}
