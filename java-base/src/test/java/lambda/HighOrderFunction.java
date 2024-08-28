package lambda;

import org.junit.Test;

import com.etixapp.java.base.basics.lambda.GreetingService;

public class HighOrderFunction {

	@Test
	public void runTest() {
		GreetingService g = s -> s.toUpperCase();
		// we call it like this
		toUpperCase(g);

		// or we call it like High Order Function
		// function as a parameter
		toUpperCase((s)->s.toUpperCase() + s.toLowerCase());

	}

	private void toUpperCase(GreetingService g) {
		String r = g.greeting("myname");
		System.out.println(r);

	}
}
