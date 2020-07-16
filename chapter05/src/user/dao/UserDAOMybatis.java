package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import user.bean.UserDTO;
@Transactional//이 DB안에서 자동으로 COMMIT CLOSE 해라 정해주는 것
public class UserDAOMybatis implements UserDAO {
	@Setter
	private SqlSession sqlSession;
	
	@Override
	public void write(UserDTO userDTO) {
		int su = sqlSession.insert("userSQL.write", userDTO);

	}

	@Override
	public List<UserDTO> getUserList() {
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserList");
		
		return list;
	}

	@Override
	public void modify(Map<String, String> map) {
		sqlSession.update("userSQL.modify",map);

	}

	@Override
	public UserDTO getUser(String id) {
		
		return sqlSession.selectOne("userSQL.getUser", id);
	}

	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete", id);

	}

}
