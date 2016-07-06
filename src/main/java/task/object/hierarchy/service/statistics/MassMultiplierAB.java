package task.object.hierarchy.service.statistics;

import task.object.hierarchy.entity.body.AstralBody;
import task.object.hierarchy.entity.body.Planet;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class MassMultiplierAB {
    public MassMultiplierAB() {
    }
/*
    public double multiplyMass(Object entity) {
        AstralBody astralBody = (AstralBody) entity;
        double mass = astralBody.getMass();
        if (!astralBody.isNoSatellitePossibility()) {
            for (int i = 0; i < astralBody.countSatellites(); i++) {
                mass += ((Planet) astralBody).getSatelliteMass(i);
            }
        }
        return mass;
    }
    */
}
