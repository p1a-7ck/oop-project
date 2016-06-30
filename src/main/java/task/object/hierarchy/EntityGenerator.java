package task.object.hierarchy;

import java.util.Random;

/**
 * Created by P1A-7CK on 30.06.2016.
 */
public class EntityGenerator {
    public StarSystem generateSystem(String name) {
        Random rn = new Random();
        Star star;
        Planet planet;
        Satellite satellite;

        StarSystem starSystem = new StarSystem(name);
        for (int i = 0; i <= rn.nextInt(3); i++) {
            star = starSystem.addStar(generateName());
            star.setMass(rn.nextDouble());
            star.setDiameter(rn.nextDouble());
            star.setDensity(rn.nextDouble());
            switch(rn.nextInt(14)) {
                case 0: star.setStellarClass(Star.STELLAR_CLASS.UNKNOWN);
                case 1: star.setStellarClass(Star.STELLAR_CLASS.O_CLASS);
                case 2: star.setStellarClass(Star.STELLAR_CLASS.B_CLASS);
                case 3: star.setStellarClass(Star.STELLAR_CLASS.A_CLASS);
                case 4: star.setStellarClass(Star.STELLAR_CLASS.F_CLASS);
                case 5: star.setStellarClass(Star.STELLAR_CLASS.G_CLASS);
                case 6: star.setStellarClass(Star.STELLAR_CLASS.K_CLASS);
                case 7: star.setStellarClass(Star.STELLAR_CLASS.M_CLASS);
                case 8: star.setStellarClass(Star.STELLAR_CLASS.W_CLASS);
                case 9: star.setStellarClass(Star.STELLAR_CLASS.L_CLASS);
                case 10: star.setStellarClass(Star.STELLAR_CLASS.T_CLASS);
                case 11: star.setStellarClass(Star.STELLAR_CLASS.Y_CLASS);
                case 12: star.setStellarClass(Star.STELLAR_CLASS.C_CLASS);
                case 13: star.setStellarClass(Star.STELLAR_CLASS.S_CLASS);
            }
        }
        for (int i = 0; i <= rn.nextInt(10); i++) {
            planet = starSystem.addPlanet(generateName());
            planet.setMass(rn.nextDouble());
            planet.setDiameter(rn.nextDouble());
            planet.setDensity(rn.nextDouble());
            planet.setHaveAir(rn.nextBoolean());
            planet.setHaveWater(rn.nextBoolean());
            planet.setHaveLand(rn.nextBoolean());
            planet.setHaveLife(rn.nextBoolean());
            for (int j = 0; j <= rn.nextInt(5); j++) {
                satellite = planet.addSatellite(generateName());
                satellite.setMass(rn.nextDouble());
                satellite.setDiameter(rn.nextDouble());
                satellite.setDensity(rn.nextDouble());
                satellite.setHaveAir(rn.nextBoolean());
                satellite.setHaveWater(rn.nextBoolean());
                satellite.setHaveLand(rn.nextBoolean());
                satellite.setHaveLife(rn.nextBoolean());
            }
        }
        return starSystem;
    }

    private String generateName() {
        Random rn = new Random();
        int c = 0, v = 0, l = rn.nextInt(7) + 4;
        String[] cw = {"B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V", "W", "X", "Z"};
        String[] vw = {"A", "E", "I", "O", "U", "Y"};
        String o;

        if (rn.nextBoolean()) { o = vw[rn.nextInt(6)]; v += 1; } else { o = cw[rn.nextInt(20)]; c += 1;}
        o.toUpperCase();
        for (int i = 0; i < l; i++) {
            if (rn.nextBoolean()) {
                v += 1;
                if ( v > 2) {
                    v = 0; c += 1;
                    o += cw[rn.nextInt(20)];
                } else {
                    c = 0;
                    o += vw[rn.nextInt(6)];
                }
            } else {
                c += 1;
                if ( c > 2) {
                    c = 0; v += 1;
                    o += vw[rn.nextInt(6)];
                } else {
                    v = 0;
                    o += cw[rn.nextInt(20)];
                }
            }
        }
        return o;
    }
}
