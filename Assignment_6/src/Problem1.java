import java.util.Arrays;
public class Problem1 {
    public static void main(String[] args) {
        // testing 4
        boolean[][] a = {{false,true,false,true},{true,false,true,false},{false,true,false,false},{true,false,false,false}};
        System.out.println("depth: " + Arrays.toString(Graph.depthFirst(a)));
        System.out.println("breadth: " + Arrays.toString(Graph.breadthFirst(a)));
        System.out.println();
//        depth: [0, 1, 2, 3]
//        breadth: [0, 1, 3, 2]

        // testing 5
        boolean[][] b = {{false,true,false,false,true}, {true,false,false,true,false},{false,false,false,false,true}, {false,true,false,false,false}, {true,false,true,false,false}};
        System.out.println("depth: " + Arrays.toString(Graph.depthFirst(b)));
        System.out.println("breadth: " + Arrays.toString(Graph.breadthFirst(b)));
        System.out.println();
//        depth: [0, 1, 3, 4, 2]
//        breadth: [0, 1, 4, 3, 2]

        //testing 6
        boolean[][] c = {{false,true,false,false,true,false},{true,false,true,false,false,false},{false,true,false,false,false,true},{false,false,false,false,true,true},{true,false,false,true,false,false},{false,false,true,true,false,false}};
        System.out.println("depth: " + Arrays.toString(Graph.depthFirst(c)));
        System.out.println("breadth: " + Arrays.toString(Graph.breadthFirst(c)));
        System.out.println();
//        depth: [0, 1, 2, 5, 3, 4]
//        breadth: [0, 1, 4, 2, 3, 5]

        // testing 5
        boolean[][] d = {{false,true,true,true,false}, {true,false,false,false,true},{true,false,false,false,true}, {true,false,false,false,true}, {false,true,false,true,false}};
        System.out.println("depth: " + Arrays.toString(Graph.depthFirst(d)));
        System.out.println("breadth: " + Arrays.toString(Graph.breadthFirst(d)));
        System.out.println();
        // d: [0, 1, 4, 3, 2]
        // b: [0, 1, 2, 3, 4]

        // testing 5
        boolean[][] e = {{false,true,false,true,false}, {true,false,false,false,true},{false,false,false,true,false}, {true,false,true,false,false}, {false,true,false,false,false}};
        System.out.println("depth: " + Arrays.toString(Graph.depthFirst(e)));
        System.out.println("breadth: " + Arrays.toString(Graph.breadthFirst(e)));
        System.out.println();
        // d: [0,1,4,3,2]
        // b: [0,1,3,4,2]
    }
}
