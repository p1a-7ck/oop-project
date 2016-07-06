package task.star.system.model;

import java.util.ArrayList;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public interface IEntitySimple extends IChangeableName, IChangeableMass, IChangeableDensity, IChangeableGeometry {
    <T> T getProperty(String name);
    <T> void setProperty(String name, T value);
    int countProperties();
    ArrayList<String> getPropertiesNames();
    <T> void addProperty(String name, T value);
    void removeProperty(String name);
}
