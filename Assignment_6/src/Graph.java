import java.util.*;

/** A class to represent a Graph */
public class Graph {

    /** The vertices of a Graph */
    private static Vertex[] vertices;

    /** Adds an Edge from i to j
     * @param i The data of the starting Vertex
     * @param target The target Vertex */
    public static void addEdge(int i, Vertex target) {
        if (vertices[i] == null) {
            vertices[i] = new Vertex(i);
        }
        vertices[i].addEdge(new Edge(target));
    }

    /**
     * Returns an array of integers representing the path taken with Depth First Search
     * @param dists A boolean array of existing paths
     * @return An array of integers representing the path taken with Depth First Search
     */
    public static int[] depthFirst(boolean[][] dists) {
        // Creates a graph with the given boolean array
        createGraphFromBooleanArray(dists);
        // Stores the visited nodes returned from depthFirstHelper
        LinkedList<Integer> ll = depthFirstHelper(0, new LinkedList<>());
        // copies the contents of the linked list to the int array
        int[] orderVisited = new int[ll.size()];
        for (int i = 0; i < ll.size(); i++) {
            orderVisited[i] = ll.get(i);
        }
        return orderVisited;
    }

    /** Returns a LinkedList containing all nodes in the correct order that they are visited
     * @param i The index of the current Vertex
     * @param ll a LinkedList to hold the order visited
     * @return a LinkedList containing all nodes in the correct order that they are visited */
    public static LinkedList<Integer> depthFirstHelper(int i, LinkedList<Integer> ll) {
        // checks that the Vertex is not null
        if (vertices[i] != null) {
            // adds the data of the Vertex to the linked list
            ll.add(vertices[i].getData());
            // marks the Vertex as visited
            vertices[i].markVisited();
            // loops over the edges of the current Vertex
            for (Edge curr : vertices[i].getEdges()) {
                int j = curr.getTarget().getData();
                // checks if the Vertex at index j is visited
                // if it is not, then the method is called with j as the index
                if (!vertices[j].isVisited()) {
                    depthFirstHelper(j, ll);
                }
            }
            return ll;
        }
        return ll;
    }

    /**
     * Returns an array of integers representing the path taken with Breadth First Search
     * @param dists A boolean array of existing paths
     * @return An array of integers representing the path taken with Breadth First Search
     */
    public static int[] breadthFirst(boolean[][] dists) {
        // Creates a graph with the given boolean array
        createGraphFromBooleanArray(dists);
        // stores the order of nodes visited
        int[] orderVisited = new int[dists.length];
        int index = 0;
        // checks that the Vertex is not null
        if (vertices[0] != null) {
            Queue<Vertex> q = new LinkedList<>();
            // adds the first Vertex into the queue
            q.add(vertices[0]);
            // marks the Vertex as visited
            vertices[0].markVisited();
            // loops while the queue is not empty
            while (!q.isEmpty()) {
                // removes the data of the front element of the queue
                int element = q.remove().getData();
                // adds the element to the linked list
                orderVisited[index] = element;
                index++;
                // loops over the edges of the current Vertex
                for (Edge currentEdge : vertices[element].getEdges()) {
                    int i = currentEdge.getTarget().getData();
                    // checks if the Vertex at index j is visited
                    // if it is not, then the Vertex is marked visited and it is added to the queue
                    if (!vertices[i].isVisited()) {
                        vertices[i].markVisited();
                        q.add(vertices[i]);
                    }
                }
            }
        }
        return orderVisited;
    }

    /** Creates a graph based on a 2d boolean array
     * @param dists A boolean array of existing paths */
    public static void createGraphFromBooleanArray(boolean[][] dists) {
        // initializes the Vertices array to the size of the length of the boolean array
        vertices = new Vertex[dists.length];
        // loops over each index of the boolean array
        for (int i = 0; i < dists.length; i++) {
            for (int j = 0; j < dists[i].length; j++) {
                // checks if the current index is true
                // adds an Edge at that index if it is true
                if (dists[i][j] && dists[i][j] != dists[i][i] && dists[i][j] != dists[j][j]) {
                    addEdge(i, new Vertex(j));
                }
            }
        }
    }


    /** Returns the minimum total distance of N-1 vertices (the shortest distance of the minimum spanning tree of a graph)
     * @param dists The distances between each Vertex
     * @return the minimum total distance of N-1 vertices */
    public static int minDistance(int[][] dists) {
        // creates a graph from the given int array
        createGraphFromIntArray(dists);
        // returns the minimum distance
        return getMinDistance(dists, 0);
    }


    /** Returns the minimum distance of a graph's minimum spanning tree
     * @param dists The distances between each Vertex
     * @param minDistance The total distance travelled in the minimum spanning tree of the graph
     * @return The minimum distance of a graph's minimum spanning tree */
    public static int getMinDistance(int[][] dists, int minDistance) {
        // sets the first Vertex to have a weight of 0
        vertices[0].setWeight(0);
        // sets the first Vertex to have a parent of -1
        vertices[0].setParent(-1);
        // loops over all vertices except the last
        for (int i = 0; i < vertices.length - 1; i++) {
            // the smallest index in the vertices array
            int min_index = getSmallestIndex();
            // marks that Vertex as visited
            vertices[min_index].markVisited();
            // loops over the vertices array
            for (int j = 0; j < vertices.length; j++) {
                // checks if the weight of the array's index is not 0, the current vertex has not been visited, and the weight of the array's index is less the Vertex's weight
                // if so, it sets the parent to the min index and sets the weight as the array's index
                if (dists[min_index][j] != 0 && !vertices[j].isVisited() && dists[min_index][j] < vertices[j].getWeight()) {
                    vertices[j].setParent(min_index);
                    vertices[j].setWeight(dists[min_index][j]);
                }
            }
        }

        System.out.println("Edge \t Weight");
        // loops over the vertices starting from the first index and sums the weights
        for (int i = 1; i < vertices.length; i++) {
            minDistance += vertices[i].getWeight();
            System.out.println(vertices[i].getParent() + " - " + i + "\t" + vertices[i].getWeight());
        }
        return minDistance;
    }

    /** Returns the smallest index
     * @return The smallest index */
    public static int getSmallestIndex() {
        // initializes the minimum value and the minimum index
        int min = Integer.MAX_VALUE, min_index = -1;
        // loops over the vertices
        for (int i = 0; i < vertices.length; i++) {
            // checks if the current vertex has been visited and if its weight is less than the current min
            // if so, the current min is set to the current Vertex's weight and the minimum index is set to the current index
            if (!vertices[i].isVisited() && vertices[i].getWeight() < min) {
                min = vertices[i].getWeight();
                min_index = i;
            }
        }
        return min_index;
    }

    public static void createGraphFromIntArray(int[][] dists) {
        vertices = new Vertex[dists.length];
        for (int i = 0; i < dists.length; i++) {
            for (int j = 0; j < dists[i].length; j++) {
                addEdge(i, new Vertex(j));
            }
        }
    }
}
