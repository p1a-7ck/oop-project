package task.star.system.service.statistics;

import task.star.system.model.*;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class MassMultiplier {
    public MassMultiplier() {
    }

    public double multiplyMass(IChangeableMass changeableMass) {
        return changeableMass.getMass();
    }

    public double multiplyMass(IAggregator aggregator) {
        return aggregator.getMass();
    }
}
