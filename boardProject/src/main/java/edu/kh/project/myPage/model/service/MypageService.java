package edu.kh.project.myPage.model.service;

import java.util.Map;

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

	


}
