package sample01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageBeanImpl implements MessageBean{
	
	private @Value("딸기")String fruit;//각각의 변수를 준다.
	
	private @Value("3500")int cost; 
	private @Value("2") int qty;
	
	
	@Override
	public void sayHello() {
		System.out.println(fruit+"\t"+cost+"\t"+qty);
		
	}

	@Override
	public void sayHello(String fruit, int cost) {
		System.out.println(fruit+"\t"+cost+"\t"+qty);
	}

	@Override
	public void sayHello(String fruit, int cost, int qty) {
		System.out.println(fruit+"\t"+cost+"\t"+qty);
		
	}
	
}
