package com.etixapp.design.patterns.creational.design.patterns.factory.explainedSimpleFactory;

// abstract is part of the third implementation
public abstract class Restaurant {

	// What if we want to add a new burger type ??? We have to change the class
	//** this approach beaks the single responsibility principle and Open close principle
	//** Solution: create a separate class SimpleBurgerFactory

	//FIRST implementation::

	/*
	public Burger orderBurger(String request) {
		Burger burger = null;
		if (request.equals("BEEF")) {
			return new BeefBurger();
		} else if (request.equals("VEGGIE")) {
			return new VeggieBurger();
		}
		try {
			burger.prepare();
		} catch (NullPointerException e) {
			System.out.println("Cannot prepare burger");
		}

		return burger;
	}
	*/

	// SECOND implementation
	/*
	public Burger orderBurger(String request) {
		SimpleBurgerFactory factory = new SimpleBurgerFactory();
		Burger burger = factory.createBurger(request);
		burger.prepare();
		return burger;
	}
	*/

	// THIRD implementation
	// Make this class abstract

	public Burger orderBurger(){
		// this method knows nothing about what king of burger we want to create
		// the responsibility of doing that is passed to the upper module(class) in our case the main class = the test class in our case
		Burger burger = createBurger();
		burger.prepare();
		return burger;
	}
	public abstract Burger createBurger(); // this is the factory method

}
