package mx.itesm.cem.arreglos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TecArrrayListTest {
	
	private TecArrayList<String> as;
	private TecArrayList<Integer> ai;
	private TecArrayList<Float> af;

	@BeforeEach //Se ejecuta cada vez que se llame una prueba
	void setUp() throws Exception {
		as = new TecArrayList<>("verde", "rojo", "amarillo", "azul");
		ai = new TecArrayList<>(4,8,15,16,23,42);
		af = new TecArrayList<>();
	}

	@Test
	void testGet() {
		assertEquals("rojo", as.get(1));
		assertEquals("azul", as.get(3));
		assertEquals((Integer) 4, ai.get(0));
		assertEquals((Integer) 42, ai.get(5));
		assertThrows(IndexOutOfBoundsException.class, () -> {
			af.get(0);
		});
		
	}
	
	@Test
	void testSize() {
		assertEquals(4 , as.size());
		assertEquals(6 , ai.size());
		assertEquals(0 , af.size());
	}
	
	@Test
	void testIsEmpty() {
		assertFalse(as.isEmpty());
		assertFalse(ai.isEmpty());
		assertTrue(af.isEmpty());
		
	}
	
	@Test
	void testSet() {
		assertEquals("verde", as.set(0, "blanco"));
		assertEquals("blanco", as.set(0, "negro"));
		assertEquals("negro", as.get(0));
		assertEquals(42, (int) ai.set(5, -10));
		assertEquals(-10, (int) ai.get(5));
		assertThrows(IndexOutOfBoundsException.class, () -> {
			af.set(5, 3.14f);
		});
	}
	
	@Test
	void testAdd(){
		as.add("negro");
		assertEquals(5, as.size());
		assertEquals("negro", as.get(4));
		ai.add(0, 1);
		assertEquals(7, ai.size());
		assertEquals(1,(int) ai.get(0));
		assertEquals(4,(int) ai.get(1));
		assertEquals(8,(int) ai.get(2));
		assertEquals(15,(int) ai.get(3));
		assertEquals(16,(int) ai.get(4));
		assertEquals(23,(int) ai.get(5));
		assertEquals(42,(int) ai.get(6));
		assertIterableEquals(List.of(1, 4, 8, 15, 16, 23, 42), ai);
		ai.add(108);
		ai.add(109);
		ai.add(110);
		ai.add(111);
		assertEquals(11,(int) ai.size());
		assertIterableEquals(List.of(1, 4, 8, 15, 16, 23, 42, 108, 109, 110, 111), ai);
	}
	
	@Test
	void testRemove(){
		as.remove(0);
		assertEquals("rojo", as.get(0));

	}

}
