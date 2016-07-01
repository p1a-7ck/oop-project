package task.object.hierarchy.entity.immitation;

import task.object.hierarchy.entity.*;

import java.util.Random;

/**
 * Created by P1A-7CK on 01.07.2016.
 */
public class BodyFactory {

    public Body createRandomSystem(int minValue, int maxStar, int maxPlanet, int maxSatellite, int maxProperty) {
        Random rn = new Random();
        Body starSystem = new BodyComposite(), star = null, planet = null, satellite = null;

        starSystem.setName("Star System");
        for (int s = 0; s < rn.nextInt(maxStar - minValue) + minValue; s++) {
            star = starSystem.addBody(generateName(5));
            if (star != null) {
                star.addProperty("TYPE", "STAR");
                star.addProperty("MASS", rn.nextLong());
                for (int m = 0; m < rn.nextInt(maxProperty); m++) star.addProperty(generateName(5), generateName(15));
            }
        }
        if (star == null) star = starSystem.getBody(0);
        if (star != null) {
            star = star.convertToComposite();
            for (int p = 0; p < rn.nextInt(maxPlanet - minValue) + minValue; p++) {
                planet = star.addBody(generateName(5));
                if (planet != null) {
                    planet = planet.convertToComposite();
                    planet.addProperty("TYPE", "PLANET");
                    planet.addProperty("MASS", rn.nextLong());
                    for (int m = 0; m < rn.nextInt(maxProperty - minValue) + minValue; m++) planet.addProperty(generateName(5), generateName(15));
                    for (int s = 0; s < rn.nextInt(maxSatellite - minValue) + minValue; s++) {
                        satellite = planet.addBody(generateName(5));
                        if (satellite != null) {
                            satellite.addProperty("TYPE", "SATELLITE");
                            satellite.addProperty("MASS", rn.nextLong());
                            for (int m = 0; m < rn.nextInt(maxProperty); m++) satellite.addProperty(generateName(5), generateName(15));
                        }
                    }
                }
            }
        }
        return starSystem;
    }

    private String generateName(int maxSize) {
        Random rn = new Random();
        int c = 0, v = 0, l = rn.nextInt(maxSize - 1) + 1;
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
