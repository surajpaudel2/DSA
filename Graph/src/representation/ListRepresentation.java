package representation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListRepresentation {
    public static void main(String[] args) {
        ListRepresentation listRepresentation = new ListRepresentation();
        listRepresentation.constructUnDirected();
    }

    public void constructDirected() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total nodes : ");
        int n = sc.nextInt();

//        Since we are assuming graph is one based so.
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i < graph.size(); i++) {
            System.out.println("Enter total nodes that are connected to " + i + "th vertex");
            int totalNodes = sc.nextInt();
            for(int j = 1; j <= totalNodes; j++) {
                System.out.println("Enter node " + j + "th vertex");
                int node = sc.nextInt();
                graph.get(i).add(node);
            }
        }

        System.out.println(graph);
    }

    public void constructUnDirected() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total nodes : ");
        int n = sc.nextInt();

//        Since we are assuming graph is one based so.
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i < graph.size(); i++) {
            System.out.println("Enter total nodes that are connected to " + i + "th vertex");
            int totalNodes = sc.nextInt();
            for(int j = 1; j <= totalNodes; j++) {
                System.out.println("Enter node " + j + "th vertex");
                int node = sc.nextInt();
                graph.get(i).add(node);
                graph.get(node).add(i);
            }
        }

        System.out.println(graph);
    }
}
