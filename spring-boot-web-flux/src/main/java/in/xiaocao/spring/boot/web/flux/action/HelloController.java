/**
 * Project Name:spring-boot-web-flux
 * File Name:HelloController.java
 * Package Name:in.xiaocao.spring.boot.web.flux.action
 * Date:2019年2月18日上午9:14:06
 * Copyright (c) 2019, wanzhengchong@163.com All Rights Reserved.
 *
*/

package in.xiaocao.spring.boot.web.flux.action;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

/**
 * ClassName:HelloController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2019年2月18日 上午9:14:06 <br/>
 * @author   zhengchong.wan
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@RestController
public class HelloController {
	
	@GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Welcome to reactive world ~");
    }

}

