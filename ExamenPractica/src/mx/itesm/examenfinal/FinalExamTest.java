package mx.itesm.examenfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FinalExamTest {
	
	Deque<Integer> mergeResult1;
	Deque<Integer> mergeResult2;
	Deque<Integer> mergeResult3;
	
	Deque<Integer> emptyIntStack;
	
	@BeforeEach
	void setup() {
		mergeResult1 = new LinkedList<Integer>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4));
		mergeResult2 = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4));
		mergeResult3 = new LinkedList<Integer>(Arrays.asList(1, 4, 12, 13, 15, 16, 17, 26, 37, 37, 48, 53, 57, 59, 62, 74, 82, 85, 90, 90, 100, 106, 210));
		
		emptyIntStack = new LinkedList<Integer>();
	}

	@Test
	void testMerge() {
		Deque<Integer> stack1 = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4));
		Deque<Integer> stack2 = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4));
		Deque<Integer> result1 = FinalExam.merge(stack1, stack2);
		assertEquals(mergeResult1, result1);
		
		Deque<Integer> stack3 = new LinkedList<Integer>();
		Deque<Integer> stack4 = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4));
		Deque<Integer> result2 = FinalExam.merge(stack3, stack4);
		assertEquals(mergeResult2, result2);
		
		Deque<Integer> stack5 = new LinkedList<Integer>();
		Deque<Integer> stack6 = new LinkedList<Integer>();
		Deque<Integer> result3 = FinalExam.merge(stack5, stack6);
		assertEquals(emptyIntStack, result3);
		
		Deque<Integer> stack7 = new LinkedList<Integer>(Arrays.asList(12, 15, 17, 37, 53, 57, 59, 82, 90, 100));
		Deque<Integer> stack8 = new LinkedList<Integer>(Arrays.asList(1, 4, 13, 16, 26, 37, 48, 62, 74, 85, 90, 106, 210));
		Deque<Integer> result4 = FinalExam.merge(stack7, stack8);
		assertEquals(mergeResult3, result4);
	}

}