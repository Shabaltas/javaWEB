package by.training.task1.repository;

import by.training.task1.entity.Car;
import by.training.task1.exception.InvalidCarDataException;
import by.training.task1.repository.specification.ByIDSpecification;
import by.training.task1.repository.specification.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * {@code Repository} implementation that store {@code Car} objects.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public class CarRepository implements Repository<Car> {
    /**
     * The {@code List} of {@code Car} objects.
     */
    private List<Car> cars = new ArrayList<>();
    /**
     * The only instance of {@code CarRepository} that can be created.
     */
    private static  CarRepository instance;
    /**
     * Private constructor to create the only {@code CarRepository}.
     */
    private CarRepository(){}
    /**
     * Static method to get the only {@code CarRepository}.
     * @return the only instance of {@code CarRepository}
     */
    public static CarRepository getInstance(){
        if (instance == null){
            instance = new CarRepository();
        }
        return instance;
    }
    /**
     * Finds the {@code Car} in this {@code CarRepository} that satisfy the search specification.
     * @param spec specification that define search options.
     * @return the {@code List} of satisfying objects.
     */
    @Override
    public List<Car> find(Specification<Car> spec) {
        List<Car> result = new ArrayList<>();
        cars.forEach(car -> {
            if (spec.match(car))
                result.add(car);
        });
        return result;
    }
    /**
     * Sorts the {@code Car} objects in this {@code CarRepository} according to a certain {@code Comparator}
     * @param comparator defines the sorting options.
     */
    @Override
    public void sort(Comparator<Car> comparator) {
        cars.sort(comparator);
    }
    /**
     * Add the {@code Car} in this {@code CarRepository}
     * @param object {@code Car} to add
     */
    @Override
    public void add(Car object) throws InvalidCarDataException{
        if (find(new ByIDSpecification(object.getId())).isEmpty()) {
            cars.add(object);
        }else{
            throw new InvalidCarDataException("Duplicate id " + object.getId());
        }
    }
    /**
     * Remove the {@code Car} from this {@code CarRepository}
     * @param object {@code Car} to remove
     */
    @Override
    public void remove(Car object) {
        cars.remove(object);
    }
    /**
     * Find the {@code Car} objects in this {@code CarRepository} that satisfy the search specification
     * and remove them.
     * @param spec specification that define search options
     */
    @Override
    public void remove(Specification<Car> spec) {
        int i = 0;
        while (i < cars.size()) {
            if (spec.match(cars.get(i))) {
                cars.remove(i);
            } else {
                i++;
            }
        }
    }
    /**
     * Update the {@code Car} in this {@code CarRepository} with identical identifier
     * @param object {@code Car} to update
     */
    @Override
    public void update(Car object) {
        for (int i = 0; i < cars.size(); i++){
            if (cars.get(i).getId() == object.getId()){
                cars.remove(i);
                cars.add(i, object);
            }
        }
    }
    /**
     * Returns a {@code Car} from {@code Repository} with that {@code index}.
     * @return a {@code Car} with that index
     */
    @Override
    public Car get(int index){
        return cars.get(index);
    }

    /**
     * Returns the number of entities in the repository.
     * @return the number of entities in the repository
     */
    public int getCount(){
        return cars.size();
    }
}

