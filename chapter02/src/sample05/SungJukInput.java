package sample05;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class SungJukInput implements SungJuk {
	private SungJukDTO2 sungJukDTO2;
	private List<SungJukDTO2> list;
	
	public void setSungJukDTO2(SungJukDTO2 sungJukDTO2) {//applicationContext에서 값을 지정함
		this.sungJukDTO2 = sungJukDTO2;
	}

	
	public void setList(List<SungJukDTO2> list) {
		this.list = list;
	}


	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름 입력: ");
		String name = scanner.next();		
		System.out.print("국어 점수 입력: ");
		int kor = scanner.nextInt();
		System.out.print("영어 점수 입력: ");
		int eng = scanner.nextInt();
		System.out.print("수학 점수 입력: ");
		int math = scanner.nextInt();

		sungJukDTO2.setName(name);
		sungJukDTO2.setKor(kor);
		sungJukDTO2.setEng(eng);
		sungJukDTO2.setMath(math);
		sungJukDTO2.setTot(kor+eng+math);
		sungJukDTO2.setAvg(sungJukDTO2.getTot()/3.0);
		
		list.add(sungJukDTO2);
		
		System.out.println(sungJukDTO2.getName()+" 님의 데이터를 입력 하였습니다.");
	}

}
