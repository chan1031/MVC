package edu.jeiu.diary_pjt.common;


// 사용자 정의 Exception - AccountNumber가 없는 경우
public class UserException extends Exception {
	
	// 기본생성자
//	public AccountNotFoundException() { }
	
	// Exception 메세지 전달용 생성자
	public UserException(String message) {
		super(message);
	}
}

