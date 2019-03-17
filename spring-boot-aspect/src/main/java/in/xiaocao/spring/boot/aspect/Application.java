package in.xiaocao.spring.boot.aspect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import in.xiaocao.spring.boot.aspect.define.MyAspect3;

@SpringBootApplication
public class Application {
	
	/*
	 * @Bean(name = "myAspect1") public MyAspect1 initMyAspect1() { return new
	 * MyAspect1(); }
	 */
	
	/*
	 * @Bean(name = "myAspect2") public MyAspect2 initMyAspect2() { return new
	 * MyAspect2(); }
	 */
	
	@Bean(name = "myAspect3") 
    public MyAspect3 initMyAspect3() { 
		  return new MyAspect3(); 
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
