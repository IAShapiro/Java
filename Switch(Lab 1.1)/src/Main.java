import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        Scanner in = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("1) Calculate factorial\n2) Flip string\n" +
                        "3) Check substring\n0) To finish work\nYour choice: ");
                choice = in.nextInt();
                Menu.functional(choice);

                System.out.print("Press 'Enter' to continue\n");
                in.nextLine();
                in.nextLine();
            }//TODO:Exceptions
        }
        catch (Throwable ex) {
            System.out.println("Error!\n");
            System.exit(1);
        }
    }
}
