package com.lej.book.main.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lej.book.main.model.dto.BookList;
import com.lej.book.main.model.mapper.MainMapper;

@Service
public class MainServiceImpl implements MainService{
	
	@Autowired
	private MainMapper mapper;
	
	// 모든 책 조회
	@Override
	public List<BookList> selectBookList() {
		return mapper.selectBookList();
	}
	
	
	// 책 등록
	@Override
	public int addBook(String bookTitle, String bookWriter, int bookPrice) {
		BookList book = new BookList();
		book.setBookTitle(bookTitle);
		book.setBookWriter(bookWriter);
		book.setBookPrice(bookPrice);
		
		return mapper.addBook(book);
	}

}
