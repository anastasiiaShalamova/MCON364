import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SchulMemberTest {

    private SchulMember schulMember;

    @Before
    public void setUp() {
        // Initialize a SchulMember object before each test
        schulMember = new SchulMember("Dovi", "Leah", 1990, "Rachel", "David", new String[]{"Alice", "Bob"}, 5);
    }

    @Test
    public void testGetLastNameOfMember() {
        assertEquals("David", schulMember.getLastNameOfMember());
    }

    @Test
    public void testSetLastNameOfMember() {
        schulMember.setLastNameOfMember("Smith");
        assertEquals("Smith", schulMember.getLastNameOfMember());
    }

    @Test
    public void testGetFirstNameOfMember() {
        assertEquals("Leah", schulMember.getFirstNameOfMember());
    }

    @Test
    public void testSetFirstNameOfMember() {
        schulMember.setFirstNameOfMember("Rachel");
        assertEquals("Rachel", schulMember.getFirstNameOfMember());
    }

    @Test
    public void testGetBirthDateOfMember() {
        assertEquals(1990, schulMember.getBirthDateOfMember());
    }

    @Test
    public void testSetBirthDateOfMember() {
        schulMember.setBirthDateOfMember(1990);
        assertEquals(1990, schulMember.getBirthDateOfMember());
    }

    @Test
    public void testGetSpouseFirstName() {
        assertEquals("Rachel", schulMember.getSpouseFirstName());
    }

    @Test
    public void testSetSpouseFirstName() {
        schulMember.setSpouseFirstName("Alice");
        assertEquals("Alice", schulMember.getSpouseFirstName());
    }

    @Test
    public void testGetSpouseLastName() {
        assertEquals("David", schulMember.getSpouseLastName());
    }

    @Test
    public void testSetSpouseLastName() {
        schulMember.setSpouseLastName("Smith");
        assertEquals("Smith", schulMember.getSpouseLastName());
    }

    @Test
    public void testGetChildrenNames() {
        assertArrayEquals(new String[]{"Alice", "Bob"}, schulMember.getChildrenNames());
    }

    @Test
    public void testSetChildrenNames() {
        schulMember.setChildrenNames(new String[]{"Charlie", "David"});
        assertArrayEquals(new String[]{"Charlie", "David"}, schulMember.getChildrenNames());
    }

    @Test
    public void testGetYearsOfMembership() {
        assertEquals(5, schulMember.getYearsOfMembership());
    }

    @Test
    public void testSetYearsOfMembership() {
        schulMember.setYearsOfMembership(10);
        assertEquals(10, schulMember.getYearsOfMembership());
    }

    @Test
    public void testCompareTo() {
        SchulMember olderMember = new SchulMember("Dovi", "Leah", 1990, "Rachel", "David", new String[]{"Alice", "Bob"}, 5);
        SchulMember youngerMember = new SchulMember("Dovi", "Leah", 1990, "Rachel", "David", new String[]{"Alice", "Bob"}, 5);

        assertTrue(schulMember.compareTo(olderMember) > 0);
        assertTrue(schulMember.compareTo(youngerMember) < 0);
        assertEquals(0, schulMember.compareTo(schulMember));
    }
}
