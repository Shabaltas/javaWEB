package by.training.task1.entity;

import by.training.task1.repository.RepUser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Autopark implements RepUser<Car> {

    private List<Car> cars = new ArrayList<>();

    public Autopark(){}

    public Autopark(List<Car> cars){
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public BigDecimal getAmount() {
        BigDecimal amount = BigDecimal.valueOf(0);
        for (Car car : cars){
            amount = amount.add(car.getCost());
        }
        return amount;
    }

    @Override
    public void update(List<Car> carsFromRep) {
        this.cars = carsFromRep;
    }
}
