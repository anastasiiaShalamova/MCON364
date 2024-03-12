package hw2_BST_version2;
import java.util.*;

class LinkedStack<T> {
	
    private LLNode<T> top;

    public LinkedStack() {
        top = null;
    }

    public void push(T element) {
        LLNode<T> newNode = new LLNode<>(element);
        newNode.link = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T element = top.info;
        top = top.link;
        return element;
    }

    public boolean isEmpty() {
        return (top == null);
    }
}
