package sample03;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//@AllArgsConstructor 생성자나 이거나 2개중에 하나만 사용하면 된다.
//@Component
@ComponentScan("spring.conf")
public class SungJukImpl implements SungJuk {
	@Autowired//컴포넌트(component)로 선언된 객체중에서 아래의 타입을 찾아서 자동으로 맵핑을 걸어라 xml에서 따로 경로를 지정해 놓지 않기 때문에 자동으로 찾아줘야 한다.
	private SungJukDTO sungJukDTO;
	
	/*
	public SungJukImpl(SungJukDTO sungJukDTO) {
		this.sungJukDTO = sungJukDTO;
	}
	*/
	
	
	@Override
	public void calcTot() {
		
		sungJukDTO.setTot(sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath()) ;
		
	}

	@Override
	public void calcAvg() {
		sungJukDTO.setAvg(sungJukDTO.getTot()/3.0);
		
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(sungJukDTO.getName()+"\t"+
							sungJukDTO.getKor()+"\t"+
							sungJukDTO.getEng()+"\t"+
							sungJukDTO.getMath()+"\t"+
							sungJukDTO.getTot()+"\t"+
							String.format("%.2f",sungJukDTO.getAvg()));
		
	}



	@Override
	public void modify() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("이름 입력: " );
		sungJukDTO.setName(scanner.next());
		System.out.println("국어 입력: " );
		sungJukDTO.setKor(scanner.nextInt());
		System.out.println("영어 입력: ");
		sungJukDTO.setEng(scanner.nextInt());
		System.out.println("수학 입력: ");
		sungJukDTO.setMath(scanner.nextInt());
		
	}

	
	
}
