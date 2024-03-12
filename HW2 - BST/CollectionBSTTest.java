package hw2_BST_version2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CollectionBSTTest {

    private BSTInterface<Character> bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
    }

    @Test
    void testAddElementAndContains() {
        assertTrue(bst.add('P'));
        assertTrue(bst.contains('P'));
    }

    @Test
    void testGetMinAndMax() {
        bst.add('P');
        bst.add('F');
        bst.add('S');
        assertEquals('F', bst.min());
        assertEquals('S', bst.max());
    }


    @Test
    void testRemoveNonExistentElement() {
        assertFalse(bst.remove('P'));
    }

    @Test
    void testEmptyTree() {
        assertNull(bst.min());
        assertNull(bst.max());
        assertFalse(bst.contains('P'));
    }

    @Test
    void testSize() {
        bst.add('P');
        bst.add('F');
        bst.add('S');
        assertEquals(3, bst.size());
        bst.remove('F');
        assertEquals(2, bst.size());
    }

}
