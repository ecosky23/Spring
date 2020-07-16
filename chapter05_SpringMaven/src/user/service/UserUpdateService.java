package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserUpdateService implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserDTO userDTO;
	private String name;
	private String id;
	private String pwd;
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("수정할 아이디 입력: ");
		id = sc.next();
		userDTO = userDAO.getUser(id);
		
		if(userDTO==null){
			
			System.out.println("찾고자 하는 아이디가 없습니다.");
			return;
		}else {
			
			System.out.println(userDTO.getName()+"\t"+userDTO.getId()+"\t"+userDTO.getPwd());
			
			System.out.println("수정할 이름 입력: ");
			name= sc.next();
			System.out.println("수정할 비밀번호 입력: ");
			pwd = sc.next();
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", name);
			map.put("id", id);
			map.put("pwd", pwd);
			
			userDAO.modify(map);
			
			System.out.println(id+"님의 정보를 수정 완료");
		}
		
	}

}
