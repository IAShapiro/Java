public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println(Notation.fromPolish(Notation.calculate("4 - ( 3 * ( - ( 4 - 5 ) ) ) / 10 + 5")));

    }
}
