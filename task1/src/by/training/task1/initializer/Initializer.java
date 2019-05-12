package by.training.task1.initializer;

import by.training.task1.action.creator.Creator;
import by.training.task1.entity.Car;
import by.training.task1.repository.Repository;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Initializer {
    private static Initializer instance;
    private Initializer(){}
    public static Initializer getInstance(){
        if (instance == null){
            instance = new Initializer();
        }
        return instance;
    }
    private static final Logger LOGGER = Logger.getLogger(Initializer.class.getSimpleName());
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
