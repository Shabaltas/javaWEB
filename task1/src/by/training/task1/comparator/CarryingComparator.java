package by.training.task1.comparator;

import by.training.task1.entity.Car;

import java.util.Comparator;

/**
 * Utility class that is used to compare {@code Car} instances
 * by their maximum load capacity.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public final class CarryingComparator implements Comparator<Car> {
    /**
     * Private constructor to create the only {@code CarryingComparator}.
     */
    private CarryingComparator() { }
    /**
     * The only instance of {@code CarryingComparator} that can be created.
     */
    private static CarryingComparator instance;
    /**
     * Static method to take the only {@code CarryingComparator}.
     * @return the only instance of {@code CarryingComparator}
     */
    public static CarryingComparator getInstance() {
        if (instance == null) {
            instance = new CarryingComparator();
        }
        return instance;
    }
    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.
     * Uses {@code Integer.compare(int x, int y)} to compare
     * two {@code Car} instances by their maximum load capacity numerically.
     *
     * @param  car1 the first {@code Car} to compare
     * @param  car2 the second {@code Car} to compare
     * @return the value {@code 0} if {@code car1.maxCarrying == car2.maxCarrying};
     *         a value less than {@code 0} if {@code car1.maxCarrying < car2.maxCarrying};
     *         a value greater than {@code 0} if {@code car1.maxCarrying > car2.maxCarrying}
     */
    @Override
    public int compare(final Car car1, final Car car2) {
        return Integer.compare(car1.getMaxCarrying(), car2.getMaxCarrying());
    }
}
