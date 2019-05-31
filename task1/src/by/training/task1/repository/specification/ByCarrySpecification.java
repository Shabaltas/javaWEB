package by.training.task1.repository.specification;

import by.training.task1.entity.Car;
/**
 * {@code Specification<Car>} implementation by load capacity.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public class ByCarrySpecification implements Specification<Car> {
    /**
     * Maximum load capacity of a {@code Car}.
     */
    private int maxCarrying;
    /**
     * Minimum load capacity of a {@code Car}.
     */
    private int minCarrying;
    /**
     * Constructs new {@code ByCarrySpecification} and initialize
     * minimum load capacity {@code minCarrying}.
     *
     * @param minimalCarrying minimum load capacity
     */
    public ByCarrySpecification(final int minimalCarrying) {
        this.maxCarrying = Integer.MAX_VALUE;
        this.minCarrying = minimalCarrying;
    }
    /**
     * Constructs new {@code ByCarrySpecification} and initialize
     * minimum load capacity {@code minCarrying}
     * and maximum load capacity {@code maxCarrying}.
     *
     * @param minimumCarrying minimum load capacity
     * @param maximumCarrying maximum load capacity
     */
    public ByCarrySpecification(final int minimumCarrying, final int maximumCarrying) {
        this.maxCarrying = maximumCarrying;
        this.minCarrying = minimumCarrying;
    }
    /**
     * Define whether a domain entity satisfy
     * this {@code ByPassengersSpecification} or not.
     * @param car a domain entity
     * @return {@code true} if the {@code Car.maxCarrying}
     *          greater than or equal to minimum load capacity
     *          and less than or equal to maximum load capacity,
     *          otherwise {@code false}
     */
    @Override
    public boolean match(Car car) {
        return maxCarrying >= car.getMaxCarrying()
                && minCarrying <= car.getMaxCarrying();
    }
}
