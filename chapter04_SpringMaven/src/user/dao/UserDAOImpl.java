package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


import user.bean.UserDTO;

@Repository("userDAO")//DB쪽 일을 할때는 Repository도 많이 쓴다. Component써도 된다.
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	@Autowired
	public void setDS(DataSource dataSource) {//dataSource를 NamedParameterJdbcDaoSupport에 전달하는 방법
		setDataSource(dataSource);
	}
	
	
	@Override
	public void write(UserDTO userDTO) {
		
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
	}//query는 list타입으로 받는다.

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