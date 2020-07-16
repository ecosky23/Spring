package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import user.service.UserService;


@ComponentScan("user.conf")//이곳에 설정되어 있다.
public class HelloSpring {
	
	public void menu(ApplicationContext context){
	
		Scanner scanner = new Scanner(System.in);
		
		int choice;
		UserService userService = null;
		
		while(true) {
			
			System.out.println("-----------------");
			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.수정");
			System.out.println("4.삭제");
			System.out.println("5.끝");
			System.out.println("-------------------");
			System.out.println("번호 입력: ");
			choice = scanner.nextInt();
			
			if(choice == 5) break;
			
			if(choice == 1) { userService = context.getBean("userInsertService", UserService.class);			
				
			} else if(choice == 2) { userService = context.getBean("userSelectService", UserService.class);		
				
			} else if(choice == 3) { userService = context.getBean("userUpdateService", UserService.class);	
				
			} else if(choice == 4) { userService = context.getBean("userDeleteService", UserService.class);			
				
			} else {
				System.out.println("1~5번 까지만 입력 가능");
				continue;
			}
			userService.execute();
		}//while
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		HelloSpring helloSpring = context.getBean("helloSpring", HelloSpring.class);
		helloSpring.menu(context);
		System.out.println("프로그램을 종료합니다.");
		
	}
}
