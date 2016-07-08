package com.epam.java.rt.lab.task.star.system.service;

import com.epam.java.rt.lab.task.star.system.model.ChangeableName;
import com.epam.java.rt.lab.task.star.system.model.CompoundableEntity;

import java.util.List;

/**
 * Created by P1A-7CK on 08.07.2016.
 */
public interface AnalyzableName {
    List<String> retrieveNames(ChangeableName changeableName);
    List<String> retrieveNamesSorted(ChangeableName changeableName);
    ChangeableName findSubEntityByName(String name, CompoundableEntity compoundableEntity);
}
