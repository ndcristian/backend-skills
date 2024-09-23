package data.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class ArrayListTest {

	@Test
	public void test() {
		// Create an ArrayList to store integers
		List<String> str = new ArrayList<>(List.of("red", "blue", "yellow"));
		ArrayList<Integer> itg = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

		// Calculate and print the sum of all elements in the ArrayList
		int sum = itg.stream().mapToInt(Integer::intValue).sum();

		// limit
		List<Integer> lim = itg.stream().limit(2).collect(Collectors.toList());

		//multiply elements value
		List<Integer> newL = itg.stream().map((e)->{return e*2;}).collect(Collectors.toList());

		System.out.println("FINISH");
	}
}
