package by.training.task1.action.validator;

import by.training.task1.entity.*;
import by.training.task1.entity.Truck;
import by.training.task1.exception.InvalidCarDataException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CarValidator {

    private static CarValidator instance;
    private static final String INT_REGEX = "\\d+";
    private static final String DOUBLE_REGEX = "\\d+(\\.\\d+)?";
    private static final byte MAX_PASSENGERS = 101;
    private static final byte MAX_CARRYING = 100;

    private CarValidator(){
    }

    public static CarValidator getInstance(){
        if (instance == null){
            instance = new CarValidator();
        }
        return instance;
    }
    //countPassengers maxCarrying cost classCar bodyType
    //int               int    BigDecimal  ClassCar CarBodyType
    public void validatePassengerCar(String[] params) throws InvalidCarDataException{
        if (areParamsValid(params, 5) && isCarValid(Arrays.asList(params).subList(1, 4))
            && isEnumValid(PassengerCar.ClassCar.class, params[4].toUpperCase())
            && isEnumValid(PassengerCar.CarBodyType.class, params[5].toUpperCase())){
            return;
        }
        throw new InvalidCarDataException();
    }

    //countPassengers maxCarrying cost cargoType countAxles bodytype
    //int               int    BigDecimal CargoType byte   AutotruckType
    public void validateAutotruck(String[] params) throws InvalidCarDataException{
        if (areParamsValid(params, 6) && isTruckValid(Arrays.asList(params).subList(1, 5)) && Pattern.matches(INT_REGEX, params[5])
                && Integer.valueOf(params[5]) < Byte.MAX_VALUE
                && isEnumValid(Autotruck.AutotruckType.class, params[6])){
            return;
        }
        throw new InvalidCarDataException();
    }

    //countPassengers maxCarrying cost    cargoType    type
    //int               int    BigDecimal CargoType CargoPassengerType
    public void validateCargoPassenger(String[] params) throws InvalidCarDataException{
        if (areParamsValid(params, 5) && isTruckValid(Arrays.asList(params).subList(1, 5))
                && isEnumValid(CargoPassengerCar.CargoPassengerType.class, params[5])){
            return;
        }
        throw new InvalidCarDataException();
    }

    private boolean isCarValid(List<String> params){
        return (Pattern.matches(INT_REGEX, params.get(0)) && Pattern.matches(INT_REGEX, params.get(1))
                && Pattern.matches(DOUBLE_REGEX, params.get(2))
                && Integer.valueOf(params.get(0)) < MAX_PASSENGERS && Integer.valueOf(params.get(1)) < MAX_CARRYING);
    }

    private boolean isTruckValid(List<String> params){
        return  (isCarValid(params.subList(0, 3)) && isEnumValid(Truck.CargoType.class, params.get(3)));
    }

    private <E extends Enum<E>> boolean isEnumValid(Class<E> en, String string){
        for (E constant : en.getEnumConstants()){
            if (constant.toString().equals(string)){
                return true;
            }
        }
        return false;
    }

    private boolean areParamsValid(String[] params, int minCount){
        return params.length >= minCount;
    }
}
