import java.util.LinkedList;
/** A class to represent a Vertex of a Graph */
public class Vertex {

    /** The data of a Vertex */
    private final int data;

    /** whether or not the Vertex has been visited */
    private boolean visited = false;

    /** The parent of a Vertex */
    private int parent;

    /** The weight of a Vertex */
    private int weight = Integer.MAX_VALUE;

    /** The Edges of a Vertex */
    private final LinkedList<Edge> edges = new LinkedList<>();


    /** Initializes the data of a Vertex
     * @param data The data of a Vertex */
    public Vertex(int data) {
        this.data = data;
    }

    /** Returns the data for a Vertex
     * @return The data for a Vertex */
    public int getData() {
        return data;
    }
    /** Returns whether or not the Vertex has been visited
     * @return Whether or not the Vertex has been visited */
    public boolean isVisited() {
        return visited;
    }

    /** Marks the Vertex as visited  */
    public void markVisited() {
        visited = true;
    }

    /** Returns the parent of a Vertex
     * @return The parent of a Vertex */
    public int getParent() {
        return parent;
    }

    /** Sets the parent of a Vertex
     * @param parent The parent of a Vertex */
    public void setParent(int parent) {
        this.parent = parent;
    }

    /** Returns the weight of a Vertex
     * @return The weight of a Vertex */
    public int getWeight() {
        return weight;
    }

    /** Sets the weight of a Vertex
     * @param weight The weight of a Vertex */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /** Returns the edges of the Vertex
     * @return The edges of a Vertex */
    public LinkedList<Edge> getEdges() {
        return edges;
    }

    /** Adds an edge to the Vertex
     * @param e The edge to add to the Vertex */
    public void addEdge(Edge e) {
        edges.add(e);
    }
}
