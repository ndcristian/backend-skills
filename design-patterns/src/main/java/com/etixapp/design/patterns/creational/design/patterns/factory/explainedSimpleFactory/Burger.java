package com.etixapp.design.patterns.creational.design.patterns.factory.explainedSimpleFactory;

// FIRST implementation
/*
public class Burger {
	private String id;
	private String name;

	public void prepare(){
		System.out.println("Burger prepared");
	}
}
 */

//THIRD implementation
public interface Burger {
	public void prepare();

}