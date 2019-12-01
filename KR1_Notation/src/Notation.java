import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Notation {
    public static String toPolish(String in) {

        List<String> numbers = new ArrayList<>();

        Stack<Character> operator = new Stack<>();

        StringBuilder out = new StringBuilder();

        Scanner strTok = new Scanner(in);
        String tmp;

        while (strTok.hasNext()) {
            tmp = strTok.next();
            if (!(tmp.length() == 1 && !Character.isDigit(tmp.charAt(0)))){
                out.append(tmp).append(" ");
                numbers.add(tmp);
            }
            else {
                while (!operator.empty() && Notation.getPrior(operator.peek()) >= Notation.getPrior(tmp.charAt(0))){
                    out.append(operator.pop()).append(" ");
                }
                operator.push(tmp.charAt(0));
            }
        }

        while (!operator.empty()) {
            out.append(operator.pop()).append(" ");
        }

        numbers.sort(Comparator.comparingInt(String::length));

        try (FileWriter writer = new FileWriter("bytes1.out", false))
        {
            for (ListIterator<String> iter = numbers.listIterator(); iter.hasNext(); ) {
                writer.write(iter.next() + " ");
            }
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        return out.toString();
    }

    public static String fromPolish(String in) {
        Stack<String> numbers = new Stack<>();
        Stack<String> numbersForCalc = new Stack<>();

        String out = "";

        Scanner strTok = new Scanner(in);
        String tmp;

        while (strTok.hasNext()){
            tmp = strTok.next();
            if (!(tmp.length() == 1 && !Character.isDigit(tmp.charAt(0)))){
                numbers.push(tmp);
                numbersForCalc.push(tmp);
            }
            else {
                String argB = numbers.pop();
                String argA = numbers.pop();

                String argBForCalc = numbersForCalc.pop();
                String argAForCalc = numbersForCalc.pop();

                if (tmp.charAt(0) == '*') {
                    numbersForCalc.push(String.valueOf(Double.parseDouble(argAForCalc) * Double.parseDouble(argBForCalc)));
                    numbers.push(" Mul( " + argA + " , " + argB + " )");
                }
                else if (tmp.charAt(0) == '/') {
                    numbersForCalc.push(String.valueOf(Double.parseDouble(argAForCalc) / Double.parseDouble(argBForCalc)));
                    numbers.push(" Div( " + argA + " , " + argB + " )");
                }
                else if (tmp.charAt(0) == '+') {
                    numbersForCalc.push(String.valueOf(Double.parseDouble(argAForCalc) + Double.parseDouble(argBForCalc)));
                    numbers.push(" Add( " + argA + " , " + argB + " )");
                }
                else if (tmp.charAt(0) == '-') {
                    numbersForCalc.push(String.valueOf(Double.parseDouble(argAForCalc) - Double.parseDouble(argBForCalc)));
                    numbers.push(" Sub( " + argA + " , " + argB + " )");
                }
            }
        }

        try (FileWriter writer = new FileWriter("bytes1.out", true))
        {
            writer.write("\n" + numbersForCalc.pop());
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        return numbers.pop();
    }

    private static int getPrior(char a) {
        if (a == '*' || a == '/') {
            return 3;
        }
        return 2;
    }
}
