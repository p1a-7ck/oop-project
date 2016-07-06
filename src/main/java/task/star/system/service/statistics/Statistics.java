package task.star.system.service.statistics;

import task.star.system.model.*;
import task.star.system.model.entity.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class Statistics implements IStatistics {
    public Statistics() {
    }

    public double multiplyMass(IChangeableMass changeableMass) {
        return new MassMultiplier().multiplyMass(changeableMass);
    }

    public double multiplyMass(IAggregator aggregator) {
        return new MassMultiplier().multiplyMass(aggregator);
    }

    public ArrayList<String> getBodiesNamesSorted(IAggregator aggregator) {
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < aggregator.countSubEntities(); i++) {
            Body body = aggregator.getSubEntity(i);
            names.add(body.getName());
            if (body instanceof Planet) {
                for (int j = 0; j < ((Planet) body).countSubEntities(); j++)
                    names.add(body.getName());
            }
        }
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        Collections.sort(names, comp);
        return names;
    }

    public ArrayList<String> getBodiesNamesWithLifeSorted(IAggregator aggregator, double minMass, double maxMass,
                                                          double minDensity, double maxDensity,
                                                          double minDiameter, double maxDiameter) {
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < aggregator.countSubEntities(); i++) {
            Body body = aggregator.getSubEntity(i);
            if (body.getMass() >= minMass && body.getMass() <= maxMass &&
                    body.getDensity() >= minDensity && body.getDensity() <= maxDensity &&
                    body.getDiameter() >= minDiameter && body.getDiameter() <= maxDiameter)
                names.add(body.getName());
            if (body instanceof Planet) {
                for (int j = 0; j < ((Planet) body).countSubEntities(); j++)
                    if (body.getMass() >= minMass && body.getMass() <= maxMass &&
                            body.getDensity() >= minDensity && body.getDensity() <= maxDensity &&
                            body.getDiameter() >= minDiameter && body.getDiameter() <= maxDiameter)
                        names.add(body.getName());
            }
        }
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        Collections.sort(names, comp);
        return names;
    }
}