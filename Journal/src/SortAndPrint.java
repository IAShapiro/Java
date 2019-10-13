import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.List;

public class SortAndPrint {
    public static void generateFile(List<Student> students) throws IOException {
        int[][] arr = {{9,8,9,10,10,8,9,9}, {8,9,10,10,8,9,10,10}};
        students.add(new Student("sstsjy ghghr", 1826928, arr));
        students.add(new Student("ju ttfhhjk"));
        students.add(new Student("rytf uughmnm"));
        students.add(new Student("tyugyh uygkhj"));
        students.add(new Student("fgdgfhg ykhjjl"));

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.dat"));
        out.writeObject(students);
        out.flush();
    }

    public static void excellentStudents(List<Student> students, OutputStream out) throws IOException {
        out.write("\n\tExcellent students:\n".getBytes());

        for (Student student : students) {
            if (student.getAverageMark() >= 6) {
                try {
                    out.write(student.toString().getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void poorStudents(List<Student> students, OutputStream out) throws IOException {
        out.write("\n\tBad students:\n".getBytes());

        for (Student student : students) {
            if (student.getAverageMark() < 6) {
                try {
                    out.write(student.toString().getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void sortName(List<Student> students, OutputStream out) {
         students.sort(Comparator.comparing(student -> student.name));
    }

    public static void sortAverageMark(List<Student> students, OutputStream out) {
         students.sort(Comparator.comparing(Student::getAverageMark));
    }

    public static void printStudent(List<Student> students, OutputStream out) {
        for (Student student : students) {
            try {
                out.write(student.toString().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}