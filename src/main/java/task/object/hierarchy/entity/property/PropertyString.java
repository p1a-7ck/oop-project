package task.object.hierarchy.entity.property;

/**
 * Created by P1A-7CK on 01.07.2016.
 */
public class PropertyString extends PropertyBase implements Property {
    String value;

    public PropertyString() { }

    public void setName(String name) {
        super.setName(name);
    }

    public String getName() {
        return super.getName();
    }

    @Override
    public <T> void setValue(T value) {
        String valueString = (String) value;
        if (valueString.length() > 255) throw new IllegalArgumentException("Property value string should be less than 255 characters");
        this.value = valueString;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Property '" + super.getName() + "' = (String) " + value + "\n";
    }
}
