package edu.jeiu.diary_pjt.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.jeiu.diary_pjt.common.ATResponse;
import edu.jeiu.diary_pjt.common.UserException;
import edu.jeiu.diary_pjt.dto.DiaryDTO;
import edu.jeiu.diary_pjt.service.DiaryService;

@Controller
public class DiaryController {

	@Autowired
	private DiaryService diaryService;

	// 목록 조회화면 Open
	@RequestMapping("/list_open")
	public String list_open() {

		return "diary_list";
	}

	// 목록 조회
	@RequestMapping("/list")
	@ResponseBody
	// 여기서 가져온 paraam은 ajax로 부터 가져온 데이터를 의미한다. 즉, ajax통신에서 이 list함수를 자동적으로 실행하게 된다.
	public List<DiaryDTO> list(@RequestParam HashMap<String, String> param) {
		List<DiaryDTO> diaryList = diaryService.getDiaryList(param);

		return diaryList;
	}

	// 편집화면 Open
	@RequestMapping("/edit")
	public String edit(@RequestParam HashMap<String, String> param, Model model) {

		model.addAttribute("id", param.get("id"));

		return "diary_view";
	}

	// view의 select
	@RequestMapping("/select")
	@ResponseBody
	public DiaryDTO select(@RequestParam HashMap<String, String> param) {
		System.out.println("What is :" + param.get("id"));
		DiaryDTO diaryDTO = diaryService.getDiary(param);

		return diaryDTO;
	}

	// 입력화면 Open
	@RequestMapping("/add")
	public String add(Model model) {

		return "diary_view";
	}

	// 입력
	@RequestMapping("/insert")
	@ResponseBody
	public ATResponse insert(@RequestParam HashMap<String, String> param) {

		ATResponse atResponse = null;

		try {
			diaryService.insertDiary(param);
			atResponse = new ATResponse("success", "", "");
		} catch (UserException ue) {
			String message = ue.getMessage();
			atResponse = new ATResponse("fail", "TBD", message);
		} catch (Exception e) {
			String message = e.getMessage();
			atResponse = new ATResponse("fail", "TBD", message);
		}

		return atResponse;
	}

	// 한건 삭제
	@RequestMapping("/delete")
	@ResponseBody
	public ATResponse delete(@RequestParam HashMap<String, String> param) {

		ATResponse atResponse = null;

		try {
			diaryService.deleteDiary(param);
			atResponse = new ATResponse("success", "", "");
		} catch (UserException ue) {
			String message = ue.getMessage();
			atResponse = new ATResponse("fail", "TBD", message);
		} catch (Exception e) {
			String message = e.getMessage();
			atResponse = new ATResponse("fail", "TBD", message);
		}

		return atResponse;
	}

	// 수정
	@RequestMapping("/update")
	@ResponseBody
	public ATResponse update(@RequestParam HashMap<String, String> param) {

		ATResponse atResponse = null;

		try {
			diaryService.updateDiary(param);
			atResponse = new ATResponse("success", "", "");
		} catch (UserException ue) {
			String message = ue.getMessage();
			atResponse = new ATResponse("fail", "TBD", message);
		} catch (Exception e) {
			String message = e.getMessage();
			atResponse = new ATResponse("fail", "TBD", message);
		}

		return atResponse;
	}
}
