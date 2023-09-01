package com.peazh.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.peazh.entity.Member;
import com.peazh.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
//	@GetMapping("/members")
//	public String members(Model model) {
//		
//		// 5개만 뽑기
//		List<Member> list = memberService.findTop5ByOrderByMnoDesc();
//
//		model.addAttribute("list", list);
//		return "members";
//	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Member member, HttpSession session) {
		System.out.println(member);
		//Member(mno=0, mname=null, mid=복숭아, mpw=0000, mjoindate=null)
		
		//멤버에서 id, pw를 보내서 몇명있는지 뽑아내기
		int count = memberService.count(member);
		System.out.println("카운트 : " + count);
		// 일치하는 아이디, 비밀번호를 입력했을 때
		//카운트 : 1
		if (count == 1) {
			//mid랑 mpw가 모두 일치할 때 값을 뽑아옴
			//member.getMpw().get() 으로 뽑아내면 null일 때 오류가 발생함
			//그걸 방지하고자 뭐가 있음 뭔지 몰루~?
			Member result = memberService.findByMidAndMpw(member.getMid(), member.getMpw());
			System.out.println("id : " + result);
			//mid, mpw를 기준으로 member 정보를 뽑아옴
//		id : Member(mno=1, mname=복숭아, mid=복숭아, mpw=0000, mjoindate=2023-09-01T10:14:14)
			session.setAttribute("id", result.getMid());
			session.setAttribute("name", result.getMname());
			return "redirect:/index";
		} else {
			return "login";
		}
		
	} 
	
	
	
}
