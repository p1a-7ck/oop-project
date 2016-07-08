package com.epam.java.rt.lab.task.star.system.model.entity;

import com.epam.java.rt.lab.task.star.system.model.ChangeableGeometry;
import com.epam.java.rt.lab.task.star.system.model.ChangeableMass;
import com.epam.java.rt.lab.task.star.system.model.ChangeableName;
import com.epam.java.rt.lab.task.star.system.model.ChangeableProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public abstract class Body implements ChangeableName, ChangeableMass, ChangeableGeometry, ChangeableProperty {
    private Long id;
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

    public List<String> getNamesAll() {
        List<String> names = new ArrayList<String>();
        names.add(this.name);
        return names;
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
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        try {
            Body objBody = (Body) obj;
            if (!this.name.equals(objBody.getName())) return false;
            if (this.mass != objBody.getMass()) return false;
            if (this.density != objBody.getDensity()) return false;
            if (this.diameter != objBody.getDiameter()) return false;
            if (this.distanceFromCenter != objBody.getDistanceFromCenter()) return false;
            return true;
        } catch (Exception exc) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Body{" +
                "name='" + name + '\'' +
                ", mass=" + mass +
                ", density=" + density +
                ", diameter=" + diameter +
                ", distanceFromCenter=" + distanceFromCenter +
                ", propertiesNames=" + getPropertiesNames() +
                '}';
    }
}