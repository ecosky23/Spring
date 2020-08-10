package board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.service.BoardService;
import member.bean.MemberDTO;

@Controller
@RequestMapping(value="board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="boardWriteForm", method=RequestMethod.GET)
	public String boardWriteForm(Model model) {
		model.addAttribute("display", "/board/boardWriteForm.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="boardWrite", method=RequestMethod.POST)
	public String boardWrite(@RequestParam Map<String, String> map, 
							 Model model) {
		boardService.boardWrite(map);//subject,content
		
		model.addAttribute("display", "/board/boardWrite.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="boardList", method=RequestMethod.GET)
	public String boardList(@RequestParam(required = false, defaultValue ="1") String pg, Model model) {
		model.addAttribute("pg", pg);
		model.addAttribute("display", "/board/boardList.jsp");
		
		return "/main/index";
	}
	
	@ResponseBody
	@RequestMapping(value="getBoardList", method=RequestMethod.POST)
	public ModelAndView getBoardList(@RequestParam String pg, HttpSession session, HttpServletResponse response) {
		
		String memId = (String) session.getAttribute("memId");
		
		//쿠키처리
		if(memId != null){
			Cookie cookie = new Cookie("memHit","ok");
			cookie.setMaxAge(30*60);//30분만 쿠키 유지
			cookie.setPath("/");//어떠한 경로든 쿠기가 들어올수 있게 하기
			response.addCookie(cookie);//클라이언트에게 보내기
		}
		
		//1페이지당 5개
		List<BoardDTO> list = boardService.getBoardList(pg);
		
		//페이징 처리
		BoardPaging boardPaging = boardService.boardPaging(pg);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.addObject("boardPaging", boardPaging);
		mav.addObject("memId", memId);
		
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="getBoardSearch", method=RequestMethod.GET)
	public ModelAndView getBoardSearch(@RequestParam Map<String, String> map) {
		
		List<BoardDTO> list = boardService.getBoardSearch(map);
		
		//페이징 처리
		BoardPaging boardPaging = boardService.boardPaging(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", map.get("pg"));
		mav.addObject("list", list);
		mav.addObject("boardPaging", boardPaging);
		
		
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="boardView", method=RequestMethod.GET)
	public String boardView(@RequestParam String seq,
							@RequestParam String pg,
							Model model) {
		model.addAttribute("seq", seq);
		model.addAttribute("pg", pg);
		model.addAttribute("display", "/board/boardView.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="getBoardView", method=RequestMethod.POST)
	public ModelAndView getBoardView(@RequestParam String seq, @CookieValue(value="memHit", required=false) Cookie cookie, HttpSession session, HttpServletResponse response) {
		
		String memId = (String) session.getAttribute("memId");
		
		//쿠키 - 조회수 증가
		System.out.println(cookie);
		if(cookie != null) {
			boardService.boardHit(seq);//조회수 증가
			
			//쿠키삭제
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		
		BoardDTO boardDTO = boardService.getBoard(seq);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardDTO", boardDTO);
		mav.addObject("memId", memId);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="boardReplyForm", method=RequestMethod.POST)
	public String boardReplyForm(@RequestParam String seq,
								 @RequestParam String pg,
								 Model model) {
		model.addAttribute("pseq", seq); //원글번호
		model.addAttribute("pg", pg); //원글이 있는 페이지 번호
		model.addAttribute("display", "/board/boardReplyForm.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="boardReply", method=RequestMethod.POST)
	public String boardReply(@RequestParam Map<String, Object> map, 
			 				 Model model) {
		boardService.boardReply(map);//pseq, pg, subject, content
		
		model.addAttribute("display", "/board/boardReply.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="boardModifyForm", method=RequestMethod.POST)
	public String boardModifyForm(@RequestParam String seq,
								  @RequestParam String pg,
								  Model model) {
		model.addAttribute("seq", seq);
		model.addAttribute("pg", pg);
		model.addAttribute("display", "/board/boardModifyForm.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="boardModify", method=RequestMethod.POST)
	@ResponseBody
	public void boardModify(@RequestParam Map<String, Object> map) {
		boardService.boardModify(map);	
	}
	
	@RequestMapping(value="boardDelete", method=RequestMethod.POST)
	@ResponseBody
	public void boardDeleteForm(@RequestParam String seq, Model model) {
		
	model.addAttribute("display", "/board/boardDelete.jsp");
			
		
	}
	
}
