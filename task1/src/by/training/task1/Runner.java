package by.training.task1;

import by.training.task1.comparator.CarComparator;
import by.training.task1.entity.Car;
import by.training.task1.entity.PassengerCar;
import by.training.task1.exception.InvalidCarDataException;
import by.training.task1.initializer.Initializer;
import by.training.task1.repository.specification.*;
import by.training.task1.repository.user.Carpark;
import by.training.task1.repository.CarRepository;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Function;

public class  Runner {

    public static void main(String[] args){
        Logger.getLogger(Runner.class).info("check");
        CarRepository rep = CarRepository.getInstance();
        Carpark park = new Carpark(rep);
        try {
            Initializer.initializeFromFile("data\\input.txt", rep);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(park.getTotalCost());

        for (int i = 0; i < rep.getCount(); i++){
            System.out.println(rep.get(i));
        }
       /* System.out.println(park.getTotalCost());
        rep.remove(new ByPassengersSpecification(6, 6));
        rep.sort(CarComparator.cmpCountCarryCost);
        System.out.println("DELETEEEEEEEED");
        for (int i = 0; i < rep.count; i++){
            System.out.println(rep.get(i).get());
        }

        HashMap<String, Function<String, Specification<Car>>> mapa = new HashMap<>();
        //String str;
        mapa.put("id", (str) -> {
            System.out.println("what id");
            Scanner in = new  Scanner(System.in);
            int id = in.nextInt();
            in.close();
            return new ByIDSpecification(id);
        });
        mapa.put("cost", (str) -> {
            System.out.println("what cost");
            Scanner in = new Scanner(System.in);
            int count = in.nextInt();
            in.close();
            return new ByPassengersSpecification(count);
        });*/

/*        System.out.println("what to do");
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        in.close();
        System.out.println(rep.find(mapa.get(answer).apply("")));*/
    }
}
