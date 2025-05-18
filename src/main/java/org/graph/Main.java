package org.graph;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a weighted graph
        WeightedGraph graph = new WeightedGraph();

        // Add vertices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        // Add edges with weights
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "D", 3);
        graph.addEdge("C", "D", 1);
        graph.addEdge("C", "E", 5);
        graph.addEdge("D", "E", 2);

        // Example 1: Using Breadth first Search
        System.out.println("Breadth-First Search from A to E:");
        Search bfs = new BreadthFirstSearch(graph, "A", "E");
        List<Vertex> bfsPath = bfs.findPath();
        printPath(bfsPath);

        // Example 2: Using fijkstra Algorithm
        System.out.println("\nDijkstra's Algorithm from A to E:");
        Search dijkstra = new DijkstraSearch(graph, "A", "E");
        List<Vertex> dijkstraPath = dijkstra.findPath();
        printPath(dijkstraPath);
    }

    private static void printPath(List<Vertex> path) {
        if (path.isEmpty()) {
            System.out.println("No path found!");
            return;
        }

        System.out.print("Path: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
} 