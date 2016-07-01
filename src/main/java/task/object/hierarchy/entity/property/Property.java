package task.object.hierarchy.entity.property;

/**
 * Created by P1A-7CK on 01.07.2016.
 */
public interface Property {
    void setName(String name);
    String getName();
    <T> void setValue(T value);
    <T> T getValue();
    String toString();
}

