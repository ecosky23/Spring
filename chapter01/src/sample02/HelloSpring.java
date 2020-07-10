package sample02;

public class HelloSpring {
	
	
	public static void main(String[] args) {
		//MessageBeanKo messageBean = new MessageBeanKo();
		
		
		//MessageBean messageBean = new MessageBeanKo();//부모 = 자식(다형성) 상속받기
		MessageBean messageBean = new MessageBeanEn();
		messageBean.sayHello("Spring");
		
		
	}
}
