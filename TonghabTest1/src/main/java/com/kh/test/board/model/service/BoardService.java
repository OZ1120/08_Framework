package com.kh.test.board.model.service;

import java.util.Map;

import com.kh.test.board.model.dto.Board;

public interface BoardService {


	int searchBd(String boardTitle, Map<String, Object> map);

}
