import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    //private transient double average;
    public static void main(String[] args) throws IOException {
        File file = new File("");
        ObjectInputStream fin = new ObjectInputStream(new FileInputStream(file));
        List<Student> students = new ArrayList<>();
        while(true);

    }
}
