package com.kh.test.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.test.model.dto.Student;
import com.kh.test.model.mapper.StudentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
	
	private StudentMapper mapper;
	
@Override
	public List<Student> selectAll() {
		return mapper.selectAll();
	}

}
