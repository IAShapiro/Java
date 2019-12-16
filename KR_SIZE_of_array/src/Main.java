import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("arrays.in"));

        String output = "";
        String tmp;
        while (in.hasNextLine()) {
//*_______________________Слишком поздно решил уточнить про пробелы. Работает только для строк формата тип_(несколько пробелов)_(между скобками и именем пробелов нет)
            tmp = in.nextLine();
            String tmpLine = tmp;

            String[] mas = tmpLine.split("=");

           // int counter = 0;

            Pattern pattern = Pattern.compile("\\[]");
            Matcher matcher = pattern.matcher(mas[0]);
          //  while(matcher.find()) {
          //      counter++;
          //  }
            mas[0] = matcher.replaceAll(" ");

            Scanner parser = new Scanner(mas[0]);
            String tmp_type = parser.next();
            //String tmp_name = parser.next();

            parser = new Scanner(mas[1]);

            ArrayList array_of_size = new ArrayList();

            if ("new".equals(parser.next())) {

                Pattern pattern2 = Pattern.compile("\\[\\d+]");
                Matcher matcher2 = pattern2.matcher(mas[1]);

                while(matcher2.find()) {
                    array_of_size.add(Integer.parseInt(mas[1].substring(matcher2.start() + 1, matcher2.end() - 1)));
                }
            }
            else {
                int numbOfElem = 1;
                Pattern pattern2 = Pattern.compile(",");

                Matcher matcher2 = pattern2.matcher(mas[1]);
                while(matcher2.find()) {
                    numbOfElem++;
                }
                array_of_size.add(numbOfElem);
            }

            output += (tmpLine + " - " + sizeobj(tmp_type, array_of_size, 0)) + "\n";

        }

        try (FileWriter writer = new FileWriter("arrays.out", false))
        {
            writer.write(output);
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int sizeobj(String typeN, List<Integer> numbOfElements, int iter) {
        if (iter == numbOfElements.size() - 1) {
            int tmp = 0;

            switch(typeN) {
                case("byte"):
                    tmp = 1;
                    break;
                case("char"):
                case("short"):
                    tmp = 2;
                    break;
                case("int"):
                case("float"):
                    tmp = 4;
                    break;
                case("double"):
                case("long"):
                    tmp = 8;
                    break;
            }
            int tmp2 = 8 + 16 + 4 + tmp * numbOfElements.get(iter);
            if (tmp2 % 8 == 0) {
                return tmp2;
            }
            return tmp2 / 8 * 8 + 8;
        }

        int tmp2 = (8 + 16 + 4 + numbOfElements.get(iter) * sizeobj(typeN, numbOfElements, iter + 1));
        if (tmp2 % 8 == 0) {
            return tmp2;
        }
        return tmp2 / 8 * 8 + 8;
    }
}
