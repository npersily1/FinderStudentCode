public class HashMap {


    // Set both of these to prime numbers to reduce chance of collision
    // Tested DEFAULT_TABLE_SIZE for speed with varying numbers and 89 was the fastest
    public final static int DEFAULT_TABLE_SIZE = 89;
    public final static int RADIX = 257;


    private int tableSize;
    private int keysInserted;

    Pair[] map;

    public HashMap() {
        tableSize = DEFAULT_TABLE_SIZE;
        map = new Pair[tableSize];
    }

    // Horner's method
    private int hash(String s) {
        int hash = 0;

        for (int i = 0; i < s.length(); i++) {
            hash = (hash * RADIX + s.charAt(i)) % tableSize;
        }
        return hash;
    }

    public void add(String key, String value) {

        keysInserted += 1;
        // Check if the table is over half capacity and then resize
        double alpha = keysInserted / ((double) tableSize);
        if (alpha > .5) {
            resize();
        }

        int hash = hash(key);
        // Starting at the initial hash of the key
        // While there is a collision
        while (map[hash] != null) {
            // Increase the hash and wrap around
            hash = (hash + 1) % tableSize;
        }
        // Add the given key-value pair to the map
        map[hash] = new Pair(key, value);

    }

    // Returns value associated with given key
    public String get(String key) {
        int hash = hash(key);
        // Start at the initial hash of the key and go until null is reached
        while (map[hash] != null) {
            // If the key at the current location is the input key: return the associate value
            if (map[hash].key.equals(key))
                return map[hash].value;
            // Increment hash and wrap around
            hash = (hash + 1) % tableSize;
        }
        // If key not found return message
        return "INVALID KEY";
    }

    // Transports the old map into a new one twice the size
    private void resize() {

        tableSize *= 2;
        Pair[] newMap = new Pair[tableSize];

        // For the length of the old table
        for (int i = 0; i < map.length; i++) {
            // Skip if pair doesn't exist
            if (!(map[i] == null)) {
                // Implement the add method above, but find the space for newMap and instead of making a new pair use the one from the old map
                int hash = hash(map[i].key);

                while (newMap[hash] != null) {
                    hash = (hash + 1) % tableSize;
                }
                newMap[hash] = map[i];
            }
        }
        map = newMap;

    }

    // Small class that is a key-value pair
    private class Pair {
        String value;
        String key;

        private Pair(String k, String v) {
            key = k;
            value = v;
        }
    }

}
