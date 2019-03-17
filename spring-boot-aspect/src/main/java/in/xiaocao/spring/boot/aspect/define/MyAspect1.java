/**
 * Project Name:spring-boot-aspect
 * File Name:MyAspect.java
 * Package Name:in.xiaocao.spring.boot.aspect.define
 * Date:2019年3月17日下午2:58:28
 * Copyright (c) 2019, wanzhengchong@163.com All Rights Reserved.
 *
*/

package in.xiaocao.spring.boot.aspect.define;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class MyAspect1 {
	
	@Before("execution(* in.xiaocao.spring.boot.aspect.service.impl.UserServiceImpl.printUser(..))")
	public void before() {
		System.out.println("before ...");
	}
	
	@After("execution(* in.xiaocao.spring.boot.aspect.service.impl.UserServiceImpl.printUser(..))")
	public void after() {
		System.out.println("after ...");
	}
	
	@AfterReturning("execution(* in.xiaocao.spring.boot.aspect.service.impl.UserServiceImpl.printUser(..))")
	public void afterReturning() {
		System.out.println("afterReturning ...");
	}
	
	@AfterThrowing("execution(* in.xiaocao.spring.boot.aspect.service.impl.UserServiceImpl.printUser(..))")
	public void afterThrowing() {
		System.out.println("afterThrowing ...");
	}
}

