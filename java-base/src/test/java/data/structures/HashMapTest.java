package data.structures;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class HashMapTest {

	@Test
	public void test(){
		// Create a HashMap to store String keys and Integer values
		HashMap<String, Integer> hashMap=new HashMap<>();
		//or
		Map<String, Integer> hashMap2=new HashMap<>();

		// Add key-value pairs to the HashMap
		hashMap.put("John",25);
		hashMap.put("Alice",30);
		hashMap.put("Bob",35);
	}
}
