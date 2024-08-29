package com.etixapp.design.patterns.principles.DependencyInversion;

public class Person {
	private Address address;

	public Person(){
		this.address = new Address(); // tightly coupled dependency !!!!
		// the scope is to have loosely coupled software modules
	}
}
