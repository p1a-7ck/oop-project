package task.object.hierarchy.service.statistics;

import task.object.hierarchy.entity.body.AstralBody;
import task.object.hierarchy.entity.body.BodiesAggregator;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class Statistics implements StatisticsImpl {
    public Statistics() {
    }

    public double multiplyMass(Object entity) {
        /*
        if (entity instanceof BodiesAggregator) {
            MassMultiplierC massMultiplierC = new MassMultiplierC();
            return massMultiplierC.multiplyMass(entity);
        } else if (entity instanceof AstralBody) {
            MassMultiplierAB massMultiplierAB = new MassMultiplierAB();
            return massMultiplierAB.multiplyMass(entity);
        }*/
        throw new IllegalArgumentException("Object should be BodiesAggregator or AstralBody");
    }
}