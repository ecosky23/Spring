package sample01;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MessageBean messageBean = context.getBean("messageBeanImpl", MessageBean.class);//부모 클래스 = 자식클래스를 요약해준것 "messageBeanImpl"를 MessageBean형식으로 변호나
		
		messageBean.sayHello();
		
		messageBean.sayHello("참외",10000);
		messageBean.sayHello("수박",12000,3);
	}
	
}
