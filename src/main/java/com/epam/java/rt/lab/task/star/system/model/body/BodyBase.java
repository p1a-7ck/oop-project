package com.epam.java.rt.lab.task.star.system.model.body;

import com.epam.java.rt.lab.task.star.system.Main;
import com.epam.java.rt.lab.task.star.system.model.ChangeableMass;
import com.epam.java.rt.lab.task.star.system.model.ChangeableName;

import java.util.*;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public abstract class BodyBase implements ChangeableName, ChangeableMass { //, ChangeableGeometry, ChangeableProperty
    private UUID id;
    private String name;
    private double mass;
    private double density;
    private double diameter;
    private double distanceFromCenter;
    private Map<String, Object> properties = new HashMap<String, Object>();

    public UUID getId() { return id; }

    public void setId(UUID id) { this.id = id; }

    public void setId() { this.id = UUID.randomUUID(); }

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
    public boolean equals(Object o) {
        Main.LOGGER.trace("{}.equals ({})", this.getName(), o.toString());
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BodyBase bodyBase = (BodyBase) o;
//        if (Double.compare(bodyBase.mass, mass) != 0) return false;
//        if (Double.compare(bodyBase.density, density) != 0) return false;
//        if (Double.compare(bodyBase.diameter, diameter) != 0) return false;
//        if (Double.compare(bodyBase.distanceFromCenter, distanceFromCenter) != 0) return false;
        if (this.id != null && bodyBase.id != null) return this.id.equals(bodyBase.id);
        throw new IllegalStateException("Formed object should have not null id field");
    }

    @Override
    public int hashCode() {
        Main.LOGGER.trace("{}.hashCode ()", this.getName());
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "BodyBase{" +
                "name='" + name +
                '}';
    }
}