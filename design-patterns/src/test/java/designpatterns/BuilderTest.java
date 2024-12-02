package designpatterns;

import org.junit.jupiter.api.Test;

import com.etixapp.design.patterns.creational.design.patterns.builder.PersonB;

public class BuilderTest {

	@Test
	public void test() {

		PersonB personB = new PersonB.Builder("Cris", "cris@mail.com").setAddress("address").setAge(3).build();

	}
}
