package algdat.eksamen.h18ord;

public class Oppgave1 {
    /*
     * a)
     * Preorden: F C A B D E I H G J
     * Inorden: A B C D E F G H I J
     * Postorden: B A E D C G H J I F
     */

    /*
     * b)
     * En rekursiv metode er enkelt og greit en metode som kaller på seg selv. Poenget med rekursive metoder er å
     * dele problemet opp i mindre oppgaver. Det er viktig å ha et basistilfelle slik at det ikke blir uendelig mange
     * kall på metoden
     *
     */

    /*
     * c)
     */

    public static class BTNode {
        BTNode left_child;
        BTNode right_child;
        char value;

        /**
         * Konstruktør som lager en ny node
         *
         * @param value Verdien dene noden skal ha
         */
        BTNode(char value) {
            this.value = value;
        }

        /**
         * Legger til en ny verdi i det binære treet
         *
         * @param value Verdien å legge til
         */
        void add(char value) {
            if (value < this.value) {
                if (this.left_child != null) {
                    this.left_child.add(value);
                } else {
                    this.left_child = new BTNode(value);
                }
            } else {
                if (this.right_child != null) {
                    this.right_child.add(value);
                } else {
                    this.right_child = new BTNode(value);
                }
            }
        }

        /**
         * Skriver ut inorden ved hjelp av rekursjon
         */
        public void printInOrder(BTNode node) {
            if (node.left_child != null) printInOrder(node.left_child);
            System.out.print(node.value + " ");
            if (node.right_child != null) printInOrder(node.right_child);
        }

    }

    public static void main(String[] args) {
        BTNode root = new BTNode('F');
        char values[] = "CIADHJBEG".toCharArray();
        for (char val : values) {
            root.add(val);
        }
        root.printInOrder(root);
    }

    /*
     * d)
     * Du kan skrive ut treet i inorden uten bruk av rekursjon ved itterasjon og bruk av en stakk (stack) og kjøre
     * en while-løkke så lenge stakken ikke er tom
     *
     */

}
