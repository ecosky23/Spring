package sample03;

import java.util.Scanner;

//@AllArgsConstructor 생성자나 이거나 2개중에 하나만 사용하면 된다.
public class SungJukImpl implements SungJuk {
	private SungJukDTO sungJukDTO;
	
	public SungJukImpl(SungJukDTO sungJukDTO) {
		this.sungJukDTO = sungJukDTO;
	}
	
	
	
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
