package hw2_BST_version2;
import java.util.*;

class BinarySearchTree<T> implements BSTInterface<T>, Comparable<T>, Comparator<T> {
	
	private BSTNode<T> root;       // reference to the root of the BST
    private Comparator<T> comp;    // comparator for comparing elements
    private boolean found;         // flag to track whether an element is found during removing

    // default constructor using natural order of elements
    public BinarySearchTree() {
        root = null;
        comp = this;
    }

    // constructor allowing custom comparator
    public BinarySearchTree(Comparator<T> comp) {
        root = null;
        this.comp = comp;
    }
    
    // method to get the root of the BST
    public BSTNode<T> getRoot() {
        return root;
    }

    // method that adding an element to the BST
    @Override
    public boolean add(T element) {
        if (element == null) {
            return false;
        }

        root = addElement(root, element);
        return true;
    }

    // recursive method that adding an element to the BST
    private BSTNode<T> addElement(BSTNode<T> node, T element) {
        if (node == null) {
            System.out.println("Added element: " + element + " (as root)");
            return new BSTNode<>(element);
        }

        int compareResult = comp.compare(element, node.getInfo());

        if (compareResult < 0) {
            if (node.getLeft() == null) {
                System.out.println("Added element: " + element + " (as left child of " + node.getInfo() + ")");
            }
            node.setLeft(addElement(node.getLeft(), element));
        } else if (compareResult > 0) {
            if (node.getRight() == null) {
                System.out.println("Added element: " + element + " (as right child of " + node.getInfo() + ")");
            }
            node.setRight(addElement(node.getRight(), element));
        } else {
            System.out.println("Duplicate element: " + element + " (ignored)");
        }
        
        return node;
    }

    // method that getting an element from the BST
    @Override
    public T get(T target) {
        if (target == null) {
            return null;
        }

        return getElement(root, target);
    }
    
    // recursive method that getting an element from the BST
    private T getElement(BSTNode<T> node, T target) {
        if (node == null) {
            return null;
        }

        if (comp.compare(target, node.getInfo()) == 0) {
            return node.getInfo();
        } else if (comp.compare(target, node.getInfo()) < 0) {
            return getElement(node.getLeft(), target);
        } else {
            return getElement(node.getRight(), target);
        }
    }

    // checking if BST contains a specific element
    @Override
    public boolean contains(T target) {
        return (get(target) != null);
    }

    // method that removing an element from the BST
    @Override
    public boolean remove(T target) {
        if (target == null) {
            return false;
        }

        root = removeElement(root, target);
        if (found) {
            System.out.println("Let's remove an element: " + target);
        } else {
            System.out.println("Element not found: " + target);
        }

        found = false; // Reset the found flag
        return found;
    }

    // recursive method that removing an element from the binary search tree
    private BSTNode<T> removeElement(BSTNode<T> node, T target) {
        if (node == null) {
            return null;
        }

        int compareResult = comp.compare(target, node.getInfo());

        if (compareResult < 0) {
            node.setLeft(removeElement(node.getLeft(), target));
        } else if (compareResult > 0) {
            node.setRight(removeElement(node.getRight(), target));
        } else {
            found = true; // setting 'found' to true when the target is found

            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            // node with two children
            // get the inorder successor
            // smallest in the right subtree
            node.setInfo(findMin(node.getRight()));

            // deleting the inorder successor
            node.setRight(removeElement(node.getRight(), node.getInfo()));
        }

        return node;
    }

    // finding the minimum value in a subtree
    private T findMin(BSTNode<T> node) {
        T minValue = node.getInfo();
        while (node.getLeft() != null) {
            minValue = node.getLeft().getInfo();
            node = node.getLeft();
        }
        return minValue;
    }
    
    // getting the minimum element in BST
    @Override
    public T min() {
        return (isEmpty()) ? null : findMin(root);
    }

    // checking if BST is full
    // false for linked implementation
    @Override
    public boolean isFull() {
        return false; // linked implementation is never full
    }
    
    // checking if BST is empty
    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    // getting the number of nodes in BST
    @Override
    public int size() {
        return countNodes(root);
    }

    // recursive method that counting the number of nodes in a subtree
    private int countNodes(BSTNode<T> node) {
        if (node == null) {
            return 0;
        }

        return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
    }
    
    // getting the maximum element in BST
    @Override
    public T max() {
        return (isEmpty()) ? null : findMax(root);
    }

    // finding the maximum value in a subtree
    private T findMax(BSTNode<T> node) {
        T maxValue = node.getInfo();
        while (node.getRight() != null) {
            maxValue = node.getRight().getInfo();
            node = node.getRight();
        }
        return maxValue;
    }

    // getting an iterator for a specific traversal order
    @Override
    public Iterator<T> getIterator(Traversal orderType) {
        List<T> list = new ArrayList<>();
        traverse(root, orderType, list);
        return list.iterator();
    }

    // comparator method to compare two elements
    @Override
    public int compare(T o1, T o2) {
        if (o1 == null && o2 == null) {
            return 0;
        } else if (o1 == null) {
            return -1;
        } else if (o2 == null) {
            return 1;
        } else {
            return o1.toString().compareTo(o2.toString());
        }
    }
    

    @Override
    public Iterator<T> iterator() {
        return getIterator(BSTInterface.Traversal.Inorder);
    }

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
    
    // traversing BST in a specific order and populate a list
    private void traverse(BSTNode<T> node, Traversal orderType, List<T> list) {
        if (node != null) {
            switch (orderType) {
                case Inorder:
                    traverse(node.getLeft(), orderType, list);
                    list.add(node.getInfo());
                    traverse(node.getRight(), orderType, list);
                    break;
                case Preorder:
                    list.add(node.getInfo());
                    traverse(node.getLeft(), orderType, list);
                    traverse(node.getRight(), orderType, list);
                    break;
                case Postorder:
                    traverse(node.getLeft(), orderType, list);
                    traverse(node.getRight(), orderType, list);
                    list.add(node.getInfo());
                    break;
            }
        }
    }

    // method to traverse BST in BFS order and populate a list
    public void traverseBFSWithQueue(BSTNode<T> root, List<T> list) {
        if (root == null) {
            return;
        }

        LinkedQueue<BSTNode<T>> queue = new LinkedQueue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            BSTNode<T> current = queue.dequeue();
            list.add(current.getInfo());

            if (current.getLeft() != null) {
                queue.enqueue(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.enqueue(current.getRight());
            }
        }
    }
    
    // so it removes the node with the specified target value from BST using BFS,
    // removing is done by setting the left or right child of the parent node to null,
    // then disconnecting the target node from the tree
    
    // checking if the target is null or the tree is empty
    public boolean removeBFS(T target) {
        if (target == null || root == null) {
            return false;
        }
        // creating a queue to perform BFS
        LinkedQueue<BSTNode<T>> queue = new LinkedQueue<>();
        queue.enqueue(root);

        // performing BFS to find the target node
        while (!queue.isEmpty()) {
            BSTNode<T> current = queue.dequeue();

            // checking the left child of the current node
            // if the left child has the target value, we're removing it by setting left to null
            if (current.getLeft() != null) {
                if (current.getLeft().getInfo().equals(target)) {
                    current.setLeft(null);
                    return true;
                } else {
                    queue.enqueue(current.getLeft());
                }
            }
            
            // checking the right child of the current node
            // if the right child has the target value, we're removing it by setting right to null
            if (current.getRight() != null) {
                if (current.getRight().getInfo().equals(target)) {
                    current.setRight(null);
                    return true;
                } else {
                    queue.enqueue(current.getRight());
                }
            }
        }

        return false; // couldn't find and remove the element
    }
    // adding a new node with the specified element to the BST using BFS
    // the element is added as the left or right child of the first available node in the tree
    public boolean addBFS(T element) {
        if (element == null) {
            return false;
        }
        
        // creating a new node with the specified element
        BSTNode<T> newNode = new BSTNode<>(element);

        // if the tree is empty, we're setting a new node as the root
        if (root == null) {
            root = newNode;
            return true;
        }
        
        // creating a queue to perform BFS
        LinkedQueue<BSTNode<T>> queue = new LinkedQueue<>();
        queue.enqueue(root);
        
        // performing BFS to find the first available node to add new element
        while (!queue.isEmpty()) {
            BSTNode<T> current = queue.dequeue();

            // checking the left child of the current node
            // if the left child is null, we're setting new node as the left child
            if (current.getLeft() == null) {
                current.setLeft(newNode);
                return true;
            } else {
                queue.enqueue(current.getLeft());     // enqueue left child 

            }

            // checking the right child of the current node
            // if the right child is null, we're setting new node as the right child
            if (current.getRight() == null) {
                current.setRight(newNode);
                return true;
            } else {
                queue.enqueue(current.getRight());    // enqueue right child 
            }
        }

        return false; // couldn't add the element
    }

}

