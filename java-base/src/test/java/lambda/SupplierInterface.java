package lambda;

import java.util.function.Supplier;

import org.junit.Test;

/**
 * an functional interface used when you want to return something but without providing any parameters
 */
public class SupplierInterface {

	Supplier<Double> random1 = () -> Math.random();
	// is the same with:
	Supplier<Double> random2 = Math::random;

	@Test
	public void runTest() {
		System.out.println(random2.get());
	}

}
