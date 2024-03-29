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
     * Maximum cost of a {@code Car}.
     */
    private BigDecimal maxCost;
    /**
     * Minimum cost of a {@code Car}.
     */
    private BigDecimal minCost;
    /**
     * Constructs new {@code ByCostSpecification}
     * and initialize maximum cost {@code maxCost}.
     *
     * @param maximumCost maximum cost
     */
    public ByCostSpecification(final BigDecimal maximumCost) {
        this.maxCost = maximumCost;
        this.minCost = BigDecimal.ZERO;
    }
    /**
     * Constructs new {@code ByCostSpecification}
     * and initialize maximum cost {@code maxCost}
     * and minimum cost {@code minCost}.
     *
     * @param minimumCost minimum cost
     * @param maximumCost maximum cost
     */
    public ByCostSpecification(final BigDecimal minimumCost, final BigDecimal maximumCost) {
        this.minCost = minimumCost;
        this.maxCost = maximumCost;
    }
    /**
     * Define whether a domain entity satisfy
     * this {@code ByCostSpecification} or not.
     * @param car a domain entity
     * @return {@code true} if the {@code Car.cost}
     *          less than or equal to maximum cost
     *          and greater than or equal to minimum cost,
     *          otherwise {@code false}
     */
    @Override
    public boolean match(Car car) {
        return maxCost.compareTo(car.getCost()) > -1
                && minCost.compareTo(car.getCost()) < 1;
    }

}
