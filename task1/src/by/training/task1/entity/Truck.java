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
     * All possible types of cargo
     */
    public enum CargoType{
        OVERALL,
        LOOSE,
        LIQUID,
        SPECIAL,
        DABGEROUS
    }

    /**
     * Type of cargo
     */
    protected CargoType cargoType;

    /**
     * @return the type of cargo of this truck
     */
    public CargoType getCargoType() {
        return cargoType;
    }

    /**
     * Sets the type of cargo of this truck
     * @param cargoType new type of cargo
     */
    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }
}

