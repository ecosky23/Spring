package sample02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("calcAdd")
public class CalcAdd implements Calc {
	
	private int x;
	private int y;

	
	public CalcAdd(@Value("70")int x, @Value("25")int y) {
		
		this.x = x;
		this.y = y;
		
	}


	@Override
	public void calculate() {
		System.out.println(x + "+" + y + "=" + (x+y));	

	}

}
