package edu.jeiu.diary_pjt.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.jeiu.diary_pjt.common.UserException;
import edu.jeiu.diary_pjt.dao.DiaryDAO;
import edu.jeiu.diary_pjt.dto.DiaryDTO;

@Service("DiaryService")
public class DiaryServicempl implements DiaryService {

	@Autowired
	private SqlSession sqlSession;

	// 목록조회 메소드
	@Override
	public List<DiaryDTO> getDiaryList(HashMap<String, String> param) {

		// searchAccountName + "%"
		String searchTitleName = param.get("searchTitleName");
		param.put("searchTitleName", searchTitleName + "%");

		DiaryDAO diaryDAO = sqlSession.getMapper(DiaryDAO.class);
		List<DiaryDTO> diaryList = diaryDAO.getDiaryDBList(param);

		return diaryList;
	}

	// 한건 조회 메서드
	@Override
	public DiaryDTO getDiary(HashMap<String, String> param) {
		DiaryDAO diaryDAO = sqlSession.getMapper(DiaryDAO.class);
		DiaryDTO diaryDTO = diaryDAO.getDiaryDB(param);

		return diaryDTO;
	}

	@Transactional
	@Override
	public void insertDiary(HashMap<String, String> param) throws UserException, Exception {

		DiaryDAO diaryDAO = sqlSession.getMapper(DiaryDAO.class);

		// AccountTransfer insert
		diaryDAO.insertDiaryDB(param);

	}

	// 삭제 메소드
	@Transactional
	@Override
	public void deleteDiary(HashMap<String, String> param) throws UserException, Exception {

		DiaryDAO diaryDAO = sqlSession.getMapper(DiaryDAO.class);

		// AccountTransfer delete
		diaryDAO.deleteDiaryDB(param);

	}

	// 수정 메소드
	@Transactional
	@Override
	public void updateDiary(HashMap<String, String> param) throws UserException, Exception {

		DiaryDAO diaryDAO = sqlSession.getMapper(DiaryDAO.class);

		// AccountTransfer update
		diaryDAO.updateDiaryDB(param);

	}

}
