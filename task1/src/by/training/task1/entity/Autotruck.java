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
public final class Autotruck extends Truck {
    /**
     * Private constructor cause we use Builder pattern
     * to create {@code Autotruck}.
     */
    private Autotruck() { }
    /**
     * All possible types of an autotruck body.
     */
    public enum AutotruckType {
        /**
         * "Container" body type.
          */
        CONTAINER,
        /**
         * "Refrigerator" body type.
         */
        REFRIGERATOR,
        /**
         * "Minitruckbus" body type.
         */
        MINITRUCKBUS
    }
    /**
     * The count of the axles of the {@code Autotruck}.
     */
    private byte countAxles;
    /**
     * The type of the {@code Autotruck} body.
     */
    private AutotruckType bodyType;
    /**
     * Returns the count of the axles of this {@code Autotruck}.
     * @return the count of the axles of this car.
     */
    public byte getCountAxles() {
        return countAxles;
    }
    /**
     * Sets the count of the axles of this {@code Autotruck}.
     * @param axles count of the axles of this car.
     */
    public void setCountAxles(final byte axles) {
        this.countAxles = axles;
    }
    /**
     * Returns the type of this {@code Autotruck} body.
     * @return the type of this car body
     */
    public AutotruckType getBodyType() {
        return bodyType;
    }
    /**
     * Sets the type of this {@code Autotruck} body.
     * @param type new type of this car body
     */
    public void setBodyType(final AutotruckType type) {
        this.bodyType = type;
    }
    /**
     * Determines whether or not two cars are equal. Two instances of
     * {@code Autotruck} are equal if the values of their
     * {@code countPassengers}, {@code maxCarrying},{@code cost},
     * {@code cargoType}, {@code countAxles} and
     * {@code bodyType} member fields are the same.
     * @param o an object to be compared with this {@code Autotruck}
     * @return {@code true} if the object to be compared is
     *         an instance of {@code Autotruck} and has
     *         the same values; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Autotruck)) {
            return false;
        }
        Autotruck that = (Autotruck) o;
        return  getMaxCarrying() == that.getMaxCarrying()
                && getCountPassengers() == that.getCountPassengers()
                && getCost().compareTo(that.getCost()) == 0
                && getCargoType() == that.getCargoType()
                && countAxles == that.countAxles
                && bodyType == that.bodyType;
    }
    /**
     * Returns the hashcode for this {@code Autotruck}.
     * @return a hash code for this car.
     */
    @Override
    public int hashCode() {
        return Objects
                .hash(getMaxCarrying(), getCountPassengers(), getCost(), getCargoType(), countAxles, bodyType);
    }
    /**
     * Returns a string representation of this {@code Autotruck}.
     * The returned string may not be empty or {@code null}.
     *
     * @return  a string representation of this car
     */
    @Override
    public String toString() {
        return "Autotruck{"
                + "id=" + getId()
                + ", countAxles=" + countAxles
                + ", bodyType=" + bodyType
                + ", cargoType=" + getCargoType()
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
         * {@code Autotruck} that will be created.
         */
        private Autotruck newCar;
        /**
         * Constructs and initializes a new car with
         * undefined fields.
         */
        public Builder() {
            newCar = new Autotruck();
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
         * Define the body type of a new car.
         * @param type the type
         * @return this {@code Builder}
         */
        public Builder withBodyType(final AutotruckType type) {
            newCar.bodyType = type;
            return this;
        }
        /**
         * Define the count of the axles of a new car.
         * @param count the count of the axles
         * @return this {@code Builder}
         */
        public Builder withCountAxles(final byte count) {
            newCar.countAxles = count;
            return this;
        }
        /**
         * Define the cargo type of a new car.
         * @param type the cargo type
         * @return this {@code Builder}
         */
        public Builder withCargoType(final CargoType type) {
            newCar.setCargoType(type);
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
         * Returns created new car.
         * @return new {@code CargoPassengerCar}
         */
        public Autotruck build() {
            return newCar;
        }
    }
}

