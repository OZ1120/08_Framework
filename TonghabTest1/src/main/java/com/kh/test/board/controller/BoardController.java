package com.kh.test.board.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.test.board.model.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService service;
	
	@GetMapping("searchBd")
	public String searchBd(
			@RequestParam("boardTitle") String boardTitle,
			Map<String, Object> map,
			Model model) {
		
		int result = service.searchBd(boardTitle,map);
		
		String path = null;
		
		if(result>0) {
			model.addAttribute(map);
			path= "searchSuccess";
		}else {
			path = "searchFail";
		}
		return path;
	}

}
