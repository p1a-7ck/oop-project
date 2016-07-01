package task.object.hierarchy.entity;

import task.object.hierarchy.entity.property.*;

import java.util.ArrayList;

/**
 * Created by P1A-7CK on 01.07.2016.
 */
public class BodyBase implements Body {
    Body parent;
    String name;
    ArrayList<Property> properties = new ArrayList<Property>();

    public BodyBase() {
    }

    public void setParent(Body parent) {
        this.parent = parent;
    }

    public Body getParent() {
        return parent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private <T> PropertyBase.PROPERTY_TYPE getValueType(T value) {
        if (value instanceof Long) {
            return PropertyBase.PROPERTY_TYPE.LONG;
        } else if (value instanceof String) {
            return PropertyBase.PROPERTY_TYPE.STRING;
        }
        return PropertyBase.PROPERTY_TYPE.OBJECT;
    }

    public Property addProperty(Property property) {
        if (getProperty(property.getName()) == null) {
            properties.add(property);
            return property;
        }
        return null;
    }

    public <T> Property addProperty(String name, T value) {
        if (getProperty(name) == null) {
            Property property = null;
            switch (getValueType(value)) {
                case LONG:
                    property = new PropertyLong();
                    break;
                case STRING:
                    property = new PropertyString();
                    break;
                case OBJECT:
                    property = new PropertyObject();
                    break;
            }
            if (property != null) {
                property.setName(name);
                property.setValue(value);
                properties.add(property);
                return property;
            }
        }
        return null;
    }

    public boolean delProperty(String name) {
        if (properties != null) {
            for (int i = 0; i < properties.size(); i++) {
                if (name.equals(properties.get(i).getName())) {
                    properties.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public Property getProperty(String name) {
        if (properties != null) {
            for (Property property : properties) {
                if (name.equals(property.getName())) return property;
            }
        }
        return null;
    }

    public Property getProperty(int arrayIndex) {
        if (properties != null) if (arrayIndex >=0 && arrayIndex < properties.size()) return properties.get(arrayIndex);
        return null;
    }

    public <T> boolean setPropertyValue(String name, T value) {
        Property property = getProperty(name);
        if (property != null) {
            if (getValueType(property.getValue()) == getValueType(value)) {
                property.setValue(value);
                return true;
            }
        }
        return false;
    }

    public <T> boolean setPropertyValue(int arrayIndex, T value) {
        Property property = getProperty(arrayIndex);
        if (property != null) {
            if (getValueType(property.getValue()) == getValueType(value)) {
                property.setValue(value);
                return true;
            }
        }
        return false;
    }

    public <T> T getPropertyValue(String name) {
        Property property = getProperty(name);
        if (property != null) return property.getValue();
        return null;
    }

    public <T> T getPropertyValue(int arrayIndex) {
        Property property = getProperty(arrayIndex);
        if (property != null) return property.getValue();
        return null;
    }

    public Body convertToComposite() {
        Body bodyComposite = new BodyComposite();
        bodyComposite.setName(name);
        Property property = null;
        for (int i = 0;; i++) {
            property = getProperty(i);
            if (property != null) {
                bodyComposite.addProperty(property);
            } else {
                break;
            }
        }
        if (parent != null) {
            Body bodyParent = parent;
            bodyParent.delBody(name);
            bodyParent.addBody(bodyComposite);
        }
        return bodyComposite;
    }

    public double getMass() {
        Property property = getProperty("MASS");
        if (property != null) {
            Long mass = property.getValue();
            return mass;
        }
        return 0;
    }

    protected String toStringProperties() {
        String o = "";

        if (properties != null) for (Property property : properties) o += property;
        return o;
    }

    @Override
    public String toString() {
        return "Body '" + this.name + "'\n" + toStringProperties();
    }

    // Override
    public Body addBody(Body body) { return null; }
    public Body addBody(String name) { return null; }
    public boolean delBody(String name) { return false; }
    public Body getBody(String name) { return null; }
    public Body getBody(int arrayIndex) { return null; }
    public Body convertToBase() { return null; }
}