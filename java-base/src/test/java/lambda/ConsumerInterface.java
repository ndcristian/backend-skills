package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

public class ConsumerInterface {

	/** List.ForEach accept a ? super Consumer as parameter */
	/**
	 * Consumer interface has only one method: accept(). Not need to create your own functional interface because java
	 * provide some for you
	 */

	Consumer<String> c1 = (s) -> System.out.println();
	Consumer<String> c2 = System.out::println;

	List<String> stringList = new ArrayList<>();

	Consumer<String> dbConsumer = (s) -> {
		System.out.println("I'm writing in database::" + s);
	};
	Consumer<String> logConsumer = (s) -> {
		System.out.println("I'm writing into a log file::" + s);
	};

	Consumer<String> dbLogConsumer = dbConsumer.andThen(logConsumer);
	//CHAINING
	// In order to do the chaining you must be sure that they are the same type
	Consumer<String> moreDbLogConsumer = dbConsumer.andThen(logConsumer).andThen(dbLogConsumer).andThen(logConsumer);

	@Test
	public void runTest() {
		c1.accept("main");
		c2.accept("method reference");

		stringList.add("John");
		stringList.add("Michael");
		System.getenv();
		System.getProperties();
		stringList.forEach(dbConsumer);
		stringList.forEach(logConsumer);
		System.out.println("*****CHAINING*******");
		// OR we can use chain
		stringList.forEach(dbLogConsumer);

	}
}
