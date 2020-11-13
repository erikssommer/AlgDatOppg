package algdat.diverse;

public class Familietre {
    public static final class Medlem {
        private String name;
        private Medlem parent;
        private Medlem left_child;
        private Medlem right_child;

        public Medlem(String name, Medlem parent, Medlem left_child, Medlem right_child){
            this.name = name;
            this.parent = parent;
            this.left_child = left_child;
            this.right_child = right_child;
        }

        public Medlem(String name){
            this(name, null, null, null);
        }

        public Medlem(String name, Medlem parent){
            this(name, parent, null, null);
        }
    }

    private Medlem rot;
    private int antall;

    public Familietre(String navn){
        rot = new Medlem(navn);
        antall = 1;
    }

    public void leggInn(Medlem medlem){
        if (medlem.parent.left_child == null){
            medlem.parent.left_child = medlem;
        }else if (medlem.parent.right_child == null){
            medlem.parent.right_child = medlem;
        }
    }

    public String finnOnkel(Medlem sibling){
        if (sibling.parent != null && sibling.parent.parent != null && sibling.parent.parent.left_child != null && sibling.parent.parent.left_child != sibling.parent) {
            return sibling.parent.parent.left_child.name;
        }else if (sibling.parent != null && sibling.parent.parent != null && sibling.parent.parent.right_child != null){
            return sibling.parent.parent.right_child.name;
        } else {
            return "Har ikke en onkel";
        }
    }

    private void inorden(Medlem medlem){
        if (medlem.left_child != null) inorden(medlem.left_child);
        System.out.print(medlem.name + ", ");
        if (medlem.right_child != null) inorden(medlem.right_child);
    }

    @Override
    public String toString(){
        inorden(rot);
        return "";
    }

    public static void main(String[] args) {
        Familietre familietre = new Familietre("Olga");
        Medlem hans = new Medlem("Hans", familietre.rot);
        familietre.leggInn(hans);

        Medlem sofia = new Medlem("Sofia", familietre.rot);
        familietre.leggInn(sofia);

        Medlem karl = new Medlem("Karl", hans);
        familietre.leggInn(karl);

        Medlem thea = new Medlem("Thea", sofia);
        familietre.leggInn(thea);

        System.out.println("Tanten til Karl er: " + familietre.finnOnkel(karl));
        System.out.println("Onkelen til Thea er: " + familietre.finnOnkel(thea));
        System.out.println("(inorden)" + familietre);
    }

}
