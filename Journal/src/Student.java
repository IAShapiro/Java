import java.util.List;

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
           //?????????
        }
        return sum * 1. / count;
    }



}