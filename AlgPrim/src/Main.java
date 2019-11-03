import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File("input.txt"));
        int numbVertex = in.nextInt();
        int numbEdges = in.nextInt();

        boolean[] used = new boolean[numbVertex];

        List<ArrayList<Edge>> edgesList = new ArrayList<ArrayList<Edge>>(numbVertex);

        for (int i = 0; i < numbVertex; i++) {
            edgesList.add(new ArrayList<Edge>());
        }

        for(int i = 0; i < numbEdges; i++) {
            int vertex1 = in.nextInt();
            int vertex2 = in.nextInt();
            int weight = in.nextInt();

            edgesList.get(vertex1 - 1).add(new Edge(vertex1, vertex2, weight));
            edgesList.get(vertex2 - 1).add(new Edge(vertex2, vertex1, weight));
        }

        List<Edge> minSubTree = Graph.minSubTree(edgesList, used);

        boolean flag = false;

        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("Spanning subgraph does not exist");
        }
        else {
            minSubTree.sort((o1, o2) -> {
                if (o1.vertex1 == o2.vertex1) {
                    return Integer.compare(o1.vertex2, o2.vertex2);
                }
                else {
                    return Integer.compare(o1.vertex1, o2.vertex1);
                }
            });

            int sumWeight = 0;
            for (Edge edge : minSubTree) {
                sumWeight += edge.weight;
                System.out.println(edge + " ");
            }
            System.out.print("\nWeight is " + sumWeight);
        }

    }
}
