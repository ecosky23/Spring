package sample04;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter {
	private String filePath, fileName;
	
	public FileOutputter() {
		System.out.println("2. FileOutputter 기본생성자");
	}
	
	public void setFilePath(String filePath) {
		System.out.println("3. setFilePath(String filePath)");
		this.filePath = filePath;
	}


	public void setFileName(String fileName) {
		System.out.println("4. setFileName(String fileName)");
		this.fileName = fileName;
	}


	@Override
	public void output(String message) {
		try {
			System.out.println("8.output");
			FileWriter fileWriter = new FileWriter(filePath+fileName);// FileWriter(파일경로)
			fileWriter.write(message);//내용을 파일로 보내기
			fileWriter.close();//꼭닫아줘야 한다.
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
