package by.training.task1;

import by.training.task1.action.comparator.CarComparator;
import by.training.task1.entity.Car;
import by.training.task1.entity.PassengerCar;
import by.training.task1.exception.InvalidCarDataException;
import by.training.task1.repository.specification.*;
import by.training.task1.repository.user.Carpark;
import by.training.task1.initializer.Initializer;
import by.training.task1.repository.CarRepository;
import org.apache.log4j.Logger;

import java.math.BigDecimal;

public class  Runner {

    public static void main(String[] args){
        Logger.getLogger(Runner.class).info("check");
        CarRepository rep = CarRepository.getInstance();
        Carpark park = new Carpark(rep);
        Initializer.initializeFromFile("data\\input.txt", rep);
        Car car1 = new PassengerCar.Builder()
                .withId(4)
                .withCost(BigDecimal.valueOf(120000))
                .withMaxCarrying(3)
                .withCountPassengers(6)
                .build();
        Car car2 = new PassengerCar.Builder()
                .withId(5)
                .withCost(BigDecimal.valueOf(1700))
                .withMaxCarrying(8)
                .withCountPassengers(6)
                .build();
        System.out.println(park.getTotalCost());
        try {
            rep.add(car1);
            rep.add(car2);
        } catch (InvalidCarDataException e) {
            Logger.getLogger(Runner.class.getSimpleName()).error(e);
        }
        for (int i = 0; i < rep.count; i++){
            System.out.println(rep.get(i));
        }
        System.out.println(park.getTotalCost());
        rep.remove(new ByPassengersSpecification(6, 6));
        //rep.sort(CarComparator.cmpCountCarryCost);
        System.out.println("DELETEEEEEEEED");
        for (int i = 0; i < rep.count; i++){
            System.out.println(rep.get(i).get());
        }
    }
}
