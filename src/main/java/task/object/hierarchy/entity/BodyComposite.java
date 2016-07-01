package task.object.hierarchy.entity;

import task.object.hierarchy.entity.property.*;

import java.util.ArrayList;

/**
 * Created by P1A-7CK on 01.07.2016.
 */
public class BodyComposite extends BodyBase implements Body {
    ArrayList<Body> bodies = new ArrayList<Body>();

    public BodyComposite() { }

    @Override
    public Body addBody(Body body) {
        if (getBody(body.getName()) == null) {
            bodies.add(body);
            if (body.getParent() != null) body.getParent().delBody(body.getName());
            body.setParent(this);
            return body;
        }
        return null;
    }

    @Override
    public Body addBody(String name) {
        if (getBody(name) == null) {
            Body body = new BodyBase();
            body.setName(name);
            bodies.add(body);
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
    public Body convertToBase() {
        if (bodies == null) {
            if (bodies.size() == 0) {
                Body bodyBase = new BodyBase();
                bodyBase.setName(super.name);
                Property property;
                for (int i = 0;; i++) {
                    property = super.getProperty(i);
                    if (property != null) {
                        bodyBase.addProperty(property);
                        break;
                    }
                }
                if (super.parent != null) {
                    super.parent.delBody(super.name);
                    super.parent.addBody(bodyBase);
                }
                return bodyBase;
            }
        }
        return null;
    }

    @Override
    public double getMass() {
        double massAll = 0;
        Long mass;

        Property property = getProperty("MASS");
        if (property != null) {
            mass = property.getValue();
            massAll = mass;
        }
        if (bodies != null) for (Body body : bodies) massAll += body.getMass();
        return massAll;
    }

    protected String toStringBodies() {
        String o = "";

        if (bodies != null) for (Body body : bodies) o += super.name + "/" + body;
        return o;
    }

    @Override
    public String toString() {
        return "Body Composite '" + this.name + "'\n" + super.toStringProperties() + toStringBodies();
    }

}