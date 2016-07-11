package com.epam.java.rt.lab.task.star.system.model.entity;

import com.epam.java.rt.lab.task.star.system.model.CompoundableEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class Planet extends BodyBase implements CompoundableEntity {
    private ArrayList<Satellite> satellites = new ArrayList<Satellite>();

    public Planet() {
    }

    public boolean haveSubEntities() {
        return true;
    }

    public int countSubEntities() {
        return satellites.size();
    }

    private int getSatellitesBoundedIndex(int index) {
        if (index >=0 && index < this.satellites.size()) return index;
        throw new IllegalArgumentException("There is no satellite with index equals " + index);
    }

    public void addSubEntity(int index, BodyBase subEntity) {
        if (subEntity instanceof Satellite) {
            for (Satellite satellite : this.satellites) {
                if (satellite.equals(subEntity))
                    throw new IllegalArgumentException("Satellite object already exist");
            }
            if (index < 0) this.satellites.add((Satellite) subEntity);
            else this.satellites.add(getSatellitesBoundedIndex(index), (Satellite) subEntity);
        } else {
            throw new IllegalArgumentException("Argument should be Satellite object");
        }
    }

    public void setSubEntity(int index, BodyBase subEntity) {
        if (subEntity instanceof Satellite) {
            this.satellites.set(getSatellitesBoundedIndex(index), (Satellite) subEntity);
        } else {
            throw new IllegalArgumentException("Argument should be Satellite object");
        }
    }

    public void removeSubEntity(int index) {
        this.satellites.remove(getSatellitesBoundedIndex(index));
    }

    public BodyBase getSubEntity(int index) {
        return this.satellites.get(getSatellitesBoundedIndex(index));
    }

    @Override
    public List<String> getNamesAll() {
        List<String> names = new ArrayList<String>();
        names.add(super.getName());
        for (BodyBase bodyBase : this.satellites) {
            names.addAll(bodyBase.getNamesAll());
        }
        return names;
    }

    @Override
    public double getMass(){
        double mass = super.getMass();
        for (Satellite satellite : this.satellites)
            mass += satellite.getMass();
        return mass;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + super.getName() + '\'' +
                ", mass=" + super.getMass() +
                ", density=" + super.getDensity() +
                ", diameter=" + super.getDiameter() +
                ", distanceFromCenter=" + super.getDistanceFromCenter() +
                ", propertyNames=" + super.getPropertiesNames() +
                ", satellites = " + satellites +
                '}';
    }
}