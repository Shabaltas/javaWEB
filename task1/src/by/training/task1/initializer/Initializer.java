package by.training.task1.initializer;

import by.training.task1.creator.Creator;
import by.training.task1.entity.Car;
import by.training.task1.exception.InvalidCarDataException;
import by.training.task1.parser.Parser;
import by.training.task1.repository.Repository;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for initialising repositories with cars from different sources.
 * This is a collection of static methods, so there is no need to create an instance
 * of the {@code Initializer} to use static methods fot initializing.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
*/
public class Initializer {
    /**
     * Private constructor.
     * There is no need to creat an instance.
     */
    private Initializer(){}

    /**
     * Logger to log information, errors and warnings and others.
     */
    private static final Logger LOGGER = Logger.getLogger(Initializer.class.getSimpleName());

    /**
     * Static method to get {@code Car} instances from the file and put them into the repository.
     * It calls {@code Parser.parseFromBuf} to parsed data from file, so variable {@code wrongListAmount}
     * counts how mush lines are invalid to calculate identifier.
     *
     * @param filename input file
     * @param repository repository to put
     */
    public static void initializeFromFile(String filename, Repository<Car> repository) throws IOException{
        List<ArrayList<String>> data = Parser.parseFromBuf(filename);
        int[] id = new int[]{1};
        for (ArrayList<String> params : data){
            params.add(1, id[0] + "");
                Creator.create(params).ifPresent(optionalCar -> {
                    LOGGER.debug("adding... " + optionalCar);
                    try {
                        repository.add(optionalCar);
                        id[0]++;
                    } catch (InvalidCarDataException e) {
                        LOGGER.warn(e);
                    }
                    LOGGER.debug("added " + optionalCar);
                });
            }
        }
    }

