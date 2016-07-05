package task.object.hierarchy;

import task.object.hierarchy.entity.complex.Complex;
import task.object.hierarchy.service.BodyFactory;
import task.object.hierarchy.service.SystemFactory;

/**
 * Created by P1A-7CK on 30.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        BodyFactory bodyFactory = new BodyFactory();

        bodyFactory.setNameMinLength(5);
        bodyFactory.setNameMaxLength(15);
        bodyFactory.setMinMass(10000);
        bodyFactory.setMaxMass(100000);
        bodyFactory.setMinDensity(10000);
        bodyFactory.setMaxDensity(100000);
        bodyFactory.setMinDiameter(10000);
        bodyFactory.setMaxDiameter(100000);
        bodyFactory.setMinDistanceFromCenter(10000);
        bodyFactory.setMaxDistanceFromCenter(100000);

        SystemFactory systemFactory = new SystemFactory();

        systemFactory.setMinStarNumber(1);
        systemFactory.setMaxStarNumber(5);
        systemFactory.setMinPlanetNumber(5);
        systemFactory.setMaxPlanetNumber(15);
        systemFactory.setMinEachPlanetSatelliteNumber(0);
        systemFactory.setMaxEachPlanetSatelliteNumber(10);

        Complex complex = systemFactory.createSystem(bodyFactory);
        complex.setName("NEW SYSTEM");

        System.out.println(complex);
    }
}
