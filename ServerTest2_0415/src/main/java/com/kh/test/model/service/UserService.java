package com.kh.test.model.service;

import org.springframework.ui.Model;

import com.kh.test.model.dto.User;

public interface UserService {

	/** 회원 정보 조회
	 * @param model
	 * @param userNo
	 * @return
	 */
	User searchNo(Model model, int userNo);

}
