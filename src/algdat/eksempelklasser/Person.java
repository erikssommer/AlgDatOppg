package algdat.eksempelklasser;

import java.util.Objects;

public class Person implements Comparable<Person>{
    private final String fornavn;
    private final String etternavn;

    public Person(String fornavn, String etternavn){
        if (fornavn == null) throw new NullPointerException("Fornavnet er tomt");
        if (etternavn == null) throw new NullPointerException("Etternavnet er tomt");
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public String fornavn(){
        return fornavn;
    }

    public String etternavn(){
        return etternavn;
    }

    @Override
    public int compareTo(Person p) {
        int cmp = etternavn.compareTo(p.etternavn);
        if (cmp != 0){
            return cmp;
        }
        return fornavn.compareTo(p.fornavn);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        return compareTo((Person)o) == 0;
    }

    //Mer direkte versjon av equals
    public boolean equals(Person p){
        if (p == null) return false;
        if (this == p) return true;
        return (p.fornavn.equals(fornavn) && p.etternavn.equals(etternavn));
    }

    @Override
    public int hashCode() {
        return Objects.hash(fornavn, etternavn);
    }

    @Override
    public String toString() {
        return fornavn + " " + etternavn;
    }
}
