package task.object.hierarchy.service;

import task.object.hierarchy.entity.body.Planet;
import task.object.hierarchy.entity.body.Satellite;
import task.object.hierarchy.entity.body.Star.Star;
import task.object.hierarchy.entity.complex.Complex;

import java.util.Random;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class SystemFactory {
    private int minStarNumber;
    private int maxStarNumber;
    private int minPlanetNumber;
    private int maxPlanetNumber;
    private int minEachPlanetSatelliteNumber;
    private int maxEachPlanetSatelliteNumber;

    public SystemFactory() {
    }

    public Complex createSystem(BodyFactory bodyFactory) {
        Complex complex = new Complex();
        ClassificationFactory classicationFactory = new ClassificationFactory();
        Random random = new Random();

        for (int s = 0; s < random.nextInt(this.maxStarNumber - this.minStarNumber) + this.minStarNumber; s++) {
            Star star = (Star) bodyFactory.createAstralBody(new Star());
            star.setStarClassificator(classicationFactory.createClassificator());
            complex.addStar(star);
        }
        for (int p = 0; p < random.nextInt(this.maxPlanetNumber - this.minPlanetNumber) + this.minPlanetNumber; p++) {
            Planet planet = (Planet) bodyFactory.createAstralBody(new Planet());
            for (int s = 0; s < random.nextInt(this.maxEachPlanetSatelliteNumber - this.minEachPlanetSatelliteNumber) + this.minEachPlanetSatelliteNumber; s++) {
                Satellite satellite = (Satellite) bodyFactory.createAstralBody(new Satellite());
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
        this.minStarNumber = minStarNumber;
    }

    public int getMaxStarNumber() {
        return maxStarNumber;
    }

    public void setMaxStarNumber(int maxStarNumber) {
        this.maxStarNumber = maxStarNumber;
    }

    public int getMinPlanetNumber() {
        return minPlanetNumber;
    }

    public void setMinPlanetNumber(int minPlanetNumber) {
        this.minPlanetNumber = minPlanetNumber;
    }

    public int getMaxPlanetNumber() {
        return maxPlanetNumber;
    }

    public void setMaxPlanetNumber(int maxPlanetNumber) {
        this.maxPlanetNumber = maxPlanetNumber;
    }

    public int getMinEachPlanetSatelliteNumber() {
        return minEachPlanetSatelliteNumber;
    }

    public void setMinEachPlanetSatelliteNumber(int minEachPlanetSatelliteNumber) {
        this.minEachPlanetSatelliteNumber = minEachPlanetSatelliteNumber;
    }

    public int getMaxEachPlanetSatelliteNumber() {
        return maxEachPlanetSatelliteNumber;
    }

    public void setMaxEachPlanetSatelliteNumber(int maxEachPlanetSatelliteNumber) {
        this.maxEachPlanetSatelliteNumber = maxEachPlanetSatelliteNumber;
    }
}
