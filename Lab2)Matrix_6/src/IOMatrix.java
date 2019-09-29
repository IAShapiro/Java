public class IOMatrix {
    public static void printMatr(int[][] matr) {
        for (int[] intM : matr) {
            for (int intN : intM) {
                if (intN == 0) {
                    System.out.print("     0 ");
                }
                else {
                    for (int i = 0; i < 3 - Math.log10(Math.abs(intN)); i++) {
                        System.out.print(" ");
                    }
                    if (intN > 0) {
                        System.out.print(" ");
                    }
                    System.out.print(" " + intN + " ");
                }
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
                matr[i][j] = (int) ((Math.random() - 1./2) * 100);
            }
        }

    }

}
