package task.object.hierarchy.entity;

import java.util.ArrayList;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public interface EntitySimpleImpl extends ChangeableNameImpl, ChangeableMassImpl, ChangeableDensityImpl, ChangeableGeometryImpl {
    <T> T getProperty(String name);             // getting property, could be any type, but factory creates next types: int, long, double, String
    <T> void setProperty(String name, T value); // setting property
    int countProperties();                      // returns number of properties
    ArrayList<String> getPropertiesNames();     // returns list of properties names
    <T> void addProperty(String name, T value); // adding property with the name as a key, and value in mapped named array
    void removeProperty(String name);           // removes property by index
}
