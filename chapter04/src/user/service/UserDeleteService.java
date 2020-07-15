package user.service;

import java.util.Scanner;


import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;
@Setter
public class UserDeleteService implements UserService {
	private UserDAO userDAO;
	private String id;
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 아이디 입력: ");
		id = sc.next();
		
		UserDTO userDTO = userDAO.getUser(id);
		if(userDTO==null) {
			System.out.println("찾고자 하는 아이디가 없습니다.");
			return;
		}
			
			userDAO.delete(id);
			
			System.out.println("삭제를 완료하였습니다.");
		

	}

}
