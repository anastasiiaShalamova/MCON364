package hw2_BST_version2;
import java.util.*;

interface Comparator<T> {
    int compare(T o1, T o2);

    boolean equals(Object obj);
}