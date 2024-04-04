package edu.kh.project.myPage.model.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.member.model.dto.Member;

public interface MypageService {

	/** 회원 정보 수정
	 * @param inputMember
	 * @param memberAddress
	 * @return result
	 */
	int updateInfo(Member inputMember, String[] memberAddress);

	
	/** 비밀번호 수정
	 * @param map
	 * @param memberNo
	 * @return
	 */
	int changePw(Map<String, Object> map, int memberNo);


	/** 회원 탈퇴
	 * @param memberPw
	 * @param memberNo
	 * @return result
	 */
	int secession(String memberPw, int memberNo);


	/** 파일 업로드 테스트 1
	 * @param uploadFile
	 * @return path
	 */
	String fileUplodad1(MultipartFile uploadFile)throws IllegalStateException, IOException;


	

	


}
