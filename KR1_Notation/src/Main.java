import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        String in = "14 + 7 - 9 * 4 / 2";

        try (FileWriter writer = new FileWriter("bytes2.out", false))
        {
            writer.write(Notation.fromPolish(Notation.toPolish(in)));
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}