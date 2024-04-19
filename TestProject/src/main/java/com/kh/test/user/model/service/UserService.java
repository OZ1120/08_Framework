package com.kh.test.user.model.service;

import com.kh.test.user.model.dto.User;

public interface UserService {

	/** 회원 정보 조회
	 * @param userId
	 * @return user
	 */
	User searchId(String userId);

	/* User searchId(String userId); */

}
