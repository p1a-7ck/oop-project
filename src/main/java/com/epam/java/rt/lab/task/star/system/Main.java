package com.epam.java.rt.lab.task.star.system;

import com.epam.java.rt.lab.task.star.system.model.entity.BodiesAggregator;
import com.epam.java.rt.lab.task.star.system.factory.FactoriesInitial;
import com.epam.java.rt.lab.task.star.system.factory.AggregatorFactory;
import com.epam.java.rt.lab.task.star.system.factory.BodyFactory;
import com.epam.java.rt.lab.task.star.system.factory.NameFactory;
import com.epam.java.rt.lab.task.star.system.factory.PropertyFactory;
import com.epam.java.rt.lab.task.star.system.model.entity.Body;
import com.epam.java.rt.lab.task.star.system.service.Analyzable;
import com.epam.java.rt.lab.task.star.system.service.Analyzer;

import java.util.List;

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

        Analyzable analyzer = new Analyzer();
        System.out.println("\nTOTAL MASS OF '" + bodiesAggregator.getName() + "' EQUALS TO " + analyzer.multiplyMass(bodiesAggregator));

        System.out.println("\nALL NAMES OF STARS/PLANETS/SATELLITES");
        System.out.println(analyzer.retrieveNames(bodiesAggregator));

        System.out.println("\nALL NAMES OF STARS/PLANETS/SATELLITES SORTED");
        List<String> names = analyzer.retrieveNamesSorted(bodiesAggregator);
        System.out.println(names);

        System.out.println("\nSEVENTH OBJECT");
        System.out.println(analyzer.findSubEntityByName(names.get(6), bodiesAggregator));
    }
}
