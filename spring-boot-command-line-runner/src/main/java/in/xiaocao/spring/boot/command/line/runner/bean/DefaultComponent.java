package in.xiaocao.spring.boot.command.line.runner.bean;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class DefaultComponent {
	
	@PostConstruct
	public void init() {
		System.out.println("The default component start to initialize ...");
	}

}