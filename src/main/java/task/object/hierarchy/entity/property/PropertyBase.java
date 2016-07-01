package task.object.hierarchy.entity.property;

/**
 * Created by P1A-7CK on 01.07.2016.
 */
public class PropertyBase implements Property {
    public enum PROPERTY_TYPE {LONG, STRING, OBJECT}
    private String name;

    public PropertyBase() { }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public <T> void setValue(T value) { }
    public <T> T getValue() { return null; }
}
