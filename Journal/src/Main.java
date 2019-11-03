import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    //private transient double average ограничивает запись
    public static void main(String[] args) throws IOException {
        List<Student> students = new ArrayList<Student>();

        int[][] arr = {{9,8,9,10,10,8,9,9}, {8,9,10,10,8,9,10,10}};
        students.add(new Student("sstsjy", "ghghr", 1826928, arr));
        students.add(new Student("ju", "ttfhhjk"));
        students.add(new Student("rytf", "uughmnm"));
        students.add(new Student("tyugyh", "uygkhj"));
        students.add(new Student("fgdgfhg", "ykhjjl"));

        try {
            ObjectOutputStream outFromFile = new ObjectOutputStream(new FileOutputStream("students.dat"));
            outFromFile.writeObject(students);
            outFromFile.flush();

            ObjectInputStream file = new ObjectInputStream(new FileInputStream("students.dat"));
            students = (List<Student>) file.readObject();

            SortAndPrint.excellentStudents(students, System.out);
            SortAndPrint.poorStudents(students, System.out);

            OutputStream outFromFile2 = new ObjectOutputStream(new FileOutputStream("excellentStudents.txt"));//PrintStream?
            SortAndPrint.poorStudents(students, outFromFile2);

            System.out.write("\n\tSorted by name:\n".getBytes());
            SortAndPrint.sortName(students);
            SortAndPrint.printStudents(students, System.out);

            System.out.write("\n\tSorted by average mark:\n".getBytes());
            SortAndPrint.sortAverageMark(students);
            SortAndPrint.printStudents(students, System.out);
        }
        catch (Exception ex) {
            System.out.println("Runtime error!\n");
            System.exit(1);
        }
    }
}