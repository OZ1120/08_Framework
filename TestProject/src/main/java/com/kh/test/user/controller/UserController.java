package com.kh.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.kh.test.user.model.dto.User;
import com.kh.test.user.model.service.UserService;

import lombok.RequiredArgsConstructor;




@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService service;


	@GetMapping("searchId")
	public String searchId(
			@RequestParam("userId")String userId, Model model
			) {
		
		User user = service.searchId(userId);
		
		String path = null;
		
		if(user != null) {
			model.addAttribute(user);
			path = "/searchSuccess";
		}else {
			path = "/searchFail";
		}
		
		
		return path;
	}
	
	
	
	/*
	 * @GetMapping("searchId") public String searchId(
	 * 
	 * @RequestParam("userId") String userId, Model model) {
	 * 
	 * User user = service.searchId( userId);
	 * 
	 * if(user!= null) { model.addAttribute(user); return "/searchSuccess";
	 * 
	 * } else { return "/searchFail"; }
	 * 
	 * }
	 */



}

