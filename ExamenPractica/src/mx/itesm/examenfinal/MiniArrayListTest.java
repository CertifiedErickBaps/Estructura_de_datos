package mx.itesm.examenfinal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class MiniArrayListTest {
	private MiniArrayList<String> list;
	private MiniArrayList<String> list2;
	private MiniArrayList<String> list3;
	
	@Before
	public void setUp(){
		list = new MiniArrayList<String>();
		list2 = new MiniArrayList<String>(5);
		list2.add("Katniss");
		list3 = new MiniArrayList<String>(Arrays.asList("Katniss", "Peeta", "Gale", "Haymitch", "Primrose", "Effie"));
	}
	
	@Test
	public void testListInit() {
		assertTrue(list.isEmpty());
		assertTrue(list.size() == 0);
		assertEquals(10, list.capacity());
		
		assertTrue(!list2.isEmpty());
		assertTrue(list2.size() == 1);
		assertEquals(5, list2.capacity());
		
		assertTrue(!list3.isEmpty());
		assertTrue(list3.size() == 6);
		assertEquals(6, list3.capacity());
	}
	
	@Test
	public void testTrimToSize() {
		list.trimToSize();
		assertEquals(10, list.capacity());
		
		list2.trimToSize();
		assertEquals(1, list2.capacity());
		
		list3.trimToSize();
		assertEquals(6, list3.capacity());
	}
	
	@Test
	public void testAddElements() {
		list.add("Katniss");
		list.add("Peeta");
		list.add("Gale");
		
		assertEquals("Katniss", list.get(0));
		assertEquals("Peeta", list.get(1));
		assertEquals("Gale", list.get(2));
		
		list.add("Haymitch");
		
		assertEquals("Katniss", list.get(0));
		assertEquals("Peeta", list.get(1));
		assertEquals("Gale", list.get(2));
		assertEquals("Haymitch", list.get(3));
		
		assertTrue(list.size()==4);
		assertEquals(10, list.capacity());
		
		list2.add("Peeta");
		list2.add("Gale");
		list2.add("Haymitch");
		list2.add("Primrose");
		list2.add("Effie");
		assertTrue(list2.size() == 6);
		assertEquals(6, list2.capacity());
	}
	
	@Test
	public void testAddIndexedElements() {
		list.add(0, "Karol");
		list.add(1, "Vanessa");
		list.add(2, "Amanda");
		
		assertEquals("Karol", list.get(0));
		assertEquals("Vanessa", list.get(1));
		assertEquals("Amanda", list.get(2));
		
		list.add(1, "Mariana");
		
		assertEquals("Karol", list.get(0));
		assertEquals("Mariana", list.get(1));
		assertEquals("Vanessa", list.get(2));
		assertEquals("Amanda", list.get(3));	
		
		assertTrue(list.size()==4);
	}
	
	@Test (expected = NullPointerException.class)
	public void testAddIndexedElementNull() {
		list.add(0, null);
	}
	
	@Test (expected = NullPointerException.class)
	public void testAddElementNull() {
		list.add(null);
	}
}