import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: [Noah Persily
 *]
 **/


public class Finder {

    private static final String INVALID = "INVALID KEY";
    public  static final int RADIX = 256;
    public  static final int PRIME1 = 7000069;
    private ArrayList<String>[] table = new ArrayList[PRIME1];

    public Finder() {


    }

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        while(br.readLine() != null) {
            String s = br.readLine();
            String[] last = s.split(",");
            table[hash(last[keyCol])].add(last[valCol]);
        }

        br.close();




    }
    public int hash(String s) {
        int hash = 0;

        for (int i = 0; i < s.length(); i++) {
            hash =  (hash * RADIX +  s.charAt(i)) % PRIME1;
        }
        return hash;

    }

    public String query(String key){

        int keyHash = hash(key);
        if(table[keyHash] == null) {
            return INVALID;
        }
        return table[keyHash].get((int)(Math.random() * table[keyHash].size()));
    }
}