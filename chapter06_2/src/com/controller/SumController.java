package com.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SumDTO;

@Controller
public class SumController {
/*	
	@RequestMapping(value="/input.do", method=RequestMethod.GET)
	public ModelAndView input() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/sum/input");// -> /sum/input.jsp
		return mav;
	}
	*/
	
	@RequestMapping(value="/input.do", method=RequestMethod.GET)
	//return타입이 String이면 단순 문자열이 아니라 뷰의 이름으로 사용된다.
	//뷰의 이름이 아니라 실제 문자열로 리턴하려면 @ResponseBody 을 사용한다. 바보.jsp가 아니라 "바보"를 사용한다.
	public String input() {
		
		return "/sum/input";
	}
	/*
	@RequestMapping(value="/result.do", method=RequestMethod.GET)
	public ModelAndView result() {
		ModelAndView mav = new ModelAndView();
		//mav.addObject("x", x);
		//mav.addObject("y", y);
		mav.setViewName("/sum/result");
		return mav;
	}
	
	@RequestMapping(value="/result.do", method=RequestMethod.GET)
	public ModelAndView result(@RequestParam int x, @RequestParam int y) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("x", x);
		mav.addObject("y", y);
		mav.addObject("sum", x+y);
		mav.setViewName("/sum/result");
		return mav;
	}
	
	@RequestMapping(value="/result.do", method=RequestMethod.GET)
	public ModelAndView result(
			@RequestParam(required=false, defaultValue="0") int x, //데이터가 안들어 오면 값을 0으로 둔다
			@RequestParam(required=false, defaultValue="0") int y) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("x", x);
		mav.addObject("y", y);
		
		mav.setViewName("/sum/result");
		return mav;
	}
	
	
	@RequestMapping(value="/result.do", method=RequestMethod.GET)
	public String result(@RequestParam Map<String, Integer> map, ModelMap modelMap) {//값이 RequestParam에 자동으로 map에 들어감 
		modelMap.put("x", map.get("x"));
		modelMap.put("y", map.get("y"));

		return "/sum/result";
	}
	*/
	
	@RequestMapping(value="/result.do", method=RequestMethod.GET)
	public String result(@ModelAttribute SumDTO sumDTO, Model model) {//값이 ModelAttribute을 통해 자동으로 sumDTO에 들어감 
		model.addAttribute("sumDTO", sumDTO);

		return "/sum/result";
	
	
	
	}
	
}
