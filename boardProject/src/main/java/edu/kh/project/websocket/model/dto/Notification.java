package edu.kh.project.websocket.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Notification {

	private int notificationNo;
	private String notificationContent;
	private String notificationCheck;
	private String notificationDate;
	private String notificationUrl;
	private String sendMemberProfileImg;
	private int sendMemberNo; // 알림을 보낸 사람
	private int receiveMemberNo; // 알림 받는 사람(중요!)
	
	private String notificationType; // 알림 내용을 구분해서 만드는 용도 :: 구분값, 상태에 따라 출력 다르게
	private String title; // 알림내용에 추가될 게시글 제목
	private int pkNo;	// 알림이 보내진 게시글 번호
}
