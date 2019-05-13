package by.training.task1.repository.specification;

import by.training.task1.entity.Car;
/**
 * {@code Specification<Car>} implementation by passenger and load capacities.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public class ByCarrynPassengersSpec implements Specification<Car> {
    /**
     * Minimum load capacity of a {@code Car}
     */
    private int carrying;
    /**
     * Minimum passenger capacity of a {@code Car}
     */
    private int countPass;
    /**
     * Constructs new {@code ByCarrynPassengersSpec} and initialize
     * the minimum passenger capacity {@code countPass} and minimum load capacity {@code carrying}.
     *
     * @param carrying minimum load capacity
     * @param countPass minimum passenger capacity
     */
    public ByCarrynPassengersSpec(int carrying, int countPass){
        this.carrying = carrying;
        this.countPass = countPass;
    }
    /**
     * Define whether a domain entity satisfy this {@code ByCarrynPassengersSpec} or not.
     * @param car a domain entity
     * @return {@code true} if the {@code Car.countPassengers} greater than or equal to minimum passenger capacity and
     *          {@code Car.maxCarrying} greater than or equal to minimum load capacity
     *          otherwise {@code false}
     */
    @Override
    public boolean match(Car car) {
        return carrying <= car.getMaxCarrying() && countPass <= car.getCountPassengers();
    }
}
