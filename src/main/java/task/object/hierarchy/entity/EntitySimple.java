package task.object.hierarchy.entity;

import java.util.ArrayList;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public interface EntitySimple extends ChangeableName, ChangeableMass, ChangeableDensity, ChangeableGeometry {
    <T> T getProperty(String name);
    <T> void setProperty(String name, T value);
    int countProperties();
    ArrayList<String> getPropertiesNames();
    <T> void addProperty(String name, T vslue);
    void removeProperty(String name);
}
