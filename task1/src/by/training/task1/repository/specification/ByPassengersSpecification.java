package by.training.task1.repository.specification;

import by.training.task1.entity.Car;

/**
 * {@code Specification<Car>} implementation by passenger capacity.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public class ByPassengersSpecification implements Specification<Car> {
    /**
     * Maximum passenger capacity of a {@code Car}.
     */
    private int maxCount;
    /**
     * Minimum passenger capacity of a {@code Car}.
     */
    private int minCount;

    /**
     * Constructs new {@code ByPassengersSpecification} and initialize
     * minimum passenger capacity {@code minCount}.
     *
     * @param minimumCount minimum passenger capacity
     */
    public ByPassengersSpecification(final int minimumCount) {
        this.maxCount = Integer.MAX_VALUE;
        this.minCount = minimumCount;
    }
    /**
     * Constructs new {@code ByPassengersSpecification} and initialize
     * maximum passenger capacity {@code maxCount}
     * and minimum passenger capacity {@code minCount}.
     *
     * @param minimumCount minimum passenger capacity
     * @param maximumCount maximum passenger capacity
     */
    public ByPassengersSpecification(final int minimumCount, final int maximumCount) {
        this.maxCount = maximumCount;
        this.minCount = minimumCount;
    }

    /**
     * Define whether a domain entity satisfy
     * this {@code ByPassengersSpecification} or not.
     * @param car a domain entity
     * @return {@code true} if the {@code Car.countPassengers}
     *          greater than or equal to minimum passenger capacity
     *          and less than or equal to maximum passenger capacity,
     *          otherwise {@code false}
     */
    @Override
    public boolean match(Car car) {
        return maxCount >= car.getCountPassengers()
                && minCount <= car.getCountPassengers();
    }
}
