package data.structures;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

	@Test
	public void test() {

		List<Integer> linkedList = new LinkedList<Integer>();
		//or
		LinkedList<Integer> lkdList2 = new LinkedList();

		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.add(6);

		LinkedList<Integer> linkedList1 = new LinkedList<>();

		linkedList1.add(3);
		linkedList1.add(2);
		linkedList1.add(1);
		linkedList1.add(0);
		linkedList1.offer(66);// the same as add. Used @Queue

		// Remove an element from the LinkedList
		linkedList1.removeFirst();
		// does not work because is declared as List not as LinkedList
		//linkedList.removeFirst();


	}

}
