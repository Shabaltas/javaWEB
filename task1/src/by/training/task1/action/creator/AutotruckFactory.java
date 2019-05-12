package by.training.task1.action.creator;

import by.training.task1.entity.Car;
import by.training.task1.entity.Autotruck;
import by.training.task1.entity.Truck;
import by.training.task1.action.validator.CarValidator;
import by.training.task1.exception.InvalidCarDataException;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;

public class AutotruckFactory implements CarFactory {
    private static final Logger LOGGER = Logger.getLogger(AutotruckFactory.class);
    @Override
    public Car getAuto(String[] params) {
        try {
            CarValidator.getInstance().validateAutotruck(params);
            return new Autotruck.Builder()
                    .withId(Integer.valueOf(params[0]))
                    .withCountPassengers(Integer.valueOf(params[1]))
                    .withMaxCarrying(Integer.valueOf(params[2]))
                    .withCost(BigDecimal.valueOf(Double.valueOf(params[3])))
                    .withCargoType(Truck.CargoType.valueOf(params[4]))
                    .withCountAxles(Byte.valueOf(params[5]))
                    .withBodyType(Autotruck.AutotruckType.valueOf(params[6]))
                    .build();
        }catch (InvalidCarDataException e){
            LOGGER.error("INVALID DATA INPUT");
            return null;
        }
    }
}
