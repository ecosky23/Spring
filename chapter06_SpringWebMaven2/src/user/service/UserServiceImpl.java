package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public String checkId(String id){
		UserDTO userDTO = userDAO.checkId(id);
		
		if(userDTO == null) {
			return "사용 가능";
		}else {
			return "사용 불가능";
		}
	}

	@Override
	public void write(UserDTO userDTO) {
		userDAO.write(userDTO);
		
	}

	@Override
	public void delete(String id) {
		userDAO.delete(id);
		
	}

	@Override
	public List<UserDTO> getUserList() {
		
		return userDAO.getUserList();
	}

	@Override
	public UserDTO searchUser(String id) {
		
		return userDAO.searchUser(id);
	}

	@Override
	public void modify(UserDTO userDTO) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		
		
		userDAO.modify(map);
		
	}

}
