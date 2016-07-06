package task.object.hierarchy.entity.body;

import java.util.ArrayList;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class Planet extends AstralBody {
    private ArrayList<Satellite> satellites = new ArrayList<Satellite>();

    public Planet() {

    }

    private int getCheckedSatellitesArrayIndex(int index) {
        if (index >=0 && index < this.satellites.size()) return index;
        throw new IllegalArgumentException("There is no satellite with index equals " + index);
    }

    public int addSatellite() {
        this.satellites.add(new Satellite());
        return this.satellites.size();
    }

    public void removeSatellite(int index) {
        index = getCheckedSatellitesArrayIndex(index);
        this.satellites.remove(index);
    }

    public Satellite getSatelliteClone(int index) {
        index = getCheckedSatellitesArrayIndex(index);
        return this.satellites.get(index).getClone();
    }

    public void setSatelliteClone(int index, Satellite satellite) {
        index = getCheckedSatellitesArrayIndex(index);
        this.satellites.get(index).setClone(satellite);
    }

    public String getSatelliteName(int index) {
        index = getCheckedSatellitesArrayIndex(index);
        return this.satellites.get(index).getName();
    }

    public void setSatelliteName(int index, String name) {
        index = getCheckedSatellitesArrayIndex(index);
        this.satellites.get(index).setName(name);
    }

    public double getSatelliteMass(int index) {
        index = getCheckedSatellitesArrayIndex(index);
        return this.satellites.get(index).getMass();
    }

    public void setSatelliteMass(int index, double mass) {
        index = getCheckedSatellitesArrayIndex(index);
        this.satellites.get(index).setMass(mass);
    }

    public double getSatelliteDensity(int index) {
        index = getCheckedSatellitesArrayIndex(index);
        return this.satellites.get(index).getDensity();
    }

    public void setSatelliteDensity(int index, double density) {
        index = getCheckedSatellitesArrayIndex(index);
        this.satellites.get(index).setDensity(density);
    }

    public double getSatelliteDiameter(int index) {
        index = getCheckedSatellitesArrayIndex(index);
        return this.satellites.get(index).getDiameter();
    }

    public void setSatelliteDiameter(int index, double diameter) {
        index = getCheckedSatellitesArrayIndex(index);
        this.satellites.get(index).setDiameter(diameter);
    }

    public double getSatelliteDistanceFromCenter(int index) {
        index = getCheckedSatellitesArrayIndex(index);
        return this.satellites.get(index).getDistanceFromCenter();
    }

    public void setSatelliteDistanceFromCenter(int index, double distance) {
        index = getCheckedSatellitesArrayIndex(index);
        this.satellites.get(index).setDistanceFromCenter(distance);
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
