package task.object.hierarchy.entity;

import task.object.hierarchy.entity.body.AstralBody;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public interface AggregatorImpl {
    String getName();                                       // getting name
    void setName(String name);                              // setting name
    int countSubEntities();                                 // returns number of stars and planets
    void addSubEntity(int index, AstralBody subEntity);     // adding new star or planet
    void setSubEntity(int index, AstralBody subEntity);     // setting star or planet to created/updated object, maybe usefull in some cases
    void removeSubEntity(int index);                        // removing star or planet by index
    AstralBody getSubEntity(int index);                     // retrieving star or planet, so "setSubEntity" become useless
    double getMass();                                       // return mass-value of object and all child-objects
}
