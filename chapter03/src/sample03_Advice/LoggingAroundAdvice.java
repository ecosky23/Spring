package sample03_Advice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAroundAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Around 입실 체크");
		
		long start = System.currentTimeMillis(); //핵심을 부르기전 시간을 체크하고
		
		Object ob = invocation.proceed();//핵심을 부른다.
		
		long end = System.currentTimeMillis();//핵심을 부른이후 시간을 체크한다.
		
		System.out.println((end-start)/1000+"초");
		
		System.out.println("Around 퇴실 체크");
		
		return ob;
	}

}
