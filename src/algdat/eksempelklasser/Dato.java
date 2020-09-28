package algdat.eksempelklasser;

import java.util.Objects;

public class Dato implements Comparable<Dato> {
    private final int dag, mnd, år;

    public Dato(int dag, int mnd, int år) {
        this.dag = dag;
        this.mnd = mnd;
        this.år = år;
    }

    public int compareTo(Dato d) {
        if (år < d.år) return -1;
        else if (år > d.år) return 1;
        else if (mnd < d.mnd) return -1;
        else if (mnd > d.mnd) return 1;
        else return dag - d.dag;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Dato)) return false;
        return compareTo((Dato) o) == 0;
    }

    public String toString() {
        return "" + dag + '/' + mnd + '-' + år;
    }

    public int hashCode() {
        return Objects.hash(dag, mnd, år);
    }
}
