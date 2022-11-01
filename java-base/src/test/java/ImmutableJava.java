import static org.junit.Assert.assertEquals;
import com.etixapp.java.base.immutable.Person;
import org.junit.jupiter.api.Test;

public class ImmutableJava {
    String name = "Dan";
    Person person = new Person("John");
    Person person2 = person;

    @Test
    public void testName() {
        person2.setName(name);
        System.out.println(person.getName());
        System.out.println(person==person2);
//        assertEquals(name, person.getName());
    }

}
