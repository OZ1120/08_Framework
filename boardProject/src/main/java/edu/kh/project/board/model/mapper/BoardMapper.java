package edu.kh.project.board.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import edu.kh.project.board.model.dto.Board;

/**
 * 
 */
@Mapper
public interface BoardMapper {

	/**
	 * @return
	 */
	List<Map<String, Object>> selectBoardTypeList();

	
	/** 게시글 조회
	 * @param string
	 * @return
	 */
	int getListCount(int boardCode);


	/** 특정 게시판의 지정된 목록 조회
	 * @param boardCode
	 * @param rowBounds
	 * @return boardList
	 */
	List<Board> selectBoardList(int boardCode, RowBounds rowBounds); } 