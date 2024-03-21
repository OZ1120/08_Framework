package edu.kh.demo.modle.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Spring EL 같은 경우 getter가 필수로 작성되어야 함!!!
// -> ${stuent.getName()} == ${Student.name}
// getter 대신 필드명 호출하는 형싱으로 작성하는데
// 자동으로 getter를 호출하기 때문

@Getter // 컴파일 시 getter 코드 자동 추가
@Setter // 컴피일 시 setter 코드 자동 추가
@ToString // 컴피알 시 toString() 메서드가 자동 오버라이딩 되서 추가

@NoArgsConstructor // 매개변수 없는 생성자( == 기본생선자)
@AllArgsConstructor //  모든 필드를 초기화하는 용도의 매개변수 생성자
public class Student {
	private String studentNo;
	private String name; // 이름
	private int age; // 나이

}
