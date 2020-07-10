package sample03;


import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class SungJukDTO {
	private String name;
	private int kor, eng, math, tot;
	private double avg;
	
	
}
