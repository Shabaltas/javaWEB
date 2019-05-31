package by.training.task1.entity;

import java.math.BigDecimal;
import java.util.Objects;
/**
 *  Cargo passenger car.
 *  {@code CargoPassengerCar} extends {@code Truck} with new field {@code type}.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public final class CargoPassengerCar extends Truck {
    /**
     * Private constructor
     * because we use Builder pattern to create {@code CargoPassengerCar}.
     */
    private CargoPassengerCar() { }
    /**
     * All possible types of a cargo passenger car body.
     */
    public enum CargoPassengerType {
        /**
         * Type of body - pickup.
         */
        PICKUP,
        /**
         * Type of body - minivan.
         */
        MINIVAN,
        /**
         * Type of body - minibus.
         */
        MINIBUS
    }
    /**
     * The type of the {@code CargoPassengerCar} body.
     */
    private CargoPassengerType type;
    /**
     * Returns the type of this {@code CargoPassengerCar} body.
     * @return the type of this car body
     */
    public CargoPassengerType getType() {
        return type;
    }
    /**
     * Sets the type of this {@code CargoPassengerCar} body.
     * @param type1 new type of this car body
     */
    public void setType(final CargoPassengerType type1) {
        this.type = type1;
    }
    /**
     * Determines whether or not two cars are equal. Two instances of
     * {@code CargoPassengerCar} are equal if the values of their
     * {@code countPassengers}, {@code maxCarrying},{@code cost},
     * {@code cargoType} and {@code type} member fields are the same.
     * @param o an object to be compared with this {@code CargoPassengerCar}
     * @return {@code true} if the object to be compared is
     *         an instance of {@code CargoPassengerCar} and has
     *         the same values; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CargoPassengerCar)) {
            return false;
        }
        CargoPassengerCar that = (CargoPassengerCar) o;
        return  getCargoType() == that.getCargoType()
                && getMaxCarrying() == that.getMaxCarrying()
                && getCountPassengers() == that.getCountPassengers()
                && getCost().compareTo(that.getCost()) == 0
                && type == that.type;
    }
    /**
     * Returns the hashcode for this {@code CargoPassengerCar}.
     * @return      a hash code for this car.
     */
    @Override
    public int hashCode() {
        return Objects
                .hash(getMaxCarrying(), getCountPassengers(), getCost(), type);
    }

    /**
     * Returns a string representation of this {@code CargoPassengerCar}.
     * The returned string may not be empty or {@code null}.
     *
     * @return  a string representation of this car
     */
    @Override
    public String toString() {
        return "CargoPassengerCar{"
                + "id=" + getId()
                + ", type=" + type
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
         * {@code CargoPassengerCar} that will be created.
         */
        private CargoPassengerCar newCar;
        /**
         * Constructs and initializes a new car with
         * undefined fields.
         */
        public Builder() {
            newCar = new CargoPassengerCar();
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
         * Define the type of a new car.
         * @param type the type
         * @return this {@code Builder}
         */
        public Builder withType(final CargoPassengerType type) {
            newCar.type = type;
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
        public CargoPassengerCar build() {
            return newCar;
        }
    }
}

