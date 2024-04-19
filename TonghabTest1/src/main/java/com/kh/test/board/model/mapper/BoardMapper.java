package com.kh.test.board.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.test.board.model.dto.Board;

@Mapper
public interface BoardMapper {

	int searchBd(String boardTitle, Map<String, Object> map);

}
