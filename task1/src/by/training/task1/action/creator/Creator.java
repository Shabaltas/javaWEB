package by.training.task1.action.creator;

import by.training.task1.entity.Car;

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
    public static Optional<Car> create(String[] params){
        Optional<CarFactory> optionalFactory = Optional.ofNullable(factoryHashMap.get(params[1]));
        String[] newParams = new String[params.length-1];
        newParams[0] = params[0];
        System.arraycopy(params, 2, newParams, 1, params.length - 2);
        return optionalFactory.map(carFactory -> carFactory.getAuto(newParams));
    }
}
