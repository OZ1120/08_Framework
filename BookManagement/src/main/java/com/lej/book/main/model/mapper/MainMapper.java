package com.lej.book.main.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lej.book.main.model.dto.BookList;

@Mapper
public interface MainMapper {

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
