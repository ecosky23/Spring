package user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import user.bean.UserDTO;
import user.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/writeForm", method=RequestMethod.GET)
	public String writeForm() {
		return "/user/writeForm";
	}
	
	
	@RequestMapping(value="/user/checkId", produces="application/String;charset=UTF-8",method=RequestMethod.POST)
	public @ResponseBody String checkId(@RequestParam String id){
		String result = userService.checkId(id);
		System.out.println(result);
		return result;
	}
	
	@RequestMapping(value="/user/write", method=RequestMethod.POST)
	@ResponseBody
	public void wrtie(@ModelAttribute UserDTO userDTO) {// @ResponseBody리턴값이 JSP로 못가게 막는다.
		userService.write(userDTO);
		
	}
	
	@RequestMapping(value="/user/deleteForm", method=RequestMethod.GET)
	public String deleteForm() {
		return "/user/deleteForm";
	}
	
	@RequestMapping(value="/user/delete", method=RequestMethod.POST)
	@ResponseBody
	public void delete(@RequestParam String id) {
		userService.delete(id);
		
	}
	
	@RequestMapping(value="/user/list", method=RequestMethod.GET)
	public String list() {
		return "/user/list";
	}
	
	@RequestMapping(value="/user/modifyForm", method=RequestMethod.GET)
	public String modifyForm() {
		return "/user/modifyForm";
	}
	
	
	
	/*
	@RequestMapping(value="/user/getUserList", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getUserList() {
		List<UserDTO> list = userService.getUserList();
		
		JSONObject json = new JSONObject();
		if(list!=null) {
			JSONArray array = new JSONArray();
			for(int i=0; i<list.size(); i++) {
				UserDTO userDTO = list.get(i);
				
				JSONObject temp = new JSONObject();
				temp.put("name", userDTO.getName());
				temp.put("id", userDTO.getId());
				temp.put("pwd", userDTO.getPwd());
				
				array.add(i, temp);
			}//for
			
			json.put("list", array);
		}
		
		return json;
	}
	
	
	@RequestMapping(value="/user/getUserList", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getUserList() {
		List<UserDTO> list = userService.getUserList();
		JSONArray array = JSONArray.fromObject(list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list",array);
		
		
		return map;
	}
	*/
	
	@RequestMapping(value="/user/searchUser", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getUser(@RequestParam String id) {
		UserDTO userDTO = userService.searchUser(id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userDTO", userDTO);
		mav.setViewName("jsonView");
	
		return mav;
	}
	
	
	@RequestMapping(value="/user/getUserList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getUserList() {
		List<UserDTO> list = userService.getUserList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");//servlet-context.xml에서 jsonview를 찾아서 json을 처리할 수 있게 한다.
		return mav;
	}
	
	@RequestMapping(value="/user/modify", method=RequestMethod.POST)
	@ResponseBody
	public void modify(@ModelAttribute UserDTO userDTO){
		System.out.println(userDTO.getId());
		userService.modify(userDTO);
	}
	
	
}
