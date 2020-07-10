package sample01;



import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;




@RequiredArgsConstructor	
public class MessageBeanImpl implements MessageBean{
	@NonNull
	private String fruit;
	@Setter
	private int cost, qty;
	
	
	/*
	public MessageBeanImpl(String fruit) {//생성자로 잡아놨다.
		super();
		this.fruit = fruit;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
*/
	
	
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
