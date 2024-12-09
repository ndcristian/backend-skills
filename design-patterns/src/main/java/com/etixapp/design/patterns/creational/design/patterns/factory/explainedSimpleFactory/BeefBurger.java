package com.etixapp.design.patterns.creational.design.patterns.factory.explainedSimpleFactory;

// FIRST implementation
/*
public class BeefBurger extends  Burger{

	@Override
	public void prepare(){
		System.out.println("BeefBurger prepared");
	}
}
 */

// THIRD implementation
public class BeefBurger extends  Restaurant implements Burger{

	@Override
	public void prepare() {

	}

	@Override
	public Burger createBurger() {
		return null;
	}
}
