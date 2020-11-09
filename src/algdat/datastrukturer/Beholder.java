package algdat.datastrukturer;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

public interface Beholder<T> extends Iterable<T> {
    public boolean leggInn(T verdi);

    public boolean inneholder(T verdi);

    public boolean fjern(T verdi);

    public int antall();

    public boolean tom();

    public void nullstill();

    public Iterator<T> iterator();

    default boolean fjernHvis(Predicate<? super T> p) {
        Objects.requireNonNull(p);

        boolean fjernet = false;
        for (Iterator<T> i = iterator(); i.hasNext(); ) {
            if (p.test(i.next())) {
                i.remove();
                fjernet = true;
            }
        }
        return fjernet;
    }
}
