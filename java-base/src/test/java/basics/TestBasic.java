package basics;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.etixapp.java.base.basics.models.Animal;
import com.etixapp.java.base.basics.models.Cat;

public class TestBasic {

	List<String> passList = new ArrayList<>();

	@Test
	public void runTest() {
		Animal animal = new Cat();
		animal.walk();

		// is not accessible
		//		animal.color
		Cat cat = new Cat();
		System.out.println(cat.getProp());

	}

	@Test
	public void passwordEncoder() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encoded1 = passwordEncoder.encode("123456");
		String encoded2 = passwordEncoder.encode("123456");
		boolean decoded = passwordEncoder.matches("123456",
				"$2a$10$4B6MmDkf276TdgQDReRE1OjIysJd2imZbC9ALCDzw9GZGTp0lahbq");
		System.out.println(decoded);
		System.out.println(passwordEncoder.encode("123456"));
		System.out.println(passwordEncoder.encode("123456"));
		System.out.println(passwordEncoder.encode("123456"));
		System.out.println(passwordEncoder.encode("123456"));
	}

}
