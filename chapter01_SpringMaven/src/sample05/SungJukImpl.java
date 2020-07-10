package sample05;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component("sungJukImpl")
public class SungJukImpl implements SungJuk {
	private int kor, math, eng, total;
	private double avg;
	private String name;
	
	public SungJukImpl() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("이름 입력: " );
		name = scanner.next();
		System.out.println("국어 입력: " );
		 kor = scanner.nextInt();
		System.out.println("영어 입력: ");
		eng = scanner.nextInt();
		System.out.println("수학 입력: ");
		math = scanner.nextInt();
		
	}
	@Override
	public void calc() {
		total=kor + math + eng;
		avg = total/3;
	}
	
	
	  @Override 
	  public void display() {
		  
	  System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
	  System.out.println(name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+total+"\t"+String.format("%.2f", avg));
	 
	  }

}
