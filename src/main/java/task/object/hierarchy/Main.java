package task.object.hierarchy;

import task.object.hierarchy.entity.body.BodiesAggregator;
import task.object.hierarchy.service.factory.BodyFactory;
import task.object.hierarchy.service.factory.NameFactory;
import task.object.hierarchy.service.factory.PropertyFactory;
import task.object.hierarchy.service.factory.AggregatorFactory;
import task.object.hierarchy.service.statistics.MassMultiplier;
import task.object.hierarchy.service.statistics.Statistics;
import task.object.hierarchy.service.statistics.StatisticsImpl;

/**
 * Created by P1A-7CK on 30.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        // nameFactory passes to another factories as an argument to create random names
        NameFactory nameFactory = new NameFactory();
        nameFactory.setNameMaxLength(15);
        nameFactory.setNameMinLength(5);

        // propertyFactory passes to aggregator/body factories as an argument to create random properties
        PropertyFactory propertyFactory = new PropertyFactory();
        propertyFactory.nameFactory = nameFactory;
        propertyFactory.setMaxPropertiesNumber(25);
        propertyFactory.setMinPropertiesNumber(0);
        propertyFactory.setMaxNumericValue(10000);
        propertyFactory.setMinNumericValue(-10000);
        propertyFactory.setMaxStringLength(50);
        propertyFactory.setMinStringLength(10);

        // bodyFactory passes to aggregator factory as an argument to create random astral bodies
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

        // aggregatorFactory create a random system which consist of random bodies
        AggregatorFactory aggregatorFactory = new AggregatorFactory();
        aggregatorFactory.nameFactory = nameFactory;
        aggregatorFactory.setMaxStarNumber(5);
        aggregatorFactory.setMinStarNumber(1);
        aggregatorFactory.setMaxPlanetNumber(15);
        aggregatorFactory.setMinPlanetNumber(5);

        BodiesAggregator bodiesAggregator = aggregatorFactory.createRandomSystem(bodyFactory, propertyFactory);

        System.out.println("\nCREATED ENTITIES");
        System.out.println(bodiesAggregator);

        // statistics process aggregator's bodies to calculate statistics data
        StatisticsImpl statistics = new Statistics();
        System.out.println("\nTOTAL MASS OF '" + bodiesAggregator.getName() + "' EQUALS TO " + statistics.multiplyMass(bodiesAggregator));

        System.out.println("\nALL NAMES OF STARS/PLANETS/SATELLITES");
        System.out.println(statistics.getBodiesNamesSorted(bodiesAggregator));

        System.out.println("\nALL NAMES OF STARS/PLANETS/SATELLITES (SHOULD BE LIFE");
        System.out.println(statistics.getBodiesNamesWithLifeSorted(bodiesAggregator,
                10000, 100000, 10000, 100000, 10000, 100000));
    }
}
