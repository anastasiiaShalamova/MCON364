public class MapEntry<K, V> {
	
    protected K key; 
    protected V value; 

    // constructor, initializing map entry with the given key and value
    public MapEntry(K k, V v) {
        key = k; 
        value = v; 
    }

    // getting the key of map entry
    public K getKey() {
        return key; 
    }

    // detting the value of map entry
    public V getValue() {
        return value; 
    }

    // setting the value of map entry
    public void setValue(V v) {
        value = v; 
    }

    
    @Override
    public String toString() {
        return "Key : " + key + "\nValue: " + value; 
    }
}

