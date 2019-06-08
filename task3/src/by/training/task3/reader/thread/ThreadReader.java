package by.training.task3.reader.thread;

import by.training.task3.reader.FileException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ThreadReader {
    private static final Logger LOGGER = Logger.getLogger(ThreadReader.class);
    public List<String> readFromFile(Path path, int count) throws FileException {
        try {
            return Files.readAllLines(path, Charset.forName("UTF-8"));
        } catch (IOException e) {
            LOGGER.warn(e);
            throw new FileException("Exception while reading threads from file", e);
        }
    }
}
