package edu.kh.project.common.util;

import java.text.SimpleDateFormat;

// 프로그램 전체적으로 사용될 유용한 기능 모음
public class Utility {
	public static int seqNum = 1; // 1~99999 반복

	/**
	 * @param originalFileName
	 * @return
	 */
	// static : 프로그램 실행되자 마자 읽는다 -> static메모리영역에 저장(클래스명.fileRename)
	public static String fileRename(String originalFileName) {
		
		
		// :: 어떻게든 중복이 안되는 형태로만 만들면 된다
		// 20240405100931_00004.jpg -:: 이런 형태로 만들자
		
		// SimpleDateFormat : 시간을 원하는 형태의 문자열로 간단히 변경
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); // :: 월,시만 대문자당
		
		//new java.util.Date() : 현재 시간을 저장한 자바 객체
		String date = sdf.format(new java.util.Date());
		
		String number = String.format("%05d", seqNum);
		
		seqNum++; // 1 증가
		// :: 100000 됐을 때 1로 변경
		if(seqNum == 100000) seqNum = 1;
		
		// 확장자
		// "문자열".substring(인덱스) :
		// 문자열을 인덱스부터 끝까지 잘라낸 결과 반환
		
		// "문자열".lastIndexOf(".") : 
		// 문자열에서 마지막 "."의 인덱스 반환
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
		// .jpg -> 형태로 나옴
		
		
		
		return date + "_" + number + ext;
	} // :: 순수 자바.... 으아아아앙아아아앙ㄱ

	
	
	// Cross Site Scripting(XSS) 방지 처리 //:: 자바스크립트 공격
	// - 웹 애플리케이션에서 발생하는 취약점
	// - 권한이 없는 사용자가 사이트에 스크립트를 작성하는 것
	public static String XSSHandling(String content) {
		
		// 스크립트나 마크업 언어에서 기호나 기능을 나타내는 문자를 변경 처리
		
		//   &  - &amp;
		//   <  - &lt;
		//   >  - &gt;
		//   "  - &quot;
		
		content = content.replaceAll("&", "&amp;");
		content = content.replaceAll("<", "&lt;");
		content = content.replaceAll(">", "&gt;");
		content = content.replaceAll("\"", "&quot;");
		
		return content;
	}
	
	
	
	
	
	
	
	
	
}
