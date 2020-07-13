package sample03;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
//@Component
@ComponentScan("spring.conf")//여기안에 모든설정이 들어있다.
public class SungJukDTO {
	private @Value("홍길동")String name;
	private @Value("90")int kor;
	private @Value("70")int eng;
	private @Value("80")int math;
	private int tot;
	private double avg;
	
	
}
