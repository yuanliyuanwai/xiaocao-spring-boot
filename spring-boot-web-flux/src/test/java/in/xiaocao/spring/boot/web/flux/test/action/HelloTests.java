/**
 * Project Name:spring-boot-web
 * File Name:HelloTests.java
 * Package Name:in.xiaocao.spring.boot.web.test.redis
 * Date:2019年2月18日上午9:20:16
 * Copyright (c) 2019, wanzhengchong@163.com All Rights Reserved.
 *
*/

package in.xiaocao.spring.boot.web.flux.test.action;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import in.xiaocao.spring.boot.web.flux.action.HelloController;

/**
 * ClassName:HelloTests <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2019年2月18日 上午9:20:16 <br/>
 * @author   zhengchong.wan
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@RunWith(SpringRunner.class)
@WebFluxTest(controllers = HelloController.class)
public class HelloTests {
    @Autowired
    WebTestClient client;

    @Test
    public void getHello() {
        client.get().uri("/hello").exchange().expectStatus().isOk();
    }
}
