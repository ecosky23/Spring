package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;
@Transactional
@Repository//같은 타입끼리 주입해서 들어간다.
public class UserDAOMybatis implements UserDAO {
	@Autowired
	private SqlSession sqlSession;
	@Override
	public UserDTO checkId(String id) {
		
		return sqlSession.selectOne("userSQL.getUser", id);
	}
	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
		
	}
	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete", id);
		
	}
	@Override
	public List<UserDTO> getUserList() {
		
		return sqlSession.selectList("userSQL.getUserList");
	}
	@Override
	public UserDTO searchUser(String id) {
		
		return sqlSession.selectOne("userSQL.searchUser", id);
	}
	@Override
	public void modify(Map<String, String> map) {
		
		sqlSession.update("userSQL.modify", map);
	}
	
}
