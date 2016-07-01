package task.object.hierarchy.entity.property;

/**
 * Created by P1A-7CK on 01.07.2016.
 */
public class PropertyLong extends PropertyBase implements Property {
    Long value; // TODO get how to use primitives in generic types

    public PropertyLong() {
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getName() {
        return super.getName();
    }

    @Override
    public <T> void setValue(T value) {
        Long valueLong = (Long) value;
        if (valueLong < 0) valueLong *= -1;
        if (valueLong <= 0 || valueLong >= Long.MAX_VALUE)
            throw new IndexOutOfBoundsException("Property value should be in a range form 0 to " + Long.MAX_VALUE);
        this.value = valueLong;
    }

    @Override
    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Property '" + super.getName() + "' = (Long) " + value + "\n";
    }
}