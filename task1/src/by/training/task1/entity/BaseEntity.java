package by.training.task1.entity;
/**
 *  Base entity for classes.
 *  <p>Provides uniq identifier</p>
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public abstract class BaseEntity {
    /**
     * Identifier. Must be uniq, so there is no possible to change it after initialization.
     */
    protected int id;

    /**
     * @return entity's identifier
     */
    public int getId() {
        return id;
    }
}
