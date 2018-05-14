package mx.itesm.examenfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MiniLinkedListTest {

	private MiniLinkedList<String> stringList;
	private MiniLinkedList<Integer> integerList;
	private MiniLinkedList<Float> floatList;
	
	@BeforeEach
    void setUp() throws Exception {
        stringList = new MiniLinkedList<String>("Katniss", "Peeta", "Gale", "Haymitch", "Primrose", "Effie");
        integerList = new MiniLinkedList<Integer>(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89);
        floatList = new MiniLinkedList<Float>();
    }
    
	@Test
	void testSize() {
		assertEquals(6, stringList.size());
        assertEquals(12, integerList.size());
        assertEquals(0, floatList.size());
	}
	
	@Test
	void testAddLast() {
		stringList.addLast("Oriam");
		assertEquals(7, stringList.size());
		
		integerList.addLast(99);
		assertEquals(13, integerList.size());
		
		floatList.addLast(3.14159f);
		assertEquals(1, floatList.size());
	}
}