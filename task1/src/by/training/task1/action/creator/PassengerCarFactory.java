package by.training.task1.action.creator;

import by.training.task1.entity.Car;
import by.training.task1.entity.PassengerCar;
import by.training.task1.action.validator.CarValidator;
import by.training.task1.exception.InvalidCarDataException;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;

public class PassengerCarFactory implements CarFactory {
    private static final Logger LOGGER = Logger.getLogger(PassengerCarFactory.class);
    @Override
    public Car getAuto(String[] params) {
        try{
            CarValidator.getInstance().validatePassengerCar(params);
            return new PassengerCar.Builder()
                    .withId(Integer.valueOf(params[0]))
                    .withCountPassengers(Integer.valueOf(params[1]))
                    .withMaxCarrying(Integer.valueOf(params[2]))
                    .withCost(BigDecimal.valueOf(Double.valueOf(params[3])))
                    .withClassCar(PassengerCar.ClassCar.valueOf(params[4]))
                    .withBodyType(PassengerCar.CarBodyType.valueOf(params[5]))
                    .build();
        }catch (InvalidCarDataException e) {
            LOGGER.error("INVALID DATA INPUT");
            return null;
        }
    }
}
