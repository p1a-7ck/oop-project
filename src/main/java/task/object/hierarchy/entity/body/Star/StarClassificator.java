package task.object.hierarchy.entity.body.Star;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class StarClassificator {
    public enum SPECTRAL_CLASS {O, B, A, F, G, K, M, W, L, T, Y, C, S, D, Q, P}
    public enum SIZE_PREFIX {d, esd, c, g, sg, sd, w, wd}
    public enum EMITION_SUFFIX {c, comp, con, e, em, ep ,er, eq, ev, ew, f, h, ha, k, m, n, neb, nn, p, pq, s, sh, ss, v, var, w, wk, wl}

    private SPECTRAL_CLASS spectralClass;
    private SIZE_PREFIX sizePrefix;
    private EMITION_SUFFIX emitionSuffix;

    public StarClassificator() {
    }

    public SPECTRAL_CLASS getSpectralClass() {
        return spectralClass;
    }

    public void setSpectralClass(SPECTRAL_CLASS spectralClass) {
        this.spectralClass = spectralClass;
    }

    public SIZE_PREFIX getSizePrefix() {
        return sizePrefix;
    }

    public void setSizePrefix(SIZE_PREFIX sizePrefix) {
        this.sizePrefix = sizePrefix;
    }

    public EMITION_SUFFIX getEmitionSuffix() {
        return emitionSuffix;
    }

    public void setEmitionSuffix(EMITION_SUFFIX emitionSuffix) {
        this.emitionSuffix = emitionSuffix;
    }

    public String getClassificationName() {
        return this.sizePrefix.toString() + this.spectralClass.toString() + this.emitionSuffix.toString();
    }
}
