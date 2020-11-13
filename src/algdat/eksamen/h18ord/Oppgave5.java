package algdat.eksamen.h18ord;

public class Oppgave5 {
    /*
     * Dobbelt lenket liste
     *
     * a)
     * Utskirft:
     * A,B,C,D,E,F,G,H,I
     * B,D,E,G,H,I
     * IndexOutOfBounceExeption(indeksen er utenfor listespennet)
     * B,D,E,G,H,I
     */

    /*
     * b) Kodet metoden remove(Medlem q)
     */

    /*
     * c) Kodet metoden remove(int index)
     */

    /**
     * Klasse som representerer en dobbelt lenket liste
     */
    public static class DoubleLinkedList {
        int size;
        Node start;
        Node end;

        /**
         * Klasse som representerer en node i en dobbelt lenket liste
         * next er neste node,
         * prev er forrige node, og
         * value er verdien til denne noden
         */
        public static class Node {
            Node next;
            Node prev;
            char value;

            /**
             * Konstruktør som lager en ny node
             *
             * @param value Verdien dene noden skal ha
             */
            Node(char value) {
                this.value = value;
            }
        }

        DoubleLinkedList() {
            this.size = 0;
            this.start = null;
            this.end = null;
        }

        /**
         * Funksjon som legger til en verdi på slutten av listen
         */
        void addBack(char value) {
            Node new_node = new Node(value);
            if (this.start == null) {
                this.start = new_node;
            }
            if (this.end == null) {
                this.end = new_node;
            }
            new_node.prev = this.end;
            this.end.next = new_node;
            new_node.next = this.start;
            this.start.prev = new_node;
            this.end = new_node;
            this.size += 1;
        }

        /**
         * Funksjon som fjerner noden på plass index
         *
         * @param index Indexen å fjerne
         */
        void remove(int index) {
            if (size == 0) throw new IndexOutOfBoundsException("Kan ikke fjerne element hvis listen er tom");

            if (size == 1) {
                start = null;
                end = null;
            } else if (index == 0) {
                start = start.next;
                start.prev = null;
            } else if (index == size - 1) {
                end = end.prev;
                end.next = null;
            } else {
                Node node = start;
                for (int i = 0; i < index; i++){
                    node = node.next;
                }
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }

        /**
         * Funksjon som fjerner noden q fra en dobbelt lenket liste
         *
         * @param q Noden som skal fjernes
         */
        void remove(Node q) {
            Node current = start;
            for (int i = 0; i < size; i++){
                if (current.value == q.value){
                    if (current == start){
                        start = start.next;
                    }else{
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                    }
                    size--;
                    return;
                }
                current = current.next;
            }
        }

        /**
         * Funksjon som skriver ut den lenkede listen
         */
        void print() {
            Node current = this.start;
            System.out.print(current.value);
            for (int i = 1; i < this.size; ++i) {
                current = current.next;
                System.out.print(", " + current.value);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        char values[] = "ABCDEFGHI".toCharArray();
        for (char val : values) {
            list.addBack(val);
        }
        list.print();
        list.remove(2);
        list.remove(4);
        list.remove(0);
        list.print();
        list.remove(6);
        list.print();

        list.remove(new DoubleLinkedList.Node('B'));
        list.print();
    }
}
