package data.structures;

import java.util.Stack;

import org.junit.jupiter.api.Test;

public class StackTest {

	@Test
	public void test(){
		Stack<Integer> stack = new Stack<>();
		// Push elements onto the stack
		stack.push(2);
		stack.push(3);
		stack.push(4);

		// Pop elements from the stack
		int poppedElement=stack.pop();

		System.out.println("FINISH");
	}
}
