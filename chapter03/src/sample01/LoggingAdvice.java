package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

//공통관심사항 - 별로 중요하진 않지만 공통으로 쓰는 코드들을 편리하게 사용하기 위해 모아둔것
//Aspect
public class LoggingAdvice {
	
	public void beforeTrace() {
		System.out.println("before trace...");
	}
	
	public void afterTrace() {
		System.out.println("after trace...");
	}
	
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
