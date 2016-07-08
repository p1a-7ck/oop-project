package com.epam.java.rt.lab.task.star.system.factory;

/**
 * Created by P1A-7CK on 07.07.2016.
 * <p>
 * This class initiates limits for randomly created values
 * for objects. It should be used to rapidly show a result
 * in Main. The arguments of set methods below could be
 * freely updated to meet the needs of usage in Main.
 */
public class FactoriesInitial {
    public FactoriesInitial() {
    }

    public void InitiateFactories(NameFactory nameFactory,
                                  PropertyFactory propertyFactory,
                                  BodyFactory bodyFactory,
                                  AggregatorFactory aggregatorFactory) {
        nameFactory.setNameMaxLength(15);
        nameFactory.setNameMinLength(5);
        propertyFactory.nameFactory = nameFactory;
        propertyFactory.setMaxPropertiesNumber(25);
        propertyFactory.setMinPropertiesNumber(0);
        propertyFactory.setMaxNumericValue(10000);
        propertyFactory.setMinNumericValue(-10000);
        propertyFactory.setMaxStringLength(50);
        propertyFactory.setMinStringLength(10);
        bodyFactory.nameFactory = nameFactory;
        bodyFactory.setMaxMass(100000);
        bodyFactory.setMinMass(10000);
        bodyFactory.setMaxDensity(100000);
        bodyFactory.setMinDensity(10000);
        bodyFactory.setMaxDiameter(100000);
        bodyFactory.setMinDiameter(10000);
        bodyFactory.setMaxDistanceFromCenter(100000);
        bodyFactory.setMinDistanceFromCenter(10000);
        bodyFactory.setMaxEachPlanetSatelliteNumber(10);
        bodyFactory.setMinEachPlanetSatelliteNumber(0);
        aggregatorFactory.nameFactory = nameFactory;
        aggregatorFactory.setMaxStarNumber(5);
        aggregatorFactory.setMinStarNumber(1);
        aggregatorFactory.setMaxPlanetNumber(15);
        aggregatorFactory.setMinPlanetNumber(5);
    }
}
