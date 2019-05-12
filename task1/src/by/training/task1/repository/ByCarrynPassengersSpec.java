package by.training.task1.repository;

import by.training.task1.entity.Car;

public class ByCarrynPassengersSpec implements Specification<Car> {
    private int carrying, countPass;
    public ByCarrynPassengersSpec(int carrying, int countPass){
        this.carrying = carrying;
        this.countPass = countPass;
    }
    @Override
    public boolean match(Car bean) {
        return carrying <= bean.getMaxCarrying() && countPass <= bean.getCountPassengers();
    }
}
