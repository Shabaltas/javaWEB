package by.training.task3.parser.thread;

import java.util.Arrays;
import java.util.List;
/**
 * Class that responsible for parsing a {@code String}
 * in the parameters for creating {@link Thread}.
 */
public class ThreadParser {
    /**
     * Parses a {@code String} consisting of the parameters.
     * @param line string that contains parameters
     * @param splitter splitter
     * @return {@code List} of strings, where each string is one parameter.
     */
    public List<String> parseLine(String line, String splitter) {
        return Arrays.asList(line.split(splitter));
    }
}
