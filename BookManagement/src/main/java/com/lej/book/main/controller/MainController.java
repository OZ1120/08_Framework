package com.lej.book.main.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	
	// 책 등록 페이지 이동
	@GetMapping("register")
	public String register() {
		return "common/register";
	}
	
	
	// 책 검색,수정,삭제 페이지 이동
	@GetMapping("etc")
	public String etc() {
		return "common/etc";
	}
	
	
	
	/** 책 조회
	 * @return
	 */
	@ResponseBody
	@GetMapping("selectBookList")
	public List<BookList> selectBookList(){
		return service.selectBookList();
	}
	
	// 책 등록
	@GetMapping("add")
	public String addBook(
			@RequestParam("bookTitle")String bookTitle,
			@RequestParam("bookWriter")String bookWriter,
			@RequestParam("bookPrice")int bookPrice,
			RedirectAttributes ra) {
		
		int result = service.addBook(bookTitle,bookWriter,bookPrice);
		
		String message = null;
		String path = null;
		
		if(result>0) {
			message= "등록 성공";
			path = "" ;
		}else {
			message = "등록에 실패하였습니다";
			path = "register";
		}
		
		ra.addFlashAttribute("message", message);
		
		
		return "redirect:/" + path;
	}
	
	
	

}
