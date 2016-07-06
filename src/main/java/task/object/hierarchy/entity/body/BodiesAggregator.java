package task.object.hierarchy.entity.body;

import java.util.ArrayList;

import task.object.hierarchy.entity.AggregatorImpl;


/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class BodiesAggregator implements AggregatorImpl {
    private String name;
    private ArrayList<AstralBody> astralBodies = new ArrayList<AstralBody>();

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
        if (index >=0 && index < this.astralBodies.size()) return index;
        throw new IllegalArgumentException("There is no astral body with index equals " + index);
    }

    public void addSubEntity(int index, AstralBody subEntity) {
        if (!(subEntity instanceof Satellite)) {
            for (AstralBody astralBody : this.astralBodies) {
                if (astralBody.equals(subEntity))
                    throw new IllegalArgumentException("Astral body object already exist");
            }
            if (index < 0) this.astralBodies.add(subEntity);
            else this.astralBodies.add(getAstralBodiesBoundedIndex(index), subEntity);
        } else {
            throw new IllegalArgumentException("Argument should be Star or Planet object");
        }
    }

    public void setSubEntity(int index, AstralBody subEntity) {
        if (!(subEntity instanceof Satellite)) {
            this.astralBodies.set(getAstralBodiesBoundedIndex(index), subEntity);
        } else {
            throw new IllegalArgumentException("Argument should be Star or Planet object");
        }
    }

    public void removeSubEntity(int index) {
        this.astralBodies.remove(getAstralBodiesBoundedIndex(index));
    }

    public AstralBody getSubEntity(int index) {
        return this.astralBodies.get(getAstralBodiesBoundedIndex(index));
    }

    public double getMass(){
        double mass = 0;
        for (AstralBody astralBody : this.astralBodies)
            mass += astralBody.getMass();
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


