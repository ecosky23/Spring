package sample05;

import lombok.Data;

@Data
public class SungJukDTO2 {
	private String name; // 이름은 중복 불가 
	private int kor; 
	private int eng; 
	private int math; 
	private int tot; 
	private double avg;
	
	@Override
	public String toString() {
		return name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + String.format("%.3f",avg);
	}
	
}
