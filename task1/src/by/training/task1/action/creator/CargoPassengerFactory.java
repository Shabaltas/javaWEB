package by.training.task1.action.creator;

import by.training.task1.entity.Car;
import by.training.task1.entity.CargoPassengerCar;
import by.training.task1.entity.Truck;
import by.training.task1.action.validator.CarValidator;
import by.training.task1.exception.InvalidCarDataException;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;

public class CargoPassengerFactory implements CarFactory {
    private static final Logger LOGGER = Logger.getLogger(CargoPassengerFactory.class);
    @Override
    public Car getAuto(String[] params) {
        try {
            CarValidator.getInstance().validateCargoPassenger(params);
            return new CargoPassengerCar.Builder()
                    .withId(Integer.valueOf(params[0]))
                    .withCountPassengers(Integer.valueOf(params[1]))
                    .withMaxCarrying(Integer.valueOf(params[2]))
                    .withCost(BigDecimal.valueOf(Double.valueOf(params[3])))
                    .withCargoType(Truck.CargoType.valueOf(params[4]))
                    .withType(CargoPassengerCar.CargoPassengerType.valueOf(params[5]))
                    .build();
        }catch (InvalidCarDataException e){
            LOGGER.error("INVALID DATA INPUT");
            return null;
        }
    }
}
