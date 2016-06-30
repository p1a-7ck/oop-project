package task.object.hierarchy;

/**
 * Created by P1A-7CK on 30.06.2016.
 */
public class Satellite extends Body {
    boolean haveAir = false, haveWater = false, haveLand = false, haveLife = false;

    public Satellite(String name) {
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

    private String satelliteOtions() {
        String o = "";
        if (haveAir) o += " AIR";
        if (haveWater) o += " WATER";
        if (haveLand) o += " LAND";
        if (haveLife) o += " LIFE";
        if (o.equals("")) return "UNKNOWN";
        return o.trim();
    }

    @Override
    public String toString() {
        return  "\n\t\tSatellite '" + super.getName() + "' (" + satelliteOtions() + "):\n" +
                "\t\t(Mass) " + super.getMass() + "\t" +
                "\t\t(Diameter) " + super.getDiameter() + "\t" +
                "\t\t(Density) " + super.getDensity() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != getClass()) return false;
        Satellite satellite = (Satellite) obj;
        if (satellite.haveAir != haveAir) return false;
        if (satellite.haveWater != haveWater) return false;
        if (satellite.haveLand != haveLand) return false;
        if (satellite.haveLife != haveLife) return false;
        Body body = (Body) obj;
        if (!super.equals(body)) return false;
        return true;
    }
}
