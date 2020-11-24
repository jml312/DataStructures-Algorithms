import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
public class Tester {
    @Test
    public void testProblem1() {
        assertEquals(Arrays.toString(new int[]{0,1,2,3}),Arrays.toString(Graph.depthFirst(new boolean[][]{{false,true,false,true},{true,false,true,false},{false,true,false,false},{true,false,false,false}})), "Testing DFS (4)");
        assertEquals(Arrays.toString(new int[]{0, 1, 3, 2}),Arrays.toString(Graph.breadthFirst(new boolean[][]{{false,true,false,true},{true,false,true,false},{false,true,false,false},{true,false,false,false}})), "Testing BFS (4)");

        assertEquals(Arrays.toString(new int[]{0, 1, 3, 4, 2}),Arrays.toString(Graph.depthFirst(new boolean[][]{{false,true,false,false,true}, {true,false,false,true,false},{false,false,false,false,true}, {false,true,false,false,false}, {true,false,true,false,false}})), "Testing DFS (5)");
        assertEquals(Arrays.toString(new int[]{0, 1, 4, 3, 2}),Arrays.toString(Graph.breadthFirst(new boolean[][]{{false,true,false,false,true}, {true,false,false,true,false},{false,false,false,false,true}, {false,true,false,false,false}, {true,false,true,false,false}})),"Testing BFS (5)");

        assertEquals(Arrays.toString(new int[]{0, 1, 2, 5, 3, 4}),Arrays.toString(Graph.depthFirst(new boolean[][]{{false,true,false,false,true,false},{true,false,true,false,false,false},{false,true,false,false,false,true},{false,false,false,false,true,true},{true,false,false,true,false,false},{false,false,true,true,false,false}})),"Testing DFS (6)");
        assertEquals(Arrays.toString(new int[]{0, 1, 4, 2, 3, 5}),Arrays.toString(Graph.breadthFirst(new boolean[][]{{false,true,false,false,true,false},{true,false,true,false,false,false},{false,true,false,false,false,true},{false,false,false,false,true,true},{true,false,false,true,false,false},{false,false,true,true,false,false}})),"Testing BFS (6)");
    }

    @Test
    public void testProblem2() {
        assertEquals(0,Graph.minDistance(new int[][]{{0}}),"Testing 1");
        assertEquals(10,Graph.minDistance(new int[][]{{0,10},{10,0}}),"Testing 2");
        assertEquals(103,Graph.minDistance(new int[][]{{0,2000,100},{2000,0,3},{100,3,0}}),"Testing 3");
        assertEquals(6,Graph.minDistance(new int[][]{{0,1,2,6},{1,0,3,4},{2,3,0,3},{6,4,3,0}}),"Testing 4");
        assertEquals(24,Graph.minDistance(new int[][]{{0,1000,700,30,6},{1000,0,100,40,10},{700,100,0,2,6},{30,40,2,0,8},{6,10,6,8,0}}),"Testing 5");
    }
}
