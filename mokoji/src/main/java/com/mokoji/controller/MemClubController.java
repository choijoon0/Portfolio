package com.mokoji.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mokoji.domain.ClubVO;
import com.mokoji.domain.MemClubVO;
import com.mokoji.domain.MemberVO;
import com.mokoji.service.ClubService;
import com.mokoji.service.MemClubService;

@Controller
public class MemClubController {
	
	@Autowired
	private MemClubService memClubService;
	
	@Autowired
	private ClubService clubService;
	
	//동호회 가입
	@RequestMapping(value = "/joinClub.do")
	public void joinClubInsert(ClubVO clubvo, MemberVO memvo, Model model, HttpServletResponse response) throws IOException {
		
		//가져온 회원코드, 동호회 코드로 회원별동호회 테이블에 회원분류 코드찾기 그거 값이 1이면 이미 회장임
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("member", memvo);
		map.put("club", clubvo);
		
		//회원분류
		int num = memClubService.getMemCtCode(map);
		
		
		if(num==2) {
			//2면이미 가입한 동호회
			System.out.println("이미 신청했거나 가입한 동호회에여");
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('이미 신청했거나 가입한 동호회입니다.');history.back();</script>");

			out.flush();
			
			
		}else if(num==1) {
			//null이면 가입가능
			System.out.println("니가 만들었어요");
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('자신이 만든 동호회는 가입이 불가능합니다.');history.back();</script>");

			out.flush();
			
			
			
		}else{
			//null이면서 동호회 가입유형이 승인제면 N으로 아님 Y로
				
			
			memClubService.joinClub(map);
			
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('가입 신청이 완료되었습니다!');history.back();</script>");

			out.flush();
		}
	}
	
	
	//승인 확인
	@RequestMapping(value="/upMemClub.do", method = RequestMethod.POST)
	public void upMemclub(MemClubVO vo,ClubVO cvo,HttpSession session, HttpServletResponse response) throws IOException {
		session.setAttribute("clubcode", cvo.getClub_code());
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter w = response.getWriter();
		
		String msg = "승인하셨습니다.";
		String msg1 = "이미 인원이 가득찼습니다!";
		
		int memtot = clubService.getClubMemtot(cvo);
		int nowmem = clubService.getNowMemberCnt(cvo);
		if(memtot - nowmem > 0) {
			memClubService.upMemclub(vo);
			w.write("<script>alert('" + msg + "');history.back();</script>");
			w.flush();
			w.close();
		}else {
			
			w.write("<script>alert('" + msg1 + "');history.back();</script>");
			w.flush();
			w.close();
		}
		
		
		
	}
	
	//승인 거절
	@RequestMapping(value="/delMemClub.do", method = RequestMethod.POST)
	public void delMemclub(MemClubVO vo, HttpSession session, HttpServletResponse response) throws IOException{
		memClubService.delMemClub(vo);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter w = response.getWriter();
		String msg = "거절하셨습니다.";
		w.write("<script>alert('" + msg + "');history.back();</script>");
		w.flush();
		w.close();
		
	}
	
	
}
