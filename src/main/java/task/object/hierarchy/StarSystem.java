package task.object.hierarchy;

import java.util.ArrayList;

/**
 * Created by P1A-7CK on 30.06.2016.
 */
public class StarSystem {
    public enum BODY_TYPE {ALL, STARS, PLANETS, SATELLITIES, STARS_AND_PLANETS, PLANETS_AND_SATELLITIES}
    public enum SORT_TYPE {NONE, NAME, MASS, DIAMETER, DENSITY}

    private String name;
    private ArrayList<Star> stars = new ArrayList<Star>();
    private ArrayList<Planet> planets = new ArrayList<Planet>();

    public StarSystem(String name) {
        this.name = name;
    }

    private Star starExist(String name) {
        if (stars != null) for (Star star : stars) if (star.getName().equals(name)) return star;
        return null;
    }

    public Star addStar(String name) {
        if (starExist(name) == null) {
            Star star = new Star(name);
            stars.add(star);
            return star;
        }
        throw new UnsupportedOperationException("Star with name '" + name + "' already exist in '" + this.name + "' system");
    }

    public Star getStar(String name) {
        Star star = starExist(name);
        if (star != null) return star;
        throw new UnsupportedOperationException("Star with name '" + name + "' does not exist in '" + this.name + "' system");
    }

    private Planet planetExist(String name) {
        if (planets != null) for (Planet planet : planets) if (planet.getName().equals(name)) return planet;
        return null;
    }

    public Planet addPlanet(String name) {
        if (planetExist(name) == null) {
            Planet planet = new Planet(name);
            planets.add(planet);
            return planet;
        }
        throw new UnsupportedOperationException("Planet with name '" + name + "' already exist in '" + this.name + "' system");
    }

    public Planet getPlanet(String name) {
        Planet planet = planetExist(name);
        if (planet != null) return planet;
        throw new UnsupportedOperationException("Planet with name '" + name + "' does not exist in '" + this.name + "' system");
    }

    public ArrayList<Object> getAllBodies(BODY_TYPE bodyType, SORT_TYPE sortType) {
        ArrayList<Object> bodies = new ArrayList<Object>();
        if (bodyType == BODY_TYPE.ALL || bodyType == BODY_TYPE.STARS || bodyType == BODY_TYPE.STARS_AND_PLANETS)
            for (Star star: stars) bodies.add(star);
        if (bodyType == BODY_TYPE.ALL || bodyType == BODY_TYPE.PLANETS || bodyType == BODY_TYPE.PLANETS_AND_SATELLITIES) {
            for (Planet planet: planets) {
                bodies.add(planet);
                if (bodyType == BODY_TYPE.ALL || bodyType == BODY_TYPE.PLANETS_AND_SATELLITIES)
                    for (Satellite satellite: planet.getSatellites()) bodies.add(satellite);
            }
        }
        if (bodyType == BODY_TYPE.SATELLITIES) for (Planet planet: planets)
            for (Satellite satellite: planet.getSatellites()) bodies.add(satellite);
        if (sortType == SORT_TYPE.NONE) return bodies;
        //TODO sort array on sortType
        return bodies;
    }

    @Override
    public String toString() {
        String o;
        EntityAnalyzer ea = new EntityAnalyzer();

        o = "\nSystem '" + name + "' (" + ea.getStarSystemStatistics(this) + ")" +
                "\n----------------------------------------------------------------------";
        if (stars != null) for (Star star: stars) o += star.toString();
        if (planets != null) for (Planet planet: planets) o += planet.toString();
        return o;
    }
}