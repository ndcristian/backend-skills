import org.junit.jupiter.api.Test;

import com.etixapp.java.base.basics.lambda.GreetingService;


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

	public void test(GreetingService g) {
		String response = g.greeting("how are you");
		System.out.println(response);
	}

	@Test
	void runTest(){
		test(g); // first call
		test(g1); // second call
		// so we call the methode by providing it the lambda expression directly
		test((n)->n.toUpperCase() + '-' + n.length());
	}
}
