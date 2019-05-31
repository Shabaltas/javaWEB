package by.training.task1.comparator;

import by.training.task1.entity.Car;

import java.util.Comparator;

/**
 * Utility class that is used to compare {@code Car} instances
 * by their identifiers.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public final class IdComparator implements Comparator<Car> {
    /**
     * Private constructor to create the only {@code IdComparator}.
     */
    private IdComparator() { }
    /**
     * The only instance of {@code IdComparator} that can be created.
     */
    private static IdComparator instance;
    /**
     * Static method to take the only {@code IdComparator}.
     * @return the only instance of {@code IdComparator}
     */
    public static IdComparator getInstance() {
        if (instance == null) {
            instance = new IdComparator();
        }
        return instance;
    }
    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.
     * Uses {@code Integer.compare(int x, int y)} to compare
     * two {@code Car} instances by their identifiers.
     *
     * @param  car1 the first {@code Car} to compare
     * @param  car2 the second {@code Car} to compare
     * @return the value {@code 0} if {@code car1.id == car2.id};
     *         a value less than {@code 0} if {@code car1.id < car2.id};
     *         a value greater than {@code 0} if {@code car1.id > car2.id}
     */
    @Override
    public int compare(final Car car1, final Car car2) {
        return Integer.compare(car1.getId(), car2.getId());
    }
}
