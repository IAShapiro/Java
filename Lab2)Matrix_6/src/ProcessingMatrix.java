public class ProcessingMatrix {
    public static void processing(int[][] matr){
        System.out.print("Required numbers: ");
        if (matr.length == 1) {
            for (int j = 0; j < matr[0].length; j++) {
                System.out.print(j + " ");
            }
            return;
        }

        for (int j = 0; j < matr[0].length; j++){
            boolean isMonotonic = true;
            double initDiff = matr[1][j] - matr[0][j];

            for (int i = 1; i < matr.length; i++) {
                double curDiff = matr[i][j] - matr[i-1][j];
                if (initDiff * curDiff <= 0) {
                    isMonotonic = false;
                    break;
                }
                initDiff = curDiff;
            }

            if (isMonotonic) {
                System.out.print(j + " ");
            }
        }
    }

}
