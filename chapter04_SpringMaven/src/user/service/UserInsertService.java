package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import user.bean.UserDTO;
import user.dao.UserDAO;


@Service
public class UserInsertService implements UserService {
	@Autowired//같은 @표시가 있는 항목에 연결해라
	private UserDTO userDTO;
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름 입력: ");
		String name = sc.next();
		System.out.println("아이디 입력: ");
		String id = sc.next();
		System.out.println("비밀번호 입력: ");
		String pwd = sc.next();
		
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		userDAO.write(userDTO);
		
		System.out.println(userDTO.getName()+" 데이터 입력완료");
		

	}

}
