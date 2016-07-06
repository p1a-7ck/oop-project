package task.object.hierarchy;

import task.object.hierarchy.entity.complex.Complex;
import task.object.hierarchy.service.factory.BodyFactory;
import task.object.hierarchy.service.factory.NameFactory;
import task.object.hierarchy.service.factory.PropertyArrayFactory;
import task.object.hierarchy.service.factory.SystemFactory;
import task.object.hierarchy.service.statistics.MassCalculatorC;

/**
 * Created by P1A-7CK on 30.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        NameFactory nameFactory = new NameFactory();
        nameFactory.setNameMaxLength(15);
        nameFactory.setNameMinLength(5);

        PropertyArrayFactory propertyArrayFactory = new PropertyArrayFactory();
        propertyArrayFactory.nameFactory = nameFactory;
        propertyArrayFactory.setMaxPropertiesNumber(25);
        propertyArrayFactory.setMinPropertiesNumber(0);
        propertyArrayFactory.setMaxNumericValue(10000);
        propertyArrayFactory.setMinNumericValue(-10000);
        propertyArrayFactory.setMaxStringLength(50);
        propertyArrayFactory.setMinStringLength(10);

        BodyFactory bodyFactory = new BodyFactory();
        bodyFactory.nameFactory = nameFactory;
        bodyFactory.setMaxMass(100000);
        bodyFactory.setMinMass(10000);
        bodyFactory.setMaxDensity(100000);
        bodyFactory.setMinDensity(10000);
        bodyFactory.setMaxDiameter(100000);
        bodyFactory.setMinDiameter(10000);
        bodyFactory.setMaxDistanceFromCenter(100000);
        bodyFactory.setMinDistanceFromCenter(10000);

        SystemFactory systemFactory = new SystemFactory();
        systemFactory.nameFactory = nameFactory;
        systemFactory.setMaxStarNumber(5);
        systemFactory.setMinStarNumber(1);
        systemFactory.setMaxPlanetNumber(15);
        systemFactory.setMinPlanetNumber(5);
        systemFactory.setMaxEachPlanetSatelliteNumber(10);
        systemFactory.setMinEachPlanetSatelliteNumber(0);

        Complex complex = systemFactory.createRandomSystem(bodyFactory, propertyArrayFactory);

        System.out.println(complex);

        MassCalculatorC massCalculatorC = new MassCalculatorC();
        System.out.println("Star System '" + complex.getName() + "' total mass equals to " + massCalculatorC.getMass(complex));
        
    }
}
