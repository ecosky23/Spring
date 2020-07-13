package spring.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample03.SungJukImpl;
import sample05.SungJukDTO2;
import sample03.SungJukDTO;

@Configuration//일반자바가 아니라 빈을 설정하고 생성하는 부분이다.
public class SpringConfiguration {
	
	@Bean(name="sungJukImpl")//메모리에 Bean을 설정해 달라 그리고 메소드명을 객체명으로 인식한다. 또는 @Bean옆에 (name="sungJukImpl")을 설정해 준다. 
	public SungJukImpl getSungJukImpl() {
		return new SungJukImpl();
	}
	@Bean//리턴되서 나오는 타입을 빈으로 설정
	public SungJukDTO2 sungJukDTO2() {
		return new SungJukDTO2();
	}
	@Bean
	public List<SungJukDTO2> list(){
		return new ArrayList<SungJukDTO2>();
	}
	
}
