package sample05;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;

@Setter
public class SungJukModify implements SungJuk {
	private List<SungJukDTO2> list;

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("수정할 이름 입력: ");
		String name = scanner.next();
		
		int sw=0;
		for(SungJukDTO2 sungJukDTO2 : list) {
			if(sungJukDTO2.getName().equals(name)) {
				sw=1;
				System.out.print("국어점수 입력: ");
				sungJukDTO2.setKor(scanner.nextInt());
				System.out.print("영어점수 입력: ");
				sungJukDTO2.setEng(scanner.nextInt());
				System.out.print("수학점수 입력: ");
				sungJukDTO2.setMath(scanner.nextInt());
				sungJukDTO2.setTot(sungJukDTO2.getKor()
								 + sungJukDTO2.getEng()
								 + sungJukDTO2.getMath());
				sungJukDTO2.setAvg(sungJukDTO2.getTot() / 3.0);	
				
				System.out.println(name + "님의 데이터를 수정 하였습니다.");
			}
		}//for
		
		if(sw == 0)
			System.out.println("찾고자하는 이름이 없습니다.");
	}
}

