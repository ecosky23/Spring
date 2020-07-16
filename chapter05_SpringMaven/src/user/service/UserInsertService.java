package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;


@Service
public class UserInsertService implements UserService {
	@Autowired
	private UserDTO userDTO;
	@Autowired
	private UserDAO userDAO;
	
	/* 롬복 setter 써서 지워도 됨
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
*/
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
