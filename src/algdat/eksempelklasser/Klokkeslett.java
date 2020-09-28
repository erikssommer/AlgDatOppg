package algdat.eksempelklasser;

import java.util.Objects;

public class Klokkeslett implements Comparable<Klokkeslett> {

    private String tid;

    public Klokkeslett(String tid){
        this.tid = tid;
    }

    @Override
    public String toString() {
        return tid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Klokkeslett)) return false;
        Klokkeslett that = (Klokkeslett) o;
        return Objects.equals(tid, that.tid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid);
    }

    @Override
    public int compareTo(Klokkeslett o) {
        if (o.tid.equals(tid)){
            return 1;
        }else {
            return -1;
        }
    }
}
