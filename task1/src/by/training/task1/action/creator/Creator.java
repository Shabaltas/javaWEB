package by.training.task1.action.creator;

import by.training.task1.entity.Car;

import java.util.*;

public class Creator {
    private Creator(){
    }
    private static HashMap<String, CarFactory> factoryHashMap = new HashMap<>();
    static {
        factoryHashMap.put("PASSENGER", new PassengerCarFactory());
        factoryHashMap.put("AUTOTRUCK", new AutotruckFactory());
        factoryHashMap.put("CARGOPASSENGER", new CargoPassengerFactory());
    }

    public static Optional<Car> create(String[] params){
        Optional<CarFactory> optionalFactory = Optional.ofNullable(factoryHashMap.get(params[1]));
        String[] newParams = new String[params.length-1];
        newParams[0] = params[0];
        System.arraycopy(params, 2, newParams, 1, params.length - 2);
        return optionalFactory.map(carFactory -> carFactory.getAuto(newParams));
    }
}
