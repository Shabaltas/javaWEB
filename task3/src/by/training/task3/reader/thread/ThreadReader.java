package by.training.task3.reader.thread;

import by.training.task3.reader.FileException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
/**
 * Class that responsible for reading data for creating {@link Thread}.
 */
public class ThreadReader {
    /**
     * To log system information.
     */
    private static final Logger LOGGER = Logger.getLogger(ThreadReader.class);
    /**
     * Reads lines representing parameters for creating thred from file.
     * @param path path to file
     * @param count the number of threads
     * @return {@code List} of {@code String} where each {@code String}
     *          contains parameters
     * @throws FileException
     *          if an I/O error occurs reading from the file or a malformed or
     *          unmappable byte sequence is read
     */
    public List<String> readFromFile(Path path, int count) throws FileException {
        try {
            return Files.readAllLines(
                    path,
                    Charset.forName("UTF-8")
            ).subList(0, count);
        } catch (IOException e) {
            LOGGER.warn(e);
            throw new FileException("Exception while reading threads from file", e);
        }
    }
}
