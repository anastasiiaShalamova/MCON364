import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.function.Function;

// link - https://learn.microsoft.com/en-us/dotnet/api/system.security.cryptography.hashalgorithm.computehash?view=net-8.0
public class SophisticatedHashFunction<K> implements HashFunction<K> {
	
    private final int capacity;
    private final Function<K, Integer> hash;

    public SophisticatedHashFunction(int capacity) {
    	
        this.capacity = capacity;
        
        // implementing the hash method using lambda expression
        this.hash = key -> {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] keyBytes = key.toString().getBytes();
                byte[] hashBytes = digest.digest(keyBytes);
                int hash = bytesToInt(hashBytes);
                return Math.abs(hash % capacity);
            } 
            catch (NoSuchAlgorithmException e) {
                return key.hashCode() % capacity;
            }
        };
    }

    @Override
    public int hash(K key) {
        return hash.apply(key);
    }

    // converting a byte array to an integer
    private int bytesToInt(byte[] bytes) {
        int result = 0;
        for (byte b : bytes) {
            result = (result << 8) | (b & 0xFF);
        }
        return result;
    }
}
