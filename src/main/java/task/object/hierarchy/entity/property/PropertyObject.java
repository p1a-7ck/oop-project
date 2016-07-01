package task.object.hierarchy.entity.property;

/**
 * Created by P1A-7CK on 01.07.2016.
 */
public class PropertyObject extends PropertyBase implements Property {
    Object value;

    public PropertyObject() { }

    public void setName(String name) {
        super.setName(name);
    }

    public String getName() {
        return super.getName();
    }

    @Override
    public <T> void setValue(T value) {
        Object valueObject = (Object) value;
        this.value = valueObject;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Property '" + super.getName() + "' = (Object) " + value + "\n";
    }
}