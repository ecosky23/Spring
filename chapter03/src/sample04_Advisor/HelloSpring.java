package sample04_Advisor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext04.xml");
		MessageBean bean = context.getBean("proxy", MessageBean.class);
		
		//study만 공통 관심사항이 삽입된다.
		bean.study();
		System.out.println("-----------------------------");
		System.out.println("결과= "+bean.game());
		System.out.println("------------------------------");
		bean.lesson();
	}
}
