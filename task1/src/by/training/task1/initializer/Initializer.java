package by.training.task1.initializer;

import by.training.task1.action.creator.Creator;
import by.training.task1.entity.Car;
import by.training.task1.repository.Repository;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

/*    private static Initializer instance;
      public static Initializer getInstance(){
        if (instance == null){
            instance = new Initializer();
        }
        return instance;
    }*/

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
     * @param filename input file
     * @param repository repository to put
     */
    public static void initializeFromFile(String filename, Repository<Car> repository){
        try(BufferedReader bufreader = new BufferedReader(new FileReader(filename))){
            final int[] i = new int[]{1};
            String line;
            while((line = bufreader.readLine()) != null) {
                if (!"".equals(line)) {
                    line = i[0] + " " + line.toUpperCase();
                    String[] params = line.split("\\s+");
                    Creator.create(params).ifPresent(optionalCar -> {
                        i[0]++;
                        repository.add(optionalCar);
                        LOGGER.info("added " + optionalCar);
                    });
                }
            }
        }catch (IOException e){
            LOGGER.error(e);
        }
    }
}
