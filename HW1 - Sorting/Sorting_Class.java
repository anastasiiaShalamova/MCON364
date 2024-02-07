import java.util.*;


public class Sorting_Class {

    // Quicksort for a list of comparable objects
    public static <T extends Comparable<T>> List<T> quickSort(List<T> list) {
        
        if (list.size() <= 1) {
            return list;
        }

        T pivot = list.get(list.size() / 2);

        List<T> less = new ArrayList<>();
        List<T> equal = new ArrayList<>();
        List<T> greater = new ArrayList<>();

        // dividing list into 3 parts based on the pivot
        for (T element : list) {
            int cmp = element.compareTo(pivot);
            if (cmp < 0) {
                less.add(element);
            } 
            else if (cmp > 0) {
                greater.add(element);
            } 
            else {
                equal.add(element);
            }
        }

        // applying Quicksort
        List<T> result = new ArrayList<>();
        result.addAll(quickSort(less));
        result.addAll(equal);
        result.addAll(quickSort(greater));

        return result;
    }

    // applying Mergesort to a comparable objects
    public static <T extends Comparable<T>> List<T> mergeSort(List<T> list) {
        if (list.size() <= 1) {
            return list;
        }

        int middle = list.size() / 2;
        List<T> left = list.subList(0, middle);
        List<T> right = list.subList(middle, list.size());

        left = mergeSort(new ArrayList<>(left));
        right = mergeSort(new ArrayList<>(right));

        return merge(left, right);
    }

    // merging 2 sorted lists into one single sorted list
    private static <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {
        List<T> result = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).compareTo(right.get(rightIndex)) < 0) {
                result.add(left.get(leftIndex++));
            } 
            else {
                result.add(right.get(rightIndex++));
            }
        }

        // sdding any remaining elements from left and right lists
        result.addAll(left.subList(leftIndex, left.size()));
        result.addAll(right.subList(rightIndex, right.size()));

        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        
        // random list of students
        List<Student> studentList = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= numStudents; i++) {
            studentList.add(new Student("Student" + i, random.nextInt(101)));
        }


        System.out.println("Unsorted List:");
        printStudentList(studentList);

        System.out.println("\nSorting using QuickSort...");
        List<Student> quickSorted = quickSort(new ArrayList<>(studentList));
        System.out.println("QuickSorted List:");
        printStudentList(quickSorted);

        System.out.println("\nSorting using MergeSort...");
        List<Student> mergeSorted = mergeSort(new ArrayList<>(studentList));
        System.out.println("MergeSorted List:");
        printStudentList(mergeSorted);


        System.out.println("\nVerification for QuickSort: " + isSorted(quickSorted));
        System.out.println("Verification for MergeSort: " + isSorted(mergeSorted));

        scanner.close();
    }

    private static <T extends Comparable<T>> void printStudentList(List<T> list) {
        System.out.println("===================================");
        for (T element : list) {
            System.out.println(element);
        }
        System.out.println("===================================");
    }

    static <T extends Comparable<T>> boolean isSorted(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }
}

