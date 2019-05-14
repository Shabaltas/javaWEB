package by.training.task1.repository.user;

import by.training.task1.entity.Car;
import by.training.task1.repository.CarRepository;

import java.math.BigDecimal;
/**
 * {@code RepUser} implementation, that contain entity collection throw the {@code CarRepository}.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public class Carpark extends RepUser<Car> {
    /**
     * Construct {@code Carpark} and initialize this {@code CarRepository}.
     * @param repository {@code CarRepository} for this {@code Carpark}
     */
    public Carpark(CarRepository repository){
        super(repository);
    }

    /**
     * Returns the total cost of this {@code Carpark}.
     * @return the total cost
     */
    public BigDecimal getTotalCost() {
        BigDecimal amount = BigDecimal.valueOf(0);
        for (int i = 0; i < ((CarRepository)(repository)).getCount(); i++){
            amount = amount.add(repository.get(i).get().getCost());
        }
        return amount;
    }
}
