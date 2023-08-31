package com.peazh.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.peazh.web.service.BoardService;

@Controller
public class BoardContoller {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public String board(Model model) {
		List<Map<String, Object>> list = boardService.list();
		model.addAttribute("list", list);
		System.out.println(list);
		return "board";
	}
}
