package streams;


import java.util.Comparator;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class StreamSource {
	String a = "Ball";
	String b = "Delta";
	String c = "Apple";

	@Test
	public void runTest() {
		System.out.println(
				Stream.of(a, b,c).max(Comparator.reverseOrder())
		);
	}
}
