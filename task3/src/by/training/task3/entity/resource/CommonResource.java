package by.training.task3.entity.resource;

public abstract class CommonResource<T> {
    private T value;
    public CommonResource (T object) {
        value = object;
    }
    public T getValue() {
        return value;
    }
}
