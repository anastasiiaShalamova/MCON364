package HW3_Maps;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements Iterable<E> {
	
    private Node<E> head; // first node in the list
    private int size; 

    // constructor to initialize an empty linked list
    public LinkedList() {
        head = null;
        size = 0; 
    }

    // adding a new element to the end of the list
    // by creaing a new node with the given data..
    public void add(E data) {
    	
        Node<E> newNode = new Node<>(data);
        
        // if list is empty, we're setting the new node as the head
        if (head == null) { 
            head = newNode; 
        } 
        // if the list is not empty, we're traversing to the last node
        else {
            Node<E> current = head;
            
            while (current.next != null) {
                current = current.next;
            }
            // linking the new node to the last node
            current.next = newNode; 
        }
        
        size++; 
    }

    // removing the first occurrence of the specified data from the list
    public boolean remove(E data) {
    	
        if (head == null) { 
            return false; 
        }

        // but if the data is in the head node, we're moving to the next node
        if (head.data.equals(data)) { 
        	
            head = head.next;
            size--; 
            
            return true; 
        }

        Node<E> current = head;
        
        // traversing the list to find the node before the one containing the data
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }
        // but if data is found, we're removing the node that containing the data
        if (current.next != null) { 
            current.next = current.next.next; 
            size--; 
            
            return true; 
        }

        return false; 
    }

    // checking if the list contains the specified data
    public boolean contains(E data) {
    	
        Node<E> current = head;
        
        // traversing the list to find the data
        while (current != null) {
            if (current.data.equals(data)) {
                return true; 
            }
            current = current.next;
        }
        return false; 
    }

    // getting the size of the list
    public int size() {
        return size;
    }

    // checking if the list is empty
    public boolean isEmpty() {
        return size == 0; 
    }

    // creating an iterator for the linked list
    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator(); 
    }

    // inner class representing an iterator for the linked list
    private class LinkedListIterator implements Iterator<E> {
    	
        private Node<E> current;

        // constructor to initialize the iterator with the head node
        // starting iterating from the head of the list
        LinkedListIterator() {
            current = head;
        }

        // checking if there are more elements to iterate over
        // if there is null, it means no more elements
        @Override
        public boolean hasNext() {
            return current != null;
        }

        // getting the next element in the iteration
        @Override
        public E next() {
        	
        	// if there are no more elements, we're throwing an exception
            if (!hasNext()) { 
                throw new NoSuchElementException(); 
            }
            
            E data = current.data; 
            current = current.next; 
            return data; 
        }
    }

    // inner class representing a node in the linked list
    private static class Node<E> {
        E data; 
        Node<E> next;

        // constructor to initialize a node with the given data
        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
}
