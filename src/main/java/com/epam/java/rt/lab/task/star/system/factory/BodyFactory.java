package com.epam.java.rt.lab.task.star.system.factory;

import com.epam.java.rt.lab.task.star.system.Main;
import com.epam.java.rt.lab.task.star.system.model.ChangeableStarClass;
import com.epam.java.rt.lab.task.star.system.model.body.BodyBase;
import com.epam.java.rt.lab.task.star.system.model.body.Planet;
import com.epam.java.rt.lab.task.star.system.model.body.Satellite;
import com.epam.java.rt.lab.task.star.system.model.body.Star;

import java.util.Random;

/**
 * Created by P1A-7CK on 06.07.2016.
 * <p>
 * This factory-class creates random number of randomly generated properties
 * for passed through the argument body-object. For star-object creates random
 * classification values, for planet-object creates random number of satellites
 * and random number of randomly generated properties through recursive call
 * to factory-method
 */
public class BodyFactory {
    public NameFactory nameFactory = new NameFactory();
    private double minMass;
    private double maxMass;
    private double minDensity;
    private double maxDensity;
    private double minDiameter;
    private double maxDiameter;
    private double minDistanceFromCenter;
    private double maxDistanceFromCenter;
    private int minEachPlanetSatelliteNumber;
    private int maxEachPlanetSatelliteNumber;

    public BodyFactory() {
    }

    public BodyBase createRandomBody(BodyBase bodyBase, PropertyFactory propertyFactory) {
        Main.LOGGER.trace(".createRandomBody()");
        Random random = new Random();
        bodyBase.setName(nameFactory.createRandomName());
        bodyBase.setMass(random.nextDouble() * (this.maxMass - this.minMass) + this.minMass);
        bodyBase.setDensity(random.nextDouble() * (this.maxDensity - this.minDensity) + this.minDensity);
        bodyBase.setDiameter(random.nextDouble() * (this.maxDiameter - this.minDiameter) + this.minDiameter);
        bodyBase.setDistanceFromCenter(random.nextDouble() * (this.maxDistanceFromCenter - this.minDistanceFromCenter) +
                this.minDistanceFromCenter);
        if (bodyBase instanceof Star) {
            Main.LOGGER.trace("bodyBase ({}) instanceof Star", bodyBase.getName());
            Star.SPECTRAL_CLASS[] spectralClass = Star.SPECTRAL_CLASS.values();
            Star.SIZE_PREFIX[] sizePrefices = Star.SIZE_PREFIX.values();
            Star.EMITION_SUFFIX[] emitionSuffices = Star.EMITION_SUFFIX.values();
            ((ChangeableStarClass) bodyBase).setSpectralClass(spectralClass[random.nextInt(16)]);
            ((ChangeableStarClass) bodyBase).setSizePrefix(sizePrefices[random.nextInt(8)]);
            ((ChangeableStarClass) bodyBase).setEmitionSuffix(emitionSuffices[random.nextInt(28)]);
        }
        if (bodyBase instanceof Planet) {
            Main.LOGGER.trace("bodyBase ({}) instanceof Planet", bodyBase.getName());
            for (int s = 0; s < random.nextInt(this.maxEachPlanetSatelliteNumber - this.minEachPlanetSatelliteNumber) +
                    this.minEachPlanetSatelliteNumber; s++) {
                Satellite satellite = (Satellite) this.createRandomBody(new Satellite(), propertyFactory);
                ((Planet) bodyBase).addSubEntity(-1, satellite);
            }
        }
        Main.LOGGER.trace("bodyBase ({}) instanceof Satellite", bodyBase.getName());
        bodyBase.setId();
        propertyFactory.createRandomProperty(bodyBase);
        Main.LOGGER.trace("return bodyBase ({})", bodyBase.getId());
        return bodyBase;
    }

    public double getMinMass() {
        return minMass;
    }

    public void setMinMass(double minMass) {
        if (minMass < 0)
            throw new IllegalArgumentException("Minimum mass should be more than or equal to zero");
        if (minMass > this.maxMass)
            throw new IllegalArgumentException("Minimum mass should be less than or equal to maximum");
        this.minMass = minMass;
    }

    public double getMaxMass() {
        return maxMass;
    }

    public void setMaxMass(double maxMass) {
        if (maxMass < 0)
            throw new IllegalArgumentException("Maximum mass should be more than or equal to zero");
        if (maxMass < this.minMass)
            throw new IllegalArgumentException("Maximum mass should be more than or equal to minimum");
        this.maxMass = maxMass;
    }

    public double getMinDensity() {
        return minDensity;
    }

    public void setMinDensity(double minDensity) {
        if (minDensity < 0)
            throw new IllegalArgumentException("Minimum density should be more than or equal to zero");
        if (minDensity > this.maxDensity)
            throw new IllegalArgumentException("Minimum density should be less than or equal to maximum");
        this.minDensity = minDensity;
    }

    public double getMaxDensity() {
        return maxDensity;
    }

    public void setMaxDensity(double maxDensity) {
        if (maxDensity < 0)
            throw new IllegalArgumentException("Maximum density should be more than or equal to zero");
        if (maxDensity < this.minDensity)
            throw new IllegalArgumentException("Maximum density should be more than or equal to minimum");
        this.maxDensity = maxDensity;
    }

    public double getMinDiameter() {
        return minDiameter;
    }

    public void setMinDiameter(double minDiameter) {
        if (minDiameter < 0)
            throw new IllegalArgumentException("Minimum diameter should be more than or equal to zero");
        if (minDiameter > this.maxDiameter)
            throw new IllegalArgumentException("Minimum diameter should be less than or equal to maximum");
        this.minDiameter = minDiameter;
    }

    public double getMaxDiameter() {
        return maxDiameter;
    }

    public void setMaxDiameter(double maxDiameter) {
        if (maxDiameter < 0)
            throw new IllegalArgumentException("Maximum diameter should be more than or equal to zero");
        if (maxDiameter < this.minDiameter)
            throw new IllegalArgumentException("Maximum diameter should be more than or equal to minimum");
        this.maxDiameter = maxDiameter;
    }

    public double getMinDistanceFromCenter() {
        return minDistanceFromCenter;
    }

    public void setMinDistanceFromCenter(double minDistanceFromCenter) {
        if (minDistanceFromCenter < 0)
            throw new IllegalArgumentException("Minimum distance from center should be more than or equal to zero");
        if (minDistanceFromCenter > this.maxDistanceFromCenter)
            throw new IllegalArgumentException("Minimum distance from center should be less than or equal to maximum");
        this.minDistanceFromCenter = minDistanceFromCenter;
    }

    public double getMaxDistanceFromCenter() {
        return maxDistanceFromCenter;
    }

    public void setMaxDistanceFromCenter(double maxDistanceFromCenter) {
        if (maxDistanceFromCenter < 0)
            throw new IllegalArgumentException("Maximum distance from center should be more than or equal to zero");
        if (maxDistanceFromCenter < this.minDistanceFromCenter)
            throw new IllegalArgumentException("Maximum distance from center should be more than or equal to minimum");
        this.maxDistanceFromCenter = maxDistanceFromCenter;
    }

    public int getMinEachPlanetSatelliteNumber() {
        return minEachPlanetSatelliteNumber;
    }

    public void setMinEachPlanetSatelliteNumber(int minEachPlanetSatelliteNumber) {
        if (minEachPlanetSatelliteNumber < 0)
            throw new IllegalArgumentException("Minimum satellites number should be more than or equal to zero");
        if (minEachPlanetSatelliteNumber > this.maxEachPlanetSatelliteNumber)
            throw new IllegalArgumentException("Minimum satellites number should be less than or equal to maximum");
        this.minEachPlanetSatelliteNumber = minEachPlanetSatelliteNumber;
    }

    public int getMaxEachPlanetSatelliteNumber() {
        return maxEachPlanetSatelliteNumber;
    }

    public void setMaxEachPlanetSatelliteNumber(int maxEachPlanetSatelliteNumber) {
        if (maxEachPlanetSatelliteNumber < 0)
            throw new IllegalArgumentException("Maximum satellites number should be more than or equal to zero");
        if (maxEachPlanetSatelliteNumber < this.minEachPlanetSatelliteNumber)
            throw new IllegalArgumentException("Maximum satellites number should be more than or equal to minimum");
        this.maxEachPlanetSatelliteNumber = maxEachPlanetSatelliteNumber;
    }
}