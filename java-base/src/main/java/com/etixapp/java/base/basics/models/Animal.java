package com.etixapp.java.base.basics.models;

public abstract class Animal {
	private String name;
	protected String age;
	public String country;
	public void makeSound(){
		System.out.println("I am animal.. Grrrrr.....");
	}

//	public abstract void myFood();

	public void walk(){
		System.out.println("I am walking");
	}
}
