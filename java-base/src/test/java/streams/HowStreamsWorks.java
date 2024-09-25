package streams;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class HowStreamsWorks {

	// *#I*
	// Two type of operations exists in streams:
	// - intermediate operations (return new stream, Lazy): filter, map, limit, skip, distinct, sorted, flatMap, peek
	// - terminal operations(Stream is consumed, can not be reused): forEach, count, collect, min, max, findAny, anyMatch, noneMatch

	// *#W* Lazy = means that all the intermediate operations ae called only if a terminal operator is called

	@Test
	public void test() {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);

		list.stream().filter((i) -> {
			System.out.println("filter received:" + i);
			return i % 2 == 0;
		}).limit(3).map((i) -> {
			System.out.println("map received:" + i);
			return i * i;
		}).forEach((i) -> {
			System.out.println(i);
		});
		// it proves that the first element flows through pipeline and if it does not fit filter condition
		// the element is removed from pipeline and the second element comes in pipeline and so on and so far
	}
}
