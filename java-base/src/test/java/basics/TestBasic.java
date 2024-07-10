package basics;

import org.junit.Test;

import com.etixapp.java.base.basics.models.Animal;
import com.etixapp.java.base.basics.models.Cat;

public class TestBasic {

	@Test
	public void runTest() {
		Animal animal = new Cat() ;
		animal.walk();

		// is not accessible
//		animal.color
		Cat cat = new Cat();
		System.out.println(cat.getProp());

	}
}
