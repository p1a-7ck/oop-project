package task.object.hierarchy.service.statistics;

import task.object.hierarchy.entity.body.BodiesAggregator;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class MassMultiplierC {
    public MassMultiplierC() {
    }

    public double multiplyMass(Object entity) {
        BodiesAggregator bodiesAggregator = (BodiesAggregator) entity;
        MassMultiplierAB massMultiplierAB = new MassMultiplierAB();
        double mass = 0;
        for (int i = 0; i < bodiesAggregator.countStars(); i++) {
            mass += massMultiplierAB.multiplyMass(bodiesAggregator.getStar(i));
        }
        for (int i = 0; i < bodiesAggregator.countPlanets(); i++) {
            mass += massMultiplierAB.multiplyMass(bodiesAggregator.getPlanet(i));
        }
        return mass;
    }
}
