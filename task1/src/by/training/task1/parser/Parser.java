package by.training.task1.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for parsing data source.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public class Parser {
    /**
     * Parse data into {@code List<String[]>} from file "filename".
     *
     * @param filename source
     * @return {@code List} of parsed arrays of {@code String}
     * @throws IOException if an I/O error occurs
     */
    public List<ArrayList<String>> parseFromBuf(String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        List<ArrayList<String>> res = new ArrayList<>();
        String line;
        int i = 0;
        while ((line = bufferedReader.readLine()) != null) {
            if (!"".equals(line)) {
                res.add(new ArrayList<>());
                String[] paramsArray = line.trim().toUpperCase().split("\\s+");
                for (String param : paramsArray){
                    res.get(i).add(param);
                }
                i++;
            }
        }
        return res;
    }
}
