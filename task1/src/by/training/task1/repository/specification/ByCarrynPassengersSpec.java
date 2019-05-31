package by.training.task1.repository.specification;

import by.training.task1.entity.Car;
/**
 * {@code Specification<Car>} implementation by passenger and load capacities.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public final class ByCarrynPassengersSpec implements Specification<Car> {
    /**
     * Maximum load capacity of a {@code Car}.
     */
    private int maxCarrying;
    /**
     * Minimum load capacity of a {@code Car}.
     */
    private int minCarrying;
    /**
     * Maximum passenger capacity of a {@code Car}.
     */
    private int maxCountPass;
    /**
     * Minimum passenger capacity of a {@code Car}.
     */
    private int minCountPass;
    /**
     * Private constructor because Builder pattern is used
     * to create {@code ByCarrynPassengersSpec}.
     * Initializes all fields with default values.
     */
    private ByCarrynPassengersSpec() {
        maxCarrying = Integer.MAX_VALUE;
        minCarrying = 0;
        maxCountPass = Integer.MAX_VALUE;
        minCountPass = 0;
    }
    /**
     * Define whether a domain entity satisfy
     * this {@code ByCarrynPassengersSpec} or not.
     * @param car a domain entity
     * @return {@code true} if the {@code Car.countPassengers}
     *          greater than or equal to minimum passenger capacity and
     *          {@code Car.maxCarrying} greater than or equal to minimum load capacity,
     *          otherwise {@code false}
     */
    @Override
    public boolean match(Car car) {
        return new ByCarrySpecification(this.minCarrying, this.maxCarrying).match(car)
                && new ByPassengersSpecification(this.minCountPass, this.maxCountPass).match(car);
    }
    /**
     * Builder pattern implementation.
     * Provides a flexible solution to create various object clearer
     * without constructor overloading.
     */
    public static class Builder {
        /**
         * {@code ByCarrynPassengersSpec} that will be created.
         */
        private ByCarrynPassengersSpec newSpec;

        /**
         * Constructs and initializes a new specification with
         * default fields values.
         */
        public Builder() {
            newSpec = new ByCarrynPassengersSpec();
        }

        /**
         * Define minimum load capacity of a new specification.
         *
         * @param minCarry minimum load capacity
         * @return this {@code Builder}
         */
        public Builder withMinCarry(final int minCarry) {
            newSpec.minCarrying = minCarry;
            return this;
        }
        /**
         * Define maximum load capacity of a new specification.
         *
         * @param maxCarry maximum load capacity
         * @return this {@code Builder}
         */
        public Builder withMaxCarry(final int maxCarry) {
            newSpec.maxCarrying = maxCarry;
            return this;
        }
        /**
         * Define minimum passenger capacity of a new specification.
         *
         * @param minCountPass minimum passenger capacity
         * @return this {@code Builder}
         */
        public Builder withMinCountPass(final int minCountPass) {
            newSpec.minCountPass = minCountPass;
            return this;
        }
        /**
         * Define maximum passenger capacity of a new specification.
         *
         * @param maxCountPass maximum passenger capacity
         * @return this {@code Builder}
         */
        public Builder withMaxCountPass(final int maxCountPass) {
            newSpec.maxCountPass = maxCountPass;
            return this;
        }
        /**
         * Returns created new specification.
         * @return new {@code ByCarrynPassengersSpec}
         */
        public ByCarrynPassengersSpec build() {
            return newSpec;
        }
    }
}
