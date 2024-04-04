package edu.kh.project.myPage.model.service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.mapper.MyPageMapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor //\@Autowired 자동완성 제공 (lombok)
public class MyPageServiceImpl implements MypageService {
	
	private final MyPageMapper mapper;
	
	// BCrypt 암호화 객체 의존성 주입(SecurityConfig 참고)
	private final BCryptPasswordEncoder bcrypt;
//	@Autowired
//	private BCryptPasswordEncoder bcrypt;
		
		

	// @RequiredArgsConstructor 를 이용했을 때 자동 완성 되는 구문
//	@Autowired
//	public MyPageServiceImpl(MyPageMapper mapper) {
//		this.mapper = mapper;
//	}
	// \주석 풀면 중복이라 오류난당
	
	
	// 회원 정보 수정
	@Override
	public int updateInfo(Member inputMember, String[] memberAddress) {

		// 입력된 주소가 있을 경우 
		// memberAddress를 A^^^B^^^C 형태로 가공
		
		// 주소 입력 X -> inputMember.getMemberAddress() -> ",,"
		
		if(inputMember.getMemberAddress().equals(",,")) {
			
			// 주소에 null 대입
			inputMember.setMemberAddress(null);
		}else { // memberAddress를 A^^^B^^^C 형태로 가공
			
			String address = String.join("^^^", memberAddress);
			
			// 주소에 가공된 데이터 대입
			inputMember.setMemberAddress(address);
		}
		
		// SQL 수행 후 결과 반환
		return mapper.updateInfo(inputMember);
	}

	// 비밀번호 변경
	@Override
	public int changePw(Map<String, Object> map, int memberNo) {
		
		// 현재 로그인한 회원의 암호화된 비밀번호를 DB에서 조회
		// ::memberNo를 mapper전달
		String pw = mapper.selectPw(memberNo);
		
		// 입력 받은 현재 비밀번호와
		// DB에서 조회한 비밀번호 비교
		// BcryptPasswordEncoder.matches(평문, 암호화된 비밀번호)
		
		String currentPw = (String)map.get("currentPw");
						// 형변환
		
		if( !bcrypt.matches(currentPw,pw)) { // 같지 않을때
			return 0;
		
		}else { // 같을 경우
			
			// 새 비밀번호 암호화 진행
			String encPw = bcrypt.encode((String)map.get("newPw"));
			
			Member member = new Member();
			
			// 새 비밀번호로 변경(UPDATE)하는 Mapper 호출
			
			// 왜 묶어서 전달???
			// Mapper에 전달 가능한 파라미터는 1개 뿐!!
			member.setMemberNo(memberNo);
			member.setMemberPw(encPw);
			
			return mapper.changePw(member);
		}
		
		
	}
	
	//회원 탈퇴
	@Override
	public int secession(String memberPw, int memberNo) {

		// 현재 회원의 암호화된 비밀번호 조회
		String pw = mapper.selectPw(memberNo);
		
		// 비교
		if( !bcrypt.matches(memberPw,pw)) {// 다를 경우
			return 0;
		}else {
			
			return mapper.secession(memberNo);
		}
		
	}

	
	
	// 파일 업로드 테스트 1
	@Override
	public String fileUplodad1(MultipartFile uploadFile) throws IllegalStateException, IOException {

		// MultipartFile이 제공하는 메서드
		// - getSize() : 파일 크기
		// - isEmpty() : 업로드한 파일이 없을 경우 true
		// - getOriginalFileName() : 원본 파일 명
		// - transferTo(경로)  : 
		//		메모리 또는 임시 저장 경로에 업로드된 파일을
		//		원하는 경로에 전송(서버 어떤 폴더에 저장할지 저장)
		
		if(uploadFile.isEmpty()) { // 업로드한 파일이 없을 경우
			return null;
		}
		
		// 업로드한 파일이 있을 경우
		// C:\\uploadFiles\\test\\파일명(확장자) 으로 서버에 저장
		
		uploadFile.transferTo(
				new File("C:\\uploadFiles\\test\\" + uploadFile.getOriginalFilename()));
		
		// 웹에서 해당 파일에 접근할 수 있는 경로를 반환
		// 서버 :  C:\\uploadFiles\\test\\a.jpg
		// 웹 접근 주소 : /myPage/file/a.jpg
		
		return "/myPage/file/" + uploadFile.getOriginalFilename();
	}

}//





