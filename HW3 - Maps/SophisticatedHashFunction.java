package HW3_Maps;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// link - https://learn.microsoft.com/en-us/dotnet/api/system.security.cryptography.hashalgorithm.computehash?view=net-8.0
public class SophisticatedHashFunction<K> implements HashFunction<K> {
	
    private final int capacity;

    public SophisticatedHashFunction(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int hash(K key) {
    	
        try {
        	
            // creating a SHA-256 MessageDigest instance
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // converting the key to bytes
            byte[] keyBytes = key.toString().getBytes();
            // updating the digest with the key bytes
            byte[] hashBytes = digest.digest(keyBytes);
            // converting the hash bytes to an integer
            int hash = bytesToInt(hashBytes);
            // applying modulo operation to fit the hash value within the capacity
            return Math.abs(hash % capacity);
        } 
        catch (NoSuchAlgorithmException e) {
        	
            // fallback to a simpler hash function or throwing an exception
            return key.hashCode() % capacity;
        }
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

