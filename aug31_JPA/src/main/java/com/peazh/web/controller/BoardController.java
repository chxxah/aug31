package com.peazh.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.peazh.web.JBoard;
import com.peazh.web.repository.BoardRepository;

@Controller
public class BoardController {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@GetMapping("/write")
	public String write() {
		return "write";
	}
	
	@PostMapping("/write")
	public String write(JBoard jboard) {
//		System.out.println(jboard);JBoard(bno=0, btitle=제목, bcontent=내용, bdate=null, mname=null)
		
		//값 실어 보내기
		jboard.setMname("복숭아");
		
		//저장하기 save()
		boardRepository.save(jboard);
		
		return "redirect:/board";
	}
	
}
