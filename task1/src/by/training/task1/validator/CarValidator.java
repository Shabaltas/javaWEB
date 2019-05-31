package by.training.task1.validator;

import by.training.task1.entity.Autotruck.AutotruckType;
import by.training.task1.entity.CargoPassengerCar.CargoPassengerType;
import by.training.task1.entity.PassengerCar.ClassCar;
import by.training.task1.entity.PassengerCar.CarBodyType;
import by.training.task1.entity.Truck.CargoType;
import by.training.task1.exception.InvalidCarDataException;

import java.util.List;
import java.util.regex.Pattern;
/**
 * Utility class for validating input data to create {@code Car}.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public final class CarValidator {
    /**
     * Regular expression for checking positive integers.
     */
    private static final String INT_REGEX = "\\d+";
    /**
     * Regular expression for checking positive fractional numbers.
     */
    private static final String DOUBLE_REGEX = "\\d+(\\.\\d+)?";
    /**
     * {@code Car} maximum possible passenger capacity.
     */
    private static final byte MAX_PASSENGERS = 101;
    /**
     * {@code Car} maximum possible load capacity.
     */
    private static final byte MAX_CARRYING = 100;
    /**
     * {@code Autotruck} maximum possible axles amount.
     */
    private static final byte MAX_AXLES = 10;
    /**
     * Message about mistake.
     */
    private static final String MSG = "Invalid data input";
    /**
     * Check if input parameters are valid to create {@code PassengerCar}.
     * The correct parameters should be in that order:
     * [{@code int} id, {@code int} countPassengers, {@code int} maxCarrying,
     * {@code BigDecimal}cost, {@code ClassCar} classCar
     * and {@code CarBodyType} bodyType]
     *
     * @param params {@code List} of {@code String} objects
     * @throws InvalidCarDataException is thrown
     *              if input parameters are not valid
     */
    public void validatePassengerCar(final List<String> params) throws InvalidCarDataException {
        if (isParamsValid(params, 6)
                && isCarValid(params.subList(0, 4))
                && isEnumValid(ClassCar.class, params.get(4))
                && isEnumValid(CarBodyType.class, params.get(5))) {
            return;
        }
        throw new InvalidCarDataException(MSG);
    }
    /**
     * Check if input parameters are valid to create {@code Autotruck}.
     * The correct parameters should be in that order:
     * [{@code int} id, {@code int} countPassengers, {@code int} maxCarrying,
     * {@code BigDecimal}cost, {@code CargoType} cargoType,
     * {@code byte} countAxles, {@code AutotruckType} bodyType]
     *
     * @param params {@code List} of {@code String} objects
     * @throws InvalidCarDataException is thrown
     *          if input parameters are not valid
     */
    public void validateAutotruck(final List<String> params) throws InvalidCarDataException {
        if (isParamsValid(params, 7)
                && isTruckValid(params.subList(0, 5))
                && Pattern.matches(INT_REGEX, params.get(5))
                && Integer.valueOf(params.get(5)) < MAX_AXLES
                && isEnumValid(AutotruckType.class, params.get(6))) {
            return;
        }
        throw new InvalidCarDataException(MSG);
    }
    /**
     * Check if input parameters are valid to create {@code CargoPassengerCar}.
     * The correct parameters should be in that order:
     * [{@code int} id, {@code int} countPassengers,
     * {@code int} maxCarrying, {@code BigDecimal}cost,
     * {@code CargoType} cargoType, {@code CargoPassengerType} type]
     *
     * @param params {@code List} of {@code String} objects
     * @throws InvalidCarDataException is thrown
     *          if input parameters are not valid
     */
    public void validateCargoPassenger(final List<String> params) throws InvalidCarDataException {
        if (isParamsValid(params, 6)
                && isTruckValid(params.subList(0, 5))
                && isEnumValid(CargoPassengerType.class, params.get(5))) {
            return;
        }
        throw new InvalidCarDataException(MSG);
    }
    /**
     * Check if input parameters are valid to create {@code Car}.
     * The correct parameters should be in that order:
     * [{@code int} id, {@code int} countPassengers,
     * {@code int} maxCarrying, {@code BigDecimal}cost]
     *
     * @param params Array of {@code String} objects
     * @return {@code true} if parameters are valid, {@code false} otherwise
     */
    private boolean isCarValid(final List<String> params) {
        return (Pattern.matches(INT_REGEX, params.get(0))
                && Pattern.matches(INT_REGEX, params.get(1))
                && Pattern.matches(INT_REGEX, params.get(2))
                && Pattern.matches(DOUBLE_REGEX, params.get(3))
                && Integer.valueOf(params.get(1)) < MAX_PASSENGERS
                && Integer.valueOf(params.get(2)) < MAX_CARRYING);
    }
    /**
     * Check if input parameters are valid to create {@code Truck}.
     * The correct parameters should be in that order:
     * [{@code int} id, {@code int} countPassengers, {@code int} maxCarrying,
     * {@code BigDecimal}cost, {@code CargoType} cargoType]
     *
     * @param params Array of {@code String} objects
     * @return {@code true} if parameters are valid, {@code false} otherwise
     */
    private boolean isTruckValid(final List<String> params) {
        return  (isCarValid(params.subList(0, 4))
                && isEnumValid(CargoType.class, params.get(4)));
    }
    /**
     * Check if input {@code String} corresponds
     * to one of the {@code Enum} constants.
     *
     * @param <E> {@code Enum}
     * @param eClass {@code Enum} class
     * @param string {@code String} to check
     * @return {@code true}
     *          if string corresponds to one of the {@code eClass} constants,
     *          {@code false} otherwise
     */
    private <E extends Enum<E>> boolean isEnumValid(final Class<E> eClass, final String string) {
        for (E constant : eClass.getEnumConstants()) {
            if (constant.toString().equals(string)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check whether input {@code List<String>} contains enough elements or not.
     *
     * @param params {@code List} of {@code String} objects
     * @param minCount minimum number of items
     * @return {@code true} if array contains enough elements,
     *          {@code false} otherwise.
     */
    private boolean isParamsValid(final List<String> params, final int minCount) {
        return params.size() >= minCount;
    }
}
