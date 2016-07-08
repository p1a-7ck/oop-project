package com.epam.java.rt.lab.task.star.system.service;

import com.epam.java.rt.lab.task.star.system.model.ChangeableMass;
import com.epam.java.rt.lab.task.star.system.model.ChangeableName;
import com.epam.java.rt.lab.task.star.system.model.CompoundableEntity;
import com.epam.java.rt.lab.task.star.system.model.entity.Body;
import com.epam.java.rt.lab.task.star.system.model.entity.Planet;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Rollan Taigulov (P1A-7CK)
 */
public class Analyzer implements Analyzable {
    public Analyzer() {
    }

    public double multiplyMass(ChangeableMass changeableMass) {
        return changeableMass.getMass();
    }

    public List<String> retrieveNames(ChangeableName changeableName) {
        return changeableName.getNamesAll();
    }

    public List<String> retrieveNamesSorted(ChangeableName changeableName) {
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
        Body body;
        for (int i = 0; i < compoundableEntity.countSubEntities(); i++) {
            body = compoundableEntity.getSubEntity(i);
            if (body.getName().matches(name)) return body;
            if (body instanceof Planet) {
                body = (Body) this.findSubEntityByName(name, (CompoundableEntity) body);
                if (body != null) return body;
            }            
        }
        return null;
    }
}