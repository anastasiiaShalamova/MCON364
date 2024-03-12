package hw2_BST_version2;
import java.util.*;

// LinkedList Node class for BSTNode
class LLNode<T> {
	
    T info;
    LLNode<T> link;

    public LLNode(T info) {
        this.info = info;
        this.link = null;
    }
}