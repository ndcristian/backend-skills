package lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.junit.Test;

/**
 * Means that it accepts 2 parameters, 2 types
 *  */
public class BiConsumerInterface {

	Consumer<String> dbConsumer = (s) -> {
		System.out.println("I'm writing in database::" + s);
	};
	Consumer<String> logConsumer = (s) -> {
		System.out.println("I'm writing into a log file::" + s);
	};

	Map<String, Consumer<String>> map = new HashMap<>();

	Consumer<String> dbLogConsumer = dbConsumer.andThen(logConsumer);

	BiConsumer<String, Integer> biConsumer = (s, i)->{
		System.out.println("My name is::" + s);
		System.out.println("My age is::" + i);
	};

	@Test
	public void runTest(){

		map.put("db", dbConsumer);
		map.put("log", logConsumer);
		map.put("dblog", dbLogConsumer);

		map.forEach((k, v)->{
			System.out.println("Key is::"+ k);
			System.out.println("Value is::"+v);

		});

	}

}
