package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import lombok.Setter;
import user.bean.UserDTO;

/*
public class UserDAOImpl implements UserDAO {
	@Setter
	private JdbcTemplate jdbcTemplate;
	
	-- jdbcTemplate 메모리에 생성 : ConnectionPool preparedStatment Resultset close 다해준다.
	롬복으로 setter해줘서 지워도 된다.
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public void write(UserDTO userDTO) {
		String sql = "insert into usertable values(?,?,?)";
		jdbcTemplate.update(sql, userDTO.getName(),userDTO.getId(), userDTO.getPwd());
		
	}

}
*/
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	
	@Override
	public void write(UserDTO userDTO) {
		//String sql = "insert into usertable values(?,?,?)";
		//getJdbcTemplate().update(sql, userDTO.getName(),userDTO.getId(), userDTO.getPwd());
		//getJdbcTemplate()는 JdbcDaoSupport가 가지고 있는 함수다
		
		//NamedParameterJdbcDaoSupport DTO를 받지못한다. 그래서 Map을 사용해야 한다.
		String sql = "insert into usertable values(:name,:id,:pwd)";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", userDTO.getId());
		map.put("name", userDTO.getName());
		map.put("pwd", userDTO.getPwd());
		getNamedParameterJdbcTemplate().update(sql, map);
		
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));//new BeanPropertyRowMapper : Userdto에 있는 변수와 db에 있는 변수와 이름을 비교하여 저절로 연결해줌
	}//query는 list타입을 받는다.

	@Override
	public UserDTO getUser(String id) {
		UserDTO userDTO=null;
		String sql = "select * from usertable where id=?";
	try {	
		 userDTO = getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class), id);
		} catch (EmptyResultDataAccessException e) {
			
		}
		 return userDTO;
	}

	@Override
	public void modify(Map<String, String> map) {
		String sql = "update usertable set name=:name, pwd=:pwd where id=:id";
		getNamedParameterJdbcTemplate().update(sql, map);
		
	}

	@Override
	public void delete(String id) {
		String sql = "delete from usertable where id=:id";
		getJdbcTemplate().update(sql, id);
		
	}

}