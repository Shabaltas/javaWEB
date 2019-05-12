package by.training.task1.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class PassengerCar extends Car {

    public enum CarBodyType{
        SEDAN,
        UNIVERSAL,
        HATCHBACK,
        COUPE,
        LIMOUSINE,
        CABRIOLET,
        TARGA,
    }
    public enum ClassCar{
        A, B, C, D, E, F
    }
    private ClassCar classCar;
    private CarBodyType bodyType;

    public ClassCar getClassCar() {
        return classCar;
    }

    public void setClassCar(ClassCar classCar) {
        this.classCar = classCar;
    }

    public CarBodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(CarBodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerCar)) return false;
        PassengerCar that = (PassengerCar) o;
        return  maxCarrying == that.maxCarrying &&
                countPassengers == that.countPassengers &&
                cost.compareTo(that.cost) == 0 &&
                classCar == that.classCar &&
                bodyType == that.bodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash( maxCarrying, countPassengers, cost, classCar, bodyType);
    }

    @Override
    public String toString() {
        return "PassengerCar{" +
                "id=" + id +
                ", classCar=" + classCar +
                ", bodyType=" + bodyType +
                ", countPassengers=" + countPassengers +
                ", maxCarrying=" + maxCarrying +
                ", cost=" + cost +
                '}';
    }

    public static class Builder{
        private PassengerCar newCar;

        public Builder(){
            newCar = new PassengerCar();
        }

        public Builder withId(int id){
            newCar.id = id;
            return this;
        }

        public Builder withClassCar(ClassCar classCar){
            newCar.classCar = classCar;
            return this;
        }

        public Builder withBodyType(CarBodyType type){
            newCar.bodyType = type;
            return this;
        }

        public Builder withCountPassengers(int countPassengers){
            newCar.countPassengers = countPassengers;
            return this;
        }

        public Builder withMaxCarrying(int maxCarrying){
            newCar.maxCarrying = maxCarrying;
            return this;
        }

        public Builder withCost(BigDecimal cost){
            newCar.cost = cost;
            return this;
        }

        public PassengerCar build(){
            return newCar;
        }
    }
}

