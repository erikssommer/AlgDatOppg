package algdat.eksempelklasser;

import java.time.Month;

public enum Maned {
    JAN(1, "Januar"),
    FEB(2, "Februar"),
    MAR(3, "Mars"),
    APR(4, "April"),
    MAI(5, "Mai"),
    JUN(6, "Juni"),
    JUL(7, "Juli"),
    AUG(8, "August"),
    SEP(9, "September"),
    OKT(10, "Oktober"),
    NOV(11, "November"),
    DES(12, "Desember");

    private final int mndnr;
    private final String fulltnavn;

    private Maned(int mndnr, String fulltnavn){
        this.mndnr = mndnr;
        this.fulltnavn = fulltnavn;
    }

    public int mndnr(){
        return mndnr;
    }

    public String fulltnavn(){
        return fulltnavn;
    }

    public static String toString(int mnd){
        return switch (mnd) {
            case 1 -> JAN.fulltnavn();
            case 2 -> FEB.fulltnavn();
            case 3 -> MAR.fulltnavn();
            case 4 -> APR.fulltnavn();
            case 5 -> MAI.fulltnavn();
            case 6 -> JUN.fulltnavn();
            case 7 -> JUL.fulltnavn();
            case 8 -> AUG.fulltnavn();
            case 9 -> SEP.fulltnavn();
            case 10 -> OKT.fulltnavn();
            case 11 -> NOV.fulltnavn();
            case 12 -> DES.fulltnavn();
            default -> throw new IllegalArgumentException("Måneden er ikke definert utenfor 1 og 12");
        };
    }

    public static Maned[] sommer(){
        return new Maned[]{JUN, JUL, AUG};
    }

    public static Maned[] vinter(){
        return new Maned[]{NOV, DES, JAN, FEB, MAR};
    }

    public static Maned[] host(){
        return new Maned[]{SEP, OKT};
    }

    public static Maned[] var(){
        return new Maned[]{APR, MAI};
    }

    @Override
    public String toString() {
        return fulltnavn;
    }
}
