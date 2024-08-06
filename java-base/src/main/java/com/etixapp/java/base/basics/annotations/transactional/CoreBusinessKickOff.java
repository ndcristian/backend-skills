package com.etixapp.java.base.basics.annotations.transactional;

import org.springframework.beans.factory.annotation.Autowired;

public class CoreBusinessKickOff {
	@Autowired
	CoreBusinessSubordinate subordinate;

	// getter/setters

	public void kickOff() {
		System.out.println("I do something big");
		subordinate.doSomethingBig();
		subordinate.doSomethingSmall(4);
	}
}
