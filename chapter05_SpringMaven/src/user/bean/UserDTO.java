package user.bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ComponentScan("user.conf")//이곳에 설정되어 있다.
public class UserDTO {
	private String name, id, pwd;
}
