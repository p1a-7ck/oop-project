package task.object.hierarchy.entity;

import task.object.hierarchy.entity.body.AstralBody;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public interface EntityComplexImpl {
    boolean haveSubEntities();                          // signaling that object could have child, overrided in Planet by returning true
    int countSubEntities();                             // returning number of children
    void addSubEntity(int index, AstralBody subEntity); // adding child it could be Star or Planet for Aggregator, and satellite for Planet
    void setSubEntity(int index, AstralBody subEntity); // setting child by index
    void removeSubEntity(int index);                    // removing child by index
    AstralBody getSubEntity(int index);                 // getting astral body it could be Star, Planet or Satellite depends on Parent-object
}
