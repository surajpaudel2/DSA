package representation;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixRepresentation {
    public static void main(String[] args) {
        MatrixRepresentation matrixRepresentation = new MatrixRepresentation();
        matrixRepresentation.constructUndirected();
    }

    public void constructDirected() {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        boolean[][] graph = new boolean[nodes + 1][nodes + 1];// Since we are making 1 based graph so nodes + 1
        // array.

        for (int i = 1; i <= nodes; i++) {
            System.out.println("Enter total nodes that are connected to : " + i);
            int edges = sc.nextInt();
            for (int j = 1; j <= edges; j++) {
                System.out.println("Enter " + j + "th node : ");
                int node = sc.nextInt();
                graph[i][node] = true;
            }
        }

//        Print Graph

        for(boolean[] row : graph) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void constructUndirected() {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        boolean[][] graph = new boolean[nodes + 1][nodes + 1];// Since we are making 1 based graph so nodes + 1
        // array.

        for (int i = 1; i <= nodes; i++) {
            System.out.println("Enter total nodes that are connected to : " + i);
            int edges = sc.nextInt();
            for (int j = 1; j <= edges; j++) {
                System.out.println("Enter " + j + "th node : ");
                int node = sc.nextInt();
                graph[i][node] = true;
                graph[node][i] = true;
            }
        }

//        Print Graph

        for(boolean[] row : graph) {
            System.out.println(Arrays.toString(row));
        }
    }
}

