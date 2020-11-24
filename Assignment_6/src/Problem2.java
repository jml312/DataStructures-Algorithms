public class Problem2 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{0,1,2,6},{1,0,3,4},{2,3,0,3},{6,4,3,0}};
        System.out.println("Shortest distance is " + Graph.minDistance(a));

        System.out.println();

       int[][] b = new int[][]{{0,100,3,10},{100,0,22,1},{3,22,0,4},{10,1,4,0}};
       System.out.println("Shortest distance is " + Graph.minDistance(b));

       System.out.println();

        int[][] c = new int[][]{{0,2000,100},{2000,0,3},{100,3,0}};
        System.out.println("Shortest distance is " + Graph.minDistance(c));

        System.out.println();

        int[][] d = new int[][]{{0,1000,700,30,6},{1000,0,100,40,10},{700,100,0,2,6},{30,40,2,0,8},{6,10,6,8,0}};
        System.out.println("Shortest distance is " + Graph.minDistance(d));

        System.out.println();

        int[][] e = new int[][]{{0,10},{10,0}};
        System.out.println("Shortest distance is " + Graph.minDistance(e));

        System.out.println();

        int[][] f = new int[][]{{0}};
        System.out.println("Shortest distance is " + Graph.minDistance(f));

    }
}
