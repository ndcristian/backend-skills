package var;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class VarTest {

	@Test
	public void test() {
		//		int num = 10;
		//		List<Integer> list = List.of(1,2,3,4,5,6,7);
		//		Map<String, Integer> map = Map.of("name", 2, "age",3);

		// we can replace this with:
		// *#!* only inside a method. not allowed as method parameters
		// *#W* also called type inference
		// var is not a keyword reserved in java : you can use it as;
		int var = 5; // no compilation erros
		//		int int = 5 // error

		var num = 10;
		var list = List.of(1, 2, 3, 4, 5, 6, 7);
		var map = Map.of("name", 2, "age", 3);

		//var altNum; //  not work because java assign a type based on the value you provide

	}
}
