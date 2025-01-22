package com.ssafy.mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ControllerParameter {

	@GetMapping("/test1")
	public String test1() {
		// 반환타입 String --> 해당 값이 viewName
		
		return "test1"; // /WEB-INF/view/test1.jsp
		
	}
	
	// 데이터도 같이 보내고 싶다.
	// 사실 반환타입을 MaV로 바꾸면 됨... 하지만 싫어
	@GetMapping("/test2-1")
	public String test2_1(Model model) {
		
		// 모델이라고 하는 바구니를 준비해뒀다.
		model.addAttribute("msg", "model data");
		return "test2"; // /WEB-INF/view/test1.jsp
	}
	
	@GetMapping("/test2-2")
	public String test2_2(Map<String, Object> model) {
		model.put("msg", "map data");
		// 모델이라고 하는 바구니를 준비해뒀다.
		return "test2"; // /WEB-INF/view/test1.jsp
	}
	
	// 파라미터 값을 가지고 오고 싶다.
	@GetMapping("/test3")
	public String test3(Model model, HttpServletRequest request, HttpSession session) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "test3";
	}
	
	@GetMapping("/test3-1")
	public String test3_1(Model model,
			@RequestParam("id") String id,
			@RequestParam(value = "pw", defaultValue = "1111") String pw
			) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "test3";
	}
	
	
	
	
	
}
