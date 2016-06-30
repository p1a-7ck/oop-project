package task.object.hierarchy;

/**
 * Created by P1A-7CK on 30.06.2016.
 */
public class Star extends Body {
    public enum STELLAR_CLASS {UNKNOWN, O_CLASS, B_CLASS, A_CLASS, F_CLASS, G_CLASS, K_CLASS, M_CLASS, W_CLASS, L_CLASS, T_CLASS, Y_CLASS, C_CLASS, S_CLASS}

    private STELLAR_CLASS stellarClass = STELLAR_CLASS.UNKNOWN;

    public Star(String name) {
        super(name);
    }

    public void setStellarClass(STELLAR_CLASS stellarClass) { this.stellarClass = stellarClass; }
    public STELLAR_CLASS getStellarClass() { return stellarClass; }

    @Override
    public String toString() {
        return  "\nStar '" + super.getName() + "' (" + stellarClass + "):\n" +
                "(Mass) " + super.getMass() + "\t" +
                "(Diameter) " + super.getDiameter() + "\t" +
                "(Density) " + super.getDensity() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != getClass()) return false;
        Star star = (Star) obj;
        if (star.stellarClass != stellarClass) return false;
        Body body = (Body) obj;
        if (!super.equals(body)) return false;
        return true;
    }
}
