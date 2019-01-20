package spring.boot.restful.invoke.action;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
	
    @Resource
	private RestTemplate restTemplate;
	
    @RequestMapping("/hello")
	public String hello(Locale locale, Model model) {
    	String result = restTemplate.getForObject("http://localhost:8080/hello", String.class);
		return result;
	}

}