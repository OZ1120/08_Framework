package edu.kh.project.myPage.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Builder : 빌더 패턴을 이용해 객체 생성 및 초기화를 쉽게 진행
// -> ㅣ기본 생성자 생성 안됨
// ->  MyBatis 조회 결과를 담을 때 필요한 객체 생성 시류ㅐ
//  	(MyBatis는 기본 생성자로 객체를 만들기 때문!)



@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UploadFile {
	
	private int fileNo;
	private String filePath;
	private String fileOriginalName;
	private String fileRename;
	private String fileUploadDate; // ::tochar로 변경해서 가져올거임
	private int memberNo;
	// join에서 가져올 컬럼
	private String memberNickname;

}
