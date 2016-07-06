package task.object.hierarchy.service;

import task.object.hierarchy.entity.body.Star.StarClassificator;

import java.util.Random;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class ClassificationFactory {
    public ClassificationFactory() {
    }

    public StarClassificator createRandomClassificator() {
        StarClassificator starClassificator = new StarClassificator();
        Random random = new Random();
        StarClassificator.SPECTRAL_CLASS[] spectralClass = StarClassificator.SPECTRAL_CLASS.values();
        StarClassificator.SIZE_PREFIX[] sizePrefices = StarClassificator.SIZE_PREFIX.values();
        StarClassificator.EMITION_SUFFIX[] emitionSuffices = StarClassificator.EMITION_SUFFIX.values();

        starClassificator.setSpectralClass(spectralClass[random.nextInt(16)]);
        starClassificator.setSizePrefix(sizePrefices[random.nextInt(8)]);
        starClassificator.setEmitionSuffix(emitionSuffices[random.nextInt(28)]);
        return starClassificator;
    }
}
