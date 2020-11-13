package algdat.diverse;

import java.util.Arrays;

public class Familietre {
    public static final class Medlem { // Gjort indre klasse public for enkelhets skyld
        private final String navn;
        private final Medlem forelder;
        private Medlem venstre_barn;
        private Medlem hoyre_barn;

        public Medlem(String navn, Medlem forelder, Medlem venstre_barn, Medlem hoyre_barn){
            this.navn = navn;
            this.forelder = forelder;
            this.venstre_barn = venstre_barn;
            this.hoyre_barn = hoyre_barn;
        }

        public Medlem(String navn){
            this(navn, null, null, null);
        }

        public Medlem(String navn, Medlem forelder){
            this(navn, forelder, null, null);
        }
    }

    private final Medlem rot;
    private int antall;

    public Familietre(String navn){
        rot = new Medlem(navn);
        antall = 1;
    }

    public void leggInn(Medlem medlem){
        if (medlem.forelder.venstre_barn == null){
            medlem.forelder.venstre_barn = medlem;
            antall++;
        }else if (medlem.forelder.hoyre_barn == null){
            medlem.forelder.hoyre_barn = medlem;
            antall++;
        }
    }

    public Medlem rotMedlem(){
        return rot;
    }

    public int antallMedlemmer(){
        return antall;
    }

    public String finnOnkel(Medlem sibling){
        if (sibling.forelder != null && sibling.forelder.forelder != null && sibling.forelder.forelder.venstre_barn != null && sibling.forelder.forelder.venstre_barn != sibling.forelder) {
            return sibling.forelder.forelder.venstre_barn.navn;
        }else if (sibling.forelder != null && sibling.forelder.forelder != null && sibling.forelder.forelder.hoyre_barn != null){
            return sibling.forelder.forelder.hoyre_barn.navn;
        } else {
            return sibling.navn + " har ikke en onkel";
        }
    }

    public String finnSosken(Medlem medlem){
        if (medlem.forelder.venstre_barn == medlem && medlem.forelder.hoyre_barn != null){
            return medlem.forelder.hoyre_barn.navn;
        }else if (medlem.forelder.hoyre_barn == medlem && medlem.forelder.venstre_barn != null){
            return medlem.forelder.venstre_barn.navn;
        }else {
            return medlem.navn + " har ikke søsken";
        }
    }

    public String finnBarn(Medlem medlem){
        String barn = "";
        if (medlem.venstre_barn != null){
            barn += medlem.venstre_barn.navn + " ";
        }
        if (medlem.hoyre_barn != null){
            barn += medlem.hoyre_barn.navn;
        }

        return barn.equals("") ? "har ingen barn" : barn;
    }

    private void inorden(Medlem medlem){
        if (medlem.venstre_barn != null) inorden(medlem.venstre_barn);
        System.out.print(medlem.navn + ", ");
        if (medlem.hoyre_barn != null) inorden(medlem.hoyre_barn);
    }

    @Override
    public String toString(){
        inorden(rot);
        return "";
    }

    public static void main(String[] args) {
        Familietre familietre = new Familietre("Olga");

        Medlem hans = new Medlem("Hans", familietre.rotMedlem());
        familietre.leggInn(hans);

        Medlem sofia = new Medlem("Sofia", familietre.rotMedlem());
        familietre.leggInn(sofia);

        Medlem karl = new Medlem("Karl", hans);
        familietre.leggInn(karl);

        Medlem thea = new Medlem("Thea", sofia);
        familietre.leggInn(thea);

        Medlem mari = new Medlem("Mari", karl);
        familietre.leggInn(mari);

        Medlem petter = new Medlem("Petter", sofia);
        familietre.leggInn(petter);

        Medlem tobias = new Medlem("Tobias", hans);
        familietre.leggInn(tobias);

        System.out.println("Tanten til Karl er: " + familietre.finnOnkel(karl));
        System.out.println("Onkelen til Thea er: " + familietre.finnOnkel(thea));
        System.out.println("Onkelen til Hans er: " + familietre.finnOnkel(hans));
        System.out.println("Onelen til Mari er: " + familietre.finnOnkel(mari));
        System.out.println("Onelen til Petter er: " + familietre.finnOnkel(petter));
        System.out.println("Tanten til Tobias er: " + familietre.finnOnkel(tobias));
        System.out.println("Tobias sitt søsken: " + familietre.finnSosken(tobias));
        System.out.println("Karl sitt søsken: " + familietre.finnSosken(karl));
        System.out.println("Olga sine barn er: " + familietre.finnBarn(familietre.rotMedlem()));
        System.out.println("Tobias sine barn er: " + familietre.finnBarn(tobias));
        System.out.println("Familien har: " + familietre.antallMedlemmer() + " medlemmer");
        System.out.println("(inorden)" + familietre);
    }

}
