package by.training.task1;

import by.training.task1.entity.Autopark;
import by.training.task1.initializer.Initializer;
import by.training.task1.repository.CarRepository;
import org.apache.log4j.Logger;

public class  Runner {

    public static void main(String[] args){
        Logger.getLogger(Runner.class).info("check");
        Autopark park = new Autopark();
        CarRepository rep = CarRepository.getInstance();
        rep.addUser(park);
        Initializer.initializeFromFile("data\\input.txt", rep);
        System.out.println(park.getCars());
        System.out.println(park.getAmount());
    }
}
