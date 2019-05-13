package by.training.task1.repository.user;

import by.training.task1.repository.Repository;

/**
 * An interface of {@code Repository} user, that contain entity collection throw the {@code Repository<T>}
 * @param <T> {@code Class} of stored entities
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public abstract class RepUser<T> {
    /**
     * Store the entity collection.
     */
    Repository<T> repository;

    /**
     * Construct {@code RepUser<T>} and initialize this {@code Repository<T>} repository.
     * @param rep {@code Repository<T>} for this {@code RepUser<T>}
     */
    protected RepUser(Repository<T> rep){
        repository = rep;
    }

    /**
     * Returns the {@code Repository} of this {@code RepUser}
     * @return the repository of this user
     */
    public Repository<T> getRepository() {
        return repository;
    }
}
