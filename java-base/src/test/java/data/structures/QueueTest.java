package data.structures;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class QueueTest {
	@Test
	public void test(){
		Queue<Integer> queue = new LinkedList<>();
		// Enqueue elements to the Queue
		queue.offer(10);
		queue.offer(20);
		queue.offer(30);
		queue.offer(40);
		queue.offer(50);
	}
}
