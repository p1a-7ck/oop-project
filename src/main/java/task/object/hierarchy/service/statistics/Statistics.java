package task.object.hierarchy.service.statistics;

import task.object.hierarchy.entity.AggregatorImpl;
import task.object.hierarchy.entity.ChangeableMassImpl;
import task.object.hierarchy.entity.EntityComplexImpl;
import task.object.hierarchy.entity.body.AstralBody;
import task.object.hierarchy.entity.body.Planet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class Statistics implements StatisticsImpl {
    // this is a base class for statistics which accessible to use through interface
    public Statistics() {
    }

    public double multiplyMass(ChangeableMassImpl changeableMass) {
        return new MassMultiplier().multiplyMass(changeableMass);
    }

    public double multiplyMass(AggregatorImpl aggregator) {
        return new MassMultiplier().multiplyMass(aggregator);
    }

    public ArrayList<String> getBodiesNamesSorted(AggregatorImpl aggregator) {
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < aggregator.countSubEntities(); i++) {
            AstralBody astralBody = aggregator.getSubEntity(i);
            names.add(astralBody.getName());
            if (astralBody instanceof Planet) {
                for (int j = 0; j < ((Planet) astralBody).countSubEntities(); j++)
                    names.add(astralBody.getName());
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

    public ArrayList<String> getBodiesNamesWithLifeSorted(AggregatorImpl aggregator, double minMass, double maxMass,
                                                          double minDensity, double maxDensity,
                                                          double minDiameter, double maxDiameter) {
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < aggregator.countSubEntities(); i++) {
            AstralBody astralBody = aggregator.getSubEntity(i);
            if (astralBody.getMass() >= minMass && astralBody.getMass() <= maxMass &&
                    astralBody.getDensity() >= minDensity && astralBody.getDensity() <= maxDensity &&
                    astralBody.getDiameter() >= minDiameter && astralBody.getDiameter() <= maxDiameter)
                names.add(astralBody.getName());
            if (astralBody instanceof Planet) {
                for (int j = 0; j < ((Planet) astralBody).countSubEntities(); j++)
                    if (astralBody.getMass() >= minMass && astralBody.getMass() <= maxMass &&
                            astralBody.getDensity() >= minDensity && astralBody.getDensity() <= maxDensity &&
                            astralBody.getDiameter() >= minDiameter && astralBody.getDiameter() <= maxDiameter)
                        names.add(astralBody.getName());
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