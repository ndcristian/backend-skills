package com.etixapp.java.base.basics.models;

public class Cat extends Animal {

	private String color = "red";

	@Override
	public void walk() {
		System.out.println("I am cat....");
	}

	public String getProp() {
		this.age = "eee";
		this.country = "RO";
		return this.age + this.country;
	}
}
