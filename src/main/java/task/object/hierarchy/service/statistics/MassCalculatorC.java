package task.object.hierarchy.service.statistics;

import task.object.hierarchy.entity.complex.Complex;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class MassCalculatorC extends StatisticsService{
    public MassCalculatorC() {
    }

    public double getMass(Complex complex) {
        MassCalculatorAB massCalculatorAB = new MassCalculatorAB();
        double mass = 0;
        for (int i = 0; i < complex.countStars(); i++) {
            mass += massCalculatorAB.getMass(complex.getStar(i));
        }
        for (int i = 0; i < complex.countPlanets(); i++) {
            mass += massCalculatorAB.getMass(complex.getPlanet(i));
        }
        return mass;
    }
}
