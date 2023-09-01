package com.peazh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	//@GetMapping(value={"/", "/index"}) 이렇게 적어도 됨
	@GetMapping({"/", "/index"})
	public String index() {
		return "index";
	}
}
