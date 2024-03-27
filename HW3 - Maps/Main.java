
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
    	
        int capacity = 1000; 
        HashTable<String, Integer> wordTable = new HashTable<>(capacity); 
        Scanner scanner = new Scanner(System.in); 

        // reading file and counting words
        readFileAndCountWords(wordTable);

        boolean quit = false; 
        while (!quit) {
            System.out.println("\nMenu:");
            System.out.println("1. View word count and linked list length it is found in for a particular word");
            System.out.println("2. View words in descending order of usage");
            System.out.println("3. View report on internal structure of the hash table");
            System.out.println("4. Choose the hash function: naive or sophisticated");
            System.out.println("Q. Quit");

            System.out.println();
            System.out.println("Enter your choice: ");
            String choice = scanner.nextLine().trim().toUpperCase(); 

            switch (choice) {
            
                case "1": 
                    System.out.print("Enter word to get its count and linked list length it is found in : ");
                    String word = scanner.nextLine().trim().toLowerCase();
                    System.out.println("Word count for '" + word + "': " + wordTable.get(word) +
                            "; the length of the linked list it is found in: " + wordTable.getListSize(word));
                    break;
                    
                case "2": 
                    System.out.println("Words in descending order of usage:");
                    for (MapEntry<String, Integer> entry : wordTable) {
                        System.out.println(entry);
                    }
                    break;
                    
                case "3":
                    wordTable.printHashTableReport();
                    break;
                    
                case "4": 
                    wordTable = new HashTable<>(capacity);
                    System.out.print("Enter hash function (naive or sophisticated): ");
                    String hashFunction = scanner.nextLine().trim().toLowerCase();
                    
                    if (hashFunction.equals("naive")) {
                        wordTable.setHashFunction(new NaiveHashFunction<>(capacity));
                    } 
                    else if (hashFunction.equals("sophisticated")) {
                        wordTable.setHashFunction(new SophisticatedHashFunction<>(capacity));
                    } 
                    else {
                        System.out.println("Invalid hash function!");
                    }
                    readFileAndCountWords(wordTable);
                    break;
                    
                case "Q": 
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close(); 
    }

    // reading file and counting words
    private static void readFileAndCountWords(HashTable<String, Integer> wordTable) {
    	
        File file = new File("alice_in_wonderland.txt"); 

        try {
        	
            Scanner fileScanner = new Scanner(file); 
            
            while (fileScanner.hasNext()) {
                String word = fileScanner.next().toLowerCase().replaceAll("[^a-zA-Z]", ""); 
                
                // ignoring empty strings and
                // updating word count in hash table
                if (!word.isEmpty()) { 
                    wordTable.put(word, wordTable.get(word) == null ? 1 : wordTable.get(word) + 1);
                }
            }
            
            fileScanner.close(); 
            System.out.println("File read successfully and words counted!"); 
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found!"); 
        }
    }
}

