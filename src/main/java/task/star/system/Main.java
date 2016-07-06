package task.star.system;

import task.star.system.model.entity.*;
import task.star.system.service.FactoriesInitial;
import task.star.system.service.factory.*;
import task.star.system.service.statistics.*;

/**
 * Created by P1A-7CK on 30.06.2016.
 * <p>
 * This is a Main - entering point to the project. There are star system entities,
 * which stores fields data and interacts each other through the methods and interfaces.
 * There are some services to implement the interaction between objects, which made
 * through the interfaces to make project code-safe and type-safe
 */
public class Main {
    public static void main(String[] args) {
        NameFactory nameFactory = new NameFactory();
        PropertyFactory propertyFactory = new PropertyFactory();
        BodyFactory bodyFactory = new BodyFactory();
        AggregatorFactory aggregatorFactory = new AggregatorFactory();
        (new FactoriesInitial()).InitiateFactories(nameFactory, propertyFactory, bodyFactory, aggregatorFactory);

        BodiesAggregator bodiesAggregator = aggregatorFactory.createRandomSystem(bodyFactory, propertyFactory);

        System.out.println("\nCREATED ENTITIES");
        System.out.println(bodiesAggregator);

        IStatistics statistics = new Statistics();
        System.out.println("\nTOTAL MASS OF '" + bodiesAggregator.getName() + "' EQUALS TO " + statistics.multiplyMass(bodiesAggregator));

        System.out.println("\nALL NAMES OF STARS/PLANETS/SATELLITES");
        System.out.println(statistics.getBodiesNamesSorted(bodiesAggregator));

        System.out.println("\nALL NAMES OF STARS/PLANETS/SATELLITES (SHOULD BE LIFE THERE)");
        System.out.println(statistics.getBodiesNamesWithLifeSorted(bodiesAggregator,
                10000, 100000, 10000, 100000, 10000, 100000));
    }
}
