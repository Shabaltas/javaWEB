package by.training.task1.repository.specification;

import by.training.task1.entity.Car;
/**
 * {@code Specification<Car>} implementation by the identifier.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public class ByIDSpecification implements Specification<Car> {
    /**
     * Desired identifier.
     */
    private int id;
    /**
     * Constructs new {@code ByIDSpecification}
     * and initialize desired identifier {@code id}.
     *
     * @param identifier desired identifier
     */
    public ByIDSpecification(final int identifier) {
        this.id = identifier;
    }
    /**
     * Define whether a domain entity satisfy
     * this {@code ByIDSpecification} or not.
     * @param car a domain entity
     * @return {@code true} if the {@code Car.id} equal to desired identifier,
     *          otherwise {@code false}
     */
    @Override
    public boolean match(Car car) {
        return id == car.getId();
    }
}
