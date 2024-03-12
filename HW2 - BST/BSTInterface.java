package hw2_BST_version2;
import java.util.*;

interface BSTInterface<T> extends CollectionInterface<T>, Iterable<T> {
	
    enum Traversal {Inorder, Preorder, Postorder}
    
    T min();
    T max();
    Iterator<T> getIterator(Traversal orderType);
}
