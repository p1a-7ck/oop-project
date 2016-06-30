package task.object.hierarchy;

/**
 * Created by P1A-7CK on 30.06.2016.
 */
public class Body {
    private String name;
    private double mass;
    private double diameter;
    private double density;

    public Body(String name) {
        this.name = name;
    }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
    public void setMass(double mass) { this.mass = mass; }
    public double getMass() { return mass; }
    public void setDiameter(double diameter) { this.diameter = diameter; }
    public double getDiameter() { return diameter; }
    public void setDensity(double density) { this.density = density; }
    public double getDensity() { return density; }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        //if (obj.getClass() != getClass()) return false;
        Body body = (Body) obj;
        if (body.getName() != getName()) return false;
        if (body.getMass() != getMass()) return false;
        if (body.getDiameter() != getDiameter()) return false;
        if (body.getDensity() != getDensity()) return false;
        return true;
    }
}
