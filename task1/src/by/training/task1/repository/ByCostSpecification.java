package by.training.task1.repository;

import by.training.task1.entity.Car;

import java.math.BigDecimal;

public class ByCostSpecification implements Specification<Car> {

    private BigDecimal cost;
    public ByCostSpecification(BigDecimal cost){
        this.cost = cost;
    }
    @Override
    public boolean match(Car bean) {
        return cost.compareTo(bean.getCost()) > -1;
    }

}
