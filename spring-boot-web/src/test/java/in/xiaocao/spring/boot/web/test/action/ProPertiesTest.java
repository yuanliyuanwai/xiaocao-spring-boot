package in.xiaocao.spring.boot.web.test.action;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import in.xiaocao.spring.boot.web.util.NeoProperties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProPertiesTest {

	
	@Autowired
    private NeoProperties neoProperties;


    @Test
    public void getHello() throws Exception {
    	System.out.println(neoProperties.getTitle());
        Assert.assertEquals(neoProperties.getTitle(), "猿里猿外");
        Assert.assertEquals(neoProperties.getDescription(), "分享生活和技术");
    }

}