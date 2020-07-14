package sample01;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//공통관심사항 - 별로 중요하진 않지만 공통으로 쓰는 코드들을 편리하게 사용하기 위해 모아둔것
//Aspect
@Aspect//공통 모듈이다. 공통관심사항 사용할때 써줘야 한다.
//@Component
@ComponentScan("sping.conf")//springConfiguration에서 설정값을 찾겠다.
public class LoggingAdvice {
	
	@Before("execution(public void sample01.MessageBeanImpl.*Before(..))")//이거 앞에 메소드를 넣어줄 것이다.
	public void beforeTrace() {
		System.out.println("before trace...");
	}
	
	@After("execution(public * *.*.*After(..))")
	public void afterTrace() {
		System.out.println("after trace...");
	}
	@Around("execution(public * *.*.*Print(..))")
	public void trace(ProceedingJoinPoint joinPoint) throws Throwable{//ProceedingJoinPoint 핵심을 호출해주는 역할 불러오고 다시복귀
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("메소드= "+methodName);
		
		StopWatch sw = new StopWatch();
		sw.start(methodName);
			
		Object ob = joinPoint.proceed();//핵심관심사항 호출 핵심을 처리하고 다시돌아온다
		System.out.println("결과 ob= "+ob);
		
		sw.stop();
		System.out.println("처리 시간= "+sw.getTotalTimeMillis()/1000+"초");
	}
}
