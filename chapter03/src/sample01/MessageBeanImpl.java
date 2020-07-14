package sample01;
//핵심관심사항(핵심코드)
public class MessageBeanImpl implements MessageBean {
	
	private String str;

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public void showPrintBefore() {
		
		System.out.println("showPrintBefore 메세지= "+str);
		
	}

	@Override
	public void viewPrintBefore() {//쓰레드 걸어줘서 조금 늦게 뜸
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("viewPrintBefore 메세지= "+str);
		
	}

	@Override
	public void showPrintAfter() {
		
		System.out.println("showPrintAfter 메세지= "+str);
		
	}

	@Override
	public void viewPrintAfter() {//쓰레드 걸어줘서 조금 늦게 뜸
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("viewPrintAfter 메세지= "+str);
		
	}
	
	@Override
	public void display() {
		System.out.println("display 메세지= "+str);
		
	}

	@Override
	public String showPrint() {
		System.out.println("showPrint 메세지= "+str);
		
		return "하하";
		
	}

	@Override
	public void viewPrint() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("viewPrint 메세지= "+str);
		
	}

}
//joinPoint = showPrintBefore(), viewPrintBefore(),display()

//pointCut = showPrintBefore(), viewPrintBefore()