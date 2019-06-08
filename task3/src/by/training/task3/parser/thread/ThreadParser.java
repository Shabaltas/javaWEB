package by.training.task3.parser.thread;

import java.util.Arrays;
import java.util.List;

public class ThreadParser {
    private static String splitter = " ";
    public static void setSplitter(String newSplitter) {
        splitter = newSplitter;
    }
    public List<String> parseLine(String line) {
        return Arrays.asList(line.split(splitter));
    }
}
