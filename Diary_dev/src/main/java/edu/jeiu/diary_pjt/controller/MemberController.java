package edu.jeiu.diary_pjt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.jeiu.diary_pjt.common.ATResponse;
import edu.jeiu.diary_pjt.common.UserException;
import edu.jeiu.diary_pjt.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	// 회원가입페이지 오픈
	@RequestMapping("/memberSave_open")
	public String save_open() {

		return "save";
	}

	// 로그인페이지 오픈
	@RequestMapping("/login_open")
	public String login_open() {

		return "login";
	}

	// 회원가입 처리
	@RequestMapping("/memberSave")
	@ResponseBody
	public ATResponse save(@RequestParam HashMap<String, String> param) {

		ATResponse atResponse = null;

		try {
			memberService.saveMember(param);
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

	// 로그인 처리
	@RequestMapping("/do_login")
	@ResponseBody
	public Map<String, String> login(@RequestParam HashMap<String, String> param) throws JsonProcessingException {
		String memberId = param.get("memberId");
		String memberPw = param.get("memberPw");
		Map<String, String> response = new HashMap();

		if (memberService.login(memberId, memberPw)) {
			System.out.println("login success");
			response.put("status", "success");
			response.put("message", "Login successful");
		} else {
			System.out.println("login fail");
			response.put("status", "fail");
			response.put("message", "Login failed");
		}
		return response;

	}
}
