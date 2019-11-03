public class Edge {
    int vertex1;
    int vertex2;
    int weight;

    public Edge(int vertex1, int vertex2, int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + vertex1 + ", " + vertex2 + ")";
    }
}
