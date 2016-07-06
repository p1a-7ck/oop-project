package task.star.system.model.entity;

import java.util.ArrayList;

import task.star.system.model.IAggregator;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class BodiesAggregator implements IAggregator {
    private String name;
    private ArrayList<Body> astralBodies = new ArrayList<Body>();

    public BodiesAggregator() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int countSubEntities() {
        return astralBodies.size();
    }

    private int getAstralBodiesBoundedIndex(int index) {
        // validation of requested index, resulting int-value of index for inline code use
        if (index >= 0 && index < this.astralBodies.size()) return index;
        throw new IllegalArgumentException("There is no astral entity with index equals " + index);
    }

    // all next methods commented in interface
    public void addSubEntity(int index, Body subEntity) {
        if (!(subEntity instanceof Satellite)) {
            for (Body body : this.astralBodies) {
                if (body.equals(subEntity))
                    throw new IllegalArgumentException("Astral entity object already exist");
            }
            if (index < 0) this.astralBodies.add(subEntity);
            else this.astralBodies.add(getAstralBodiesBoundedIndex(index), subEntity);
        } else {
            throw new IllegalArgumentException("Argument should be Star or Planet object");
        }
    }

    public void setSubEntity(int index, Body subEntity) {
        if (!(subEntity instanceof Satellite)) {
            this.astralBodies.set(getAstralBodiesBoundedIndex(index), subEntity);
        } else {
            throw new IllegalArgumentException("Argument should be Star or Planet object");
        }
    }

    public void removeSubEntity(int index) {
        this.astralBodies.remove(getAstralBodiesBoundedIndex(index));
    }

    public Body getSubEntity(int index) {
        return this.astralBodies.get(getAstralBodiesBoundedIndex(index));
    }

    public double getMass() {
        double mass = 0;
        for (Body body : this.astralBodies)
            mass += body.getMass();
        return mass;
    }

    @Override
    public String toString() {
        return "BodiesAggregator{" +
                "name='" + name + '\'' +
                ", astralBodies=" + astralBodies +
                '}';
    }
}