package task.object.hierarchy.entity;

import task.object.hierarchy.entity.body.AstralBody;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public interface AggregatorImpl {
    String getName();
    void setName(String name);
    int countSubEntities();
    void addSubEntity(int index, AstralBody subEntity);
    void setSubEntity(int index, AstralBody subEntity);
    void removeSubEntity(int index);
    AstralBody getSubEntity(int index);
    double getMass();
}
