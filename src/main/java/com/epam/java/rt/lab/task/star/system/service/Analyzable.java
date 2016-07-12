package com.epam.java.rt.lab.task.star.system.service;

import com.epam.java.rt.lab.task.star.system.model.CompoundableEntity;

import java.util.List;

/**
 * oop-project
 *
 * @author Rollan Taigulov (P1A-7CK)
 */
public interface Analyzable extends AnalyzableMass, AnalyzableName {
    public List<String> findHashCodeCollision(CompoundableEntity compoundableEntity, CompoundableEntity compoundableEntityNew);
}
