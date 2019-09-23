import java.util.List;
import java.util.Map;

public class Student implements Comparable<Student> {
    public String name;
    public int number;
    public List<Session> sessions;

    @Override
    public int compareTo(Student other) {
        if (this.name.compareTo(other.name) == 0) {
            return this.number - other.number;
        }
        return this.name.compareTo(other.name);
    }

    public double getAverageMark() {
        int sum = 0;
        int count = 0;
        for (Session session: this.sessions) {
           for (Map.Entry<Subjects, Integer> subject : session.subjects.entrySet()){
               sum += subject.getValue();
               count++;
           }
        }
        return (double) sum / count;
    }



}