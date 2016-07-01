package task.object.hierarchy.entity;

import task.object.hierarchy.entity.property.*;

/**
 * Created by P1A-7CK on 01.07.2016.
 */
public interface Body {
    void setParent(Body parent);
    Body getParent();
    void setName(String name);
    String getName();
    Property addProperty(Property property);
    <T> Property addProperty(String name, T value);
    boolean delProperty(String name);
    Property getProperty(String name);
    Property getProperty(int arrayIndex);
    <T> boolean setPropertyValue(String name, T value);
    <T> boolean setPropertyValue(int arrayIndex, T value);
    <T> T getPropertyValue(String name);
    <T> T getPropertyValue(int arrayIndex);
    Body addBody(Body body);
    Body addBody(String name);
    boolean delBody(String name);
    Body getBody(String name);
    Body getBody(int arrayIndex);
    Body convertToComposite();
    Body convertToBase();
    double getMass();
}
