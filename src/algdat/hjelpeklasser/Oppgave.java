package algdat.hjelpeklasser;

@FunctionalInterface
public interface Oppgave<T> {
    void utforOppgave(T t);
}
