package by.training.task1.comparator;

import by.training.task1.entity.Car;

import java.util.Comparator;

/**
 * Utility class that is used to compare {@code Car} instances
 * by their maximum passenger capacity.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public class PassengerComparator implements Comparator<Car> {
    /**
     * Private constructor to create the only {@code PassengerComparator}.
     */
    private PassengerComparator(){}
    /**
     * The only instance of {@code PassengerComparator} that can be created.
     */
    private static PassengerComparator instance;
    /**
     * Static method to get the only {@code PassengerComparator}.
     * @return the only instance of {@code PassengerComparator}
     */
    public static PassengerComparator getInstance(){
        if (instance == null){
            instance = new PassengerComparator();
        }
        return instance;
    }
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
