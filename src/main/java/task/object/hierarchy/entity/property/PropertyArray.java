package task.object.hierarchy.entity.property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class PropertyArray {
    private Map<String, Property> properties = new HashMap<String, Property>();

    public PropertyArray() {
    }

    public ArrayList<String> getNames() {
        return getNames("");
    }

    public ArrayList<String> getNames(String match) {
        ArrayList<String> names = new ArrayList<String>();

        for (Map.Entry<String, Property> entry : this.properties.entrySet()) {
            if (match.length() == 0 || entry.getKey().contains(match)) names.add(entry.getKey());
        }
        return names;
    }

    public ArrayList<String> getNamesValueIsNotNumeric() {
        return getNamesValueIsNotNumeric("");
    }

    public ArrayList<String> getNamesValueIsNotNumeric(String match) {
        ArrayList<String> names = new ArrayList<String>();

        for (Map.Entry<String, Property> entry : this.properties.entrySet()) {
            if (match.length() == 0 || entry.getKey().contains(match)) {
                System.out.println(entry.getValue().getValue().getClass());
            }
        }
        return names;
    }

    public <T> void addProperty(String name, T value) {
        if (!properties.containsKey(name)) {
            properties.put(name, new Property(value));
        } else {
            throw new IllegalArgumentException("Property with name '" + name + "' already exist");
        }
    }

    public <T> T getProperty(String name) {
        if (!properties.containsKey(name)) throw new IllegalArgumentException("Property with name '" + name + "' does not exist");
        return (T) properties.get(name).getValue();
    }

    public <T> void setProperty(String name, T value) {
        if (!properties.containsKey(name)) throw new IllegalArgumentException("Property with name '" + name + "' does not exist");
        properties.put(name, new Property(value));
    }

    public void removeProperty(String name) {
        if (!properties.containsKey(name)) throw new IllegalArgumentException("Property with name '" + name + "' does not exist");
        properties.remove(name);
    }

    @Override
    public String toString() {
        return "PropertyArray{" +
                "properties=" + properties +
                '}';
    }
}
