package com.epam.java.rt.lab.task.star.system.service;

import com.epam.java.rt.lab.task.star.system.model.ChangeableMass;
import com.epam.java.rt.lab.task.star.system.model.CompoundableEntity;

import java.util.List;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public interface AnalyzableMass {
    double multiplyMass(ChangeableMass changeableMass);

    public List<ChangeableMass> findSubEntitiesWithLessMass(double mass, CompoundableEntity compoundableEntity);
}
