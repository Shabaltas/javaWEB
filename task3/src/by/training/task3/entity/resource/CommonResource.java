package by.training.task3.entity.resource;

/**
 * Common resource that is shared between threads.
 * @param <T>
 */
public abstract class CommonResource<T> {
    /**
     * Stored object.
     */
    private T value;

    /**
     * Constructor.
     * @param object the object to be stored and shared
     */
    public CommonResource(T object) {
        value = object;
    }

    /**
     * Returns the stored value.
     * @return the value
     */
    public T getValue() {
        return value;
    }
}
