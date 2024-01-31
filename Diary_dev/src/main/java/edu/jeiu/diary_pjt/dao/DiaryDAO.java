package edu.jeiu.diary_pjt.dao;

import java.util.HashMap;
import java.util.List;

import edu.jeiu.diary_pjt.dto.DiaryDTO;

public interface DiaryDAO {
	// 목록조회DB 메소드
	public List<DiaryDTO> getDiaryDBList(HashMap<String, String> param);

	// 조회DB 메소드
	public DiaryDTO getDiaryDB(HashMap<String, String> param);

	// 입력DB 메소드 - AccountTransfer insert
	public void insertDiaryDB(HashMap<String, String> param) throws Exception;

	// 입력DB 메소드 - AccountTransfer insert
	public void deleteDiaryDB(HashMap<String, String> param) throws Exception;

	// 수정
	public void updateDiaryDB(HashMap<String, String> param) throws Exception;
}
