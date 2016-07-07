package task.star.system.model;

import task.star.system.model.entity.Star;

/**
 * Created by P1A-7CK on 07.07.2016.
 */
public interface IChangeableStarClass {
    Star.SPECTRAL_CLASS getSpectralClass();

    void setSpectralClass(Star.SPECTRAL_CLASS spectralClass);

    Star.SIZE_PREFIX getSizePrefix();

    void setSizePrefix(Star.SIZE_PREFIX sizePrefix);

    Star.EMITION_SUFFIX getEmitionSuffix();

    void setEmitionSuffix(Star.EMITION_SUFFIX emitionSuffix);

    String getClassificationName();
}
