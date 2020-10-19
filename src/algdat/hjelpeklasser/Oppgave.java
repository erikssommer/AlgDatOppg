package algdat.hjelpeklasser;

@FunctionalInterface
public interface Oppgave<T> {
    void utforOppgave(T t);

    public static <T> Oppgave<T> konsollutskrift(){
        return t -> System.out.print(t + " ");
    }

    default Oppgave<T> deretter(Oppgave<? super T> oppgave){
        return t -> {
            utforOppgave(t);
            oppgave.utforOppgave(t);
        };
    }
}
