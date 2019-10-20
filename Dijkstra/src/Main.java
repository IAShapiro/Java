import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int tmp, minIndex, min;
        final int INFTY = Integer.MAX_VALUE;

        Scanner in = new Scanner(new File("input.txt"));
        int numbOfPeaks = in.nextInt();
        int numbOfEdges = in.nextInt();

        int[][] linkMatr = new int[numbOfEdges][numbOfEdges];

        int[] minDistance = new int[numbOfPeaks];
        boolean[] isPass = new boolean[numbOfPeaks];

        for (int i = 0; i < numbOfEdges; i++) {
            int k = in.nextInt();
            int l = in.nextInt();
            linkMatr[k - 1][l - 1] = linkMatr[l - 1][k - 1] = in.nextInt();
        }

        int begin_index = in.nextInt() - 1;
        int end_index = in.nextInt() - 1;

        for (int i = 0; i < numbOfPeaks; i++)
        {
            if (i != begin_index) {
                minDistance[i] = INFTY;
            }
        }

        do {
            minIndex = INFTY;
            min = INFTY;
            for (int i = 0; i < numbOfPeaks; i++)
            {
                if ((isPass[i] == false) && (minDistance[i] < min))
                {
                    min = minDistance[i];
                    minIndex = i;
                }
            }

            if (minIndex != INFTY)
            {
                for (int i = 0; i < numbOfPeaks; i++)
                {
                    if (linkMatr[minIndex][i] > 0)
                    {
                        tmp = min + linkMatr[minIndex][i];
                        if (tmp < minDistance[i])
                        {
                            minDistance[i] = tmp;
                        }
                    }
                }
                isPass[minIndex] = true;
            }
        } while (minIndex < INFTY);

        System.out.printf("\nКратчайшие расстояния до вершин: \n");
        for (int i = 0; i < numbOfPeaks; i++) {
            System.out.printf("%5d ", minDistance[i] != INFTY ? minDistance[i] : -1);
        }

        System.out.printf("\nКратчайшее расстояние до вершины: \n");
        System.out.printf("%5d ", minDistance[end_index] != INFTY ? minDistance[end_index] : -1);
    }
}
