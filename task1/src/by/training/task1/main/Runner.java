package by.training.task1.main;

import by.training.task1.comparator.CarryingComparator;
import by.training.task1.comparator.CostComparator;
import by.training.task1.comparator.PassengerComparator;
import by.training.task1.entity.Car;
import by.training.task1.initializer.Initializer;
import by.training.task1.repository.specification.ByCarrynPassengersSpec;
import by.training.task1.repository.specification.Specification;
import by.training.task1.repository.user.Carpark;
import by.training.task1.repository.CarRepository;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class  Runner {

    private static Logger LOGGER = Logger.getLogger(Runner.class.getSimpleName());

    public static void main(String[] args){
        Logger.getLogger(Runner.class).info("check");
        CarRepository rep = CarRepository.getInstance();
        Carpark park = new Carpark(rep);
        try {
            Initializer.initializeFromFile("data\\input.txt", rep);
        } catch (IOException e) {
            LOGGER.warn(e);
        }
        for (int i = 0; i < rep.getCount(); i++){
            System.out.println(rep.get(i));
        }
        System.out.println("TOTAL COST: " + park.getTotalCost());
        rep.sort(CostComparator.getInstance());
        System.out.println("SORTED BY COST");
        for (int i = 0; i < rep.getCount(); i++){
            System.out.println(rep.get(i));
        }
        rep.sort(PassengerComparator.getInstance().thenComparing(CarryingComparator.getInstance()).thenComparing(CostComparator.getInstance()));
        System.out.println("SORTED BY COUNT&CARRY&COST");
        for (int i = 0; i < rep.getCount(); i++){
            System.out.println(rep.get(i));
        }
        System.out.println("FOUNDED cars with passengers capacity 2-6 & load capacity 7-8:");
        Specification<Car> spec = new ByCarrynPassengersSpec.Builder()
                                        .withMinCountPass(2)
                                        .withMaxCountPass(6)
                                        .withMinCarry(7)
                                        .withMaxCarry(8)
                                        .build();
        List<Car> foundedCars = park.getRepository().find(spec);
        for (int i = 0; i < foundedCars.size(); i++){
            System.out.println(foundedCars.get(i));
        }
    }
}
