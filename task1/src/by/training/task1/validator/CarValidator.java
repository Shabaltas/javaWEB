package by.training.task1.validator;

import by.training.task1.entity.*;
import by.training.task1.entity.Truck;
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
public class CarValidator {
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
     * Private constructor because we use .
     */
    private CarValidator(){
    }

    /**
     * Check if input parameters are valid to create {@code PassengerCar}.
     * The correct parameters should be in that order:
     * [{@code int} id, {@code int} countPassengers, {@code int} maxCarrying, {@code BigDecimal}cost,
     * {@code ClassCar} classCar, {@code CarBodyType} bodyType]
     *
     * @param params {@code List} of {@code String} objects
     * @throws InvalidCarDataException is thrown if input parameters are not valid
     */
    public static void validatePassengerCar(List<String> params) throws InvalidCarDataException{
        if (areParamsValid(params, 6) && isCarValid(params.subList(0, 4))
            && isEnumValid(PassengerCar.ClassCar.class, params.get(4))
            && isEnumValid(PassengerCar.CarBodyType.class, params.get(5))){
            return;
        }
        throw new InvalidCarDataException("Invalid data input");
    }
    /**
     * Check if input parameters are valid to create {@code Autotruck}.
     * The correct parameters should be in that order:
     * [{@code int} id, {@code int} countPassengers, {@code int} maxCarrying, {@code BigDecimal}cost,
     * {@code CargoType} cargoType, {@code byte} countAxles, {@code AutotruckType} bodyType]
     *
     * @param params {@code List} of {@code String} objects
     * @throws InvalidCarDataException is thrown if input parameters are not valid
     */
    public static void validateAutotruck(List<String> params) throws InvalidCarDataException{
        if (areParamsValid(params, 7) && isTruckValid(params.subList(0, 5)) && Pattern.matches(INT_REGEX, params.get(5))
                && Integer.valueOf(params.get(5)) < MAX_AXLES
                && isEnumValid(Autotruck.AutotruckType.class, params.get(6))){
            return;
        }
        throw new InvalidCarDataException("Invalid data input");
    }
    /**
     * Check if input parameters are valid to create {@code CargoPassengerCar}.
     * The correct parameters should be in that order:
     * [{@code int} id, {@code int} countPassengers, {@code int} maxCarrying, {@code BigDecimal}cost,
     * {@code CargoType} cargoType, {@code CargoPassengerType} type]
     *
     * @param params {@code List} of {@code String} objects
     * @throws InvalidCarDataException is thrown if input parameters are not valid
     */
    public static void validateCargoPassenger(List<String> params) throws InvalidCarDataException{
        if (areParamsValid(params, 6) && isTruckValid(params.subList(0, 5))
                && isEnumValid(CargoPassengerCar.CargoPassengerType.class, params.get(5))){
            return;
        }
        throw new InvalidCarDataException("Invalid data input");
    }
    /**
     * Check if input parameters are valid to create {@code Car}.
     * The correct parameters should be in that order:
     * [{@code int} id, {@code int} countPassengers, {@code int} maxCarrying, {@code BigDecimal}cost]
     *
     * @param params Array of {@code String} objects
     * @return {@code true} if parameters are valid, {@code false} otherwise
     */
    private static boolean isCarValid(List<String> params){
        return (Pattern.matches(INT_REGEX, params.get(0)) && Pattern.matches(INT_REGEX, params.get(1))
                && Pattern.matches(INT_REGEX, params.get(2))
                && Pattern.matches(DOUBLE_REGEX, params.get(3))
                && Integer.valueOf(params.get(1)) < MAX_PASSENGERS && Integer.valueOf(params.get(2)) < MAX_CARRYING);
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
    private static boolean isTruckValid(List<String> params){
        return  (isCarValid(params.subList(0, 4)) && isEnumValid(Truck.CargoType.class, params.get(4)));
    }
    /**
     * Check if input {@code String} corresponds to one of the {@code Enum} constants.
     *
     * @param eClass {@code Enum} class
     * @param string {@code String} to check
     * @return {@code true} if string corresponds to one of the {@code eClass} constants,
     *          {@code false} otherwise
     */
    private static <E extends Enum<E>> boolean isEnumValid(Class<E> eClass, String string){
        for (E constant : eClass.getEnumConstants()){
            if (constant.toString().equals(string)){
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
    private static boolean areParamsValid(List<String> params, int minCount){
        return params.size() >= minCount;
    }
}
