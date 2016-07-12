package com.epam.java.rt.lab.task.star.system.model.body;

import com.epam.java.rt.lab.task.star.system.model.ChangeableMass;
import com.epam.java.rt.lab.task.star.system.model.ChangeableName;

import java.util.*;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public abstract class BodyBase implements ChangeableName, ChangeableMass { //, ChangeableGeometry, ChangeableProperty
    private UUID id = UUID.randomUUID();
    private String name;
    private double mass;
    private double density;
    private double diameter;
    private double distanceFromCenter;
    private Map<String, Object> properties = new HashMap<String, Object>();

    public UUID getId() { return id; }

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

    public List<String> getPropertiesNames() {
        List<String> propertiesNames = new ArrayList<String>();
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

    public void copyOf(BodyBase bodyBase) {
        this.id = bodyBase.getId();
        this.name = bodyBase.getName();
        this.mass = bodyBase.getMass();
        this.density = bodyBase.getDensity();
        this.diameter = bodyBase.getDiameter();
        this.distanceFromCenter = bodyBase.getDistanceFromCenter();
    }

    @Override
    public int hashCode() {
        return (id == null || name == null) ? 0 :
                id.hashCode() + name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        try {
            BodyBase objBodyBase = (BodyBase) obj;
            if (!this.name.equals(objBodyBase.getName())) return false;
            if (this.mass != objBodyBase.getMass()) return false;
            if (this.density != objBodyBase.getDensity()) return false;
            if (this.diameter != objBodyBase.getDiameter()) return false;
            if (this.distanceFromCenter != objBodyBase.getDistanceFromCenter()) return false;
            return true;
        } catch (Exception exc) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "BodyBase{" +
                "name='" + name + '\'' +
                ", mass=" + mass +
                ", density=" + density +
                ", diameter=" + diameter +
                ", distanceFromCenter=" + distanceFromCenter +
                ", propertiesNames=" + getPropertiesNames() +
                '}';
    }
}