package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class Collector {

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
	public void collectToList() {
		// collect to list
		List<String> newList = list.stream().filter(s -> s.length() > 3).collect(Collectors.toList());
		System.out.println(list); // to prove that the original list remains intact
		System.out.println(newList);

	}

	@Test
	public void collectToSet() {
		// collect to set
		Set<String> newSet = list.stream().filter(s -> s.length() > 3).collect(Collectors.toSet());
		System.out.println(newSet); // remove duplicates
	}

	@Test
	public void join() {
		String newString = list.stream().filter(s -> s.length() > 3).collect(Collectors.joining("-"));
		System.out.println(newString); // remove duplicates
	}

	@Test
	public void groupBy() {
		//group all the words by length
		Map<Integer, List<String>> groups = list.stream().filter(s -> s.length() > 3)
				.collect(Collectors.groupingBy(s -> s.length()));
		System.out.println(groups);

		//group all the words by first character
		Map<Character, List<String>> groupsChar = list.stream().filter(s -> s.length() > 3)
				.collect(Collectors.groupingBy(s -> s.charAt(0)));
		System.out.println(groupsChar);
	}

}
