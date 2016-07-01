package task.object.hierarchy.entity;

import java.util.ArrayList;

/**
 * Created by P1A-7CK on 01.07.2016.
 */
public class BodyComposite extends BodyBase implements Body, BodySystem {
    ArrayList<Body> bodies = new ArrayList<Body>();

    public BodyComposite() { }

    @Override
    public Body addBody(Body body) {
        if (getBody(body.getName()) == null) {
            bodies.add(body);
            body.getParent().delBody(body.getName());
            body.setParent(this);
            return body;
        }
        return null;
    }

    @Override
    public boolean delBody(String name) {
        if (bodies != null) {
            for (int i = 0; i < bodies.size(); i++) {
                if (name.equals(bodies.get(i).getName())) {
                    bodies.get(i).setParent(null);
                    bodies.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Body getBody(String name) {
        if (bodies != null) {
            for (Body body : bodies) {
                if (name.equals(body.getName())) return body;
            }
        }
        return null;
    }

    @Override
    public Body getBody(int arrayIndex) {
        if (bodies != null && arrayIndex >=0 && arrayIndex < bodies.size()) return bodies.get(arrayIndex);
        return null;
    }

    @Override
    public Body convertToComposite(Body body) {
        return null; //TODO cloning issue
    }

    @Override
    public Body convertToComposite(String name) {
        return null; //TODO cloning issue
    }

    @Override
    public Body convertToBase(Body body) {
        return null; //TODO cloning issue
    }

    @Override
    public Body convertToBase(String name) {
        return null; //TODO cloning issue
    }
}