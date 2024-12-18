import java.io.BufferedReader;
import java.io.IOException;


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
        String s = br.readLine();
        // While the file isn't over
        while (s != null) {
            // Add the indicated columns to the table and read a new line
            String[] line = s.split(",");
            hashMap.add(line[keyCol], line[valCol]);
            s = br.readLine();
        }

        br.close();
    }

    public String query(String key) {
        return hashMap.get(key);
    }
}