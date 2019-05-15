package test.task1.repository;

import by.training.task1.comparator.*;
import by.training.task1.entity.*;
import by.training.task1.exception.InvalidCarDataException;
import by.training.task1.initializer.Initializer;
import by.training.task1.repository.CarRepository;
import by.training.task1.repository.specification.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class CarRepositoryTest {

    static CarRepository rep;
    static ArrayList<Car> expectedInitialCars = new ArrayList<>(Arrays.asList(
            new PassengerCar.Builder()
                    .withId(1)
                    .withCountPassengers(4)
                    .withMaxCarrying(2)
                    .withCost(BigDecimal.valueOf(12000))
                    .withClassCar(PassengerCar.ClassCar.A)
                    .withBodyType(PassengerCar.CarBodyType.SEDAN)
                    .build(),
            new Autotruck.Builder()
                    .withId(2)
                    .withCountPassengers(7)
                    .withMaxCarrying(12)
                    .withCost(BigDecimal.valueOf(15000.200))
                    .withCargoType(Truck.CargoType.LOOSE)
                    .withCountAxles((byte)4)
                    .withBodyType(Autotruck.AutotruckType.MINITRUCKBUS)
                    .build(),
            new CargoPassengerCar.Builder()
                    .withId(3)
                    .withCountPassengers(6)
                    .withMaxCarrying(8)
                    .withCost(BigDecimal.valueOf(17500))
                    .withCargoType(Truck.CargoType.OVERALL)
                    .withType(CargoPassengerCar.CargoPassengerType.PICKUP)
                    .build(),
            new Autotruck.Builder()
                    .withId(4)
                    .withCountPassengers(7)
                    .withMaxCarrying(12)
                    .withCost(BigDecimal.valueOf(15000.200))
                    .withCargoType(Truck.CargoType.LOOSE)
                    .withCountAxles((byte)4)
                    .withBodyType(Autotruck.AutotruckType.MINITRUCKBUS)
                    .build(),
            new Autotruck.Builder()
                    .withId(5)
                    .withCountPassengers(2)
                    .withMaxCarrying(9)
                    .withCost(BigDecimal.valueOf(15789))
                    .withCargoType(Truck.CargoType.DANGEROUS)
                    .withCountAxles((byte)3)
                    .withBodyType(Autotruck.AutotruckType.REFRIGERATOR)
                    .build(),
            new CargoPassengerCar.Builder()
                    .withId(6)
                    .withCountPassengers(7)
                    .withMaxCarrying(12)
                    .withCost(BigDecimal.valueOf(8900))
                    .withCargoType(Truck.CargoType.OVERALL)
                    .withType(CargoPassengerCar.CargoPassengerType.MINIVAN)
                    .build(),
            new PassengerCar.Builder()
                    .withId(7)
                    .withCountPassengers(6)
                    .withMaxCarrying(8)
                    .withCost(BigDecimal.valueOf(1200))
                    .withClassCar(PassengerCar.ClassCar.C)
                    .withBodyType(PassengerCar.CarBodyType.TARGA)
                    .build(),
            new PassengerCar.Builder()
                    .withId(8)
                    .withCountPassengers(20)
                    .withMaxCarrying(8)
                    .withCost(BigDecimal.valueOf(17500.2))
                    .withClassCar(PassengerCar.ClassCar.F)
                    .withBodyType(PassengerCar.CarBodyType.CABRIOLET)
                    .build(),
            new CargoPassengerCar.Builder()
                    .withId(9)
                    .withCountPassengers(2)
                    .withMaxCarrying(99)
                    .withCost(BigDecimal.valueOf(11000))
                    .withCargoType(Truck.CargoType.SPECIAL)
                    .withType(CargoPassengerCar.CargoPassengerType.PICKUP)
                    .build()
    ));
    @BeforeTest
    public static void initRep() throws InvalidCarDataException {
        rep = CarRepository.getInstance();
        if (rep.getCount() == 0) {
            for (Car car : expectedInitialCars) {
                rep.add(car);
            }
        }
    }

    @DataProvider(name = "4findTest")
    public static Object[][] createData4find(){
        return new Object[][]{
                {new ByIDSpecification(2),
                        new ArrayList<>(Collections.singletonList(
                                new Autotruck.Builder()
                                    .withId(2)
                                    .withCountPassengers(7)
                                    .withMaxCarrying(12)
                                    .withCost(BigDecimal.valueOf(15000.200))
                                    .withCargoType(Truck.CargoType.LOOSE)
                                    .withCountAxles((byte) 4)
                                    .withBodyType(Autotruck.AutotruckType.MINITRUCKBUS)
                                    .build()))},
                {new ByPassengersSpecification(1, 6),
                        new ArrayList<>(Arrays.asList(
                                new PassengerCar.Builder()
                                    .withId(1)
                                    .withCountPassengers(4)
                                    .withMaxCarrying(2)
                                    .withCost(BigDecimal.valueOf(12000))
                                    .withClassCar(PassengerCar.ClassCar.A)
                                    .withBodyType(PassengerCar.CarBodyType.SEDAN)
                                    .build(),
                                new CargoPassengerCar.Builder()
                                    .withId(3)
                                    .withCountPassengers(6)
                                    .withMaxCarrying(8)
                                    .withCost(BigDecimal.valueOf(17500))
                                    .withCargoType(Truck.CargoType.OVERALL)
                                    .withType(CargoPassengerCar.CargoPassengerType.PICKUP)
                                    .build(),
                                new Autotruck.Builder()
                                    .withId(5)
                                    .withCountPassengers(2)
                                    .withMaxCarrying(9)
                                    .withCost(BigDecimal.valueOf(15789))
                                    .withCargoType(Truck.CargoType.DANGEROUS)
                                    .withCountAxles((byte)3)
                                    .withBodyType(Autotruck.AutotruckType.REFRIGERATOR)
                                    .build(),
                                new PassengerCar.Builder()
                                    .withId(7)
                                    .withCountPassengers(6)
                                    .withMaxCarrying(8)
                                    .withCost(BigDecimal.valueOf(1200))
                                    .withClassCar(PassengerCar.ClassCar.C)
                                    .withBodyType(PassengerCar.CarBodyType.TARGA)
                                    .build(),
                                new CargoPassengerCar.Builder()
                                    .withId(9)
                                    .withCountPassengers(2)
                                    .withMaxCarrying(99)
                                    .withCost(BigDecimal.valueOf(11000))
                                    .withCargoType(Truck.CargoType.SPECIAL)
                                    .withType(CargoPassengerCar.CargoPassengerType.PICKUP)
                                    .build()
                                ))},
                {new ByCostSpecification(BigDecimal.valueOf(8000), BigDecimal.valueOf(12000)),
                        new ArrayList<>(Arrays.asList(
                                new PassengerCar.Builder()
                                        .withId(1)
                                        .withCountPassengers(4)
                                        .withMaxCarrying(2)
                                        .withCost(BigDecimal.valueOf(12000))
                                        .withClassCar(PassengerCar.ClassCar.A)
                                        .withBodyType(PassengerCar.CarBodyType.SEDAN)
                                        .build(),
                                new CargoPassengerCar.Builder()
                                        .withId(6)
                                        .withCountPassengers(7)
                                        .withMaxCarrying(12)
                                        .withCost(BigDecimal.valueOf(8900))
                                        .withCargoType(Truck.CargoType.OVERALL)
                                        .withType(CargoPassengerCar.CargoPassengerType.MINIVAN)
                                        .build(),
                                new CargoPassengerCar.Builder()
                                        .withId(9)
                                        .withCountPassengers(2)
                                        .withMaxCarrying(99)
                                        .withCost(BigDecimal.valueOf(11000))
                                        .withCargoType(Truck.CargoType.SPECIAL)
                                        .withType(CargoPassengerCar.CargoPassengerType.PICKUP)
                                        .build()
                        ))},
                {new ByCarrynPassengersSpec.Builder()
                        .withMaxCarry(9)
                        .withMinCarry(8)
                        .withMinCountPass(1)
                        .withMaxCountPass(6)
                        .build(),
                        new ArrayList<>(Arrays.asList(
                                new CargoPassengerCar.Builder()
                                        .withId(3)
                                        .withCountPassengers(6)
                                        .withMaxCarrying(8)
                                        .withCost(BigDecimal.valueOf(17500))
                                        .withCargoType(Truck.CargoType.OVERALL)
                                        .withType(CargoPassengerCar.CargoPassengerType.PICKUP)
                                        .build(),
                                new Autotruck.Builder()
                                        .withId(5)
                                        .withCountPassengers(2)
                                        .withMaxCarrying(9)
                                        .withCost(BigDecimal.valueOf(15789))
                                        .withCargoType(Truck.CargoType.DANGEROUS)
                                        .withCountAxles((byte)3)
                                        .withBodyType(Autotruck.AutotruckType.REFRIGERATOR)
                                        .build(),
                                new PassengerCar.Builder()
                                        .withId(7)
                                        .withCountPassengers(6)
                                        .withMaxCarrying(8)
                                        .withCost(BigDecimal.valueOf(1200))
                                        .withClassCar(PassengerCar.ClassCar.C)
                                        .withBodyType(PassengerCar.CarBodyType.TARGA)
                                        .build()
                        ))}
        };
    }

    @Test(dataProvider = "4findTest")
    public static void findTest(Specification<Car> spec, List<Car> expected){
        assertEquals(rep.find(spec), expected);
    }

    @DataProvider(name = "4sortTest")
    public static Object[][] creatData4sort(){
        return new Object[][]{
                {PassengerComparator.getInstance()
                        .thenComparing(CarryingComparator.getInstance())
                        .thenComparing(CostComparator.getInstance()),
                        new ArrayList<>(Arrays.asList(
                                new Autotruck.Builder()
                                        .withId(5)
                                        .withCountPassengers(2)
                                        .withMaxCarrying(9)
                                        .withCost(BigDecimal.valueOf(15789))
                                        .withCargoType(Truck.CargoType.DANGEROUS)
                                        .withCountAxles((byte)3)
                                        .withBodyType(Autotruck.AutotruckType.REFRIGERATOR)
                                        .build(),
                                new CargoPassengerCar.Builder()
                                        .withId(9)
                                        .withCountPassengers(2)
                                        .withMaxCarrying(99)
                                        .withCost(BigDecimal.valueOf(11000))
                                        .withCargoType(Truck.CargoType.SPECIAL)
                                        .withType(CargoPassengerCar.CargoPassengerType.PICKUP)
                                        .build(),
                                new PassengerCar.Builder()
                                        .withId(1)
                                        .withCountPassengers(4)
                                        .withMaxCarrying(2)
                                        .withCost(BigDecimal.valueOf(12000))
                                        .withClassCar(PassengerCar.ClassCar.A)
                                        .withBodyType(PassengerCar.CarBodyType.SEDAN)
                                        .build(),
                                new PassengerCar.Builder()
                                        .withId(7)
                                        .withCountPassengers(6)
                                        .withMaxCarrying(8)
                                        .withCost(BigDecimal.valueOf(1200))
                                        .withClassCar(PassengerCar.ClassCar.C)
                                        .withBodyType(PassengerCar.CarBodyType.TARGA)
                                        .build(),
                                new CargoPassengerCar.Builder()
                                        .withId(3)
                                        .withCountPassengers(6)
                                        .withMaxCarrying(8)
                                        .withCost(BigDecimal.valueOf(17500))
                                        .withCargoType(Truck.CargoType.OVERALL)
                                        .withType(CargoPassengerCar.CargoPassengerType.PICKUP)
                                        .build(),
                                new CargoPassengerCar.Builder()
                                        .withId(6)
                                        .withCountPassengers(7)
                                        .withMaxCarrying(12)
                                        .withCost(BigDecimal.valueOf(8900))
                                        .withCargoType(Truck.CargoType.OVERALL)
                                        .withType(CargoPassengerCar.CargoPassengerType.MINIVAN)
                                        .build(),
                                new Autotruck.Builder()
                                        .withId(2)
                                        .withCountPassengers(7)
                                        .withMaxCarrying(12)
                                        .withCost(BigDecimal.valueOf(15000.200))
                                        .withCargoType(Truck.CargoType.LOOSE)
                                        .withCountAxles((byte)4)
                                        .withBodyType(Autotruck.AutotruckType.MINITRUCKBUS)
                                        .build(),
                                new Autotruck.Builder()
                                        .withId(4)
                                        .withCountPassengers(7)
                                        .withMaxCarrying(12)
                                        .withCost(BigDecimal.valueOf(15000.200))
                                        .withCargoType(Truck.CargoType.LOOSE)
                                        .withCountAxles((byte)4)
                                        .withBodyType(Autotruck.AutotruckType.MINITRUCKBUS)
                                        .build(),
                                new PassengerCar.Builder()
                                        .withId(8)
                                        .withCountPassengers(20)
                                        .withMaxCarrying(8)
                                        .withCost(BigDecimal.valueOf(17500.2))
                                        .withClassCar(PassengerCar.ClassCar.F)
                                        .withBodyType(PassengerCar.CarBodyType.CABRIOLET)
                                        .build()
                        ))},
                {IdComparator.getInstance(), expectedInitialCars}
        };
    }

    @Test(dataProvider = "4sortTest")
    public static void sortTest(Comparator<Car> comparator, List<Car> expected){
        List<Car> actual = new ArrayList<>();
        rep.sort(comparator);
        for (int i = 0; i < rep.getCount(); i++){
            actual.add(rep.get(i));
        }
        assertEquals(actual, expected);
    }
/*All tests are performed randomly and I can not predict which ones will be after deleting / adding objects*/

    @DataProvider(name = "4removeBeanTest")
    public static Object[][] createData4removeBean(){
        return new Object[][]{
                {new Autotruck.Builder()
                        .withId(2)
                        .withCountPassengers(7)
                        .withMaxCarrying(12)
                        .withCost(BigDecimal.valueOf(15000.200))
                        .withCargoType(Truck.CargoType.LOOSE)
                        .withCountAxles((byte)4)
                        .withBodyType(Autotruck.AutotruckType.MINITRUCKBUS)
                        .build(), new ArrayList<>(Arrays.asList(
                                    new PassengerCar.Builder()
                                            .withId(1)
                                            .withCountPassengers(4)
                                            .withMaxCarrying(2)
                                            .withCost(BigDecimal.valueOf(12000))
                                            .withClassCar(PassengerCar.ClassCar.A)
                                            .withBodyType(PassengerCar.CarBodyType.SEDAN)
                                            .build(),
                                    new CargoPassengerCar.Builder()
                                            .withId(3)
                                            .withCountPassengers(6)
                                            .withMaxCarrying(8)
                                            .withCost(BigDecimal.valueOf(17500))
                                            .withCargoType(Truck.CargoType.OVERALL)
                                            .withType(CargoPassengerCar.CargoPassengerType.PICKUP)
                                            .build(),
                                    new Autotruck.Builder()
                                            .withId(4)
                                            .withCountPassengers(7)
                                            .withMaxCarrying(12)
                                            .withCost(BigDecimal.valueOf(15000.200))
                                            .withCargoType(Truck.CargoType.LOOSE)
                                            .withCountAxles((byte)4)
                                            .withBodyType(Autotruck.AutotruckType.MINITRUCKBUS)
                                            .build(),
                                    new Autotruck.Builder()
                                            .withId(5)
                                            .withCountPassengers(2)
                                            .withMaxCarrying(9)
                                            .withCost(BigDecimal.valueOf(15789))
                                            .withCargoType(Truck.CargoType.DANGEROUS)
                                            .withCountAxles((byte)3)
                                            .withBodyType(Autotruck.AutotruckType.REFRIGERATOR)
                                            .build(),
                                    new CargoPassengerCar.Builder()
                                            .withId(6)
                                            .withCountPassengers(7)
                                            .withMaxCarrying(12)
                                            .withCost(BigDecimal.valueOf(8900))
                                            .withCargoType(Truck.CargoType.OVERALL)
                                            .withType(CargoPassengerCar.CargoPassengerType.MINIVAN)
                                            .build(),
                                    new PassengerCar.Builder()
                                            .withId(7)
                                            .withCountPassengers(6)
                                            .withMaxCarrying(8)
                                            .withCost(BigDecimal.valueOf(1200))
                                            .withClassCar(PassengerCar.ClassCar.C)
                                            .withBodyType(PassengerCar.CarBodyType.TARGA)
                                            .build(),
                                    new PassengerCar.Builder()
                                            .withId(8)
                                            .withCountPassengers(20)
                                            .withMaxCarrying(8)
                                            .withCost(BigDecimal.valueOf(17500.2))
                                            .withClassCar(PassengerCar.ClassCar.F)
                                            .withBodyType(PassengerCar.CarBodyType.CABRIOLET)
                                            .build(),
                                    new CargoPassengerCar.Builder()
                                            .withId(9)
                                            .withCountPassengers(2)
                                            .withMaxCarrying(99)
                                            .withCost(BigDecimal.valueOf(11000))
                                            .withCargoType(Truck.CargoType.SPECIAL)
                                            .withType(CargoPassengerCar.CargoPassengerType.PICKUP)
                                            .build()
                        ))},
                {new Autotruck.Builder()
                        .withId(12)
                        .withCountPassengers(7)
                        .withMaxCarrying(0)
                        .withCost(BigDecimal.valueOf(15000.200))
                        .withCargoType(Truck.CargoType.LOOSE)
                        .withCountAxles((byte)4)
                        .withBodyType(Autotruck.AutotruckType.MINITRUCKBUS)
                        .build(), expectedInitialCars}
        };
    }

    @Test(dataProvider = "4removeBeanTest")
    public static void removeBeanTest(Car object, List<Car> expected) throws InvalidCarDataException {
        for (Car car : expectedInitialCars){
            rep.remove(car);
        }
        initRep();
        rep.remove(object);
        List<Car> actual = new ArrayList<>();
        for (int i = 0; i < rep.getCount(); i++){
            actual.add(rep.get(i));
        }
        assertEquals(actual, expected);
    }

    @DataProvider(name = "4addBeanTest")
    public static Object[][] createData4addBean(){
        return new Object[][]{
                {new Autotruck.Builder()
                        .withId(12)
                        .withCost(BigDecimal.valueOf(9000.780))
                        .build(), new ArrayList<>(Arrays.asList(
                        new PassengerCar.Builder()
                                .withId(1)
                                .withCountPassengers(4)
                                .withMaxCarrying(2)
                                .withCost(BigDecimal.valueOf(12000))
                                .withClassCar(PassengerCar.ClassCar.A)
                                .withBodyType(PassengerCar.CarBodyType.SEDAN)
                                .build(),
                        new Autotruck.Builder()
                                .withId(2)
                                .withCountPassengers(7)
                                .withMaxCarrying(12)
                                .withCost(BigDecimal.valueOf(15000.200))
                                .withCargoType(Truck.CargoType.LOOSE)
                                .withCountAxles((byte)4)
                                .withBodyType(Autotruck.AutotruckType.MINITRUCKBUS)
                                .build(),
                        new CargoPassengerCar.Builder()
                                .withId(3)
                                .withCountPassengers(6)
                                .withMaxCarrying(8)
                                .withCost(BigDecimal.valueOf(17500))
                                .withCargoType(Truck.CargoType.OVERALL)
                                .withType(CargoPassengerCar.CargoPassengerType.PICKUP)
                                .build(),
                        new Autotruck.Builder()
                                .withId(4)
                                .withCountPassengers(7)
                                .withMaxCarrying(12)
                                .withCost(BigDecimal.valueOf(15000.200))
                                .withCargoType(Truck.CargoType.LOOSE)
                                .withCountAxles((byte)4)
                                .withBodyType(Autotruck.AutotruckType.MINITRUCKBUS)
                                .build(),
                        new Autotruck.Builder()
                                .withId(5)
                                .withCountPassengers(2)
                                .withMaxCarrying(9)
                                .withCost(BigDecimal.valueOf(15789))
                                .withCargoType(Truck.CargoType.DANGEROUS)
                                .withCountAxles((byte)3)
                                .withBodyType(Autotruck.AutotruckType.REFRIGERATOR)
                                .build(),
                        new CargoPassengerCar.Builder()
                                .withId(6)
                                .withCountPassengers(7)
                                .withMaxCarrying(12)
                                .withCost(BigDecimal.valueOf(8900))
                                .withCargoType(Truck.CargoType.OVERALL)
                                .withType(CargoPassengerCar.CargoPassengerType.MINIVAN)
                                .build(),
                        new PassengerCar.Builder()
                                .withId(7)
                                .withCountPassengers(6)
                                .withMaxCarrying(8)
                                .withCost(BigDecimal.valueOf(1200))
                                .withClassCar(PassengerCar.ClassCar.C)
                                .withBodyType(PassengerCar.CarBodyType.TARGA)
                                .build(),
                        new PassengerCar.Builder()
                                .withId(8)
                                .withCountPassengers(20)
                                .withMaxCarrying(8)
                                .withCost(BigDecimal.valueOf(17500.2))
                                .withClassCar(PassengerCar.ClassCar.F)
                                .withBodyType(PassengerCar.CarBodyType.CABRIOLET)
                                .build(),
                        new CargoPassengerCar.Builder()
                                .withId(9)
                                .withCountPassengers(2)
                                .withMaxCarrying(99)
                                .withCost(BigDecimal.valueOf(11000))
                                .withCargoType(Truck.CargoType.SPECIAL)
                                .withType(CargoPassengerCar.CargoPassengerType.PICKUP)
                                .build(),
                        new Autotruck.Builder()
                                .withId(12)
                                .withCost(BigDecimal.valueOf(9000.780))
                                .build()
                ))}
        };
    }

    @Test(dataProvider = "4addBeanTest")
    public static void addBeanTest(Car object, List<Car> expected) throws InvalidCarDataException {
        for (Car car : expectedInitialCars){
            rep.remove(car);
        }
        initRep();
        rep.add(object);
        List<Car> actual = new ArrayList<>();
        for (int i = 0; i < rep.getCount(); i++){
            actual.add(rep.get(i));
        }
        assertEquals(actual, expected);
        rep.remove(object);
    }

    //duplicate id
    @DataProvider(name = "4badAddBeanTest")
    public static Object[][] createData4badAddBean(){
        return new Object[][]{
                {new Autotruck.Builder()
                        .withId(1)
                        .withCost(BigDecimal.valueOf(9000.780))
                        .build(),}
        };
    }

    @Test(dataProvider = "4badAddBeanTest")
    public static void badAddBeanTest(Car object) throws InvalidCarDataException {
        for (Car car : expectedInitialCars){
            rep.remove(car);
        }
        initRep();
        assertThrows(InvalidCarDataException.class, () -> rep.add(object));
    }

}
