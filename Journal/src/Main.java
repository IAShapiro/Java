import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    //private transient double average ограничивает запись
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Student> students = new ArrayList<Student>();

        SortAndPrint.generateFile(students);
        ObjectInputStream file = new ObjectInputStream(new FileInputStream("students.dat"));
        students = (List<Student>) file.readObject();

        SortAndPrint.excellentStudents(students, System.out);
        SortAndPrint.poorStudents(students, System.out);

        System.out.write("\n\tSorted by name:\n".getBytes());
        SortAndPrint.sortName(students, System.out);
        SortAndPrint.printStudent(students, System.out);

        System.out.write("\n\tSorted by average mark:\n".getBytes());
        SortAndPrint.sortAverageMark(students, System.out);
        SortAndPrint.printStudent(students, System.out);
    }
}