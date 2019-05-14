package by.training.task1.creator;

import by.training.task1.entity.Car;
import org.apache.log4j.Logger;

import java.util.*;
/**
 * This utility class provide a static method that creates {@code Car} subclasses objects
 * by choosing a concrete factory for it.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public class Creator {
    /**
     * Private constructor.
     * There is no need to creat an instance.
     */
    private Creator(){}
    /**
     * Logger to log information, errors and warnings and others.
     */
    private static final Logger LOGGER = Logger.getLogger(Creator.class.getSimpleName());
    /**
     * Constants that define type of a factory in {@code factoryHashMap}.
     */
    private static final String PASSENGER_TYPE = "PASSENGER",
                                AUTOTRUCK_TYPE = "AUTOTRUCK",
                                CARGOPASSENGER_TYPE = "CARGOPASSENGER";
    /**
     * {@code HashMap} that contains factories available by their {@code String} types
     * to create requested {@code Car} object.
     */
    private static HashMap<String, CarFactory> factoryHashMap = new HashMap<>();
    static {
        factoryHashMap.put(PASSENGER_TYPE, new PassengerCarFactory());
        factoryHashMap.put(AUTOTRUCK_TYPE, new AutotruckFactory());
        factoryHashMap.put(CARGOPASSENGER_TYPE, new CargoPassengerFactory());
    }
    /**
     * Choose concrete factory by input parameters and create {@code Optional<Car>} object.
     * @param params necessary parameters to create a {@code Car}
     * @return if {@code params} are valid return created {@code Optional<Car>},
     *          otherwise {@code Optional.empty()}.
     */
    public static Optional<Car> create(List<String> params){
        Optional<CarFactory> optionalFactory = Optional.ofNullable(factoryHashMap.get(params.get(0)));
        LOGGER.debug("chosen factory: " + (optionalFactory.isPresent() ? optionalFactory.get().getClass().getSimpleName() : "null"));
        return optionalFactory.map(carFactory -> carFactory.getAuto(params.subList(1, params.size())));
    }
}
