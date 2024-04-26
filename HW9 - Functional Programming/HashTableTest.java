import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HashTableTest {
	
    private HashTable<String, Integer> hashTable;

    @Before
    public void setUp() {
        hashTable = new HashTable<>(10);
    }

    @Test
    public void testPutAndGet() {
        hashTable.put("key1", 1);
        hashTable.put("key2", 2);
        assertEquals(Integer.valueOf(1), hashTable.get("key1"));
        assertEquals(Integer.valueOf(2), hashTable.get("key2"));
    }

    @Test
    public void testRemove() {
        hashTable.put("key1", 1);
        hashTable.put("key2", 2);

        assertEquals(Integer.valueOf(1), hashTable.remove("key1"));
        assertNull(hashTable.get("key1"));
        assertEquals(Integer.valueOf(2), hashTable.get("key2"));
    }

    @Test
    public void testContains() {
        hashTable.put("key1", 1);
        assertTrue(hashTable.contains("key1"));
        assertFalse(hashTable.contains("key2"));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(hashTable.isEmpty());
        hashTable.put("key1", 1);
        assertFalse(hashTable.isEmpty());
    }

    @Test
    public void testIsFull() {
        assertFalse(hashTable.isFull());
        for (int i = 0; i < 10; i++) {
            hashTable.put("key" + i, i);
        }
        assertTrue(hashTable.isFull());
    }

    @Test
    public void testSize() {
        assertEquals(0, hashTable.size());
        hashTable.put("key1", 1);
        assertEquals(1, hashTable.size());
    }

    @Test
    public void testGetListSize() {
        hashTable.put("key1", 1);
        hashTable.put("key2", 2);
        assertEquals(1, hashTable.getListSize("key1"));
        assertEquals(0, hashTable.getListSize("key3"));
    }

    @Test
    public void testIterator() {
        hashTable.put("key1", 1);
        hashTable.put("key2", 2);
        hashTable.put("key2", 2);

        int[] expectedValues = {2, 1};
        int[] actualValues = new int[hashTable.size()];

        int index = 0;

        for (MapEntry<String, Integer> entry : hashTable) {
            actualValues[index++] = entry.getValue();
        }

        assertEquals(expectedValues.length, actualValues.length);
        for (int i = 0; i < expectedValues.length; i++) {
            assertEquals(expectedValues[i], actualValues[i]);
        }
    }

}

