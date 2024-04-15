package com.kh.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.test.model.dto.User;
import com.kh.test.model.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserService service;
	
	
	
	@RequestMapping("searchNo")
	public String searchNo(
		@RequestParam("userNo") int userNo,
		Model model) {
		
		User user = service.searchNo(model, userNo);
		
		String path = null;
		
		if(user != null) { // userNo 있을 경우
			path = "/searchSusess";
		}else {
			path = "/searchFail";
		}
		
		
		return path;
	}

}
