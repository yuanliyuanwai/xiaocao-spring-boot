/**
 * Project Name:spring-boot-aspect
 * File Name:UserController.java
 * Package Name:in.xiaocao.spring.boot.aspect.action
 * Date:2019年3月17日下午3:07:54
 * Copyright (c) 2019, wanzhengchong@163.com All Rights Reserved.
 *
*/

package in.xiaocao.spring.boot.aspect.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import in.xiaocao.spring.boot.aspect.entity.User;
import in.xiaocao.spring.boot.aspect.service.UserService;

/**
 * ClassName:UserController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2019年3月17日 下午3:07:54 <br/>
 * @author   zhengchong.wan
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/print")
	@ResponseBody
	public User printUser(Long id, String username, String note) {
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		user.setNote(note);
		userService.printUser(user);
		return user;
	}
	

}

