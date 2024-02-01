package edu.jeiu.diary_pjt.service;

import java.util.HashMap;

import edu.jeiu.diary_pjt.common.UserException;

public interface MemberService {
	public void saveMember(HashMap<String, String> param) throws UserException, Exception;
}
