package com.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SessionAspect {
	
	@Before("execution(* com.control.LoginController.loginForm(..))")
	public void invalidate(JoinPoint jp) {
		Object[] obj=jp.getArgs();
		HttpServletRequest request=(HttpServletRequest) obj[1];
		HttpSession session=request.getSession(false);
		if(session!=null) session.invalidate();
	}
	
	@Before("execution(* com.control.ShopControl.*(..))")
	public ModelAndView verify(JoinPoint jp) {
		Object[] obj=jp.getArgs();
		HttpServletRequest request=(HttpServletRequest) obj[1];
		HttpSession session=request.getSession();
		if(session.isNew()) {
			ModelAndView mandv=(ModelAndView) obj[0];
			mandv.setViewName("error.jsp");
			return mandv;
		}
		return null;
	}
}
