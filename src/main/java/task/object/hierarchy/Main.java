package task.object.hierarchy;

import task.object.hierarchy.entity.*;
import task.object.hierarchy.entity.Body;
import task.object.hierarchy.entity.immitation.*;
import task.object.hierarchy.entity.property.*;

/**
 * Created by P1A-7CK on 30.06.2016.
 */
public class Main {
    public static void main(String[] args) {

        task.object.hierarchy.entity.Body body = new BodyFactory().createRandomSystem(5, 7, 10, 8, 6);

        System.out.println(body);

        System.out.println("Total mass equals to " + body.getMass());

        /*
         *

        StarSystem sunSystem = new StarSystem("Sun System");
        sunSystem.addStar("Sun");
        sunSystem.addPlanet("Earth");
        sunSystem.getPlanet("Earth").addSatellite("Moon");

        System.out.println(sunSystem);

        StarSystem pseudoSystem;
        EntityFactory entityFactory = new EntityFactory();

        pseudoSystem = entityFactory.generateSystem("Pseudo System");
        System.out.println(pseudoSystem);
         */
    }
}
