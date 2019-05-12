package by.training.task1.repository;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {
    List<T> find(Specification<T> spec);
    List<T> sort(Comparator<T> comparator);
    void add(T bean);
    void remove(T bean);
    void remove(Specification<T> spec);
    List<T> getAll();
}
