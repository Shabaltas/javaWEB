package by.training.task1.repository;

import by.training.task1.entity.Car;

public class ByCarrySpecification implements Specification<Car> {

    private int carrying;
    public ByCarrySpecification(int carrying){
        this.carrying = carrying;
    }
    @Override
    public boolean match(Car bean) {
        return carrying <= bean.getMaxCarrying();
    }
}
