package in.xiaocao.web;

import java.util.Locale;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.xiaocao.model.User;

@RestController
public class HelloController {
	
    @RequestMapping("/hello")
	public String hello(Locale locale, Model model) {
		return "Hello World";
	}
    
    @RequestMapping("/json")
    public User json() {
    	User user = new User();
    	user.setId(1L);
    	user.setUserName(" userName ");
    	user.setEmail("");
        user.setNickName("           ");
    	return user;
    }

}