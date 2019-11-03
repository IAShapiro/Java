import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final static int INF = Integer.MAX_VALUE;

    private static Edge minWeightEdge(List<Edge> edges, boolean[] used) {
        Edge min = new Edge(0, 0, INF);

        for (Edge edge: edges) {
            if (min.weight > edge.weight && (!used[edge.vertex1 - 1] || !used[edge.vertex2 - 1])) {
                min = edge;
            }
        }

        return min;
    }

    public static List<Edge> minSubTree(List<ArrayList<Edge>> edgesList, boolean[] used) {
        List<Edge> subTree = new ArrayList<Edge>();

        List<Edge> temp = edgesList.get(0);
        used[0] = true;

        Edge min = minWeightEdge(temp, used);

        while (min.weight < Integer.MAX_VALUE) {
            for (int i = 0; i < edgesList.get(min.vertex2 - 1).size(); i++) {
                temp.add(edgesList.get(min.vertex2 - 1).get(i));
            }
            temp.remove(min);
            subTree.add(min);
            used[min.vertex2 - 1] = true;

            min = minWeightEdge(temp, used);
        }

        return subTree;
    }
}
