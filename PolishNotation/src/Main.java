public class Main {

    public static void main(String[] args) throws Exception {

        try {
            System.out.println(Notation.fromPolish(Notation.toPolish(" ( 4 - ( 3 * ( - ( 4 - 5 ) ) ) / 10 + 5 ")));
        }
        catch (Exception ex) {
            System.out.println("Input error\n");

        }
    }
}
