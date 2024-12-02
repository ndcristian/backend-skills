package designpatterns;

import org.junit.jupiter.api.Test;

import com.etixapp.design.patterns.creational.design.patterns.singleton.DatabaseConnector;

public class SingletonTest {

	@Test
	public void test(){
		DatabaseConnector d1 = DatabaseConnector.getInstance();
		DatabaseConnector d2 = DatabaseConnector.getInstance();

		assert(d1==d2);
	}
}
