package by.training.task1.creator;

import by.training.task1.entity.Car;

import java.util.List;

/**
 * Interface that declares the factory method
 * that returns new {@code Car} objects.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public interface CarFactory {
    /**
     * Factory method that will be implemented in {@code CarFactory} subclasses
     * to return {@code Car} subclasses objects.
     * @param params necessary parameters to create a {@code Car}
     * @return created {@code Car}
     */
    Car getAuto(List<String> params);
}
