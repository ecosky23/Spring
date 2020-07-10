package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {
	
	
	public static void main(String[] args) {
		//ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");//환경설정 경로 지정하기
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");//XML파일 환경설정 경로 지정하기
		
		MessageBean bean = (MessageBean) context.getBean("messageBean");// applicationContext.xml에 있는  class="sample03.MessageBeanKo"을 가져오기 위해 id 값을 지정해서 가져온다. 
																		//이것을 부모 객체에 넣고 object타입으로 넘어오는 형태를 MessageBean형식으로 형변환 한다.
		bean.sayHello("Spring");
		
		MessageBean bean2 = context.getBean("messageBean", MessageBean.class);//스프링은 기본이 싱글톤이다. 그래서 하나의 bean을 같이 사용한다. 객체를 하나하나 생성하려면 xml의 scope를 프로토타입으로 설정해줘야한다. 																	
		bean2.sayHello("Spring");												//.getBean("messageBean", MessageBean.class); messageBean을 MessageBean.class형식으로 가져온다는 것이다. 이런형식으로 하면 형변환 안해도 된다.
		
		MessageBean bean3 = (MessageBean) context.getBean("messageBean"); 																		
		bean3.sayHello("Spring");
	}
}
