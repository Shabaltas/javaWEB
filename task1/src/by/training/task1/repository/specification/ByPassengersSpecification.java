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
     * Minimum passenger capacity of a {@code Car}
     */
    private int count;

    /**
     * Constructs new {@code ByPassengersSpecification} and initialize
     * the minimum passenger capacity {@code count}.
     *
     * @param count minimum passenger capacity
     */
    public ByPassengersSpecification(int count){
        this.count = count;
    }

    /**
     * Define whether a domain entity satisfy this {@code ByPassengersSpecification} or not.
     * @param car a domain entity
     * @return {@code true} if the {@code Car.countPassengers} greater than or equal to minimum passenger capacity,
     *          otherwise {@code false}
     */
    @Override
    public boolean match(Car car) {
        return count <= car.getCountPassengers();
    }
}
