package com.lej.book.main.model.service;

import java.util.List;

import com.lej.book.main.model.dto.BookList;

public interface MainService {


	/** 모든 책 조회
	 * @return
	 */
	List<BookList> selectBookList();

	/** 책 등록
	 * @param bookTitle
	 * @param bookWriter
	 * @param bookPrice
	 * @return
	 */
	int addBook(String bookTitle, String bookWriter, int bookPrice);

}
