public class IOMatrix {
    public static void printMatr(int[][] matr) {
        for (int[] intM : matr) {
            for (int intN : intM) {
                System.out.print(" " + intN + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void initMatr(int[][] matr){
        for (int i = 0; i < matr.length; i++)
        {
            for (int j = 0; j < matr[0].length; j++)
            {
                matr[i][j] = (int) (Math.random() * 100);
            }
        }

    }

}
