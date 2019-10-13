import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Session implements Serializable {
    public Map<Subjects, Integer> session = new HashMap<>();

    public Pair<Integer, Integer> getStatistics() {
        int sum = 0;
        int count = 0;
        for(Subjects subject : session.keySet()) {
            sum += session.get(subject);
            count++;
        }
        return new Pair<>(sum, count);
    }

    public double sessionAverage() {//после вопроса про итератор можно удалить?
        Pair<Integer, Integer> statics = this.getStatistics();
        return (double) statics.first / statics.second;
    }
}

enum Subjects{
    CALCULUS,
    GEOMETRY_AND_ALGEBRA,
    COMPUTER_SCIENCE,
    HYSTORY,
    EDUCATIONAL_PRACTICE,
    ENGLISH,
    DISCRETE_MATH,
    ECONOMICS
}