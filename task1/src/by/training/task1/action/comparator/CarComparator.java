package by.training.task1.action.comparator;

import by.training.task1.entity.Car;

import java.util.Comparator;

public class CarComparator {
    private CarComparator(){}
    public static final Comparator<Car> cmpCountCarryCost = new PassengerComparator().thenComparing(new CarryingComparator()).thenComparing(new CostComparator());
    public static final Comparator<Car> cmpCost = new CostComparator();
    public static final Comparator<Car> cmpPassengers = new PassengerComparator();
    public static final Comparator<Car> cmpCarrying = new CarryingComparator();
    public static final Comparator<Car> cmpId = new IdComparator();
}

class PassengerComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        return Integer.compare(car1.getCountPassengers(), car2.getCountPassengers());
    }
}

class CostComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        return car1.getCost().compareTo(car2.getCost());
    }
}

class CarryingComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        return Integer.compare(car1.getMaxCarrying(), car2.getMaxCarrying());
    }
}

class IdComparator implements Comparator<Car>{
    @Override
    public int compare(Car car1, Car car2) {
        return Integer.compare(car1.getId(), car2.getId());
    }
}