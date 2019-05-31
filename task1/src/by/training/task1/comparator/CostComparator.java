package by.training.task1.comparator;

import by.training.task1.entity.Car;

import java.util.Comparator;

/**
 * Utility class that is used to compare {@code Car} instances
 * by their cost.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public final class CostComparator implements Comparator<Car> {
    /**
     * Private constructor to create the only {@code CostComparator}.
     */
    private CostComparator() { }
    /**
     * The only instance of {@code CostComparator} that can be created.
     */
    private static CostComparator instance;
    /**
     * Static method to take the only {@code CostComparator}.
     * @return the only instance of {@code CostComparator}
     */
    public static CostComparator getInstance() {
        if (instance == null) {
            instance = new CostComparator();
        }
        return instance;
    }
    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.
     * Uses {@code BigDecimal.compareTo(BigDecimal val)} to compare
     * two {@code Car} instances by their cost.
     *
     * @param  car1 the first {@code Car} to compare
     * @param  car2 the second {@code Car} to compare
     * @return the value {@code 0} if {@code car1.cost == car2.cost};
     *         a value {@code -1} than {@code 0} if {@code car1.cost < car2.cost};
     *         a value {@code 1} than {@code 0} if {@code car1.cost > car2.cost}
     */
    @Override
    public int compare(final Car car1, final Car car2) {
        return car1.getCost().compareTo(car2.getCost());
    }
}
