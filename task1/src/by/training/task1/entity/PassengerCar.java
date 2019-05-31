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
public final class PassengerCar extends Car {
    /**
     * Private constructor
     * because we use Builder pattern to create {@code PassengerCar}.
     */
    private PassengerCar() { }
    /**
     * All possible types of a passenger car body.
     */
    public enum CarBodyType {
        /**
         * Type of body - sedan.
         */
        SEDAN,
        /**
         * Type of body - universal.
         */
        UNIVERSAL,
        /**
         * Type of body - hatchback.
         */
        HATCHBACK,
        /**
         * Type of body - coupe.
         */
        COUPE,
        /**
         * Type of body - limousine.
         */
        LIMOUSINE,
        /**
         * Type of body - cabriolet.
         */
        CABRIOLET,
        /**
         * Type of body - targa.
         */
        TARGA,
    }

    /**
     * All possible classes of a passenger car.
     */
    public enum ClassCar {
        /**
         * Car class 'A'.
         */
        A,
        /**
         * Car class 'B'.
         */
        B,
        /**
         * Car class 'C'.
         */
        C,
        /**
         * Car class 'D'.
         */
        D,
        /**
         * Car class 'E'.
         */
        E,
        /**
         * Car class 'F'.
         */
        F
    }

    /**
     * The class of the {@code PassengerCar}.
     */
    private ClassCar classCar;
    /**
     * The type of the {@code PassengerCar} body.
     */
    private CarBodyType bodyType;

    /**
     * Returns the class of this {@code PassengerCar}.
     * @return the class of this car
     */
    public ClassCar getClassCar() {
        return classCar;
    }

    /**
     * Sets the class of this {@code PassengerCar}.
     * @param carClass new class of this car
     */
    public void setClassCar(final ClassCar carClass) {
        this.classCar = carClass;
    }

    /**
     * Returns the type of this {@code PassengerCar} body.
     * @return the type of this car body
     */
    public CarBodyType getBodyType() {
        return bodyType;
    }

    /**
     * Sets the type of this {@code PassengerCar} body.
     * @param type new type of this car body
     */
    public void setBodyType(final CarBodyType type) {
        this.bodyType = type;
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
        if (this == o) {
            return true;
        }
        if (!(o instanceof PassengerCar)) {
            return false;
        }
        PassengerCar that = (PassengerCar) o;
        return  getMaxCarrying() == that.getMaxCarrying()
                && getCountPassengers() == that.getCountPassengers()
                && getCost().compareTo(that.getCost()) == 0
                && classCar == that.classCar
                && bodyType == that.bodyType;
    }
    /**
     * Returns the hashcode for this {@code PassengerCar}.
     * @return a hash code for this car.
     */
    @Override
    public int hashCode() {
        return Objects
                .hash(getMaxCarrying(), getCountPassengers(), getCost(), classCar, bodyType);
    }
    /**
     * Returns a string representation of this {@code PassengerCar}.
     * The returned string may not be empty or {@code null}.
     *
     * @return  a string representation of this car
     */
    @Override
    public String toString() {
        return "PassengerCar{"
                + "id=" + getId()
                + ", classCar=" + classCar
                + ", bodyType=" + bodyType
                + ", countPassengers=" + getCountPassengers()
                + ", maxCarrying=" + getMaxCarrying()
                + ", cost=" + getCost()
                + '}';
    }

    /**
     * Builder pattern implementation.
     * Provides a flexible solution to create various object clearer
     * without constructor overloading.
     */
    public static class Builder {
        /**
         * {@code PassengerCar} that will be created.
         */
        private PassengerCar newCar;

        /**
         * Constructs and initializes a new car with
         * undefined fields.
         */
        public Builder() {
            newCar = new PassengerCar();
        }

        /**
         * Define the id of a new car.
         * @param id uniq identifier
         * @return this {@code Builder}
         */
        public Builder withId(final int id) {
            newCar.setId(id);
            return this;
        }
        /**
         * Define maximum passengers capacity of a new car.
         * @param countPassengers maximum passengers capacity
         * @return this {@code Builder}
         */
        public Builder withCountPassengers(final int countPassengers) {
            newCar.setCountPassengers(countPassengers);
            return this;
        }
        /**
         * Define maximum load capacity of a new car.
         * @param maxCarrying maximum load capacity
         * @return this {@code Builder}
         */
        public Builder withMaxCarrying(final int maxCarrying) {
            newCar.setMaxCarrying(maxCarrying);
            return this;
        }
        /**
         * Define the cost of a new car.
         * @param cost the cost
         * @return this {@code Builder}
         */
        public Builder withCost(final BigDecimal cost) {
            newCar.setCost(cost);
            return this;
        }
        /**
         * Define the class of a new car.
         * @param classCar the class
         * @return this {@code Builder}
         */
        public Builder withClassCar(final ClassCar classCar) {
            newCar.classCar = classCar;
            return this;
        }
        /**
         * Define the body type of a new car.
         * @param type the body type
         * @return this {@code Builder}
         */
        public Builder withBodyType(final CarBodyType type) {
            newCar.bodyType = type;
            return this;
        }
        /**
         * Returns created new car.
         * @return new {@code PassengerCar}
         */
        public PassengerCar build() {
            return newCar;
        }
    }
}

