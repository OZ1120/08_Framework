package com.lej.book.main.model.service;

import java.util.List;

import com.lej.book.main.model.dto.BookList;

public interface MainService {


	/** 모든 책 조회
	 * @return
	 */
	List<BookList> selectBookList();

}
