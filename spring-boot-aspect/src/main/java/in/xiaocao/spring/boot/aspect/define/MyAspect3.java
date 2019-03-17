/**
 * Project Name:spring-boot-aspect
 * File Name:MyAspect3.java
 * Package Name:in.xiaocao.spring.boot.aspect.define
 * Date:2019年3月17日下午3:41:32
 * Copyright (c) 2019, wanzhengchong@163.com All Rights Reserved.
 *
*/

package in.xiaocao.spring.boot.aspect.define;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * ClassName:MyAspect3 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2019年3月17日 下午3:41:32 <br/>
 * @author   zhengchong.wan
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Aspect
public class MyAspect3 {
	
	@Pointcut("execution(* in.xiaocao.spring.boot.aspect.service.impl.UserServiceImpl.printUser(..))")
	public void pointcut() {
	}
	
	@Around("pointcut()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("around before ....");
		// 回调目标对象的原有方法
		joinPoint.proceed();
		System.out.println("around after ...");
	}

}

