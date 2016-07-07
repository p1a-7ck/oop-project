package task.star.system.model;

import task.star.system.model.entity.Body;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public interface ICompoundableEntity {
    boolean haveSubEntities();

    int countSubEntities();

    void addSubEntity(int index, Body subEntity);

    void setSubEntity(int index, Body subEntity);

    void removeSubEntity(int index);

    Body getSubEntity(int index);
}
