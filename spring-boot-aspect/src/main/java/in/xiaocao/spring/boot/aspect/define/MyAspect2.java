package in.xiaocao.spring.boot.aspect.define;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class MyAspect2 {
	
	@Pointcut("execution(* in.xiaocao.spring.boot.aspect.service.impl.UserServiceImpl.printUser(..))")
	public void pointcut() {
	}
	
	@Before("pointcut()")
	public void before() {
		System.out.println("before ...");
	}
	
	@After("pointcut()")
	public void after() {
		System.out.println("after ...");
	}
	
	@AfterReturning("pointcut()")
	public void afterReturning() {
		System.out.println("afterReturning ...");
	}
	
	@AfterThrowing("pointcut()")
	public void afterThrowing() {
		System.out.println("afterThrowing ...");
	}
}

