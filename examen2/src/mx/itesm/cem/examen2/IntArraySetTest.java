package mx.itesm.cem.examen2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntArraySetTest {    

    @Test
    void testAdd() {
        Set<Integer> s = new IntArraySet(5);
        assertEquals(0, s.size());
        assertTrue(s.add(0));
        assertEquals(1, s.size());
        assertTrue(s.add(1));
        assertEquals(2, s.size());
        assertFalse(s.add(0));
        assertEquals(2, s.size());
        assertTrue(s.add(4));
        assertEquals(3, s.size());
        assertTrue(s.add(3));
        assertFalse(s.add(3));
        assertEquals(4, s.size());
        assertThrows(NullPointerException.class,
                () -> s.add(null));
        assertThrows(IllegalArgumentException.class,
                () -> s.add(5));
        assertThrows(IllegalArgumentException.class,
                () -> s.add(-1));
    }

    @Test
    void testCollectionConstructor() {
        assertEquals(0, new IntArraySet(10, Arrays.asList())
                .size());
        assertEquals(1,
                new IntArraySet(10, Arrays.asList(0))
                        .size());
        assertEquals(2,
                new IntArraySet(10, Arrays.asList(0, 9))
                        .size());
        assertEquals(10, new IntArraySet(10,
                Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))
                        .size());
        assertThrows(NullPointerException.class,
                () -> new IntArraySet(5, null));
        assertThrows(NullPointerException.class,
                () -> new IntArraySet(5,
                        Arrays.asList(1, 2, null, 4)));
        assertThrows(IllegalArgumentException.class,
                () -> new IntArraySet(5,
                        Arrays.asList(1, 2, -10, 4)));
        assertThrows(IllegalArgumentException.class,
                () -> new IntArraySet(5,
                        Arrays.asList(1, 2, 3, 4, 5)));
    }

    @SuppressWarnings("unlikely-arg-type")
    @Test
    void testRemove() {
        Set<Integer> s = new IntArraySet(5,
                Arrays.asList(0, 1, 3, 4));
        assertEquals(4, s.size());
        assertTrue(s.remove(3));
        assertEquals(3, s.size());
        assertFalse(s.remove(5));
        assertFalse(s.remove(10));
        assertFalse(s.remove(-1));
        assertFalse(s.remove(3));
        assertEquals(3, s.size());
        assertFalse(s.remove(2));
        assertEquals(3, s.size());
        assertTrue(s.remove(0));
        assertEquals(2, s.size());
        assertTrue(s.remove(1));
        assertEquals(1, s.size());
        assertTrue(s.remove(4));
        assertEquals(0, s.size());
        assertFalse(s.remove(4));
        assertThrows(NullPointerException.class,
                () -> s.remove(null));
        assertThrows(ClassCastException.class,
                () -> s.remove("hello"));
    }

    @Test
    void testIterator() {
        Collection<Integer> c = Arrays.asList(0, 2, 4, 8);
        Set<Integer> s = new IntArraySet(10, c);
        Iterator<Integer> it1 = s.iterator();
        Iterator<Integer> it2 = c.iterator();
        assertTrue(it1.hasNext());
        assertTrue(it2.hasNext());
        while (it1.hasNext() && it2.hasNext()) {
            assertEquals(it2.next(), it1.next());
        }
        assertFalse(it1.hasNext());
        assertFalse(it2.hasNext());
        assertThrows(NoSuchElementException.class,
                () -> it1.next());
        assertThrows(NoSuchElementException.class,
                () -> it2.next());
        assertIterableEquals(c, s);
        assertEquals("[0, 2, 4, 8]", s.toString());
        assertIterableEquals(Arrays.asList(),
                new IntArraySet(10));
        assertIterableEquals(Arrays.asList(9),
                new IntArraySet(10, Arrays.asList(9)));
        c = Arrays.asList(0, 1, 2, 3);
        s = new IntArraySet(4, c);
        assertIterableEquals(c, s);
        assertEquals("[0, 1, 2, 3]", s.toString());
    }
}
