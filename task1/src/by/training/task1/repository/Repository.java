package by.training.task1.repository;

import by.training.task1.exception.InvalidCarDataException;
import by.training.task1.repository.specification.Specification;

import java.util.Comparator;
import java.util.List;

/**
 * Provides an abstract storage engine for entity collections.
 * @param <T> {@code Class} of entity to store.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public interface Repository<T> {
    /**
     * Finds the objects in {@code Repository} that satisfy the search specification.
     * @param spec specification that define search options.
     * @return the {@code List} of satisfying objects.
     */
    List<T> find(Specification<T> spec);

    /**
     * Sorts the objects in {@code Repository} according to a certain {@code Comparator}
     * @param comparator defines the sorting options.
     */
    void sort(Comparator<T> comparator);

    /**
     * Add the object in {@code Repository}
     * @param object object to add
     */
    void add(T object) throws InvalidCarDataException;

    /**
     * Remove the object from {@code Repository}
     * @param object object to remove
     */
    void remove(T object);

    /**
     * Find the objects in {@code Repository} that satisfy the search specification
     * and remove them.
     * @param spec specification that define search options
     */
    void remove(Specification<T> spec);

    /**
     * Update the object in {@code Repository}
     * @param object object to update
     */
    void update(T object);

    /**
     * Returns an object from {@code Repository} with that {@code index}.
     * @return an object with that index
     */
    T get(int index);
}
