package by.training.task1.repository.specification;

import by.training.task1.entity.Car;

import java.math.BigDecimal;
/**
 * {@code Specification<Car>} implementation by the cost.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public class ByCostSpecification implements Specification<Car> {
    /**
     * Maximum cost of a {@code Car}
     */
    private BigDecimal cost;
    /**
     * Constructs new {@code ByCostSpecification} and initialize the maximum cost  {@code cost}.
     *
     * @param cost maximum cost
     */
    public ByCostSpecification(BigDecimal cost){
        this.cost = cost;
    }
    /**
     * Define whether a domain entity satisfy this {@code ByCostSpecification} or not.
     * @param car a domain entity
     * @return {@code true} if the {@code Car.cost} less than or equal to maximum passenger capacity,
     *      *          otherwise {@code false}
     */
    @Override
    public boolean match(Car car) {
        return cost.compareTo(car.getCost()) > -1;
    }

}
