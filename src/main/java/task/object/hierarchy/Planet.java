package task.object.hierarchy;

import java.util.ArrayList;

/**
 * Created by P1A-7CK on 30.06.2016.
 */
public class Planet extends Body {
    boolean haveAir = false, haveWater = false, haveLand = false, haveLife = false;
    private ArrayList<Satellite> satellites = new ArrayList<Satellite>();

    public Planet(String name) {
        super(name);
    }

    public void setHaveAir(boolean haveAir) { this.haveAir = haveAir; }
    public boolean getHaveAir() { return haveAir; }
    public void setHaveWater(boolean haveWater) { this.haveWater = haveWater; }
    public boolean getHaveWater() { return haveWater; }
    public void setHaveLand(boolean haveLand) { this.haveLand = haveLand; }
    public boolean getHaveLand() { return haveLand; }
    public void setHaveLife(boolean haveLife) { this.haveLife = haveLife; }
    public boolean getHaveLife() { return haveLife; }

    private String planetOtions() {
        String o = "";
        if (haveAir) o += " AIR";
        if (haveWater) o += " WATER";
        if (haveLand) o += " LAND";
        if (haveLife) o += " LIFE";
        if (o.equals("")) return "UNKNOWN";
        return o.trim();
    }

    private Satellite satelliteExist(String name) {
        if (satellites != null) for (Satellite satellite : satellites) if (satellite.getName().equals(name)) return satellite;
        return null;
    }

    public Satellite addSatellite(String name) {
        if (satelliteExist(name) == null) {
            Satellite satellite = new Satellite(name);
            satellites.add(satellite);
            return satellite;
        }
        throw new UnsupportedOperationException("Satellite with name '" + name + "' already exist around '" + super.getName() + "' planet");
    }

    public Satellite getSatellite(String name) {
        Satellite satellite = satelliteExist(name);
        if (satellite != null) return satellite;
        throw new UnsupportedOperationException("Satellite with name '" + name + "' does not exist around '" + super.getName() + "' planet");
    }

    public ArrayList<Satellite> getSatellites() {
        return satellites;
    }

    private String satellitesToString() {
        String o = "";
        if (satellites != null) for (Satellite satellite: satellites) o += satellite.toString();
        return o;
    }

    @Override
    public String toString() {
        return  "\n\tPlanet '" + super.getName() + "' (" + planetOtions() + "):\n" +
                "\t(Mass) " + super.getMass() + "\t" +
                "\t(Diameter) " + super.getDiameter() + "\t" +
                "\t(Density) " + super.getDensity() + "\n" + satellitesToString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != getClass()) return false;
        Planet planet = (Planet) obj;
        if (planet.haveAir != haveAir) return false;
        if (planet.haveWater != haveWater) return false;
        if (planet.haveLand != haveLand) return false;
        if (planet.haveLife != haveLife) return false;
        Body body = (Body) obj;
        if (!super.equals(body)) return false;
        return true;
    }

}
