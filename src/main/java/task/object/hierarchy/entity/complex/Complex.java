package task.object.hierarchy.entity.complex;

import java.util.ArrayList;
import task.object.hierarchy.entity.body.*;
import task.object.hierarchy.entity.body.Star.Star;


/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class Complex {
    private String name;
    private ArrayList<Star> stars = new ArrayList<Star>();
    private ArrayList<Planet> planets = new ArrayList<Planet>();

    public Complex() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int getCheckedStarArrayIndex(int index) {
        if (index >=0 && index < this.stars.size()) return index;
        throw new IllegalArgumentException("There is no star with index equals " + index);
    }

    private int getCheckedPlanetArrayIndex(int index) {
        if (index >=0 && index < this.planets.size()) return index;
        throw new IllegalArgumentException("There is no planet with index equals " + index);
    }

    public void addStar(Star star) {
        this.stars.add(star);
    }

    public Star getStar(int index) {
        index = getCheckedStarArrayIndex(index);
        return this.stars.get(index);
    }

    public void setStar(int index, Star star) {
        removeStar(index);
        this.stars.add(index, star);
    }

    public void removeStar(int index) {
        index = getCheckedStarArrayIndex(index);
        this.stars.remove(index);
    }

    public void addPlanet(Planet planet) {
        this.planets.add(planet);
    }

    public Planet getPlanet(int index) {
        index = getCheckedPlanetArrayIndex(index);
        return this.planets.get(index);
    }

    public void setPlanet(int index, Planet planet) {
        removePlanet(index);
        this.planets.add(index, planet);
    }

    public void removePlanet(int index) {
        index = getCheckedPlanetArrayIndex(index);
        this.planets.remove(index);
    }

    @Override
    public String toString() {
        String o = "";

        o += "Stars / " + this.stars.size() + ":\n";
        for (Star star: this.stars) o += "\t" + star + "\n";
        o += "Planets / " + this.planets.size() + ":\n";
        for (Planet planet: this.planets) o += "\t\t" + planet + "\n";
        return this.name + "\n" + o;
    }

}


