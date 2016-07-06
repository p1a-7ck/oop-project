package task.star.system.service.statistics;

import task.star.system.model.*;

import java.util.ArrayList;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public interface IStatistics {
    double multiplyMass(IChangeableMass changeableMass);
    double multiplyMass(IAggregator aggregator);
    ArrayList<String> getBodiesNamesSorted(IAggregator aggregator);
    ArrayList<String> getBodiesNamesWithLifeSorted(IAggregator aggregator,
                                                   double minMass, double maxMass,
                                                   double minDensity, double maxDensity,
                                                   double minDiameter, double maxDiameter);
}
