package by.training.task1.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class CargoPassengerCar extends Truck{

    public enum CargoPassengerType{
        PICKUP,
        MINIVAN,
        MINIBUS
    }
    private CargoPassengerType type;

    public CargoPassengerType getType() {
        return type;
    }

    public void setType(CargoPassengerType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CargoPassengerCar)) return false;
        CargoPassengerCar that = (CargoPassengerCar) o;
        return  maxCarrying == that.maxCarrying &&
                countPassengers == that.countPassengers &&
                cost.compareTo(that.cost) == 0 && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxCarrying, countPassengers, cost, type);
    }

    @Override
    public String toString() {
        return "CargoPassengerCar{" +
                "id=" + id +
                ", type=" + type +
                ", cargoType=" + cargoType +
                ", countPassengers=" + countPassengers +
                ", maxCarrying=" + maxCarrying +
                ", cost=" + cost +
                '}';
    }

    public static class Builder{
        private CargoPassengerCar newCar;

        public Builder(){
            newCar = new CargoPassengerCar();
        }

        public Builder withId(int id){
            newCar.id = id;
            return this;
        }

        public Builder withType(CargoPassengerType type){
            newCar.type = type;
            return this;
        }

        public Builder withCargoType(CargoType type){
            newCar.cargoType = type;
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

        public CargoPassengerCar build(){
            return newCar;
        }
    }
}

