import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Sorting_Class_Test {

    @Test
    void testQuickSort() {
        List<Student> unsortedList = Arrays.asList(
                new Student("Leah", 85),
                new Student("Chana", 72),
                new Student("Rivka", 95)
        );

        List<Student> actualSorted = Sorting_Class.quickSort(new ArrayList<>(unsortedList));

        assertTrue(Sorting_Class.isSorted(actualSorted),
                "This list should be sorted in ascending order");

        assertIterableEquals(
                Arrays.asList(
                        new Student("David", 68),
                        new Student("Moshe", 72),
                        new Student("Yakov", 85)
                ),
                actualSorted,
                "The sorted list should match the expected order"
        );
    }

    @Test
    void testMergeSort() {
        List<Student> unsortedList = Arrays.asList(
                new Student("Leah", 85),
                new Student("Chana", 72),
                new Student("Rivka", 95)
        );

        List<Student> actualSorted = Sorting_Class.mergeSort(new ArrayList<>(unsortedList));

        assertTrue(Sorting_Class.isSorted(actualSorted),
                "The list should be sorted in ascending order");

        assertIterableEquals(
                Arrays.asList(
                        new Student("David", 68),
                        new Student("Moshe", 72),
                        new Student("Yakov", 85)
                ),
                actualSorted,
                "The sorted list should match the expected order"
        );
    }

    @Test
    void testQuickSortEmptyList() {
        List<Student> emptyList = Arrays.asList();
        List<Student> actualSorted = Sorting_Class.quickSort(new ArrayList<>(emptyList));

        assertTrue(Sorting_Class.isSorted(actualSorted),
                "An empty list should remain empty and sorted");
        assertEquals(emptyList, actualSorted,
                "The sorted empty list should match the original empty list");
    }

    @Test
    void testMergeSortSingletonList() {
        List<Student> singletonList = Arrays.asList(new Student("Alice", 85));
        List<Student> actualSorted = Sorting_Class.mergeSort(new ArrayList<>(singletonList));

        assertTrue(Sorting_Class.isSorted(actualSorted),
                "A singleton list should remain sorted");
        assertEquals(singletonList, actualSorted,
                "The sorted singleton list should match the original singleton list");
    }
}

