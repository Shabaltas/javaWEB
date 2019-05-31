package by.training.task1.entity;

/**
 *  Truck car.
 *  Extends {@code Car} with new field {@code cargoType}.
 *  <p>Provides general fields to all types of trucks with access to them</p>
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public abstract class Truck extends Car {
    /**
     * All possible types of cargo.
     */
    public enum CargoType {
        /**
         * Type of cargo - overall.
         */
        OVERALL,
        /**
         * Type of cargo - loose.
         */
        LOOSE,
        /**
         * Type of cargo - liquid.
         */
        LIQUID,
        /**
         * Type of cargo - special.
         */
        SPECIAL,
        /**
         * Type of cargo - dangerous.
         */
        DANGEROUS
    }

    /**
     * Type of cargo.
     */
    private CargoType cargoType;

    /**
     * @return the type of cargo of this truck
     */
    public CargoType getCargoType() {
        return cargoType;
    }

    /**
     * Sets the type of cargo of this truck.
     * @param type new type of cargo
     */
    public void setCargoType(final CargoType type) {
        this.cargoType = type;
    }
}

