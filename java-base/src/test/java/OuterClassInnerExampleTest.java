import org.junit.Test;

import com.etixapp.java.base.basics.nested.OuterClassInnerExample;

public class OuterClassInnerExampleTest {

	OuterClassInnerExample outerClassInnerExample = new OuterClassInnerExample();

	OuterClassInnerExample.InnerClass innerClass = outerClassInnerExample.new InnerClass();

	@Test
	public void TestInnerExample() {

		System.out.println(outerClassInnerExample.testAccessReturn());
		outerClassInnerExample.testAccess();

	}

}
