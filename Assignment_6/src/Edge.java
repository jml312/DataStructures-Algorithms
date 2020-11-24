/** A class to represent ab Edge of a Graph */
public class Edge {

    /** The target Vertex of an Edge */
    private final Vertex target;

    /** Initializes the target Vertex of an Edge
     * @param target The target Vertex of an Edge */
    public Edge(Vertex target) {
        this.target = target;
    }

    /** Gets the target Vertex of an Edge
     * @return The target Vertex of an Edge */
    public Vertex getTarget() {
        return target;
    }
}
