package com.epam.java.rt.lab.task.star.system.model;

import com.epam.java.rt.lab.task.star.system.model.body.BodyBase;
import com.epam.java.rt.lab.task.star.system.model.body.Satellite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class StarSystem implements ChangeableMass, ChangeableName, CompoundableEntity {
    private String name;
    private List<BodyBase> bodies = new ArrayList<BodyBase>();

    public StarSystem() {
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
        for (BodyBase bodyBase : this.bodies) {
            names.addAll(bodyBase.getNamesAll());
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
        throw new IllegalArgumentException("There is no astral body with index equals " + index);
    }

    // all next methods commented in interface
    public void addSubEntity(int index, BodyBase subEntity) {
        if (!(subEntity instanceof Satellite)) {
            for (BodyBase bodyBase : this.bodies) {
                if (bodyBase.equals(subEntity))
                    throw new IllegalArgumentException("Astral body object already exist");
            }
            if (index < 0) this.bodies.add(subEntity);
            else this.bodies.add(getBodiesBoundedIndex(index), subEntity);
        } else {
            throw new IllegalArgumentException("Argument should be Star or Planet object");
        }
    }

    public void setSubEntity(int index, BodyBase subEntity) {
        if (!(subEntity instanceof Satellite)) {
            this.bodies.set(getBodiesBoundedIndex(index), subEntity);
        } else {
            throw new IllegalArgumentException("Argument should be Star or Planet object");
        }
    }

    public void removeSubEntity(int index) {
        this.bodies.remove(getBodiesBoundedIndex(index));
    }

    public BodyBase getSubEntity(int index) {
        return this.bodies.get(getBodiesBoundedIndex(index));
    }

    public double getMass() {
        double mass = 0;
        for (BodyBase bodyBase : this.bodies)
            mass += bodyBase.getMass();
        return mass;
    }

    public void setMass(double mass) {
        throw new UnsupportedOperationException("Aggregator Mass Could Not Be Changed");
    }

    @Override
    public String toString() {
        return "StarSystem{" +
                "name='" + name + '\'' +
                ", 'number of bodies'=" + bodies.size() +
                '}';
    }
}