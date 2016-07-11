package com.epam.java.rt.lab.task.star.system;

import com.epam.java.rt.lab.task.star.system.factory.*;
import com.epam.java.rt.lab.task.star.system.model.entity.BodyBase;
import com.epam.java.rt.lab.task.star.system.model.entity.Planet;
import com.epam.java.rt.lab.task.star.system.model.entity.StarSystem;
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
        StarSystemFactory starSystemFactory = new StarSystemFactory();
        (new FactoriesInitial()).InitiateFactories(nameFactory, propertyFactory, bodyFactory, starSystemFactory);

        StarSystem starSystem = starSystemFactory.createRandomSystem(bodyFactory, propertyFactory);

        System.out.println("\nCREATED ENTITIES");
        System.out.println(starSystem);

        Analyzable analyzer = new Analyzer();
        System.out.println("\nTOTAL MASS OF '" + starSystem.getName() + "' EQUALS TO " + analyzer.multiplyMass(starSystem));

        System.out.println("\nALL NAMES OF STARS/PLANETS/SATELLITES");
        System.out.println(analyzer.retrieveNames(starSystem));

        System.out.println("\nALL NAMES OF STARS/PLANETS/SATELLITES SORTED");
        List<String> names = analyzer.retrieveNamesSorted(starSystem);
        System.out.println(names);

        System.out.println("\nSEVENTH OBJECT");
        System.out.println(analyzer.findSubEntityByName(names.get(6), starSystem));

        System.out.println("\nCOPYING AND COMPARING OBJECT");
        BodyBase planetClone = new Planet();
        planetClone.copyOf(starSystem.getSubEntity(2));
        System.out.println("\nFIRST OBJECT (COPYOF):");
        System.out.println(planetClone);
        System.out.println("\nSECOND OBJECT (INITIAL):");
        System.out.println(starSystem.getSubEntity(2));
        System.out.println("\nEQUAL RESULT:");
        System.out.println(planetClone.equals(starSystem.getSubEntity(2)));

        System.out.println("\nRETRIEVING SUB-ENTITIES BY MASS (" + starSystem.getSubEntity(6).getMass() + "):");
        System.out.println(analyzer.findSubEntitiesWithLessMass(starSystem.getSubEntity(6).getMass(), starSystem));
    }
}
