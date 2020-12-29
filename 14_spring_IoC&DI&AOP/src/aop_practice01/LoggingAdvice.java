package aop_practice01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("[Before invoking a method: LoggingAdvice");
		System.out.println(invocation.getMethod() + "before invoking");
		
		Object object = invocation.proceed();
		
		System.out.println("[After invoking a method: LoggingAdvice");
		System.out.println(invocation.getMethod() + "after invoking");
		return object;
	}

}
