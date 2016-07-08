package com.epam.java.rt.lab.task.star.system.model.entity;

import com.epam.java.rt.lab.task.star.system.model.ChangeableMass;
import com.epam.java.rt.lab.task.star.system.model.ChangeableName;
import com.epam.java.rt.lab.task.star.system.model.CompoundableEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class BodiesAggregator implements ChangeableMass, ChangeableName, CompoundableEntity {
    private String name;
    private List<Body> bodies = new ArrayList<Body>();

    public BodiesAggregator() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNamesAll() {
        List<String> names = new ArrayList<String>();
        names.add(this.name);
        for (Body body : this.bodies) {
            names.addAll(body.getNamesAll());
        }
        return names;
    }

    public boolean haveSubEntities() {
        return true;
    }

    public int countSubEntities() {
        return bodies.size();
    }

    private int getBodiesBoundedIndex(int index) {
        // validation of requested index, resulting int-value of index for inline code use
        if (index >= 0 && index < this.bodies.size()) return index;
        throw new IllegalArgumentException("There is no astral entity with index equals " + index);
    }

    // all next methods commented in interface
    public void addSubEntity(int index, Body subEntity) {
        if (!(subEntity instanceof Satellite)) {
            for (Body body : this.bodies) {
                if (body.equals(subEntity))
                    throw new IllegalArgumentException("Astral entity object already exist");
            }
            if (index < 0) this.bodies.add(subEntity);
            else this.bodies.add(getBodiesBoundedIndex(index), subEntity);
        } else {
            throw new IllegalArgumentException("Argument should be Star or Planet object");
        }
    }

    public void setSubEntity(int index, Body subEntity) {
        if (!(subEntity instanceof Satellite)) {
            this.bodies.set(getBodiesBoundedIndex(index), subEntity);
        } else {
            throw new IllegalArgumentException("Argument should be Star or Planet object");
        }
    }

    public void removeSubEntity(int index) {
        this.bodies.remove(getBodiesBoundedIndex(index));
    }

    public Body getSubEntity(int index) {
        return this.bodies.get(getBodiesBoundedIndex(index));
    }

    public double getMass() {
        double mass = 0;
        for (Body body : this.bodies)
            mass += body.getMass();
        return mass;
    }

    public void setMass(double mass) {
        throw new UnsupportedOperationException("Aggregator Mass Could Not Be Changed");
    }

    @Override
    public String toString() {
        return "BodiesAggregator{" +
                "name='" + name + '\'' +
                ", bodies=" + bodies +
                '}';
    }
}