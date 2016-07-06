package task.object.hierarchy.entity.body.Star;

import task.object.hierarchy.entity.body.AstralBody;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class Star extends AstralBody {
    private StarClassificator starClassificator = new StarClassificator();

    public Star() {
    }

    public StarClassificator getStarClassificator() {
        return starClassificator;
    }

    public void setStarClassificator(StarClassificator starClassificator) {
        this.starClassificator = starClassificator;
    }

    @Override
    public String toString() {
        return "Star{" +
                "name='" + super.getName() + '\'' +
                ", starClassificator=" + starClassificator +
                ", mass=" + super.getMass() +
                ", density=" + super.getDensity() +
                ", diameter=" + super.getDiameter() +
                ", distanceFromCenter=" + super.getDistanceFromCenter() +
                ", propertyArray=" + super.getPropertyArray() +
                '}';

    }
}
