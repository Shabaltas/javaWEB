package by.training.task1.action.creator;

import by.training.task1.entity.Car;

import java.util.List;

public interface CarFactory {
    Car getAuto(String[] params);
}
