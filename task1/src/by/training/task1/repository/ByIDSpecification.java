package by.training.task1.repository;

import by.training.task1.entity.Car;

public class ByIDSpecification implements Specification<Car> {

    private int id;

    public ByIDSpecification(int id){
        this.id = id;
    }

    @Override
    public boolean match(Car car) {
        return id == car.getId();
    }
}
