package by.training.task1.entity;

import java.math.BigDecimal;
/**
 *  Initial class for cars.
 *  <p>Provides general fields to all types of cars with access to them</p>
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public abstract class Car extends BaseEntity {
    /**
     * Maximum passenger capacity.
     */
    private int countPassengers;
    /**
     * Maximum load capacity.
     */
    private int maxCarrying;
    /**
     * Car cost.
     */
    private BigDecimal cost;

    /**
     * @return maximum passenger capacity of this car.
     */
    public int getCountPassengers() {
        return countPassengers;
    }

    /**
     * Sets maximum passenger capacity.
     * @param count new maximum passenger capacity
     */
    public void setCountPassengers(final int count) {
        this.countPassengers = count;
    }

    /**
     * @return maximum load capacity of this car
     */
    public int getMaxCarrying() {
        return maxCarrying;
    }

    /**
     * Sets maximum load capacity.
     * @param carrying new maximum load capacity
     */
    public void setMaxCarrying(final int carrying) {
        this.maxCarrying = carrying;
    }

    /**
     * @return the cost of this car
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * Sets the cost.
     * @param cost1 new cost
     */
    public void setCost(final BigDecimal cost1) {
        this.cost = cost1;
    }

}
