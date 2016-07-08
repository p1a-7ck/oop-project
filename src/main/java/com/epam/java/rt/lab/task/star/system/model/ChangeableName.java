package com.epam.java.rt.lab.task.star.system.model;

import java.util.List;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public interface ChangeableName {
    String getName();

    void setName(String name);

    List<String> getNamesAll();
}
