import java.util.Scanner;

public class Menu {
    public static void functional(int choice) {
        switch(choice) {
            case(1):
                func1Fact();
                break;
            case(2):
                func2Reverse();
                break;
            case(3):
                func3Substr();
                break;
            case(0):
                System.exit(0);
            default:
                System.out.print("Incorrect input! \n");
                break;
        }
    }

    private static void func1Fact() {
        Scanner in = new Scanner(System.in);
        System.out.print("To calculate n!, enter the value of n (n <= 20): ");
        int n = in.nextInt();
        System.out.println((((n > 20) || (n < 0)) ? "Incorrect input\n" : (n + "!=" + factorial(n))));
    }

    private static void func2Reverse() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input string: ");
        String str = in.nextLine();
        String reversedStr = new StringBuffer(str).reverse().toString();
        System.out.println("Reversed string: " + reversedStr);
    }

    private static void func3Substr(){
        Scanner in = new Scanner(System.in);
        System.out.print("Input string: ");
        String str = in.nextLine();
        System.out.print("Input substring: ");
        String substr = in.nextLine();
        boolean isContain1 = str.contains(substr);
        System.out.println(substr + " is" + ((!isContain1) ? " not" : "") + " contained");
    }

    private static long factorial(int n) {
        if (n == 0)
        {
            return 1;
        }
        return n * factorial(n-1);
    }
}
