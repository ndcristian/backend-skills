package com.etixapp.java.base.basics.lambda;


// this annotation is a good practice
//functional interface = an interface with only one methode
// to be use with lambda functions an interface should be a FUNCTIONAL INTERFACE
@FunctionalInterface
public interface GreetingService {
	String greeting(String s);
}
