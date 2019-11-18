import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Notation {
    public static String toPolish(String in) throws Exception {
        Stack<Character> operator = new Stack<>();

        String out = "";

        in = " ( " + in + " )";

        Pattern pattern = Pattern.compile("(\\( - )");
        Matcher matcher = pattern.matcher(in);
        in = matcher.replaceAll("( 0 - ");
        int counterBreckets = 1;

        Scanner strTok = new Scanner(in);
        String tmp;
        strTok.next();
        operator.push('(');

        while (strTok.hasNext()) {
            tmp = strTok.next();
            if (!(tmp.length() == 1 && !Character.isDigit(tmp.charAt(0)))){
                out += tmp + " ";
            }
            else if (tmp.charAt(0) == '(') {
                operator.push('(');
                counterBreckets++;
            }
            else if (tmp.charAt(0) == ')') {
                counterBreckets--;
                if (counterBreckets < 0) {
                    throw (new Exception ("Invalid input\n"));
                }
                while (operator.peek() != '(') {
                    out += operator.pop() + " ";
                }
                operator.pop();
            }
            else {
                while (!operator.empty() && Notation.getPrior(operator.peek()) >= Notation.getPrior(tmp.charAt(0))){
                    out += operator.pop() + " ";
                }
                operator.push(tmp.charAt(0));
            }
        }

        if (counterBreckets != 0) {
            throw (new Exception ("Invalid input\n"));
        }

        while (!operator.empty()) {
            if (operator.peek() != '(') {
                out += operator.pop() + " ";
            }
            else {
                operator.pop();
            }
        }
        return out;
    }

    private static int getPrior(char a) throws Exception {
        switch (a) {
            case '^':
                return 4;
            case '*': case '/':
                return 3;
            case '+': case '-':
                return 2;
            case '(': case ')':
                return 1;
            default:
                throw (new Exception ("Invalid input\n"));
        }
    }

    public static String fromPolish(String in) {
        Stack<String> numbers = new Stack<>();

        String out = "";

        Scanner strTok = new Scanner(in);
        String tmp;

        while (strTok.hasNext()){
            tmp = strTok.next();
            if (!(tmp.length() == 1 && !Character.isDigit(tmp.charAt(0)))){
                numbers.push(tmp);
            }
            else {
                String argB = numbers.pop();
                String argA = numbers.pop();
                numbers.push(" ( " + argA + " " + tmp + " " + argB + " ) ");

            }
        }

        while (!numbers.empty()) {
            out = numbers.pop() + out;
        }

        return out;
    }


}
