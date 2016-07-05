package task.object.hierarchy;

import task.object.hierarchy.entity.immitation.*;

/**
 * Created by P1A-7CK on 30.06.2016.
 */
public class Main {
    public static void main(String[] args) {

        task.object.hierarchy.entity.Body body = new BodyFactory().createRandomSystem(5, 7, 10, 8, 6);
        System.out.println(body);
        System.out.println("Total mass equals to " + body.getMass());

    }
}
