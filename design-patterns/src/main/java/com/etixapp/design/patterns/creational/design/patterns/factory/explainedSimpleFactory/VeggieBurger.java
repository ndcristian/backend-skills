package com.etixapp.design.patterns.creational.design.patterns.factory.explainedSimpleFactory;

// FIRST implementation
/*
public class VeggieBurger extends Burger {
	@Override
	public void prepare() {
		System.out.println("VeggieBurger prepared");
	}

}
*/

// THIRD implementation with restaurant abstract

public class VeggieBurger extends Restaurant implements Burger {

	// FIRST implementation
	/*
		@Override
	public void prepare() {
		System.out.println("VeggieBurger prepared");
	}
	 */


	@Override
	public Burger createBurger() {
		return new VeggieBurger();
	}

	@Override
	public void prepare() {

	}
}
