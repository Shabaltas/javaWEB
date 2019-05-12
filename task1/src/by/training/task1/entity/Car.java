package by.training.task1.entity;

import java.math.BigDecimal;

public abstract class Car extends BaseEntity {

    protected int countPassengers;
    protected int maxCarrying;
    protected BigDecimal cost;

    public int getCountPassengers() {
        return countPassengers;
    }

    public void setCountPassengers(int countPassengers) {
        this.countPassengers = countPassengers;
    }

    public int getMaxCarrying() {
        return maxCarrying;
    }

    public void setMaxCarrying(int maxCarrying) {
        this.maxCarrying = maxCarrying;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

}
