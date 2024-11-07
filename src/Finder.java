import java.io.BufferedReader;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;

/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 * <p>
 * Completed by: [Noah Persily
 * ]
 **/


public class Finder {

    private static final String INVALID = "INVALID KEY";
    private HashMap hashMap;

    public Finder() {
        hashMap = new HashMap();
    }

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        while (br.readLine() != null) {
            String s = br.readLine();
            String[] line = s.split(",");
            hashMap.add(line[keyCol],line[valCol]);
        }

        br.close();


    }


    public String query(String key) {
        return hashMap.get(key);
    }
}