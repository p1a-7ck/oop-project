package task.star.system.model;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public interface IAggregator extends ICompoundableEntity {
    String getName();

    void setName(String name);

    double getMass();
}
