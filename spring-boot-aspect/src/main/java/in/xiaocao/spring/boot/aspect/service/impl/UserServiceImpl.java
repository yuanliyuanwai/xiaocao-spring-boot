/**
 * Project Name:spring-boot-aspect
 * File Name:UserServiceImpl.java
 * Package Name:in.xiaocao.spring.boot.aspect.service.impl
 * Date:2019年3月17日下午2:55:43
 * Copyright (c) 2019, wanzhengchong@163.com All Rights Reserved.
 *
*/

package in.xiaocao.spring.boot.aspect.service.impl;

import org.springframework.stereotype.Service;

import in.xiaocao.spring.boot.aspect.entity.User;
import in.xiaocao.spring.boot.aspect.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public void printUser(User user) {
		if (user == null) {
			throw new RuntimeException("检查用户参数是否为空......");
		}
		System.out.println("id = " + user.getId());
		System.out.println("username = " + user.getUsername());
		System.out.println("note = " + user.getNote());
	}

}

