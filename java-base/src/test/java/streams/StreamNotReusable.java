package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class StreamNotReusable {

	List<String> list = new ArrayList<>();

	@Before
	public void runBefore() {
		list.add("Apple");
		list.add("Apple");
		list.add("Cat");
		list.add("Boy");
		list.add("Dog");
		list.add("Delta");
		list.add("Ball");
		list.add("Duck");
		list.add("Airplane");
		list.add("Truck");
	}

	@Test
	public void parallelTest() {
		Stream<String> newStream = list.stream().filter(s -> s.length() > 3);
		newStream.forEach(s -> System.out.println(s)); // this wil be executed
		//newStream.forEach(s -> System.out.println(s.toUpperCase())); // this will throw error
		// ==> stream are not reusable
		list.forEach((e) -> {
			System.out.println(e);
		});

	}
}
