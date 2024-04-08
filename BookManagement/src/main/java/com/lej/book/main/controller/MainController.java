package com.lej.book.main.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lej.book.main.model.dto.BookList;
import com.lej.book.main.model.service.MainService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	
	private final MainService service;
	
	
	@RequestMapping("/")
	public String mainPage() {
		
		return "common/main";
	}
	
	
	@GetMapping("register")
	public String register() {
		return "common/register";
	}
	
	/** 책 조회
	 * @return
	 */
	@GetMapping("selectBookList")
	public List<BookList> selectBookList(){
		return service.selectBookList();
	}
	
	
	

}
