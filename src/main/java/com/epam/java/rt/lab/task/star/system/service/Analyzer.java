package com.epam.java.rt.lab.task.star.system.service;

import com.epam.java.rt.lab.task.star.system.Main;
import com.epam.java.rt.lab.task.star.system.model.ChangeableMass;
import com.epam.java.rt.lab.task.star.system.model.ChangeableName;
import com.epam.java.rt.lab.task.star.system.model.CompoundableEntity;
import com.epam.java.rt.lab.task.star.system.model.body.BodyBase;
import com.epam.java.rt.lab.task.star.system.model.body.Planet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Rollan Taigulov (P1A-7CK)
 */
public class Analyzer implements Analyzable {
    private static final Logger INFO = LoggerFactory.getLogger(Analyzer.class.getName().concat(".INFO"));
    private static final Logger WARN = LoggerFactory.getLogger(Analyzer.class.getName().concat(".WARN"));

    public Analyzer() {
    }

    public double multiplyMass(ChangeableMass changeableMass) {
        return changeableMass.getMass();
    }

    public List<String> retrieveNames(ChangeableName changeableName) {
        return changeableName.getNamesAll();
    }

    public List<String> retrieveNamesSorted(ChangeableName changeableName) {
        Main.LOGGER.trace(".retrieveNamesSorted()");
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        List<String> names = changeableName.getNamesAll();
        Collections.sort(names, comp);
        return names;
    }

    public ChangeableName findSubEntityByName(String name, CompoundableEntity compoundableEntity) {
        BodyBase bodyBase;
        for (int i = 0; i < compoundableEntity.countSubEntities(); i++) {
            bodyBase = compoundableEntity.getSubEntity(i);
            if (bodyBase.getName().matches(name)) return bodyBase;
            if (bodyBase instanceof Planet) {
                bodyBase = (BodyBase) this.findSubEntityByName(name, (CompoundableEntity) bodyBase);
                if (bodyBase != null) return bodyBase;
            }
        }
        return null;
    }

    public List<ChangeableMass> findSubEntitiesWithLessMass(double mass, CompoundableEntity compoundableEntity) {
        Main.LOGGER.trace("{}.findSubEntitiesWithLessMass ({})", ((ChangeableName) compoundableEntity).getName(), mass);
        List<ChangeableMass> resultEntities = new ArrayList<ChangeableMass>();
        ChangeableMass subEntity;
        for (int i = 0; i < compoundableEntity.countSubEntities(); i++) {
            subEntity = compoundableEntity.getSubEntity(i);
            if (subEntity.getMass() < mass) resultEntities.add(subEntity);
            if (subEntity instanceof Planet)
                resultEntities.addAll(this.findSubEntitiesWithLessMass(mass, (CompoundableEntity) subEntity));
        }
        return resultEntities;
    }

    public List<String> findHashCodeCollision(CompoundableEntity compoundableEntity, CompoundableEntity compoundableEntityNew) {
        List<String> resultEntitiesToString = new ArrayList<String>();
        BodyBase bodyBase;
        BodyBase bodyBaseNew;
        for (int i = 0; i < compoundableEntity.countSubEntities(); i++) {
            bodyBase = compoundableEntity.getSubEntity(i);
            for (int j = i; j < compoundableEntityNew.countSubEntities(); j++) {
                bodyBaseNew = compoundableEntityNew.getSubEntity(j);
                if (bodyBase.hashCode() == bodyBaseNew.hashCode()){
                    if (bodyBaseNew instanceof Planet) {
                        resultEntitiesToString.add(bodyBase.getName().concat(" = ").concat(bodyBaseNew.getName()));
                    }
                }
                if (bodyBase instanceof Planet && bodyBaseNew instanceof Planet) {
                    resultEntitiesToString.addAll(this.findHashCodeCollision((CompoundableEntity) bodyBase,
                            (CompoundableEntity) bodyBaseNew));
                }
            }
            if (bodyBase instanceof Planet) {
                resultEntitiesToString.addAll(this.findHashCodeCollision((CompoundableEntity) bodyBase, compoundableEntityNew));
            }
        }
        return resultEntitiesToString;
    }
}