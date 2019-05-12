package by.training.task1.repository;

import by.training.task1.entity.Car;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarRepository implements Repository<Car> {

    private List<Car> cars = new ArrayList<>();

    private List<RepUser<Car>> users = new ArrayList<>();

    private static CarRepository instance;

    public static CarRepository getInstance(){
        if (instance == null){
            instance = new CarRepository();
        }
        return instance;
    }

    public void addUser(RepUser<Car> anotherUser){
        users.add(anotherUser);
        anotherUser.update(cars);
    }

    @Override
    public List<Car> find(Specification<Car> spec) {
        List<Car> result = new ArrayList<>();
        for (Car auto : cars) {
            if (spec.match(auto)) {
                result.add(auto);
            }
        }
        return result;
    }

    @Override
    public List<Car> sort(Comparator<Car> comparator) {
        cars.sort(comparator);
        users.forEach(user -> user.update(cars));
        return cars;
    }

    @Override
    public void add(Car bean) {
        cars.add(bean);
        users.forEach(user -> user.update(cars));
    }

    @Override
    public void remove(Car bean) {
        cars.remove(bean);
        users.forEach(user -> user.update(cars));
    }

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
        users.forEach(user -> user.update(cars));
    }

    @Override
    public List<Car> getAll(){
        return cars;
    }
}

