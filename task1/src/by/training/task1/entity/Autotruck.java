package by.training.task1.entity;

import java.math.BigDecimal;
import java.util.Objects;
/**
 *  Autotruck.
 *  {@code CargoPassengerCar} extends {@code Truck} with new field
 *  {@code countAxles} and {@code bodyType}.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public class Autotruck extends Truck {
    /**
     * All possible types of an autotruck body
     */
    public enum AutotruckType{
        CONTAINER,
        REFRIGERATOR,
        MINITRUCKBUS
    }
    /**
     * The count of the axles of the {@code Autotruck}.
     */
    private byte countAxles;
    /**
     * The type of the {@code Autotruck} body
     */
    private AutotruckType bodyType;
    /**
     * Returns the count of the axles of this {@code Autotruck}
     * @return the count of the axles of this car
     */
    public byte getCountAxles() {
        return countAxles;
    }
    /**
     * Sets the count of the axles of this {@code Autotruck}
     * @param countAxles count of the axles of this car
     */
    public void setCountAxles(byte countAxles) {
        this.countAxles = countAxles;
    }
    /**
     * Returns the type of this {@code Autotruck} body
     * @return the type of this car body
     */
    public AutotruckType getBodyType() {
        return bodyType;
    }
    /**
     * Sets the type of this {@code Autotruck} body
     * @param bodyType new type of this car body
     */
    public void setBodyType(AutotruckType bodyType) {
        this.bodyType = bodyType;
    }
    /**
     * Determines whether or not two cars are equal. Two instances of
     * {@code Autotruck} are equal if the values of their
     * {@code countPassengers}, {@code maxCarrying},{@code cost},{@code cargoType},
     * {@code countAxles} and {@code bodyType} member fields are the same.
     * @param o an object to be compared with this {@code Autotruck}
     * @return {@code true} if the object to be compared is
     *         an instance of {@code Autotruck} and has
     *         the same values; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autotruck)) return false;
        Autotruck that = (Autotruck) o;
        return  maxCarrying == that.maxCarrying &&
                countPassengers == that.countPassengers &&
                cost.compareTo(that.cost) == 0 &&
                cargoType == that.cargoType &&
                countAxles == that.countAxles &&
                bodyType == that.bodyType;
    }
    /**
     * Returns the hashcode for this {@code Autotruck}.
     * @return      a hash code for this car.
     */
    @Override
    public int hashCode() {
        return Objects.hash(maxCarrying, countPassengers, cost, countAxles, bodyType);
    }
    /**
     * Returns a string representation of this {@code Autotruck}.
     * The returned string may not be empty or {@code null}.
     *
     * @return  a string representation of this car
     */
    @Override
    public String toString() {
        return "Autotruck{" +
                "id=" + id +
                ", countAxles=" + countAxles +
                ", bodyType=" + bodyType +
                ", cargoType=" + cargoType +
                ", countPassengers=" + countPassengers +
                ", maxCarrying=" + maxCarrying +
                ", cost=" + cost +
                '}';
    }
    /**
     * Builder pattern implementation.
     * Provides a flexible solution to create various object clearer
     * without constructor overloading.
     */
    public static class Builder{
        /**
         * {@code Autotruck} that will be created
         */
        private Autotruck newCar;
        /**
         * Constructs and initializes a new car with
         * undefined fields.
         */
        public Builder(){
            newCar = new Autotruck();
        }
        /**
         * Define the id of a new car.
         * @param id uniq identifier
         * @return this {@code Builder}
         */
        public Builder withId(int id){
            newCar.id = id;
            return this;
        }
        /**
         * Define the body type of a new car.
         * @param type the type
         * @return this {@code Builder}
         */
        public Builder withBodyType(AutotruckType type){
            newCar.bodyType = type;
            return this;
        }
        /**
         * Define the count of the axles of a new car.
         * @param count the count of the axles
         * @return this {@code Builder}
         */
        public Builder withCountAxles(byte count){
            newCar.countAxles = count;
            return this;
        }
        /**
         * Define the cargo type of a new car.
         * @param type the cargo type
         * @return this {@code Builder}
         */
        public Builder withCargoType(CargoType type){
            newCar.cargoType = type;
            return this;
        }
        /**
         * Define maximum passengers capacity of a new car.
         * @param countPassengers maximum passengers capacity
         * @return this {@code Builder}
         */
        public Builder withCountPassengers(int countPassengers){
            newCar.countPassengers = countPassengers;
            return this;
        }
        /**
         * Define maximum load capacity of a new car.
         * @param maxCarrying maximum load capacity
         * @return this {@code Builder}
         */
        public Builder withMaxCarrying(int maxCarrying){
            newCar.maxCarrying = maxCarrying;
            return this;
        }
        /**
         * Define the cost of a new car.
         * @param cost the cost
         * @return this {@code Builder}
         */
        public Builder withCost(BigDecimal cost){
            newCar.cost = cost;
            return this;
        }
        /**
         * Returns created new car
         * @return new {@code CargoPassengerCar}
         */
        public Autotruck build(){
            return newCar;
        }
    }
}

