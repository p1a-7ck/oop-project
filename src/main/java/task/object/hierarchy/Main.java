package task.object.hierarchy;

import task.object.hierarchy.entity.*;
import task.object.hierarchy.entity.property.*;

/**
 * Created by P1A-7CK on 30.06.2016.
 */
public class Main {
    public static void main(String[] args) {

        task.object.hierarchy.entity.Body body = new BodyBase();

        body.setName("Sun");
        body.addProperty("Mass", 5987345L);

        System.out.println(body);

        body.delProperty("Mass");
        body.addProperty("Class", "SUPERNOVA");

        System.out.println(body);



        //ParameterDouble parameterDouble = new ParameterDouble("name");

        //parameterDouble.setValue(0.0);

        //System.out.println(parameterDouble);

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
