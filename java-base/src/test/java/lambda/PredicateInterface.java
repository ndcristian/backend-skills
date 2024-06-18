package lambda;

import java.util.function.Predicate;

import org.junit.Test;


/**
 * Return a boolean, Is useful whenever you need to check something
 * */
public class PredicateInterface {

	Predicate<Integer> isGT2 = (n)->n>2;
	Predicate<Integer> isGT10 = (n)->n>10;


	@Test
	public void rubTest(){

		System.out.println(isGT2.test(4));
		System.out.println(isGT10.negate().test(6));
		System.out.println(Predicate.isEqual(2).test("5"));

	}
}
