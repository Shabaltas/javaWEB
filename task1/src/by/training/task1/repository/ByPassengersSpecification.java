package by.training.task1.repository;

import by.training.task1.entity.Car;

public class ByPassengersSpecification implements Specification<Car> {

    private int count;
    public ByPassengersSpecification(int count){
        this.count = count;
    }
    @Override
    public boolean match(Car bean) {
        return count <= bean.getCountPassengers();
    }
}
