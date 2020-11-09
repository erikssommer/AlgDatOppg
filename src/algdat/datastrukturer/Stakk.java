package algdat.datastrukturer;

public interface Stakk<T> {
    public void leggInn(T verdi);

    public T kikk();

    public T taUt();

    public int antall();

    public boolean tom();

    public void nullstill();
}
