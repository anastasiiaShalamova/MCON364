
import java.util.function.Function;

public class NaiveHashFunction<K> implements HashFunction<K> {
	
    private final int capacity;
    private final Function<K, Integer> hash;

    public NaiveHashFunction(int capacity) {
        this.capacity = capacity;
        // implementing the hash method using lambda expression
        this.hash = key -> Math.abs(key.hashCode()) % capacity;
    }

    @Override
    public int hash(K key) {
        return hash.apply(key);
    }
}
