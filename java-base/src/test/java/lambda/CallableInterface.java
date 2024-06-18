package lambda;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

import org.junit.Test;

// is almost the same as Consumer
// need throw exception
public class CallableInterface {

	Supplier<Double> s = Math::random;
	Callable<Double> c = Math::random;


	@Test
	public void runTest() throws Exception {
		System.out.println(s.get());
		System.out.println(c.call());
	}
}
