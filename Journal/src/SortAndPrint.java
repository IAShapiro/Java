import java.io.IOException;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.List;

public class SortAndPrint {
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

    public static void sortName(List<Student> students) {
         students.sort(Comparator.comparing(student -> (student.lastName + " " + student.name)));
    }

    public static void sortId(List<Student> students) {
        students.sort(Comparator.comparing(student -> student.id));
    }

    public static void sortAverageMark(List<Student> students) {
         students.sort(Comparator.comparing(Student::getAverageMark));
    }

    public static void printStudents(List<Student> students, OutputStream out) {//вывод в файл проверить, как рабоатет
        for (Student student : students) {
            try {
                out.write(student.toString().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}