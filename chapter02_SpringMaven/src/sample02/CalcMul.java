package sample02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalcMul implements Calc {
	
	private int x;
	private int y;

	@Autowired//호출안된 데이터를 필요할때 주입해준다.
	public void setX(@Value("25")int x) {
		this.x = x;
	}

	@Autowired
	public void setY(@Value("30")int y) {
		this.y = y;
	}


	@Override
	public void calculate() {
		System.out.println(x + "*" + y + "=" + (x*y));

	}

}
