package task.object.hierarchy;

/**
 * Created by P1A-7CK on 30.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        StarSystem sunSystem = new StarSystem("Sun System");
        sunSystem.addStar("Sun");
        sunSystem.addPlanet("Earth");
        sunSystem.getPlanet("Earth").addSatellite("Moon");

        System.out.println(sunSystem);

        StarSystem pseudoSystem;
        EntityFactory entityFactory = new EntityFactory();

        pseudoSystem = entityFactory.generateSystem("Pseudo System");
        System.out.println(pseudoSystem);
    }
}
