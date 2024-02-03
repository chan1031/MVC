package edu.jeiu.diary_pjt.dao;

import java.util.HashMap;

import edu.jeiu.diary_pjt.dto.MemberDTO;

public interface MemberDAO {
	//회원가입 메서드
	public void saveMemberDB(HashMap<String, String> param) throws Exception;
	
	//회원조회 메서드
	public MemberDTO getMemberDB(String memberId);
}
