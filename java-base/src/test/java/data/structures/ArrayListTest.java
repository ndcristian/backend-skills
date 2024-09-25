package data.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
		List<Integer> newL = itg.stream().map((e) -> {
			return e * 2;
		}).collect(Collectors.toList());

		System.out.println("FINISH");

		// other way *#:)*  *#!*
		List<Integer> w = Arrays.asList(1, 2, 3, 4, 5, 6, 8);
		w.set(0,99); // allows elements modification
		w.add(33); // not allowed to add or remove
		Collections.addAll(w, 55, 66, 77, 88); // error

		// other way *#:)*  *#!*
		List<Integer> q = List.of(22, 33, 44, 55, 6667); // specific implementation
		// you can not add, not remove elements to this / from this
		// you can not modify the elements as well
		// *#:)* it is a way keep list immutable *#W*
		q.set(0, 33);
		System.out.println("FINISH");

	}
}
