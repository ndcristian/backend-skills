package strings;

import org.junit.jupiter.api.Test;

public class StringTest {

	// trim() vs strip()

	@Test
	public void test() {
		String s1 = " udemy ";
		System.out.println("--" + s1.trim() + "--");

		char c = '\u2002';
		String s2 = c + " udemy ";
		System.out.println("--" + s2.trim() + "--");// here the beginning space is not removed
		// this is the purpose of strip();
		System.out.println("--" + s2.strip() + "--");
	}
}
