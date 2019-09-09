import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int k;
        double x;

        try {
            System.out.println("Input k: ");
            k = in.nextInt();
            System.out.println("Input x: ");
            x = in.nextDouble();
            System.out.printf("Sinh(%f) using Taylor series: %.3f \nSinh(%f) using Math: %.3f", x,
                    SinhTaylorSeries.calculation(k, x), x, Math.sinh(x));
        }
        catch (Throwable ex) {
            System.out.println("Input/output error!\n");
            return;
        }
    }
}
