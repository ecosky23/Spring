package sample05;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;




@Component
@Scope("prototype")
public class SungJukInput implements SungJuk {

	@Autowired//자동으로 맵핑하기 -  같은 @Component("SungJukDTO2")나 Configuration에서 SungJukDTO2값을 찾는다.
	private SungJukDTO2 sungJukDTO2;
	
	//List가 부모이르몰 여러개의 클래스가 생성될수 있다.
	//그러므로 반드시@Qualifier를 사용해서 Bean id를 등록해야 한다.
	@Qualifier("list")//부모클래스인 List가 자식클래스가 많아서 반드시 지정해줘야 한다.
	@Autowired//자동으로 맵핑하기 같은 @Component("List")나 @Bean을 찾는다. Configuration에서 찾는다.
	private List<SungJukDTO2> list;

	
	/*
	 * public void setSungJukDTO2(SungJukDTO2 sungJukDTO2) {//applicationContext에서
	 * 값을 지정함 this.sungJukDTO2 = sungJukDTO2; 
	 * }
	 * 
	 * 
	 * public void setList(List<SungJukDTO2> list) { 
	 * this.list = list; 
	 * }
	 */
	

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
		sungJukDTO2.setTot(kor + eng + math);
		sungJukDTO2.setAvg(sungJukDTO2.getTot() / 3.0);

		list.add(sungJukDTO2);

		System.out.println(sungJukDTO2.getName() + " 님의 데이터를 입력 하였습니다.");
	}

}
