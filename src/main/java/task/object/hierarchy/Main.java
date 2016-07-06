package task.object.hierarchy;

import task.object.hierarchy.entity.complex.Complex;
import task.object.hierarchy.entity.property.PropertyArray;
import task.object.hierarchy.service.BodyFactory;
import task.object.hierarchy.service.PropertyArrayFactory;
import task.object.hierarchy.service.SystemFactory;

/**
 * Created by P1A-7CK on 30.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        PropertyArrayFactory propertyArrayFactory = new PropertyArrayFactory();
        propertyArrayFactory.setMaxPropertiesNumber(25);
        propertyArrayFactory.setMinPropertiesNumber(0);
        propertyArrayFactory.setNameMaxLength(10);
        propertyArrayFactory.setNameMinLength(5);
        propertyArrayFactory.setMaxNumericValue(10000);
        propertyArrayFactory.setMinNumericValue(-10000);
        propertyArrayFactory.setMaxStringLength(50);
        propertyArrayFactory.setMinStringLength(10);

        BodyFactory bodyFactory = new BodyFactory();
        bodyFactory.setNameMaxLength(15);
        bodyFactory.setNameMinLength(5);
        bodyFactory.setMaxMass(100000);
        bodyFactory.setMinMass(10000);
        bodyFactory.setMaxDensity(100000);
        bodyFactory.setMinDensity(10000);
        bodyFactory.setMaxDiameter(100000);
        bodyFactory.setMinDiameter(10000);
        bodyFactory.setMaxDistanceFromCenter(100000);
        bodyFactory.setMinDistanceFromCenter(10000);

        SystemFactory systemFactory = new SystemFactory();
        systemFactory.setNameMaxLength(15);
        systemFactory.setNameMinLength(5);
        systemFactory.setMaxStarNumber(5);
        systemFactory.setMinStarNumber(1);
        systemFactory.setMaxPlanetNumber(15);
        systemFactory.setMinPlanetNumber(5);
        systemFactory.setMaxEachPlanetSatelliteNumber(10);
        systemFactory.setMinEachPlanetSatelliteNumber(0);

        Complex complex = systemFactory.createRandomSystem(bodyFactory, propertyArrayFactory);

        System.out.println(complex);
    }
}
