package lambda;

import java.util.function.Function;

import org.junit.Test;

/**
 * unlike Consumer , Function return and the return type is the second type provided between diamonds <>
 * */
public class FunctionInterface {

	Function<String, Integer> strLen = (s) -> s.length();
	Function<Integer, Integer> square = (i) -> i * i;
	Function<Integer, Integer> plus2 = (i) -> i + 2;

	@Test
	public void runTest() {

		System.out.println(strLen.apply("wells"));
		System.out.println(square.apply(3));


		// chaining with andThen
		// a.andThen(b) => a then b
		System.out.println(plus2.andThen(square).apply(8));

		// chaining with compose will reverse the order in which methods are applied
		// a.compose(b) => b then a
		System.out.println(plus2.compose(square).apply(8));


	}
}
