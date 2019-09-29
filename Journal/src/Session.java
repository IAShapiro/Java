import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Session {
    Map<Subjects, Integer> session = new HashMap<>();

    public Pair<Integer, Integer> getStatistics() {
        int sum = 0;
        int count = 0;
        for(Subjects subject : session.keySet()) {
            sum += session.get(subject);
            count++;
        }
        return new Pair<Integer, Integer>(sum, count);
    }

    public double sessionAverage() {
        Pair<Integer, Integer> statics = this.getStatistics();
        return (double)statics.first / statics.second;
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