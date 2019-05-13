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
     * Maximum passenger capacity
     */
    protected int countPassengers;
    /**
     * Maximum load capacity
     */
    protected int maxCarrying;
    /**
     * Car cost
     */
    protected BigDecimal cost;

    /**
     * @return maximum passenger capacity of this car
     */
    public int getCountPassengers() {
        return countPassengers;
    }

    /**
     * Sets maximum passenger capacity
     * @param countPassengers  new maximum passenger capacity
     */
    public void setCountPassengers(int countPassengers) {
        this.countPassengers = countPassengers;
    }

    /**
     * @return maximum load capacity of this car
     */
    public int getMaxCarrying() {
        return maxCarrying;
    }

    /**
     * Sets maximum load capacity
     * @param maxCarrying new maximum load capacity
     */
    public void setMaxCarrying(int maxCarrying) {
        this.maxCarrying = maxCarrying;
    }

    /**
     * @return the cost of this car
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * Sets the cost
     * @param cost new cost
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

}
