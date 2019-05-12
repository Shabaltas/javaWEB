package by.training.task1.repository;

@FunctionalInterface
public interface Specification<T> {
    boolean match(T bean);
}
