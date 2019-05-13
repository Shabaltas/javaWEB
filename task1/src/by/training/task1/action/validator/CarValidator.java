package by.training.task1.action.validator;

import by.training.task1.entity.*;
import by.training.task1.entity.Truck;
import by.training.task1.exception.InvalidCarDataException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
/**
 * Class for validating input data to create {@code Car}.
 * Uses Singleton pattern - a software design pattern
 * that restricts the instantiation of a class to one "single" instance.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public class CarValidator {
    /**
     * The only instance of {@code CarValidator} that can be created.
     */
    private static CarValidator instance;
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
     * Private constructor to create the only {@code CarValidator}.
     */
    private CarValidator(){
    }

    /**
     * Static method to get the only {@code CarValidator}.
     * @return the only instance of {@code CarValidator}
     */
    public static CarValidator getInstance(){
        if (instance == null){
            instance = new CarValidator();
        }
        return instance;
    }

    /**
     * Check if input parameters are valid to create {@code PassengerCar}.
     * The correct parameters should be in that order:
     * [{@code int} countPassengers, {@code int} maxCarrying, {@code BigDecimal}cost,
     * {@code ClassCar} classCar, {@code CarBodyType} bodyType]
     *
     * @param params Array of {@code String} objects
     * @throws InvalidCarDataException is thrown if input parameters are not valid
     */
    public void validatePassengerCar(String[] params) throws InvalidCarDataException{
        if (areParamsValid(params, 5) && isCarValid(Arrays.asList(params).subList(1, 4))
            && isEnumValid(PassengerCar.ClassCar.class, params[4].toUpperCase())
            && isEnumValid(PassengerCar.CarBodyType.class, params[5].toUpperCase())){
            return;
        }
        throw new InvalidCarDataException();
    }
    /**
     * Check if input parameters are valid to create {@code Autotruck}.
     * The correct parameters should be in that order:
     * [{@code int} countPassengers, {@code int} maxCarrying, {@code BigDecimal}cost,
     * {@code CargoType} cargoType, {@code byte} countAxles, {@code AutotruckType} bodyType]
     *
     * @param params Array of {@code String} objects
     * @throws InvalidCarDataException is thrown if input parameters are not valid
     */
    public void validateAutotruck(String[] params) throws InvalidCarDataException{
        if (areParamsValid(params, 6) && isTruckValid(Arrays.asList(params).subList(1, 5)) && Pattern.matches(INT_REGEX, params[5])
                && Integer.valueOf(params[5]) < Byte.MAX_VALUE
                && isEnumValid(Autotruck.AutotruckType.class, params[6])){
            return;
        }
        throw new InvalidCarDataException();
    }
    /**
     * Check if input parameters are valid to create {@code CargoPassengerCar}.
     * The correct parameters should be in that order:
     * [{@code int} countPassengers, {@code int} maxCarrying, {@code BigDecimal}cost,
     * {@code CargoType} cargoType, {@code CargoPassengerType} type]
     *
     * @param params Array of {@code String} objects
     * @throws InvalidCarDataException is thrown if input parameters are not valid
     */
    public void validateCargoPassenger(String[] params) throws InvalidCarDataException{
        if (areParamsValid(params, 5) && isTruckValid(Arrays.asList(params).subList(1, 5))
                && isEnumValid(CargoPassengerCar.CargoPassengerType.class, params[5])){
            return;
        }
        throw new InvalidCarDataException();
    }
    /**
     * Check if input parameters are valid to create {@code Car}.
     * The correct parameters should be in that order:
     * [{@code int} countPassengers, {@code int} maxCarrying, {@code BigDecimal}cost]
     *
     * @param params Array of {@code String} objects
     * @return {@code true} if parameters are valid, {@code false} otherwise
     */
    private boolean isCarValid(List<String> params){
        return (Pattern.matches(INT_REGEX, params.get(0)) && Pattern.matches(INT_REGEX, params.get(1))
                && Pattern.matches(DOUBLE_REGEX, params.get(2))
                && Integer.valueOf(params.get(0)) < MAX_PASSENGERS && Integer.valueOf(params.get(1)) < MAX_CARRYING);
    }
    /**
     * Check if input parameters are valid to create {@code Truck}.
     * The correct parameters should be in that order:
     * [{@code int} countPassengers, {@code int} maxCarrying, {@code BigDecimal}cost,
     * {@code CargoType} cargoType]
     *
     * @param params Array of {@code String} objects
     * @return {@code true} if parameters are valid, {@code false} otherwise
     */
    private boolean isTruckValid(List<String> params){
        return  (isCarValid(params.subList(0, 3)) && isEnumValid(Truck.CargoType.class, params.get(3)));
    }
    /**
     * Check if input {@code String} corresponds to one of the {@code Enum} constants.
     *
     * @param eClass {@code Enum} class
     * @param string {@code String} to check
     * @return {@code true} if string corresponds to one of the {@code eClass} constants,
     *          {@code false} otherwise
     */
    private <E extends Enum<E>> boolean isEnumValid(Class<E> eClass, String string){
        for (E constant : eClass.getEnumConstants()){
            if (constant.toString().equals(string)){
                return true;
            }
        }
        return false;
    }

    /**
     * Check if input {@code String} array contains enough elements.
     *
     * @param params Array of {@code String} objects
     * @param minCount minimum number of items
     * @return {@code true} if array contains enough elements,
     *          {@code false} otherwise.
     */
    private boolean areParamsValid(String[] params, int minCount){
        return params.length >= minCount;
    }
}
