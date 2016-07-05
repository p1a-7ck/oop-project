package task.object.hierarchy.entity.body;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class Satellite extends AstralBody {
    public Satellite getClone() {
        Satellite satellite = new Satellite();
        satellite.setName(super.getName());
        satellite.setMass(super.getMass());
        satellite.setDensity(super.getDensity());
        satellite.setDiameter(super.getDiameter());
        satellite.setDistanceFromCenter(super.getDistanceFromCenter());
        return satellite;
    }

    public void setClone(Satellite satellite) {
        super.setName(satellite.getName());
        super.setMass(satellite.getMass());
        super.setDensity(satellite.getDensity());
        super.setDiameter(satellite.getDiameter());
        super.setDistanceFromCenter(satellite.getDistanceFromCenter());
    }
}
