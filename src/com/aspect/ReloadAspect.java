package com.aspect;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ReloadAspect {
	List<HttpSession> mylist=new ArrayList<HttpSession>();
	
	@Around("execution(* com.control.ShopControl.placeOrder(..))")
	public ModelAndView invoke(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("AROUND ADVICE called.. before the method");
		Object[] args=pjp.getArgs();
		HttpServletRequest request=(HttpServletRequest) args[1];
		HttpSession session=request.getSession();
		if(mylist.contains(session)) {
			ModelAndView mandv=(ModelAndView) args[0];
			mandv.setViewName("placeorder");
			return mandv;
		}else {
			mylist.add(session);
			pjp.proceed();
		}
		System.out.println("AROUND ADVICE called.. after the method");
		return null;
	}
}
