package com.kh.test.model.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kh.test.model.dto.User;
import com.kh.test.model.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserMapper mapper;
	
	@Override
	public User searchNo(Model model, int userNo) {
		
		return mapper.searchNo(model,userNo);
	}

}
