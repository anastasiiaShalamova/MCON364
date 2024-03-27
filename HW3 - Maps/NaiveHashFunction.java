package HW3_Maps;

class NaiveHashFunction<K> implements HashFunction<K> {

    private final int capacity;

    public NaiveHashFunction(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}

