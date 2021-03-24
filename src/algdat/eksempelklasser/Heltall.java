package algdat.eksempelklasser;

import java.util.Objects;

public final class Heltall implements Comparable<Heltall>{

    private final int verdi;

    public Heltall(int verdi) {
        this.verdi = verdi;
    }

    public int intVerdi(){
        return verdi;
    }

    @Override
    public int compareTo(Heltall h) {
        /*
         * if (verdi < h.verdi) return -1;
         * else if (verdi == h.verdi) return 0;
         * else return 1;
         */
        return Integer.compare(verdi, h.verdi);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Heltall)) return false;
        return verdi == ((Heltall)o).verdi;
    }

    public boolean equals(Heltall h){
        return verdi == h.verdi;
    }

    @Override
    public int hashCode() {
        return 31 + verdi;
    }

    @Override
    public String toString() {
        return Integer.toString(verdi);
    }
}
