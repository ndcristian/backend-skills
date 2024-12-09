package com.etixapp.design.patterns.creational.design.patterns.factory.explainedSimpleFactory;

public class SimpleBurgerFactory {

	// With this approach we fixed the single responsibility pattern
	//BUT we break the Open Close Principle -- because if we want to extend this class by adding more burgers types we have to change the class

	// Solution : Make restaurant abstract

	// Second implementation
	/*
		public Burger createBurger(String request) {
		Burger burger = null;
		if (request.equals("BEEF")) {
			return new BeefBurger();
		} else if (request.equals("VEGGIE")) {
			return new VeggieBurger();
		}
		return null;
	}
	 */

}
