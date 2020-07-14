package sample02_Java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloSpring {
	public static void main(String[] args) {
		MessageBean messageBean = new MessageBeanImpl();
		MessageBean proxy = (MessageBean) Proxy.newProxyInstance(MessageBean.class.getClassLoader(), new Class[] {MessageBean.class}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("입실 체크한다.");//공통사항
				
				Object ob = method.invoke(messageBean, args);//핵심사항 호출 around방식
				
				System.out.println("퇴실 체크한다.");//공통사항
				return ob;
			}
		});//()
		
		proxy.study();
		System.out.println("-----------------------");
		System.out.println("결과= "+proxy.game());
	}
}
