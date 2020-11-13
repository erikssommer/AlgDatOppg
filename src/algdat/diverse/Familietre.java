package algdat.diverse;

public class Familietre {
    public static final class Node{
        private String name;
        private Node parent;
        private Node left_child;
        private Node right_child;

        public Node(String name, Node parent, Node left_child, Node right_child){
            this.name = name;
            this.parent = parent;
            this.left_child = left_child;
            this.right_child = right_child;
        }

        public Node(String name){
            this(name, null, null, null);
        }

        public Node(String name, Node parent){
            this(name, parent, null, null);
        }
    }

    private Node rot;
    private int antall;

    public Familietre(String navn){
        rot = new Node(navn);
        antall = 1;
    }

    public void leggInn(String name, Node parent){
        if (parent.left_child == null){
            parent.left_child = new Node(name, parent);
        }else if (parent.right_child == null){
            parent.right_child = new Node(name, parent);
        }
    }

    public String finnOnkel(Node sibling){
        if (sibling.parent != null && sibling.parent.parent != null && sibling.parent.parent.left_child != null && sibling.parent.parent.left_child != sibling.parent) {
            return sibling.parent.parent.left_child.name;
        }else if (sibling.parent != null && sibling.parent.parent != null && sibling.parent.parent.right_child != null){
            return sibling.parent.parent.right_child.name;
        } else {
            return "Har ikke en onkel";
        }
    }

    private void inorden(Node node){
        if (node.left_child != null) inorden(node.left_child);
        System.out.println(node.name);
        if (node.right_child != null) inorden(node.right_child);
    }

    @Override
    public String toString(){
        inorden(rot);
        return "";
    }

    public static void main(String[] args) {
        Familietre familietre = new Familietre("Olga");
        familietre.leggInn("Hans", familietre.rot);
        familietre.leggInn("Sofia", familietre.rot);
        familietre.leggInn("Karl", familietre.rot.left_child);
        familietre.leggInn("Thea", familietre.rot.right_child);
        familietre.leggInn("Markus", familietre.rot.right_child.left_child);

        System.out.println("Tanten til Karl er: " + familietre.finnOnkel(familietre.rot.left_child.left_child));
        System.out.println("Onkelen til Thea er: " + familietre.finnOnkel(familietre.rot.right_child.left_child));
        System.out.println(familietre);
    }

}
