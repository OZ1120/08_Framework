package edu.kh.project.board.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.kh.project.board.model.dto.Comment;
import edu.kh.project.board.model.service.CommentService;
import lombok.RequiredArgsConstructor;

/* @RestController (REST API 구축을 위해 사용하는 컨트롤러)
 * 
 * == @Controller (요청/응답 제어 + bean 등록)
 * 	 + @ResponseBody (응답 본문으로 데이터 반환)
 * 
 * -> 모든 응답을 응답 본문(ajax호출 부분)으로 반환하는 컨트롤러
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("comment") // :: /comment 시작 요청 처리
public class CommentControll {
	
	private final CommentService service;
	
	/**댓글 조회
	 * @param boardNo
	 * @return commentList
	 */
	// value 속성 : 매핑할 주소
	// produces 속성 : 응답할 데이터의 형식을 지정
	@GetMapping(value="", produces = "application/json")
	public List<Comment> select(@RequestParam("boardNo")int boardNo){
		
		// HttpMessageConverter가
		// List -> JSON(문자열)로 변환해서 응답
		
		return service.select(boardNo);
	}
	
	
	/** 댓글 등록
	 * @return
	 */
	@PostMapping("")
	public int insert(@RequestBody Comment comment) {
		
		// 요청 데이터가 JSON으로 명시됨
		// headers : {"Content-Type" : "application/json"}
		

		// -> Arguments Resolver가 JSON을 DTO(comment)로 자동 변경 
		// 	(JACKSON 라이브러리 기능)
		
		// :: HttpMessageConverter : 보낼때
		
		return service.insert(comment);
		//:: restcontroller : 비동기 화면으로 돌아감
	}
	
	
	/** 댓글 수정
	 * @param comment (번호, 내용_
	 * @return result
	 */
	@PutMapping("")
	public int update(@RequestBody Comment comment) {
		return service.update(comment);
	}
	
	
	
	/** 댓글 삭제
	 * @param commentNo
	 * @return result
	 */
	@DeleteMapping("")
	public int delete(@RequestBody int commentNo) {
		return service.delete(commentNo);
	}
	

}
