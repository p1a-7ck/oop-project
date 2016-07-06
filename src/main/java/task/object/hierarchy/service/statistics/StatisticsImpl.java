package task.object.hierarchy.service.statistics;

import task.object.hierarchy.entity.AggregatorImpl;
import task.object.hierarchy.entity.ChangeableMassImpl;

import java.util.ArrayList;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public interface StatisticsImpl {
    double multiplyMass(ChangeableMassImpl changeableMass);                                 // getting mass for mass-having objects
    double multiplyMass(AggregatorImpl aggregator);                                         // getting mass for aggregator objects
    ArrayList<String> getBodiesNamesSorted(AggregatorImpl aggregator);                      // getting array of names of aggregator's children including satellites
    ArrayList<String> getBodiesNamesWithLifeSorted(AggregatorImpl aggregator,
                                                   double minMass, double maxMass,
                                                   double minDensity, double maxDensity,
                                                   double minDiameter, double maxDiameter);
}
