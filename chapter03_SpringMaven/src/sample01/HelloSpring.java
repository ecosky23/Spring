package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.conf.SpringConfiguraion;

public class HelloSpring {
	
	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("acQuickStart.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguraion.class);//xml 파일이 아니라 자바 파일을 직접적으로 련결해서 사용하는 방법
 		MessageBean bean = context.getBean("messageBeanImpl", MessageBean.class);
		
		
		/*
		bean.showPrintBefore();
		System.out.println("----------------");
		bean.viewPrintBefore();
		System.out.println("----------------");
		bean.display();
		System.out.println("----------------");
		*/
		/*
		bean.showPrintAfter();
		System.out.println("----------------");
		bean.viewPrintAfter();
		System.out.println("----------------");
		*/
		
		bean.showPrint();
		System.out.println("----------------");
		bean.viewPrint();
		System.out.println("----------------");
		bean.display();
		System.out.println("----------------");
		
	}
}
