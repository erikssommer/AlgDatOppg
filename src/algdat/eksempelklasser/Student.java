package algdat.eksempelklasser;

public class Student extends Person{
    private final Studium studium;

    public Student(String fornavn, String etternavn, Studium studium) {
        super(fornavn, etternavn);
        this.studium = studium;
    }

    public Studium studium(){
        return studium;
    }

    @Override
    public String toString() {
        return super.toString() + " " + studium.name();
    }
}
