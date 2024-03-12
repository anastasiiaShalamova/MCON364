package hw2_BST_version2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Character> bst = new BinarySearchTree<>();
        Scanner scanner = new Scanner(System.in);

        // adding initial elements
        addInitialElements(bst);

        // interactive CLI
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addElement(bst, scanner);
                    break;
                case 2:
                    removeElement(bst, scanner);
                    break;
                case 3:
                    printTraversal(bst, BSTInterface.Traversal.Inorder);
                    break;
                case 4:
                    printTraversal(bst, BSTInterface.Traversal.Preorder);
                    break;
                case 5:
                    printTraversal(bst, BSTInterface.Traversal.Postorder);
                    break;
                case 6:
                    printBFS(bst);
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addInitialElements(BinarySearchTree<Character> bst) {
        bst.add('P');
        bst.add('F');
        bst.add('S');
        bst.add('B');
        bst.add('H');
        bst.add('R');
        bst.add('Y');
        bst.add('G');
        bst.add('T');
        bst.add('Z');
        bst.add('W');
    }

    private static void printMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Add an element");
        System.out.println("2. Remove an element");
        System.out.println("3. Print In-order traversal");
        System.out.println("4. Print Pre-order traversal");
        System.out.println("5. Print Post-order traversal");
        System.out.println("6. Print Breadth-First Search (BFS)");
        System.out.println("7. Exit");
    }

    private static void addElement(BinarySearchTree<Character> bst, Scanner scanner) {
        System.out.print("Enter a character to add: ");
        char addElement = scanner.next().charAt(0);
        bst.add(addElement);
        System.out.println("Added element: " + addElement);
    }

    private static void removeElement(BinarySearchTree<Character> bst, Scanner scanner) {
        System.out.print("Enter a character to remove: ");
        char removeElement = scanner.next().charAt(0);
        if (bst.remove(removeElement)) {
            System.out.println("Removed element: " + removeElement);
        } else {
            System.out.println("Element not found: " + removeElement);
        }
    }

    private static void printTraversal(BinarySearchTree<Character> bst, BSTInterface.Traversal traversal) {
        System.out.print(traversal.toString() + " traversal: ");
        Iterator<Character> iter = bst.getIterator(traversal);
        while (iter.hasNext()) {
            System.out.print(iter.next());
        }
        System.out.println();
    }

    private static void printBFS(BinarySearchTree<Character> bst) {
        List<Character> bfsList = new ArrayList<>();
        bst.traverseBFSWithQueue(bst.getRoot(), bfsList);

        System.out.print("Breadth-First Search (BFS): ");
        for (Character ch : bfsList) {
            System.out.print(ch);
        }
        System.out.println();
    }
}
