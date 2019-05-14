package by.training.task1.comparator;

import by.training.task1.entity.Car;

import java.util.Comparator;
/**
 * Utility class for comparing and sorting {@code Car} instances.
 * This is a collection of static members, so there is no need to create an instance
 * of the {@code CarComparator} to use static methods fot comparing and sorting.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public class CarComparator {
    /**
     * Private constructor.
     * There is no need to creat an instance.
     */
    private CarComparator(){}

    /**
     * Compares {@code Car} instances by their maximum passenger capacity,
     * maximum load capacity and cost in that order.
     * It is passed as a parameter to a sort method .
     */
    public static final Comparator<Car> cmpCountCarryCost = new PassengerComparator()
                                                                .thenComparing(new CarryingComparator())
                                                                .thenComparing(new CostComparator());
    /**
     * Compares {@code Car} instances by their cost.
     * It is passed as a parameter to a sort method .
     */
    public static final Comparator<Car> cmpCost = new CostComparator();
    /**
     * Compares {@code Car} instances by their maximum passenger capacity.
     * It is passed as a parameter to a sort method .
     */
    public static final Comparator<Car> cmpPassengers = new PassengerComparator();
    /**
     * Compares {@code Car} instances by their maximum load capacity.
     * It is passed as a parameter to a sort method .
     */
    public static final Comparator<Car> cmpCarrying = new CarryingComparator();
    /**
     * Compares {@code Car} instances by their identifiers.
     * It is passed as a parameter to a sort method .
     */
    public static final Comparator<Car> cmpId = new IdComparator();
}

/**
 * Utility class that is used to compare {@code Car} instances
 * by their maximum passenger capacity.
 */
class PassengerComparator implements Comparator<Car> {
    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.
     * Uses {@code Integer.compare(int x, int y)} to compare two {@code Car} instances
     * by their maximum passenger capacity numerically.
     *
     * @param  car1 the first {@code Car} to compare
     * @param  car2 the second {@code Car} to compare
     * @return the value {@code 0} if {@code car1.countPassengers == car2.countPassengers};
     *         a value less than {@code 0} if {@code car1.countPassengers < car2.countPassengers};
     *         a value greater than {@code 0} if {@code car1.countPassengers > car2.countPassengers}
     */
    @Override
    public int compare(Car car1, Car car2) {
        return Integer.compare(car1.getCountPassengers(), car2.getCountPassengers());
    }
}
/**
 * Utility class that is used to compare {@code Car} instances
 * by their cost.
 */
class CostComparator implements Comparator<Car> {
    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.
     * Uses {@code BigDecimal.compareTo(BigDecimal val)} to compare two {@code Car} instances
     * by their cost.
     *
     * @param  car1 the first {@code Car} to compare
     * @param  car2 the second {@code Car} to compare
     * @return the value {@code 0} if {@code car1.cost == car2.cost};
     *         a value {@code -1} than {@code 0} if {@code car1.cost < car2.cost};
     *         a value {@code 1} than {@code 0} if {@code car1.cost > car2.cost}
     */
    @Override
    public int compare(Car car1, Car car2) {
        return car1.getCost().compareTo(car2.getCost());
    }
}
/**
 * Utility class that is used to compare {@code Car} instances
 * by their maximum load capacity.
 */
class CarryingComparator implements Comparator<Car> {
    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.
     * Uses {@code Integer.compare(int x, int y)} to compare two {@code Car} instances
     * by their maximum load capacity numerically.
     *
     * @param  car1 the first {@code Car} to compare
     * @param  car2 the second {@code Car} to compare
     * @return the value {@code 0} if {@code car1.maxCarrying == car2.maxCarrying};
     *         a value less than {@code 0} if {@code car1.maxCarrying < car2.maxCarrying};
     *         a value greater than {@code 0} if {@code car1.maxCarrying > car2.maxCarrying}
     */
    @Override
    public int compare(Car car1, Car car2) {
        return Integer.compare(car1.getMaxCarrying(), car2.getMaxCarrying());
    }
}
/**
 * Utility class that is used to compare {@code Car} instances
 * by their identifiers.
 */
class IdComparator implements Comparator<Car>{
    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.
     * Uses {@code Integer.compare(int x, int y)} to compare two {@code Car} instances
     * by their identifiers.
     *
     * @param  car1 the first {@code Car} to compare
     * @param  car2 the second {@code Car} to compare
     * @return the value {@code 0} if {@code car1.id == car2.id};
     *         a value less than {@code 0} if {@code car1.id < car2.id};
     *         a value greater than {@code 0} if {@code car1.id > car2.id}
     */
    @Override
    public int compare(Car car1, Car car2) {
        return Integer.compare(car1.getId(), car2.getId());
    }
}