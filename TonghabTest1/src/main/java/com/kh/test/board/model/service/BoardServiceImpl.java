package com.kh.test.board.model.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

	private final BoardMapper mapper;
	
	@Override
	public int searchBd(String boardTitle, Map<String, Object> map) {
		
		int result = mapper.searchBd(boardTitle,map);

		return result;
	}
}
