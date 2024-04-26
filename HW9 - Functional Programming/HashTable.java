import java.util.Iterator;

public class HashTable<K, V> implements MapInterface<K, V> {

    private int size; 
    private final int capacity;
    private final LinkedList<MapEntry<K, V>>[] table; // array of linked lists to store key value pairs
    private HashFunction<K> hashFunction; // hash function for determining indices

    // constructor with capacity parameter
    public HashTable(int capacity) {
    	
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
        this.size = 0;
        this.hashFunction = new NaiveHashFunction<>(capacity); 
        }

    // constructor with capacity and custom hash function parameters
    public HashTable(int capacity, HashFunction<K> hashFunction) {
    	
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
        this.size = 0;
        this.hashFunction = hashFunction;
    }

    // adding or update a key value pair in the hash table
    @Override
    public V put(K key, V value) {
    	
        int index = hashFunction.hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (MapEntry<K, V> entry : table[index]) {
        	
            if (entry.getKey().equals(key)) { 
                V oldValue = entry.getValue();
                entry.setValue(value);
                
                return oldValue;
            }
        }

        // adding a new key value pair
        table[index].add(new MapEntry<>(key, value)); 
        size++;
        
        return null;
    }

    // retrieving the value associated with a key
    @Override
    public V get(K key) {
    	
        int index = hashFunction.hash(key);
        
        if (table[index] != null) {
            for (MapEntry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue(); 
                }
            }
        }
        return null;
    }

    // removing a key value pair from the hash table
    @Override
    public V remove(K key) {
    	
        int index = hashFunction.hash(key);
        
        if (table[index] != null) {
            for (MapEntry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    table[index].remove(entry);
                    size--; 
                    return entry.getValue();
                }
            }
        }
        return null; 
    }

    // checking if the hash table contains a key
    // and checking if the get method returns a non null value
    @Override
    public boolean contains(K key) {
        return get(key) != null; 
    }

    // checking if the hash table is empty
    // and if size is 0
    @Override
    public boolean isEmpty() {
        return size == 0; 
    }

    // checking if the hash table is full
    // and if the the size is equal to capacity
    @Override
    public boolean isFull() {
        return size == capacity; 
    }

    // getting the current size of the hash table
    // and returning the size
    @Override
    public int size() {
        return size; 
    }

    // setting a custom hash function
    public void setHashFunction(HashFunction<K> hashFunction) {
        this.hashFunction = hashFunction; 
    }

    // getting the size of the linked list at a specific index
    public int getListSize(K key) {
    	
        int index = hashFunction.hash(key);
        
        if (table[index] != null && contains(key)) {
            return table[index].size(); // Return the size of the linked list
        }
        
        return 0;
    }

    // printing a report about the hash table
    public void printHashTableReport() {
    	
        int totalWords = 0;
        int unusedSlots = 0;
        int totalLinkedLists = 0;
        int totalListLength = 0;

        System.out.println("Word Count:");
        
        for (int i = 0; i < capacity; i++) {
            System.out.print("Slot " + i + ": ");
            if (table[i] != null) {
                System.out.print("[ ");
                int listSize = table[i].size();
                for (MapEntry<K, V> entry : table[i]) {
                    System.out.print(entry.getKey() + " : " + entry.getValue() + " ");
                    totalWords += (Integer) entry.getValue();  
                }
                System.out.println("]");
                totalLinkedLists++; // Increment the total number of linked lists
                totalListLength += listSize; // Add the size of this linked list to the total length
                System.out.println("Size of linked list: " + listSize);
            } 
            else {
                unusedSlots++;
                System.out.println("Empty");
            }
        }

        System.out.println("\nTotal words in map: " + totalWords);
        System.out.println("Size of the array: " + capacity);
        System.out.println("Number of unused array slots: " + unusedSlots);
        System.out.println("Load factor: " + (double) size / capacity);

        double averageLength = (double) totalListLength / totalLinkedLists;
        System.out.println("Average linked list length: " + averageLength);
    }

    // iterator for the hash table
    @Override
    public Iterator<MapEntry<K, V>> iterator() {
        return new HashTableIterator();
    }

    // iterator class for the hash table
    private class HashTableIterator implements Iterator<MapEntry<K, V>> {
    	
        private final MapEntry<K, V>[] sortedEntries;
        private int currentIndex = 0;

        // constructor for the iterator
        public HashTableIterator() {
        	
            sortedEntries = new MapEntry[size];
            int index = 0;

            // populating sortedEntries with all entries in the hash table
            for (int i = 0; i < capacity; i++) {
                if (table[i] != null) {
                    for (MapEntry<K, V> entry : table[i]) {
                        sortedEntries[index++] = entry;
                    }
                }
            }

            sortEntriesByUsageCount(sortedEntries); 
        }

        // sorting entries by usage count
        private void sortEntriesByUsageCount(MapEntry<K, V>[] entries) {
        	
            for (int i = 1; i < entries.length; i++) {
            	
                MapEntry<K, V> keyEntry = entries[i];
                int j = i - 1;
                
                while (j >= 0 && ((Integer) entries[j].getValue()) < ((Integer) keyEntry.getValue())) {
                    entries[j + 1] = entries[j];
                    j--;
                }
                entries[j + 1] = keyEntry;
            }
        }

        @Override
        public boolean hasNext() {
            return currentIndex < sortedEntries.length;
        }

        @Override
        public MapEntry<K, V> next() {
        	
            if (!hasNext()) {
                return null;
            }
            
            return sortedEntries[currentIndex++];
        }
    }
}
