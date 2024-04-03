package edu.kh.project.myPage.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	

}
