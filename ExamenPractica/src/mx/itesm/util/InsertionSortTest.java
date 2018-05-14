package mx.itesm.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InsertionSortTest {

	@Test
	void insertionsortTest() {
		int array3[] = {};
		Arrays.insertionsort(array3);
		assertEquals("[]", java.util.Arrays.toString(array3));
		
		int array2[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		Arrays.insertionsort(array2);
		for (int i = 0; i < array2.length; i++) {
			assertEquals(i, array2[i]);
		}
		
		int array1[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Arrays.insertionsort(array1);
		for (int i = 0; i < array1.length; i++) {
			assertEquals(i, array1[i]);
		}
		
		int array4[] = {-2, -50, 40, 0, -100, 100, 99, 100, -33, 21, -20, -50};
		Arrays.insertionsort(array4);
		assertEquals("[-100, -50, -50, -33, -20, -2, 0, 21, 40, 99, 100, 100]", java.util.Arrays.toString(array4));
	}

}