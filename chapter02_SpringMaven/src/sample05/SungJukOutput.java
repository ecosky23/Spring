package sample05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SungJukOutput implements SungJuk {
	@Qualifier("list")
	@Autowired
	private List<SungJukDTO2> list;
	

	/*
	 * public void setList(List<SungJukDTO2> list) { this.list = list; }
	 */

	@Override
	public void execute() {
		System.out.println("이름 \t 국어 \t 영어 \t 수학 \t 총점 \t 평균");
		for(SungJukDTO2 sungJukDTO2 : list) {
			System.out.println(sungJukDTO2.toString());			
		}
	}
}
//그냥 하면 싱글톤이 되서 입력 값이 모두 같은 값이 된다. 그래서 싱글톤을 깨야 한다.