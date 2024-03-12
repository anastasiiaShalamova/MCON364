package hw2_BST_version2;
import java.util.*;

interface CollectionInterface<T> {
	
    boolean add(T element);
    T get(T target);
    boolean contains(T target);
    boolean remove(T target);
    boolean isFull();
    boolean isEmpty();
    int size();
}
