package task.object.hierarchy;

import task.object.hierarchy.entity.EntitySimpleImpl;
import task.object.hierarchy.entity.body.AstralBody;
import task.object.hierarchy.entity.body.BodiesAggregator;
import task.object.hierarchy.entity.body.Star;
import task.object.hierarchy.service.factory.BodyFactory;
import task.object.hierarchy.service.factory.NameFactory;
import task.object.hierarchy.service.factory.PropertyFactory;
import task.object.hierarchy.service.factory.SystemFactory;

/**
 * Created by P1A-7CK on 30.06.2016.
 */
public class Main {
    public static void main(String[] args) {

        NameFactory nameFactory = new NameFactory();
        nameFactory.setNameMaxLength(15);
        nameFactory.setNameMinLength(5);

        PropertyFactory propertyFactory = new PropertyFactory();
        propertyFactory.nameFactory = nameFactory;
        propertyFactory.setMaxPropertiesNumber(25);
        propertyFactory.setMinPropertiesNumber(0);
        propertyFactory.setMaxNumericValue(10000);
        propertyFactory.setMinNumericValue(-10000);
        propertyFactory.setMaxStringLength(50);
        propertyFactory.setMinStringLength(10);

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
        bodyFactory.setMaxEachPlanetSatelliteNumber(10);
        bodyFactory.setMinEachPlanetSatelliteNumber(0);

        SystemFactory systemFactory = new SystemFactory();
        systemFactory.nameFactory = nameFactory;
        systemFactory.setMaxStarNumber(5);
        systemFactory.setMinStarNumber(1);
        systemFactory.setMaxPlanetNumber(15);
        systemFactory.setMinPlanetNumber(5);

        BodiesAggregator bodiesAggregator = systemFactory.createRandomSystem(bodyFactory, propertyFactory);

        System.out.println(bodiesAggregator);

        /*
        Statistics statistics = new Statistics();
        System.out.println("Star System '" + bodiesAggregator.getName() + "' total mass equals to " + statistics.multiplyMass(bodiesAggregator));

        System.out.println("Not A Star System total mass equals to " + statistics.multiplyMass(bodyFactory));
        */
    }
}
