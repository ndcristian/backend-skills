package designpatterns;

import org.junit.jupiter.api.Test;

import com.etixapp.design.patterns.creational.design.patterns.builder.singleton.DatabaseConnector;

public class singleton {

	@Test
	public void test(){
		DatabaseConnector d1 = DatabaseConnector.getInstance();
		DatabaseConnector d2 = DatabaseConnector.getInstance();

		assert(d1==d2);
	}
}
