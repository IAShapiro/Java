import java.io.Serializable;
import java.util.*;

public class Student implements Comparable<Student>, Serializable {
    public String name;
    public String lastName;
    public int id;
    public List<Session> sessionsList;

    public Student(String lastName, String name, int id, int[][] rating) {
        this.name = name;
        this.lastName = lastName;
        sessionsList = new ArrayList<Session>();

        for (int i = 0; i < rating.length; i++) {
            Session sessions = new Session();
            sessions.session = new HashMap<Subjects, Integer>(Subjects.values().length);
            int j = 0;
            for (Subjects subject : Subjects.values()) {
                sessions.session.put(subject, rating[i][j]);//отследить выход за границы массива(?)
                j++;
            }
            sessionsList.add(sessions);
        }

        this.id = id;
    }

    public Student(String lastName, String name) {
        this.name = name;
        this.lastName = lastName;
        sessionsList = new ArrayList<>();

        for (int i = 0; i < (int) (1.0 + Math.random() * 7.0); i++) {
            Session sessions = new Session();
            sessions.session = new HashMap<Subjects, Integer>(Subjects.values().length);
            for (Subjects subject : Subjects.values()) {
                sessions.session.put(subject, (int) (4.0 + Math.random() * 6.0));
            }
            sessionsList.add(sessions);
        }

        this.id = 1800000 + (int) (Math.random() * 100000);
    }

    @Override
    public int compareTo(Student other) {
        if (this.name.compareTo(other.lastName + " " + other.name) == 0) {
            return this.id - other.id;
        }
        return this.name.compareTo(other.lastName + " " + other.name);
    }

    public double getAverageMark() {
        int sum = 0;
        int count = 0;
        for (Session session: this.sessionsList) {
           for (Map.Entry<Subjects, Integer> subject : session.session.entrySet()){
               sum += subject.getValue();
               count++;
           }
        }
        return (double) sum / count;
    }

//    public float getAverage()//Не работает
//    {
//        Pair<Integer, Integer> result = new Pair<>(0, 0);
//        Iterator<Session> it = sessionsList.iterator();
//        Pair<Integer, Integer> current;
//        while (it.hasNext()){
//            current = it.next().getStatistics();
//            result.first += current.first;
//            result.second += current.second;
//        }
//        return (float) result.first / result.second;
//    }

    @Override
    public String toString(){
        return this.lastName + "\t" + this.name + " \t(" + this.id + ") \t" + ((int) (this.getAverageMark() * 1000)) / 1000. + "\n";
    }
}