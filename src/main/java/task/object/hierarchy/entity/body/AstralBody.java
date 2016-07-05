package task.object.hierarchy.entity.body;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public abstract class AstralBody {
    private String name;
    private double mass;
    private double density;
    private double diameter;
    private double distanceFromCenter;

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

    public boolean isNoSatellitePossibility() {
        return true;
    }

    public int countSatellites() {
        return 0;
    }

    @Override
    public String toString() {
        return this.name + " / (mass) " + this.mass + " / (density) " + this.density +
                " / (diameter) " + this.diameter + " / (distance) " + this.distanceFromCenter + "\n";
    }
}
