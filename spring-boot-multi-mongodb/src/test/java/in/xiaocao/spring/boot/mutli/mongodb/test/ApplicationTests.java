package in.xiaocao.spring.boot.mutli.mongodb.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import in.xiaocao.spring.boot.multi.mongodb.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {Application.class})
public class ApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("hello world");
	}

}
