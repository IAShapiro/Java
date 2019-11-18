import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));

        StringBuilder file = new StringBuilder(in.nextLine());

        while (in.hasNextLine()) {
            file.append("\n").append(in.nextLine());
        }

        String str = file.toString();

        System.out.print(str.replaceAll("('.*?')|(\".*?\")|((//.*?\\n)|(/\\*(\\n|.)*?\\*/))", "$1$2"));

    }
}
