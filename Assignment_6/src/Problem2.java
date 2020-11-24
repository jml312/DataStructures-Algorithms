public class Problem2 {
    public static void main(String[] args) {
        int[][] dists = new int[][]{{0,1,2,6},{1,0,3,4},{2,3,0,3},{6,4,3,0}};
        System.out.println("Shortest is " + Graph.minDistance(dists));
    }
}
