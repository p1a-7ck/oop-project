package com.epam.java.rt.lab.task.star.system.factory;

import com.epam.java.rt.lab.task.star.system.model.entity.StarSystem;
import com.epam.java.rt.lab.task.star.system.model.entity.Planet;
import com.epam.java.rt.lab.task.star.system.model.entity.Star;

import java.util.Random;

/**
 * Created by P1A-7CK on 06.07.2016.
 * <p>
 * This factory-class creates random number of bodies with random properties
 * and randomly set name. Random values generated between set limits, which
 * could be updated through certain methods.
 */
public class StarSystemFactory {
    public NameFactory nameFactory = new NameFactory();
    private int minStarNumber;
    private int maxStarNumber;
    private int minPlanetNumber;
    private int maxPlanetNumber;

    public StarSystemFactory() {
    }

    public StarSystem createRandomSystem(BodyFactory bodyFactory, PropertyFactory propertyFactory) {
        Random random = new Random();

        StarSystem starSystem = new StarSystem();
        starSystem.setName(nameFactory.createRandomName());
        for (int s = 0; s < random.nextInt(this.maxStarNumber - this.minStarNumber) + this.minStarNumber; s++)
            starSystem.addSubEntity(-1, bodyFactory.createRandomBody(new Star(), propertyFactory));
        for (int p = 0; p < random.nextInt(this.maxPlanetNumber - this.minPlanetNumber) + this.minPlanetNumber; p++)
            starSystem.addSubEntity(-1, bodyFactory.createRandomBody(new Planet(), propertyFactory));
        return starSystem;
    }

    public int getMinStarNumber() {
        return minStarNumber;
    }

    public void setMinStarNumber(int minStarNumber) {
        if (minStarNumber < 0)
            throw new IllegalArgumentException("Minimum star number should be more than or equal to zero");
        if (minStarNumber > this.maxStarNumber)
            throw new IllegalArgumentException("Minimum star number should be less than or equal to maximum");
        this.minStarNumber = minStarNumber;
    }

    public int getMaxStarNumber() {
        return maxStarNumber;
    }

    public void setMaxStarNumber(int maxStarNumber) {
        if (maxStarNumber < 0)
            throw new IllegalArgumentException("Maximum stars number should be more than or equal to zero");
        if (maxStarNumber < this.minStarNumber)
            throw new IllegalArgumentException("Maximum stars number should be more than or equal to minimum");
        this.maxStarNumber = maxStarNumber;
    }

    public int getMinPlanetNumber() {
        return minPlanetNumber;
    }

    public void setMinPlanetNumber(int minPlanetNumber) {
        if (minPlanetNumber < 0)
            throw new IllegalArgumentException("Minimum planets number should be more than or equal to zero");
        if (minPlanetNumber > this.maxPlanetNumber)
            throw new IllegalArgumentException("Minimum planets number should be less than or equal to maximum");
        this.minPlanetNumber = minPlanetNumber;
    }

    public int getMaxPlanetNumber() {
        return maxPlanetNumber;
    }

    public void setMaxPlanetNumber(int maxPlanetNumber) {
        if (maxPlanetNumber < 0)
            throw new IllegalArgumentException("Maximum planets number should be more than or equal to zero");
        if (maxPlanetNumber < this.minPlanetNumber)
            throw new IllegalArgumentException("Maximum planets number should be more than or equal to minimum");
        this.maxPlanetNumber = maxPlanetNumber;
    }
}