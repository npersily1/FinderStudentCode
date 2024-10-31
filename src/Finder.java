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
    public  static final int PRIME = 7000069;
    private ArrayList<Integer>[] table = new ArrayList<Integer>[];

    public Finder() {


    }

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {

        br.close();
        ArrayList<Integer> bob = new ArrayList<>();
        bob.add(12);



    }
    public int hash(String s) {
        int hash = 0;

        for (int i = 0; i < s.length(); i++) {
            hash =  (hash * RADIX +  s.charAt(i)) % 5;
        }
        return hash;

    }

    public String query(String key){

        return INVALID;
    }
}