package edu.jeiu.diary_pjt.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jeiu.diary_pjt.common.UserException;
import edu.jeiu.diary_pjt.dao.DiaryDAO;
import edu.jeiu.diary_pjt.dao.MemberDAO;
import edu.jeiu.diary_pjt.dto.DiaryDTO;
import edu.jeiu.diary_pjt.dto.MemberDTO;

@Service("MemberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private SqlSession sqlSession;

	
	@Override
	public void saveMember(HashMap<String, String> param) throws UserException, Exception {
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);

		// AccountTransfer insert
		memberDAO.saveMemberDB(param);
	}


	@Override
	public boolean login(String memberId, String memberPw) {
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		MemberDTO memberDTO = memberDAO.getMemberDB(memberId);
		
		if(memberDTO != null && memberDTO.getMemberPw().equals(memberPw)) {
			return true;
		}else {
			return false;
		}
	}
	
}
