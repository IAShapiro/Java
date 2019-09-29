import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Student implements Comparable<Student> {
    public String name;
    public int number;
    public List<Session> sessions;
    int id;

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
           for (Map.Entry<Subjects, Integer> subject : session.session.entrySet()){
               sum += subject.getValue();
               count++;
           }
        }
        return (double) sum / count;
    }

    public float getAverage()
    {
        Pair<Integer, Integer> result = new Pair<>(0, 0);
        Iterator it = sessions.iterator();
        new Pair<>(0, 0);
        Pair<Integer, Integer> current;
        while (it.hasNext()){
            current = it.getStatistics();
            result.first += current.first;
            result.second += current.second;
        }
        return (float) result.first / result.second;
    }





}

















