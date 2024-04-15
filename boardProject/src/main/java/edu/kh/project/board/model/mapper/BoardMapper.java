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
	List<Board> selectBoardList(int boardCode, RowBounds rowBounds);


	/**
	 * @param map
	 * @return
	 */
	Board selectOne(Map<String, Integer> map);


	/** 좋아요 해제(DELETE)
	 * @param map
	 * @return return
	 */
	int deleteBoardLike(Map<String, Integer> map);


	/** 좋아요 체크(INSERT)
	 * @param map
	 * @return
	 */
	int insertBoardLike(Map<String, Integer> map); 
	
	/** 게시글 좋아요 개수 조회
	 * @param temp
	 * @return
	 */
	int selectLikeCount(int temp);


	/** w조회수 1증가
	 * @param boardNo
	 * @return
	 */
	int updateReadCount(int boardNo);


	/** 조회 수 조회
	 * @param boardNo
	 * @return
	 */
	int selectReadcount(int boardNo);
	
	} 