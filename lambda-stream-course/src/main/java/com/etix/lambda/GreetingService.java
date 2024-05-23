package com.etix.lambda;


//@++ a functional interface is an interface with only one abstract method
// the annotation is not mandatory
@FunctionalInterface
public interface GreetingService {
	// all methods are public here that we don't need to specify public or private
	void greet(String name);
	// when we want to have a return value
	//String greet(String name)
}
