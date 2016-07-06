package task.object.hierarchy.service.statistics;

import task.object.hierarchy.entity.AggregatorImpl;
import task.object.hierarchy.entity.ChangeableMassImpl;
import task.object.hierarchy.entity.body.AstralBody;
import task.object.hierarchy.entity.body.Planet;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class MassMultiplier {
    public MassMultiplier() {
    }

    public double multiplyMass(ChangeableMassImpl changeableMass) {
        return changeableMass.getMass();
    }

    public double multiplyMass(AggregatorImpl aggregator) {
        return aggregator.getMass();
    }
}
