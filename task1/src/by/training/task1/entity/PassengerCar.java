package by.training.task1.entity;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *  Passenger car.
 *  {@code PassengerCar} extends {@code Car} with new fields:
 *  {@code classCar} and {@code bodyType}.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public class PassengerCar extends Car {
    /**
     * All possible types of a passenger car body
     */
    public enum CarBodyType{
        SEDAN,
        UNIVERSAL,
        HATCHBACK,
        COUPE,
        LIMOUSINE,
        CABRIOLET,
        TARGA,
    }

    /**
     * All possible classes of a passenger car
     */
    public enum ClassCar{
        A, B, C, D, E, F
    }

    /**
     * The class of the {@code PassengerCar}
     */
    private ClassCar classCar;
    /**
     * The type of the {@code PassengerCar} body
     */
    private CarBodyType bodyType;

    /**
     * Returns the class of this {@code PassengerCar}
     * @return the class of this car
     */
    public ClassCar getClassCar() {
        return classCar;
    }

    /**
     * Sets the class of this {@code PassengerCar}
     * @param classCar new class of this car
     */
    public void setClassCar(ClassCar classCar) {
        this.classCar = classCar;
    }

    /**
     * Returns the type of this {@code PassengerCar} body
     * @return the type of this car body
     */
    public CarBodyType getBodyType() {
        return bodyType;
    }

    /**
     * Sets the type of this {@code PassengerCar} body
     * @param bodyType new type of this car body
     */
    public void setBodyType(CarBodyType bodyType) {
        this.bodyType = bodyType;
    }

    /**
     * Determines whether or not two cars are equal. Two instances of
     * {@code PassengerCar} are equal if the values of their
     * {@code countPassengers}, {@code maxCarrying},{@code cost},
     * {@code classCar} and {@code bodyType} member fields are the same.
     * @param o an object to be compared with this {@code PassengerCar}
     * @return {@code true} if the object to be compared is
     *         an instance of {@code PassengerCar} and has
     *         the same values; {@code false} otherwise.
     */
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
    /**
     * Returns the hashcode for this {@code PassengerCar}.
     * @return      a hash code for this car.
     */
    @Override
    public int hashCode() {
        return Objects.hash( maxCarrying, countPassengers, cost, classCar, bodyType);
    }
    /**
     * Returns a string representation of this {@code PassengerCar}.
     * The returned string may not be empty or {@code null}.
     *
     * @return  a string representation of this car
     */
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

    /**
     * Builder pattern implementation.
     * Provides a flexible solution to create various object clearer
     * without constructor overloading.
     */
    public static class Builder{
        /**
         * {@code PassengerCar} that will be created
         */
        private PassengerCar newCar;

        /**
         * Constructs and initializes a new car with
         * undefined fields.
         */
        public Builder(){
            newCar = new PassengerCar();
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
         * Define the class of a new car.
         * @param classCar the class
         * @return this {@code Builder}
         */
        public Builder withClassCar(ClassCar classCar){
            newCar.classCar = classCar;
            return this;
        }
        /**
         * Define the body type of a new car.
         * @param type the body type
         * @return this {@code Builder}
         */
        public Builder withBodyType(CarBodyType type){
            newCar.bodyType = type;
            return this;
        }
        /**
         * Returns created new car
         * @return new {@code PassengerCar}
         */
        public PassengerCar build(){
            return newCar;
        }
    }
}

