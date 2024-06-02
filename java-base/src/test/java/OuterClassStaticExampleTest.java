import com.etixapp.java.base.basics.nested.OuterClassStaticExample;
import com.etixapp.java.base.basics.nested.OuterClassStaticExample.StaticNestedClass;
import org.junit.Test;

public class OuterClassStaticExampleTest {

  private OuterClassStaticExample.StaticNestedClass staticNestedClass =  new OuterClassStaticExample.StaticNestedClass();
  private OuterClassStaticExample.StaticNestedClass staticNestedClass2 =  new StaticNestedClass();

  @Test
  public void testNested(){
    staticNestedClass2.display();
    staticNestedClass.display();
  }

}
