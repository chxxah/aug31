package com.peazh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.peazh.web.Member;
import com.peazh.web.repository.MemberRepository;

@Controller
public class MemberController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	
	@GetMapping("/members")
	public String members(Model model) {
		
		//전체뽑기
		List<Member> list = memberRepository.findAll();
		//5개만 뽑아보기
//		List<Member> list = memberRepository.findTop5ByOrderByMno();
//		findAll() 전체 가져오기
//		findOne() pk 기준으로 하나 가져오기
//		save() 저장하기 / 수정하기
//		count() 개수 가져오기
//		delete() 삭제
		
		model.addAttribute("list", list);
		return "members";
	}
}
