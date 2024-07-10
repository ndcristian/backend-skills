package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class Parallel {
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
		// using parallel the operation is much faster specially when processes are time consuming
		// it changes the flow from pipeline (one by one) into a parallel actions
		// it creates a thread for each value
		List<String> newList = list.stream().filter(s -> s.length() > 3).parallel().collect(Collectors.toList());
		System.out.println(newList);

	}

}
