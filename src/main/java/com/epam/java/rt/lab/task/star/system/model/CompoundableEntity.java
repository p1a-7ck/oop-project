package com.epam.java.rt.lab.task.star.system.model;

import com.epam.java.rt.lab.task.star.system.model.body.BodyBase;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public interface CompoundableEntity {
    boolean haveSubEntities();

    int countSubEntities();

    void addSubEntity(int index, BodyBase subEntity);

    void setSubEntity(int index, BodyBase subEntity);

    void removeSubEntity(int index);

    BodyBase getSubEntity(int index);
}
