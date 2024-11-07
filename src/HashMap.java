public class HashMap {

    private class Pair {
        String value;
        String key;

        private Pair(String k, String v) {
            key = k;
            value = v;
        }
    }

    public final static int DEFAULT_TABLE_SIZE = 20;
    public final static int RADIX = 256;
    private int tableSize;
    private int keysInserted;

    Pair[] map;

    public HashMap() {
        tableSize = DEFAULT_TABLE_SIZE;
        map = new Pair[tableSize];
    }

    private int hash(String s) {
        int hash = 0;

        for (int i = 0; i < s.length(); i++) {
            hash = (hash * RADIX + s.charAt(i)) % tableSize;
        }
        return hash;
    }

    public void add(String key, String value) {
        keysInserted += 1;

        double alpha = keysInserted / (double) tableSize;
        if (alpha > .5) {
            resize();
        }

        int hash = hash(key);

        while (map[hash] != null) {
            hash = (hash + 1) % tableSize;
        }
        map[hash] = new Pair(key, value);

    }

    public String get(String key) {

    }

    private void resize() {




    }


}
