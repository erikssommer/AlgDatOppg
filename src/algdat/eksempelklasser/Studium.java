package algdat.eksempelklasser;

public enum Studium {
    Data ("Ingeniørfag - data"),
    IT ("Informasjonsteknologi"),
    Anvendt ("Anvendt datateknologi"),
    Elektro ("Ingeniørfag - elektronikk og informasjonsteknologi"),
    Enkeltemne ("Enkeltemnestudent");

    private final String fulltnavn;

    private Studium(String fulltnavn){
        this.fulltnavn = fulltnavn;
    }

    @Override
    public String toString() {
        return fulltnavn;
    }
}
