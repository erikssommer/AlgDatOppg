package algdat.diverse;

/**
 * Enkel bruk av lambda-uttrykk
 */

public class Lambda {

    @FunctionalInterface
    interface MyInterface{
        public void sum(int a, int b);
    }

    static class Demo implements MyInterface{

        @Override
        public void sum(int a, int b) {
            System.out.println("Summen er " + (a + b));
        }
    }

    static class TestWithoutLambda{
        public static void main(String[] args) {
            MyInterface demo = new Demo();
            demo.sum(10, 20);
        }
    }

    static class TestWithLambda{
        public static void main(String[] args) {
            MyInterface lambda = (a, b) -> System.out.println("Summen er " + (a + b));
            lambda.sum(10,20);
        }
    }
}
