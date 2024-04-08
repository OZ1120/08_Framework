package com.lej.book.main.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookList {
	
	private int    bookNo;
	private String bookTitle;
	private String bookWriter;
	private int    bookPrice;
	private String regDate;

}
