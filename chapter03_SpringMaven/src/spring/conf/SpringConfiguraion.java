package spring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import sample01.LoggingAdvice;
import sample01.MessageBeanImpl;

@EnableAspectJAutoProxy
@Configuration//환경설정하기
public class SpringConfiguraion {
	
	@Bean
	public MessageBeanImpl messageBeanImpl() {
		return new MessageBeanImpl();
	}
	@Bean
	public LoggingAdvice loggingAdvice() {
		return new LoggingAdvice();
	}
}
