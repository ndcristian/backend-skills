package designpatterns;

import org.junit.jupiter.api.Test;

import com.etixapp.design.patterns.behavioral.design.pattern.strategy.Addition;
import com.etixapp.design.patterns.behavioral.design.pattern.strategy.OperationManager;

public class StrategyTest {

	@Test
	public void StrategyTest(){
		OperationManager manager = new OperationManager();
		// we can change it at runtime
		manager.setStrategy(new Addition());
		manager.execute(2,3);
	}
}
