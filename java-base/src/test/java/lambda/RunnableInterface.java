package lambda;

import org.junit.Test;

public class RunnableInterface {

	Runnable r = () -> {
		System.out.println("From Runnable::");

	};

	@Test
	public void runTest() {

		new Thread(r).start();
		//Notice that HELLO wil be displayed first even if it is called after start()
		// and that because start wil be executed into a new async thread
		System.out.println("HELLO::");
	}
}
