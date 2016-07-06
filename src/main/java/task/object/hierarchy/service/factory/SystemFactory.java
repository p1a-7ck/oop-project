package task.object.hierarchy.service.factory;

import task.object.hierarchy.entity.body.Planet;
import task.object.hierarchy.entity.body.Satellite;
import task.object.hierarchy.entity.body.Star.Star;
import task.object.hierarchy.entity.complex.Complex;

import java.util.Random;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class SystemFactory {
    public NameFactory nameFactory = new NameFactory();
    private int minStarNumber;
    private int maxStarNumber;
    private int minPlanetNumber;
    private int maxPlanetNumber;
    private int minEachPlanetSatelliteNumber;
    private int maxEachPlanetSatelliteNumber;

    public SystemFactory() {
    }

    public Complex createRandomSystem(BodyFactory bodyFactory, PropertyArrayFactory propertyArrayFactory) {
        ClassificationFactory classificationFactory = new ClassificationFactory();
        Random random = new Random();

        Complex complex = new Complex();
        complex.setName(nameFactory.createRandomName());
        for (int s = 0; s < random.nextInt(this.maxStarNumber - this.minStarNumber) + this.minStarNumber; s++) {
            Star star = (Star) bodyFactory.createRandomAstralBody(new Star(), propertyArrayFactory);
            star.setStarClassificator(classificationFactory.createRandomClassificator());
            complex.addStar(star);
        }
        for (int p = 0; p < random.nextInt(this.maxPlanetNumber - this.minPlanetNumber) + this.minPlanetNumber; p++) {
            Planet planet = (Planet) bodyFactory.createRandomAstralBody(new Planet(), propertyArrayFactory);
            for (int s = 0; s < random.nextInt(this.maxEachPlanetSatelliteNumber - this.minEachPlanetSatelliteNumber) + this.minEachPlanetSatelliteNumber; s++) {
                Satellite satellite = (Satellite) bodyFactory.createRandomAstralBody(new Satellite(), propertyArrayFactory);
                planet.setSatelliteClone(planet.addSatellite() - 1, satellite);
            }
            complex.addPlanet(planet);
        }
        return complex;
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
