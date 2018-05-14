package mx.itesm.examenfinal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class FinalExam {

	public static <T extends Comparable<T>> Deque<T> merge(Deque<T> stack1, Deque<T> stack2) {
		Deque<T> vector = new LinkedList<T>();

		if (stack1.isEmpty() && stack2.isEmpty()) {
			return vector;
		}
		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			if (stack1.getFirst().compareTo(stack2.getFirst()) > 0) {
				vector.add(stack2.pop());
			} else if (stack1.getFirst().compareTo(stack2.getFirst()) < 0) {
				vector.add(stack1.pop());
			} else if (stack1.getFirst().compareTo(stack2.getFirst()) == 0) {
				vector.add(stack2.pop());
				vector.add(stack1.pop());
			}
		}
		if (stack1.isEmpty()) {
			while (!stack2.isEmpty()) {
				vector.add(stack2.pop());
			}
			return vector;
		}
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				vector.add(stack1.pop());
			}
			return vector;
		}
		return null;
	}
}