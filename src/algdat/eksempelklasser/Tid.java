package algdat.eksempelklasser;

import java.util.Objects;

public class Tid implements Comparable<Tid>{
    private Klokkeslett klokkeslett;
    private Dato dato;

    public Tid(Klokkeslett klokkeslett, Dato dato){
        this.klokkeslett = klokkeslett;
        this.dato = dato;
    }

    @Override
    public String toString() {
        return klokkeslett.toString() + " , " + dato.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tid)) return false;
        Tid tid = (Tid) o;
        return klokkeslett.equals(tid.klokkeslett) &&
                dato.equals(tid.dato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(klokkeslett, dato);
    }

    @Override
    public int compareTo(Tid o) {
        if (o.dato.compareTo(dato) > 0 ){
            return 1;
        }else if (o.klokkeslett.compareTo(klokkeslett) > 0){
            return 1;
        } else {
            return -1;
        }
    }
}
