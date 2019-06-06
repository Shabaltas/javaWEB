package by.training.task2.reader;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Reader {
    private static final Logger LOGGER = Logger
            .getLogger(Reader.class.getSimpleName());

    public String readFileToString(Path path) {
        try {
            String string = new String(Files.readAllBytes(path));
            LOGGER.debug("Read successfully");
            return string;
        } catch (IOException e) {
            LOGGER.warn("Read failed.", e);
            throw new FileReaderException(e);
        }
    }
}
