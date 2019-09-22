import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int m;
        int n;
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("This is the matrix of size m*n. \nInput m: ");
            m = in.nextInt();
            System.out.println("Input n: ");
            n = in.nextInt();
            int[][] matrix = new int[m][n];

            if (m <= 0 || n <= 0) {
                throw new Exception();
            }

            System.out.println("Matrix " + m + "*" + n + "\n");
            IOMatrix.initMatr(matrix);
            IOMatrix.printMatr(matrix);
            ProcessingMatrix.processing(matrix);
        }
        catch (Exception ex) {
            System.out.println("Input/output error!\n");
            System.exit(1);
        }
    }
}
