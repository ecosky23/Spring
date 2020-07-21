package user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import user.bean.UserDTO;


public interface UserService {

	public String checkId(String id);

	public void write(UserDTO userDTO);

	public void delete(String id);

	public List<UserDTO> getUserList();

	public UserDTO searchUser(String id);

	public void modify(UserDTO userDTO);
	
}
