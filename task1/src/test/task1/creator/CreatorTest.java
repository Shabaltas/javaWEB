package test.task1.creator;

import by.training.task1.creator.Creator;
import by.training.task1.entity.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class CreatorTest {

    @DataProvider(name = "cars")
    public static Object[][] createData() {
        return new Object[][]{
                {new ArrayList<>(Arrays.asList("PASSENGER", "1", "4", "2", "12000", "A", "SEDAN")),
                        Optional.of(new PassengerCar.Builder()
                                .withId(1)
                                .withCountPassengers(4)
                                .withMaxCarrying(2)
                                .withCost(BigDecimal.valueOf(12000))
                                .withClassCar(PassengerCar.ClassCar.A)
                                .withBodyType(PassengerCar.CarBodyType.SEDAN)
                                .build())},
                {new ArrayList<>(Arrays.asList("AUTOTRUCK", "2", "7", "12", "15000.200", "LOOSE", "4", "MINITRUCKBUS")),
                        Optional.of(new Autotruck.Builder()
                                .withId(2)
                                .withCountPassengers(7)
                                .withMaxCarrying(12)
                                .withCost(BigDecimal.valueOf(15000.200))
                                .withCargoType(Truck.CargoType.LOOSE)
                                .withCountAxles((byte)4)
                                .withBodyType(Autotruck.AutotruckType.MINITRUCKBUS)
                                .build())},
                {new ArrayList<>(Arrays.asList("AUTOTRUCK", "3", "7", "9LOOSE", "2", "MINRUCKBUS")),
                        Optional.empty()},
                {new ArrayList<>(Arrays.asList("CARGOPASSENGER", "4", "6", "8", "17500", "OVERALL", "PICKUP")),
                        Optional.of(new CargoPassengerCar.Builder()
                                .withId(4)
                                .withCountPassengers(6)
                                .withMaxCarrying(8)
                                .withCost(BigDecimal.valueOf(17500))
                                .withCargoType(Truck.CargoType.OVERALL)
                                .withType(CargoPassengerCar.CargoPassengerType.PICKUP)
                                .build())}
        };
    }
    @Test(dataProvider = "cars")
    public void createTest(List<String> params, Optional<Car> expected) {
        assertEquals(new Creator().create(params), expected);
    }
}
