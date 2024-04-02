package edu.kh.project.email.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailMapper {

	int updateAuthKey(Map<String, String> map);

	int insertAuthKey(Map<String, String> map);

	/** 이메일, 인증번호 확인
	 * @param map
	 * @return
	 */
	int checkAuthKey(Map<String, Object> map);

}
