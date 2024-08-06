package com.etixapp.java.base.basics.annotations.transactional;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CrossCuttingConcern {
	@Before("execution(* com.etixapp.java.base.basics.annotations.transactional.*(..))")
	public void doCrossCutStuff(){
		System.out.println("Doing the cross cutting concern now");
	}
}
