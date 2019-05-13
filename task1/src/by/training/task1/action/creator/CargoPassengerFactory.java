package by.training.task1.action.creator;

import by.training.task1.entity.CargoPassengerCar;
import by.training.task1.entity.Truck;
import by.training.task1.action.validator.CarValidator;
import by.training.task1.exception.InvalidCarDataException;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
/**
 * {@code CarFactory} implementation to create concrete {@code CargoPassengerCar} object.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public class CargoPassengerFactory implements CarFactory {
    /**
     * Logger to log information, errors and warnings and others.
     */
    private static final Logger LOGGER = Logger.getLogger(CargoPassengerFactory.class);
    /**
     * Factory method that check input data and if it is valid,
     * create and return new {@code CargoPassengerCar}.

     * @param params Array of {@code String}
     *               that contains necessary parameters to create a {@code CargoPassengerCar}
     * @return if {@code params} are valid return created {@code CargoPassengerCar},
     *          otherwise {@code null}.
     */
    @Override
    public CargoPassengerCar getAuto(String[] params) {
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
