import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] alph = new int['z' - 'a' + 1];
        Scanner in = new Scanner(System.in);
        String str;

        try {
            System.out.println("Input lines: ");
            do {
                str = in.nextLine();
                str = str.toLowerCase();

                for (int i = 0; i < str.length(); i++) {
                    if ('a' <= str.charAt(i) && str.charAt(i) <= 'z'){
                        alph[str.charAt(i) - 'a']++;
                    }
                }
            } while (!str.equals(""));

            System.out.print("Searched letters: ");
            for (int i = 0; i < alph.length; i++) {
                if (alph[i] != 0) {
                    System.out.print((char)(i + 'a') + " ");
                }
            }
        }
        catch (Exception ex) {
            System.out.println("Input/output error!\n");
            System.exit(1);
        }
    }
}
