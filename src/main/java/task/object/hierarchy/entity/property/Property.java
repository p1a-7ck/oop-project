package task.object.hierarchy.entity.property;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class Property<T> {
    private T value;

    public Property(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}