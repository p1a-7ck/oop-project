package task.object.hierarchy.entity.property;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class PropertyArray {
    private Map<String, Property> properties = new HashMap<String, Property>();

    public PropertyArray() {
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
}
