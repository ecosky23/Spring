package member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;
import member.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public @ResponseBody String login(@RequestParam Map<String, String> map, HttpServletRequest request, HttpSession session, Model model) {
		
		
	MemberDTO memberDTO = memberService.login(map);
	
	String loginFail = null;
	//응답
	if(memberDTO==null) {
		loginFail = "fail";
		
	}else {
		//세션
		session = request.getSession(); //세션 생성
		session.setAttribute("memName", memberDTO.getName());
		session.setAttribute("memId", map.get("id"));
		session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
		
		loginFail ="success";
	}
	
	
	model.addAttribute("loginFail", loginFail);

	return loginFail;
	}
	
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session, Model model) {
		session.invalidate();
		//model.addAttribute("display", "/template/body.jsp");
		return new ModelAndView("redirect:/main/index");// 코드가 똑깥을 때 중복으로 쓰지 말고 코드를 다시 부르는 방법
	}
	
	@RequestMapping(value="writeForm", method=RequestMethod.GET)
	public String writeForm(Model model) {
		model.addAttribute("display", "/member/writeForm.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="checkId", method=RequestMethod.POST)
	@ResponseBody
	public String checkId(@RequestParam String id) {
		
		return memberService.checkId(id);
	}
	
	@RequestMapping(value="checkPost", method=RequestMethod.GET)
	public String checkPost() {
		
		return "/member/checkPost";
	}
	
	@RequestMapping(value="getZipecodeList", method=RequestMethod.POST)
	public ModelAndView getZipecodeList(@RequestParam Map<String, String> map) {
	
		List<ZipcodeDTO> list = memberService.getZipecodeList(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	@RequestMapping(value="wrtie", method=RequestMethod.POST)
	public String write(@ModelAttribute MemberDTO memberDTO, Model model) {
		
		memberService.write(memberDTO);
		
		model.addAttribute("display", "/member/write.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="modifyForm", method=RequestMethod.GET)
	public String modifyForm(HttpSession session, Model model) {
		String id = (String) session.getAttribute("memId");
		MemberDTO memberDTO = memberService.getMember(id);
				
		model.addAttribute("memberDTO", memberDTO);
		model.addAttribute("display", "/member/modifyForm.jsp");
		return "/main/index";
	}
	@ResponseBody
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public void modify(@ModelAttribute MemberDTO memberDTO) {
		
		memberService.modify(memberDTO);
		
	}
	
	
}
