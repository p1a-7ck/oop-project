package task.object.hierarchy.entity.body;

import task.object.hierarchy.entity.EntitySimpleImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public abstract class AstralBody implements EntitySimpleImpl {
    private String name;
    private double mass;
    private double density;
    private double diameter;
    private double distanceFromCenter;
    private Map<String, Object> properties = new HashMap<String, Object>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getDistanceFromCenter() {
        return distanceFromCenter;
    }

    public void setDistanceFromCenter(double distanceFromCenter) {
        this.distanceFromCenter = distanceFromCenter;
    }

    public <T> T getProperty(String name) {
        if (!properties.containsKey(name))
            throw new IllegalArgumentException("Property with name '" + name + "' does not exist");
        return (T) properties.get(name);
    }

    public <T> void setProperty(String name, T value) {
        if (!properties.containsKey(name))
            throw new IllegalArgumentException("Property with name '" + name + "' does not exist");
        if (!properties.get(name).getClass().equals(value.getClass()))
            throw new IllegalArgumentException("Property '" + name + "' value have another type");
        properties.put(name, value);
    }

    public int countProperties() {
        return properties.size();
    }

    public ArrayList<String> getPropertiesNames() {
        ArrayList<String> propertiesNames = new ArrayList<String>();
        for (Map.Entry<String, Object> entry : properties.entrySet())
            propertiesNames.add(entry.getKey());
        return propertiesNames;
    }

    public <T> void addProperty(String name, T value) {
        if (properties.containsKey(name))
            throw new IllegalArgumentException("Property with name '" + name + "' already exist");
        properties.put(name, value);
    }

    public void removeProperty(String name) {
        if (!properties.containsKey(name))
            throw new IllegalArgumentException("Property with name '" + name + "' does not exist");
        properties.remove(name);
    }

    @Override
    public String toString() {
        return "AstralBody{" +
                "name='" + name + '\'' +
                ", mass=" + mass +
                ", density=" + density +
                ", diameter=" + diameter +
                ", distanceFromCenter=" + distanceFromCenter +
                ", propertiesNames=" + getPropertiesNames() +
                '}';
    }
}
