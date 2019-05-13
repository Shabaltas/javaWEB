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
     * Minimum load capacity of a {@code Car}
     */
    private int carrying;
    /**
     * Constructs new {@code ByCarrySpecification} and initialize
     * the minimum load capacity {@code carrying}.
     *
     * @param carrying minimum load capacity
     */
    public ByCarrySpecification(int carrying){
        this.carrying = carrying;
    }
    /**
     * Define whether a domain entity satisfy this {@code ByPassengersSpecification} or not.
     * @param car a domain entity
     * @return {@code true} if the {@code Car.maxCarrying} greater than or equal to minimum load capacity,
     *          otherwise {@code false}
     */
    @Override
    public boolean match(Car car) {
        return carrying <= car.getMaxCarrying();
    }
}
