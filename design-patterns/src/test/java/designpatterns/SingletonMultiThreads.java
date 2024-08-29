package designpatterns;

import org.junit.jupiter.api.Test;

import com.etixapp.design.patterns.creational.design.patterns.builder.singleton.Database;

public class SingletonMultiThreads {

	@Test
	void test(){
		Database.INSTANCE.connect();
	}
}
