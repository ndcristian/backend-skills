package annotations;

import org.junit.Test;

import com.etixapp.java.base.basics.annotations.transactional.CoreBusinessKickOff;

public class transactional {

	@Test
	public void test() {
		CoreBusinessKickOff test = new CoreBusinessKickOff();
		test.kickOff();
	}
}

/** expected output */
//I do something big
//		Doing the cross cutting concern now
//		I did something small
//		Doing the cross cutting concern now
//		I also do something small but with an int