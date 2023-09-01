package com.peazh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.peazh.entity.JBoard;
import com.peazh.entity.Member;
import com.peazh.service.BoardService;
import com.peazh.service.MemberService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/board")
	public String board(Model model) {
		List<JBoard> list = boardService.findAll();
		model.addAttribute("list", list);
		System.out.println(list);
//[JBoard(bno=1, btitle=글이 써지나요?, bcontent=됩니다., bdate=2023-08-31T16:54:35, member=null), JBoard(bno=2, btitle=글을 써요, bcontent=오늘은 1일~, bdate=2023-09-01T10:15:17, member=Member(mno=1, mname=복숭아, mid=복숭아, mpw=0000, mjoindate=2023-09-01T10:14:14))]
		return "board";
	}
	
	@GetMapping("/write")
	public String write() {
		return "write";
	}
	
	@PostMapping("/write")
	public String write(JBoard jboard, HttpSession session) {
//		System.out.println(jboard);JBoard(bno=0, btitle=제목, bcontent=내용, bdate=null, mname=null)
		
		if (session.getAttribute("id") != null) {
			//값 실어 보내기
			Member member = memberService.findByMid((String)session.getAttribute("id"));
			jboard.setMember(member);
			
			//저장하기 save()
			boardService.save(jboard);
			
			return "redirect:/board";
			
		} else {
			return "write";
		}
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam(name="bno", required = true) int bno, Model model) {
		JBoard detail = boardService.findByBno(bno);
		model.addAttribute("detail",detail);
		System.out.println(detail);
		return "detail";
	}
	
}
