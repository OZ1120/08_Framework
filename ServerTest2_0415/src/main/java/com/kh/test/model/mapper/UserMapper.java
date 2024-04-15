package com.kh.test.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.ui.Model;

import com.kh.test.model.dto.User;

@Mapper
public interface UserMapper {

	/** 회원 정보 조회
	 * @param model
	 * @param userNo
	 * @return
	 */
	User searchNo(Model model, int userNo);

}
