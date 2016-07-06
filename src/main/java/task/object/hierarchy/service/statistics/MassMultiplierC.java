package task.object.hierarchy.service.statistics;

import task.object.hierarchy.entity.complex.Complex;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class MassMultiplierC {
    public MassMultiplierC() {
    }

    public double multiplyMass(Object entity) {
        Complex complex = (Complex) entity;
        MassMultiplierAB massMultiplierAB = new MassMultiplierAB();
        double mass = 0;
        for (int i = 0; i < complex.countStars(); i++) {
            mass += massMultiplierAB.multiplyMass(complex.getStar(i));
        }
        for (int i = 0; i < complex.countPlanets(); i++) {
            mass += massMultiplierAB.multiplyMass(complex.getPlanet(i));
        }
        return mass;
    }
}
