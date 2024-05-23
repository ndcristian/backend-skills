package com.etix;

import com.etix.lambda.GreetingService;
import com.etixapp.java.base.basics.models.Dog;

public class Main {
	public static void main(String[] args) {

		System.out.println("Hello world!");

		Dog dog = new Dog();

		//@++ instantiate interface providing the implementation
		GreetingService hiService = new GreetingService() {
			@Override
			public void greet(String name) {
				System.out.println("Hi..." + name);
			}
		};
		GreetingService helloService = new GreetingService() {
			@Override
			public void greet(String name) {
				System.out.println("Hello..." + name);
			}
		};
		// --->
		// now transform this into a lambda function
		// --->
		GreetingService helloServiceTransformedInLambda = (name) -> {
			System.out.println("Hello from LAMBDA..." + name);
		};
		// because we have only one line between {} we can remove them
		// because we have only one parameter between () we can remove them
		/** THE PARAMETER TYE IS OPTIONAL it can be removed. java will now the type from interface declaration
		 * SO if Dog type is provided as parameter tan we can call Dog methods
		 */

		/**
		 * @++
		 * SO ... the lambda expression is just  an implementation of an interface
		 * BUT with one condition ...
		 * TO HAVE ONLY ONE ABSTRACT METHOD
		 *
		 * */

		hiService.greet("Cris");
		helloService.greet("Pop");
		helloServiceTransformedInLambda.greet("Transformer");
	}
}