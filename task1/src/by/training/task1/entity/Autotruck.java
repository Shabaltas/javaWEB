package by.training.task1.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Autotruck extends Truck {

    public enum AutotruckType{
        CONTAINER,
        REFRIGERATOR,
        MINITRUCKBUS
    }
    private byte countAxles;
    private AutotruckType bodytype;

    public byte getCountAxles() {
        return countAxles;
    }

    public void setCountAxles(byte countAxles) {
        this.countAxles = countAxles;
    }

    public AutotruckType getBodytype() {
        return bodytype;
    }

    public void setBodytype(AutotruckType bodytype) {
        this.bodytype = bodytype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autotruck)) return false;
        Autotruck that = (Autotruck) o;
        return  maxCarrying == that.maxCarrying &&
                countPassengers == that.countPassengers &&
                cost.compareTo(that.cost) == 0 &&
                countAxles == that.countAxles &&
                bodytype == that.bodytype;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxCarrying, countPassengers, cost, countAxles, bodytype);
    }

    @Override
    public String toString() {
        return "Autotruck{" +
                "id=" + id +
                ", countAxles=" + countAxles +
                ", bodytype=" + bodytype +
                ", cargoType=" + cargoType +
                ", countPassengers=" + countPassengers +
                ", maxCarrying=" + maxCarrying +
                ", cost=" + cost +
                '}';
    }

    public static class Builder{
        private Autotruck newCar;

        public Builder(){
            newCar = new Autotruck();
        }

        public Builder withId(int id){
            newCar.id = id;
            return this;
        }

        public Builder withBodyType(AutotruckType type){
            newCar.bodytype = type;
            return this;
        }

        public Builder withCountAxles(byte count){
            newCar.countAxles = count;
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

        public Autotruck build(){
            return newCar;
        }
    }
}

