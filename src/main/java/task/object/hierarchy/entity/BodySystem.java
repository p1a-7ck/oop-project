package task.object.hierarchy.entity;

import task.object.hierarchy.entity.property.*;

/**
 * Created by P1A-7CK on 01.07.2016.
 */
public interface BodySystem {
    void setName(String name);
    String getName();
    Property addProperty(Property property);
    <T> Property addProperty(String name, T value);
    Property getProperty(String name);
    Property getProperty(int arrayIndex);
    <T> boolean setPropertyValue(String name, T value);
    <T> boolean setPropertyValue(int arrayIndex, T value);
    <T> T getPropertyValue(String name);
    <T> T getPropertyValue(int arrayIndex);
}
