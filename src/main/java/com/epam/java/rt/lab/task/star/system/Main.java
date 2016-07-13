package com.epam.java.rt.lab.task.star.system;

import com.epam.java.rt.lab.task.star.system.factory.*;
import com.epam.java.rt.lab.task.star.system.model.StarSystem;
import com.epam.java.rt.lab.task.star.system.service.Analyzable;
import com.epam.java.rt.lab.task.star.system.service.Analyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by P1A-7CK on 30.06.2016.
 * <p>
 * This is a Main - entering point to the project. There are star system entities,
 * which stores fields data and interacts each other through the methods and interfaces.
 * There are some services to implement the interaction between objects, which made
 * through the interfaces to make project code-safe and type-safe
 */
public class Main {
    public final static Logger LOGGER = LoggerFactory.getLogger("LOGGER");

    public static void main(String[] args) {
        NameFactory nameFactory = new NameFactory();
        PropertyFactory propertyFactory = new PropertyFactory();
        BodyFactory bodyFactory = new BodyFactory();
        StarSystemFactory starSystemFactory = new StarSystemFactory();
        (new FactoriesInitial()).InitiateFactories(nameFactory, propertyFactory, bodyFactory, starSystemFactory);

        StarSystem starSystem = starSystemFactory.createRandomSystem(bodyFactory, propertyFactory);
        System.out.println(starSystem);

        Analyzable analyzer = new Analyzer();
        System.out.println(analyzer.multiplyMass(starSystem));
        System.out.println(analyzer.retrieveNames(starSystem));

        System.out.println(analyzer.retrieveNamesSorted(starSystem));
        System.out.println(analyzer.findSubEntityByName(nameFactory.createRandomName(), starSystem));

        System.out.println(starSystem.getSubEntity(3).equals(starSystem.getSubEntity(5)));

        System.out.println(analyzer.findSubEntitiesWithLessMass(starSystem.getSubEntity(6).getMass(), starSystem));
    }
}
