package test.task1.validator;

import by.training.task1.exception.InvalidCarDataException;
import by.training.task1.validator.CarValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class CarValidatorTest {

    @DataProvider(name="wrongPassengerCar")
    public static Object[][] createIncorrectPasCar(){
        return new Object[][]{
                {new ArrayList<>(Arrays.asList("1", "6", "8;", "17500", "A", "sedan")), },
                {new ArrayList<>(Arrays.asList("6", "8", "17500", "B", "coupe")), },
                {new ArrayList<>(), },
                {new ArrayList<>(Arrays.asList("3b", "6", "120", "17500", "A", "SEdaN")), },
                {new ArrayList<>(Arrays.asList("", "6", "8", "17500", "A", "lim")), }
        };
    }

    @DataProvider(name="rightPassengerCar")
    public static Object[][] createCorrectPasCar(){
        return new Object[][]{
                {new ArrayList<>(Arrays.asList("1", "6", "9", "17500", "A", "SEDAN")), },
                {new ArrayList<>(Arrays.asList("2", "20", "8", "17500.2", "F", "CABRIOLET")), },
                {new ArrayList<>(Arrays.asList("3", "6", "8", "120.128", "C", "TARGA")), }
        };
    }

    @Test(dataProvider = "wrongPassengerCar")
    public void validatePassengerCarExcepTest (List<String> params){
        assertThrows(InvalidCarDataException.class, () -> CarValidator.validatePassengerCar(params));
    }

    @Test(dataProvider = "rightPassengerCar")
    public void validatePassengerCarTest(List<String> params){
        try {
            CarValidator.validatePassengerCar(params);
        } catch (InvalidCarDataException e) {
            fail();
        }
    }

    @DataProvider(name="wrongAutotruck")
    public static Object[][] createIncorrectAutotruck(){
        return new Object[][]{
                {new ArrayList<>(Arrays.asList("1", "7", "12", "15000.200", "loose", "43", "minitruckbus")), },
                {new ArrayList<>(Arrays.asList("12", "7", "12", "-15.20", "loose", "4", "minitruckbus")), },
                {new ArrayList<>(), },
                {new ArrayList<>(Arrays.asList("-9", "7", "12", "17300", "loose", "4", "CONTAINER")), },
                {new ArrayList<>(Arrays.asList("", "7", "12", "17300", "loose", "4", "mini")), },
                {new ArrayList<>(Arrays.asList("1", "-7", "12", "5000", "loose", "4", "container")), },
                {new ArrayList<>(Arrays.asList("2", "7", "-12", "17300", "loose", "4", "REFRIGERATOR")), },
                {new ArrayList<>(Arrays.asList("286", "7", "12", "17300", "loose", "-4", "container")), },
                {new ArrayList<>(Arrays.asList("253", "7", "12", "15000.200", "LOSE", "4", "minitruckbus")), }
        };
    }

    @DataProvider(name="rightAutotruck")
    public static Object[][] createCorrectAutotruck(){
        return new Object[][]{
                {new ArrayList<>(Arrays.asList("1", "7", "12", "15000.200", "LOOSE", "4", "MINITRUCKBUS")), },
                {new ArrayList<>(Arrays.asList("23", "2", "99", "15000.200", "DANGEROUS", "3", "REFRIGERATOR")), },
                {new ArrayList<>(Arrays.asList("128", "100", "22", "15000.200", "LIQUID", "4", "CONTAINER")), },
                {new ArrayList<>(Arrays.asList("1080", "2", "99", "15000.200", "SPECIAL", "8", "MINITRUCKBUS")), },
                {new ArrayList<>(Arrays.asList("269", "7", "12", "15000.200", "OVERALL", "2", "CONTAINER")), },
        };
    }

    @Test(dataProvider = "wrongAutotruck")
    public void validateAutotruckExepTest (List<String> params){
        assertThrows(InvalidCarDataException.class, () -> CarValidator.validateAutotruck(params));
    }

    @Test(dataProvider = "rightAutotruck")
    public void validateAutotruckTest(List<String> params){
        try {
            CarValidator.validateAutotruck(params);
        } catch (InvalidCarDataException e) {
            fail();
        }
    }
    
    @DataProvider(name="wrongCargoPassenger")
    public static Object[][] createIncorrectCargoPassenger(){
        return new Object[][]{
                {new ArrayList<>(Arrays.asList("1", "7", "100", "15000.200", "LOOSE", "PICKUP")), },
                {new ArrayList<>(Arrays.asList("12", "7", "12", "-15.20", "OVERALL", "MINIVAN")), },
                {new ArrayList<>(), },
                {new ArrayList<>(Arrays.asList("-9", "7", "12", "17300", "DANGEROUS", "MINIBUS")), },
                {new ArrayList<>(Arrays.asList("", "7", "12", "17300", "SPECIAL", "PICKUP")), },
                {new ArrayList<>(Arrays.asList("1", "7", "12", "5000", "SPECIAL", "PICKup")), },
                {new ArrayList<>(Arrays.asList("2", "7", "12", "17300", "loose", "4", "PICKUP")), },
                {new ArrayList<>(Arrays.asList("286", "102", "10", "17300", "loose", "MINIVAN")), },
                {new ArrayList<>(Arrays.asList("253", "7", "12", "15000.200")), }
        };
    }

    @DataProvider(name="rightCargoPassenger")
    public static Object[][] createCorrectCargoPassenger(){
        return new Object[][]{
                {new ArrayList<>(Arrays.asList("1", "7", "12", "15000.200", "LOOSE", "MINIVAN")), },
                {new ArrayList<>(Arrays.asList("23", "2", "99", "15000.200", "DANGEROUS", "MINIBUS")), },
                {new ArrayList<>(Arrays.asList("128", "100", "22", "15000.200", "LIQUID", "PICKUP")), },
                {new ArrayList<>(Arrays.asList("1080", "2", "99", "15000.200", "SPECIAL", "PICKUP")), },
                {new ArrayList<>(Arrays.asList("0", "7", "12", "15000.200", "OVERALL", "MINIVAN")), },
        };
    }

    @Test(dataProvider = "wrongCargoPassenger")
    public void validateCargoPassengerExepTest (List<String> params){
        assertThrows(InvalidCarDataException.class, () -> CarValidator.validateCargoPassenger(params));
    }

    @Test(dataProvider = "rightCargoPassenger")
    public void validateCargoPassengerTest(List<String> params){
        try {
            CarValidator.validateCargoPassenger(params);
        } catch (InvalidCarDataException e) {
            fail();
        }
    }

}
