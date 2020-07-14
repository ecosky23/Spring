package sample03_Advice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext03.xml");
		MessageBean bean = context.getBean("proxy", MessageBean.class);
		bean.study();
		System.out.println("-----------------------------");
		System.out.println("결과= "+bean.game());
	}
}
