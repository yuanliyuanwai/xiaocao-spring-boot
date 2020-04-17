package in.xiaocao.web;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import in.xiaocao.util.XiaoCaoProperties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProPertiesTest {

	@Autowired
    private XiaoCaoProperties neoProperties;

    @Test
    public void getHello() throws Exception {
    	System.out.println(neoProperties.getTitle());
        Assert.assertEquals(neoProperties.getTitle(), "曾经的故事");
        Assert.assertEquals(neoProperties.getDescription(), "简单生活简单学习简单工作");
    }

    @Test
    public void testMap() throws Exception {
    	Map<String, Long> orderMinTime=new HashMap<String, Long>();
    	long xx=orderMinTime.get("123");
    }

}