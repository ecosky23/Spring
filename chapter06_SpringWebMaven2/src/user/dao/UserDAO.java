package user.dao;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;

public interface UserDAO {

	public UserDTO checkId(String id);

	public void write(UserDTO userDTO);

	public void delete(String id);

	public List<UserDTO> getUserList();

	public UserDTO searchUser(String id);

	public void modify(Map<String, String> map);

	public List<UserDTO> searchUserList(UserDTO userDTO);

	

}
