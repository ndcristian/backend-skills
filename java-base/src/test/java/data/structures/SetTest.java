package data.structures;

import java.util.Set;

import org.junit.jupiter.api.Test;

public class SetTest {

	//*#I set does not allow duplicate. Set does not keep the order in which elements were added*

	@Test
	public void test() {
		//		*#:)*
		Set<String> set = Set.of("ab", "bc", "cd");
		// creating a Set with this method , you are not allowed to add or remove elements
		//
	}
}
