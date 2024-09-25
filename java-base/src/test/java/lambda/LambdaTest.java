package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;

import com.etixapp.java.base.basics.lambda.GreetingService;
import com.etixapp.java.base.basics.lambda.ObjectOperations;
import com.etixapp.java.base.basics.lambda.StringConcat;
import com.etixapp.java.base.basics.lambda.StringOperations;

public class LambdaTest {
	// from Java8 we can quickly provide an implementation for an interface
	// without having a class which implicitly implements that interface
	GreetingService g = new GreetingService() {
		@Override
		public String greeting(String s) {
			return s.toLowerCase();
		}
	};
	// but we can also do this in a different way
	// this way is lambda functions
	GreetingService g1 = (n) -> n.toUpperCase();

	// in this case we assign a function to a reference type and this is called Function As First Class

	//	now let's create a new method which can accept as parameter a GreetingService
	//	let's see hoe we can call this methode

	GreetingService gReturnModel = (n) -> {
		if (n == null)
			return null;
		// return can be used only if we have multiline implementation of lambda
		return n.toUpperCase();
	};

	public void test(GreetingService g) {
		String response = g.greeting("how are you");
		System.out.println(response);
	}

	/**
	 * METHOD REFERENCE
	 * */
	StringOperations operation1 = s1 -> System.out.println(s1);
	// or using (*#W*) METHOD REFERENCE we can write it like this:
	StringOperations operation2 = System.out::println;
	//!!!! only for lambda with only one line of code
	// in this case java assume that the parameter we give to the methode is going to be the same assigned to println methode

	ObjectOperations obj = Objects::isNull;

	/**
	 * Multiple params METHOD REFERENCE
	 *  */

	// normal way to define lambda
	StringConcat stringConcat = (s1, s2) -> s1.concat(s2);
	// using method reference
	StringConcat stringConcat2 = String::concat;
	// java will know what and how to use parameters

	List<String> myList = new ArrayList<>();
	StringOperations listOperation = (s)-> myList.add(s);
	StringOperations listOperation2 = myList::add;


	@Test
	void runTest() {
		test(g); // first call
		test(g1); // second call
		// so we call the methode by providing it the lambda expression directly
		/** HIGHER ORDER FUNCTION */
		test((n) -> n.toUpperCase() + '-' + n.length());

		operation1.accept("Hello");
		// in this case java assume that the parameter we give to the methode is going to be the same assigned to println methode from lambda definition
		operation2.accept("REFERENCE");
		System.out.println(obj.evaluate("this"));

		// 2 params
		System.out.println( stringConcat.concatString("ab", "cd"));
		System.out.println( stringConcat2.concatString("ab", "cd"));

		listOperation.accept("Name");
		listOperation2.accept("Name2");
		System.out.println(myList);
	}
}
