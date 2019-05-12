package by.training.task1.entity;

public abstract class Truck extends Car {

    public enum CargoType{
        OVERALL,
        LOOSE,
        LIQUID,
        SPECIAL,
        DABGEROUS
    }

    protected CargoType cargoType;

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }
}

