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
        // Stores the visited nodes returned from breadthFirstHelper
        LinkedList<Integer> ll = breadthFirstHelper(0, new LinkedList<>());
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
    public static LinkedList<Integer> breadthFirstHelper(int i, LinkedList<Integer> ll) {
        // checks that the Vertex is not null
        if (vertices[i] != null) {
            Queue<Vertex> q = new LinkedList<>();
            // adds the first Vertex into the queue
            q.add(vertices[i]);
            // marks the Vertex as visited
            vertices[i].markVisited();
            // loops while the queue is not empty
            while (!q.isEmpty()) {
                // removes the data of the front element of the queue
                int element = q.remove().getData();
                // adds the element to the linked list
                ll.add(element);
                // loops over the edges of the current Vertex
                for (Edge curr : vertices[element].getEdges()) {
                    int j = curr.getTarget().getData();
                    // checks if the Vertex at index j is visited
                    // if it is not, then the Vertex is marked visited and it is added to the queue
                    if (!vertices[j].isVisited()) {
                        vertices[j].markVisited();
                        q.add(vertices[j]);
                    }
                }
            }
            return ll;
        }
        return ll;
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


    public static int minDistance(int[][] dists) {
        createGraphFromIntArray(dists);
        return getMinDistance(dists, 0);
    }


    public static int getMinDistance(int[][] graph, int minDistance) {
        vertices[0].setWeight(0);
        vertices[0].setParent(-1);
        for (int i = 0; i < vertices.length - 1; i++) {
            int min_index = getSmallestIndex();
            vertices[min_index].markVisited();
            for (int j = 0; j < vertices.length; j++) {
                if (graph[min_index][j] != 0 && !vertices[j].isVisited() && graph[min_index][j] < vertices[j].getWeight()) {
                    vertices[j].setParent(min_index);
                    vertices[j].setWeight(graph[min_index][j]);
                }
            }
        }

        System.out.println("Edge \tWeight");
        for (int i = 1; i < vertices.length; i++) {
            minDistance += vertices[i].getWeight();
            System.out.println(vertices[i].getParent() + " - " + i + "\t" + vertices[i].getWeight());
        }
        return minDistance;
    }

    public static int getSmallestIndex() {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int i = 0; i < vertices.length; i++) {
            if (!vertices[i].isVisited() && vertices[i].getWeight() < min) {
                min = vertices[i].getData();
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
