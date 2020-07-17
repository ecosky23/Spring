package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.SungJukDTO;
//@RequestMapping("/sungJuk")//namespace 구분자
@Controller
public class SungJukController {
	
	@RequestMapping(value="/sungJuk/input.do", method=RequestMethod.GET)
	public String input() {
		return "/sungJuk/input";
	}
	@RequestMapping(value="/sungJuk/result.do", method=RequestMethod.POST)
	public String result (@ModelAttribute SungJukDTO sungJukDTO, Model model) {
		model.addAttribute("sungJukDTO", sungJukDTO);
		return "/sungJuk/result";
	}
	
}
