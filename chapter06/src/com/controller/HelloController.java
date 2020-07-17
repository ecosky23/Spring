package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller//이렇게 선언해줘야 요청한 url과 매핑이 되는 controller을 찾아 HandlerMapping이 찾아온다.
public class HelloController {
	
	@RequestMapping(value="/hello.do", method=RequestMethod.GET)//요청한 url Mapping
	public ModelAndView hello() {//콜백 메소드 Spring이 알아서 처리해 준다.
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "Have a nice day!!");
		//mav.setViewName("hello");//hello.jsp를 찾는다. .jsp는 servlet.xml에서 자동으로 달아주기를 선언했다.
		mav.setViewName("/view/hello");
		return mav;
	}
}
