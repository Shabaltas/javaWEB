package by.training.task1;

import by.training.task1.repository.user.Carpark;
import by.training.task1.initializer.Initializer;
import by.training.task1.repository.CarRepository;
import org.apache.log4j.Logger;

public class  Runner {

    public static void main(String[] args){
        Logger.getLogger(Runner.class).info("check");
        CarRepository rep = CarRepository.getInstance();
        Carpark park = new Carpark(rep);
        Initializer.initializeFromFile("data\\input.txt", rep);
        System.out.println(park.getRepository().getAll());
        System.out.println(park.getTotalCost());
    }
}
