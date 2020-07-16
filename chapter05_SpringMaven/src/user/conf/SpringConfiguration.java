package user.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import user.bean.UserDTO;
import user.dao.UserDAOMybatis;
import user.main.HelloSpring;
import user.service.UserDeleteService;
import user.service.UserInsertService;
import user.service.UserSelectService;
import user.service.UserUpdateService;

@Configuration
public class SpringConfiguration {
	
	@Bean
	public SqlSessionTemplate sqlSession() throws Exception{
		return new SqlSessionTemplate(sqlSessionFactory()); 
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver resource = new PathMatchingResourcePatternResolver();
		
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setConfigLocation(resource.getResource("spring/mybatis-config.xml"));
		sqlSessionFactoryBean.setMapperLocations(resource.getResources("user/dao/userMapper.xml"));
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		basicDataSource.setUsername("c##java");
		basicDataSource.setPassword("bit");
		basicDataSource.setMaxTotal(20);
		basicDataSource.setMaxIdle(3);
		
		return basicDataSource;
	}
	
	
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}
	
	
	
	
	@Bean
	public HelloSpring helloSpring() {
		HelloSpring helloSpring = new HelloSpring();
		return helloSpring;
	}
	
	@Bean
	public UserInsertService userInsertService() {
		return new UserInsertService();
	}
	
	@Bean
	public UserSelectService userSelectService() {
		return new UserSelectService();
	}
	
	@Bean
	public UserUpdateService userUpdateService() {
		return new UserUpdateService();
	}
	
	@Bean
	public UserDeleteService userDeleteService() {
		return new UserDeleteService();
	}
	
	@Bean
	public UserDTO userDTO() {
		return new UserDTO();
	}
	
	@Bean
	public UserDAOMybatis userDAOMybatis() {
		return new UserDAOMybatis();
	}
	
}
