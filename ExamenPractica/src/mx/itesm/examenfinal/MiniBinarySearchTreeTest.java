package mx.itesm.examenfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MiniBinarySearchTreeTest {
	
	MiniBinarySearchTree<Integer> tree1;
	MiniBinarySearchTree<Integer> tree2;
	MiniBinarySearchTree<Integer> tree3;
	MiniBinarySearchTree<Integer> tree4;
	MiniBinarySearchTree<Integer> tree5;
	
	@BeforeEach
	void setup() {
		tree1 = new MiniBinarySearchTree<Integer>();
		tree1.add(6);
		tree1.add(2);
		tree1.add(1);
		tree1.add(4);
		tree1.add(3);
		tree1.add(5);
		tree1.add(7);
		tree1.add(8);
		tree1.add(11);
		tree1.add(9);
		tree1.add(10);
		tree1.add(12);
		
		tree2  = new MiniBinarySearchTree<Integer>();
		tree2.add(12);
		tree2.add(13);
		tree2.add(6);
		tree2.add(7);
		tree2.add(9);
		tree2.add(8);
		tree2.add(11);
		tree2.add(10);
		tree2.add(2);
		tree2.add(1);
		tree2.add(5);
		tree2.add(3);
		tree2.add(4);
		
		tree3 = new MiniBinarySearchTree<Integer>();
		tree3.add(4);
		tree3.add(5);
		tree3.add(2);
		tree3.add(1);
		tree3.add(3);
		
		tree4 = new MiniBinarySearchTree<Integer>();
		
		tree5 = new MiniBinarySearchTree<Integer>();
		tree5.add(4);
	}

	@Test
	void testDiameter() {
		assertEquals(9, tree1.diameter());
		assertEquals(9, tree2.diameter());
		assertEquals(4, tree3.diameter());
		assertEquals(0, tree4.diameter());
		assertEquals(1, tree5.diameter());
	}

}