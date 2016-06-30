package task.object.hierarchy;

/**
 * Created by P1A-7CK on 30.06.2016.
 */
public class EntityAnalyzer {
    public String getStarSystemStatistics(StarSystem starSystem) {
        double mass = 0;
        int star_num = 0, planet_num = 0, satellite_num = 0, i = 0;
        String typeName;
        Star star;
        Planet planet;
        Satellite satellite;

        for (Object obj: starSystem.getAllBodies(StarSystem.BODY_TYPE.ALL, StarSystem.SORT_TYPE.NONE)) {
            typeName = obj.getClass().getName();
            if (typeName.equals("task.object.hierarchy.Star")) {
                star = (Star) obj;
                mass += star.getMass();
                star_num += 1;
            }
            if (typeName.equals("task.object.hierarchy.Planet")) {
                planet = (Planet) obj;
                mass += planet.getMass();
                planet_num += 1;
            }
            if (typeName.equals("task.object.hierarchy.Satellite")) {
                satellite = (Satellite) obj;
                mass += satellite.getMass();
                satellite_num += 1;
            }
        }
        return mass + " megatons, " + star_num + " stars, " + planet_num + " planets, " + satellite_num + " satellites";
    }
}
